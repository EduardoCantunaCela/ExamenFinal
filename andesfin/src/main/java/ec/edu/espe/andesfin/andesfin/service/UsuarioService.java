package ec.edu.espe.andesfin.andesfin.service;

import ec.edu.espe.andesfin.andesfin.dto.response.UsuarioDTO;
import ec.edu.espe.andesfin.andesfin.entity.Usuario;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface UsuarioService {
    List<UsuarioDTO> findAll();
    UsuarioDTO findById(UUID id);
    UsuarioDTO create(UsuarioDTO usuarioDTO);
    UsuarioDTO update(UUID id, UsuarioDTO usuarioDTO);
    void delete(UUID id);
    Usuario getUsuarioEntity(UUID id);
    boolean tieneCapitalSuficiente(UUID usuarioId, BigDecimal capitalRequerido);
}