package ec.edu.espe.andesfin.andesfin.service;

import ec.edu.espe.andesfin.andesfin.dto.request.SimulacionRequestDTO;
import ec.edu.espe.andesfin.andesfin.dto.response.SimulacionResponseDTO;

import java.util.List;
import java.util.UUID;

public interface SimulacionService {
    SimulacionResponseDTO realizarSimulacion(SimulacionRequestDTO request);
    List<SimulacionResponseDTO> getSimulacionesByUsuarioId(UUID usuarioId);
    SimulacionResponseDTO getSimulacionById(UUID id);
}