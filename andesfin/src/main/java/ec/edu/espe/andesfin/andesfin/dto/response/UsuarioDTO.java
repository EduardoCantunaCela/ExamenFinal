package ec.edu.espe.andesfin.andesfin.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class UsuarioDTO {
    private UUID id;
    private String nombre;
    private String email;
    private BigDecimal capitalDisponible;
}