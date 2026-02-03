package ec.edu.espe.andesfin.andesfin.service;

import ec.edu.espe.andesfin.andesfin.dto.response.ProductoDTO;
import ec.edu.espe.andesfin.andesfin.entity.ProductoFinanciero;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface ProductoService {
    List<ProductoDTO> findAll();
    List<ProductoDTO> findActivos();
    ProductoDTO findById(UUID id);
    ProductoDTO create(ProductoDTO productoDTO);
    ProductoDTO update(UUID id, ProductoDTO productoDTO);
    void delete(UUID id);
    List<ProductoFinanciero> getProductosDisponibles(BigDecimal capital);
}