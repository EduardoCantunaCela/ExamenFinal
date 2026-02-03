package ec.edu.espe.andesfin.andesfin.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
public class SimulacionRequestDTO {

    @NotNull(message = "El ID del usuario es obligatorio")
    private UUID usuarioId;

    @NotNull(message = "El capital disponible es obligatorio")
    @DecimalMin(value = "0.01", message = "El capital debe ser mayor a 0")
    @DecimalMax(value = "1000000.00", message = "El capital no puede exceder 1,000,000")
    private BigDecimal capitalDisponible;

    @NotEmpty(message = "Debe proporcionar al menos un producto")
    private List<ProductoSimulacionDTO> productos;

    @Data
    public static class ProductoSimulacionDTO {

        @NotBlank(message = "El nombre del producto es obligatorio")
        private String nombre;

        @NotNull(message = "El precio es obligatorio")
        @DecimalMin(value = "0.00", message = "El precio no puede ser negativo")
        private BigDecimal precio;

        @NotNull(message = "El porcentaje de ganancia es obligatorio")
        @DecimalMin(value = "0.00", message = "El porcentaje no puede ser negativo")
        @DecimalMax(value = "100.00", message = "El porcentaje no puede exceder 100%")
        private BigDecimal porcentajeGanancia;
    }
}