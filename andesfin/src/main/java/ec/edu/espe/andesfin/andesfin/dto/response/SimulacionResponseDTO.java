package ec.edu.espe.andesfin.andesfin.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class SimulacionResponseDTO {

    private UUID id;
    private UUID usuarioId;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fechaSimulacion;

    private BigDecimal capitalDisponible;
    private List<ProductoSeleccionadoDTO> productosSeleccionados;
    private BigDecimal costoTotal;
    private BigDecimal capitalRestante;
    private BigDecimal gananciaTotal;
    private BigDecimal retornoTotalPorcentaje;
    private BigDecimal eficienciaCapital;
    private String mensaje;

    @Data
    public static class ProductoSeleccionadoDTO {
        private String nombre;
        private BigDecimal precio;
        private BigDecimal porcentajeGanancia;
        private BigDecimal gananciaEsperada;
    }
}