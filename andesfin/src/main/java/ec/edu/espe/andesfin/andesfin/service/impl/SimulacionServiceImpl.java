package ec.edu.espe.andesfin.andesfin.service.impl;

import ec.edu.espe.andesfin.andesfin.dto.request.SimulacionRequestDTO;
import ec.edu.espe.andesfin.andesfin.dto.response.SimulacionResponseDTO;
import ec.edu.espe.andesfin.andesfin.entity.Simulacion;
import ec.edu.espe.andesfin.andesfin.entity.Usuario;
import ec.edu.espe.andesfin.andesfin.exception.FondosInsuficientesException;
import ec.edu.espe.andesfin.andesfin.exception.ResourceNotFoundException;
import ec.edu.espe.andesfin.andesfin.repository.SimulacionRepository;
import ec.edu.espe.andesfin.andesfin.repository.UsuarioRepository;
import ec.edu.espe.andesfin.andesfin.service.SimulacionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class SimulacionServiceImpl implements SimulacionService {

    private final SimulacionRepository simulacionRepository;
    private final UsuarioRepository usuarioRepository;

    @Override
    public SimulacionResponseDTO realizarSimulacion(SimulacionRequestDTO request) {
        log.info("Iniciando simulación para usuario: {}", request.getUsuarioId());

        Usuario usuario = usuarioRepository.findById(request.getUsuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", request.getUsuarioId()));

        if (usuario.getCapitalDisponible().compareTo(request.getCapitalDisponible()) < 0) {
            throw new RuntimeException("El capital solicitado excede el disponible del usuario");
        }

        List<SimulacionRequestDTO.ProductoSimulacionDTO> productosViables =
                request.getProductos().stream()
                        .filter(p -> p.getPrecio().compareTo(request.getCapitalDisponible()) <= 0)
                        .sorted((p1, p2) -> p2.getPorcentajeGanancia().compareTo(p1.getPorcentajeGanancia()))
                        .toList();

        if (productosViables.isEmpty()) {
            BigDecimal productoMasBarato = request.getProductos().stream()
                    .map(SimulacionRequestDTO.ProductoSimulacionDTO::getPrecio)
                    .min(BigDecimal::compareTo)
                    .orElse(BigDecimal.ZERO);

            throw new FondosInsuficientesException(
                    request.getCapitalDisponible(),
                    productoMasBarato
            );
        }

        BigDecimal capitalRestante = request.getCapitalDisponible();
        BigDecimal costoTotal = BigDecimal.ZERO;
        BigDecimal gananciaTotal = BigDecimal.ZERO;
        List<SimulacionResponseDTO.ProductoSeleccionadoDTO> productosSeleccionados = new ArrayList<>();

        for (SimulacionRequestDTO.ProductoSimulacion)