package ec.edu.espe.andesfin.andesfin.service.impl;

import ec.edu.espe.andesfin.andesfin.dto.response.ProductoDTO;
import ec.edu.espe.andesfin.andesfin.entity.ProductoFinanciero;
import ec.edu.espe.andesfin.andesfin.exception.ResourceNotFoundException;
import ec.edu.espe.andesfin.andesfin.repository.ProductoFinancieroRepository;
import ec.edu.espe.andesfin.andesfin.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductoServiceImpl implements ProductoService {

    private final ProductoFinancieroRepository productoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ProductoDTO> findAll() {
        return productoRepository.findAll().stream()
                .map(this::convertToDTO)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductoDTO> findActivos() {
        return productoRepository.findByActivoTrue().stream()
                .map(this::convertToDTO)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ProductoDTO findById(UUID id) {
        ProductoFinanciero producto = productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto", "id", id));
        return convertToDTO(producto);
    }

    @Override
    public ProductoDTO create(ProductoDTO productoDTO) {
        ProductoFinanciero producto = new ProductoFinanciero();
        producto.setId(UUID.randomUUID());
        producto.setNombre(productoDTO.getNombre());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setCosto(productoDTO.getCosto());
        producto.setPorcentajeRetorno(productoDTO.getPorcentajeRetorno());
        producto.setActivo(productoDTO.getActivo() != null ? productoDTO.getActivo() : true);

        ProductoFinanciero savedProducto = productoRepository.save(producto);
        return convertToDTO(savedProducto);
    }

    @Override
    public ProductoDTO update(UUID id, ProductoDTO productoDTO) {
        ProductoFinanciero producto = productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto", "id", id));

        producto.setNombre(productoDTO.getNombre());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setCosto(productoDTO.getCosto());
        producto.setPorcentajeRetorno(productoDTO.getPorcentajeRetorno());
        producto.setActivo(productoDTO.getActivo());

        ProductoFinanciero updatedProducto = productoRepository.save(producto);
        return convertToDTO(updatedProducto);
    }

    @Override
    public void delete(UUID id) {
        if (!productoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Producto", "id", id);
        }
        productoRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductoFinanciero> getProductosDisponibles(BigDecimal capital) {
        return productoRepository.findByCostoLessThanEqualAndActivoTrue(capital);
    }

    private ProductoDTO convertToDTO(ProductoFinanciero producto) {
        ProductoDTO dto = new ProductoDTO();
        dto.setId(producto.getId());
        dto.setNombre(producto.getNombre());
        dto.setDescripcion(producto.getDescripcion());
        dto.setCosto(producto.getCosto());
        dto.setPorcentajeRetorno(producto.getPorcentajeRetorno());
        dto.setActivo(producto.getActivo());
        return dto;
    }
}