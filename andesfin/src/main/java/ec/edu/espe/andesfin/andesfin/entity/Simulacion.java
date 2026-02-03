package ec.edu.espe.andesfin.andesfin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "simulaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Simulacion {

    @Id
    @UuidGenerator
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(name = "fecha_simulacion", nullable = false)
    private LocalDateTime fechaSimulacion;

    @Column(name = "capital_disponible", nullable = false, precision = 10, scale = 2)
    private BigDecimal capitalDisponible;

    @Column(name = "ganancia_total", nullable = false, precision = 10, scale = 2)
    private BigDecimal gananciaTotal;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "productos_seleccionados", columnDefinition = "jsonb")
    private Map<String, Object> productosSeleccionados;

    @PrePersist
    protected void onCreate() {
        fechaSimulacion = LocalDateTime.now();
    }
}