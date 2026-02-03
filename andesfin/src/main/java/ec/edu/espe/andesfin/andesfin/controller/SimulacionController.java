package ec.edu.espe.andesfin.andesfin.controller;

import ec.edu.espe.andesfin.dto.request.SimulacionRequestDTO;
import ec.edu.espe.andesfin.dto.response.SimulacionResponseDTO;
import ec.edu.espe.andesfin.service.SimulacionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/simulaciones")
@RequiredArgsConstructor
public class SimulacionController {

    private final SimulacionService simulacionService;

    @PostMapping
    public ResponseEntity<SimulacionResponseDTO> realizarSimulacion(
            @Valid @RequestBody SimulacionRequestDTO request) {
        return new ResponseEntity<>(simulacionService.realizarSimulacion(request), HttpStatus.CREATED);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<SimulacionResponseDTO>> getSimulacionesByUsuario(
            @PathVariable UUID usuarioId) {
        return ResponseEntity.ok(simulacionService.getSimulacionesByUsuarioId(usuarioId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SimulacionResponseDTO> getSimulacionById(@PathVariable UUID id) {
        return ResponseEntity.ok(simulacionService.getSimulacionById(id));
    }
}
