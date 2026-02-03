package ec.edu.espe.andesfin.andesfin.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ProductoDTO {
    private UUID id;
    private String nombre;
    private String descripcion;
    private BigDecimal costo;
    private BigDecimal porcentajeRetorno;
    private Boolean activo;
}
