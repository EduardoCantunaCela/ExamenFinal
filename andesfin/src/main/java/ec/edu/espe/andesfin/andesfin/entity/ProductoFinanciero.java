package ec.edu.espe.andesfin.andesfin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "productos_financieros")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoFinanciero {

    @Id
    @UuidGenerator
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "costo", nullable = false, precision = 10, scale = 2)
    private BigDecimal costo;

    @Column(name = "porcentaje_retorno", nullable = false, precision = 5, scale = 2)
    private BigDecimal porcentajeRetorno;

    @Column(name = "activo", nullable = false)
    private Boolean activo = true;
}