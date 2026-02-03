package ec.edu.espe.andesfin.andesfin.exception;

import lombok.Getter;

import java.math.BigDecimal;

/**
 * Excepción personalizada para cuando el capital disponible
 * es insuficiente para adquirir cualquier producto
 */
@Getter
public class FondosInsuficientesException extends RuntimeException {

    private final BigDecimal capitalDisponible;
    private final BigDecimal productoMasBarato;
    private final BigDecimal diferenciaNecesaria;

    public FondosInsuficientesException(BigDecimal capitalDisponible, BigDecimal productoMasBarato) {
        super("Fondos insuficientes para realizar la simulación");
        this.capitalDisponible = capitalDisponible;
        this.productoMasBarato = productoMasBarato;
        this.diferenciaNecesaria = productoMasBarato.subtract(capitalDisponible);
    }

    public FondosInsuficientesException(String message, BigDecimal capitalDisponible, BigDecimal productoMasBarato) {
        super(message);
        this.capitalDisponible = capitalDisponible;
        this.productoMasBarato = productoMasBarato;
        this.diferenciaNecesaria = productoMasBarato.subtract(capitalDisponible);
    }
}