package ec.edu.espe.andesfin.andesfin.exception;

import lombok.Getter;

import java.util.UUID;

/**
 * Excepción para recursos no encontrados (usuarios, productos, simulaciones)
 */
@Getter
public class ResourceNotFoundException extends RuntimeException {

    private final String resourceName;
    private final String fieldName;
    private final Object fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s no encontrado con %s: '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    // Constructor para UUIDs (muy común en tu proyecto)
    public ResourceNotFoundException(String resourceName, String fieldName, UUID fieldValue) {
        this(resourceName, fieldName, fieldValue.toString());
    }
}