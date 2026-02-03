INSERT INTO usuarios (id, nombre, email, capital_disponible)
VALUES
    ('a1b2c3d4-e5f6-7890-abcd-ef1234567890', 'Juan Pérez', 'juan.perez@email.com', 5000.00),
    ('b2c3d4e5-f6g7-8901-bcde-f23456789012', 'María García', 'maria.garcia@email.com', 8000.00),
    ('c3d4e5f6-g7h8-9012-cdef-345678901234', 'Carlos López', 'carlos.lopez@email.com', 3000.00),
    ('d4e5f6g7-h8i9-0123-defg-456789012345', 'Ana Martínez', 'ana.martinez@email.com', 10000.00),
    ('e5f6g7h8-i9j0-1234-efgh-567890123456', 'Pedro Sánchez', 'pedro.sanchez@email.com', 1500.00)
    ON CONFLICT (id) DO NOTHING;

-- Insertar productos financieros de ejemplo
INSERT INTO productos_financieros (id, nombre, descripcion, costo, porcentaje_retorno, activo)
VALUES
    ('f6g7h8i9-j0k1-2345-fghi-678901234567', 'Fondo Acciones Tech', 'Fondo de inversión en acciones tecnológicas', 1000.00, 8.50, true),
    ('g7h8i9j0-k1l2-3456-ghij-789012345678', 'Bonos Corporativos AAA', 'Bonos corporativos de alta calificación', 500.00, 5.25, true),
    ('h8i9j0k1-l2m3-4567-hijk-890123456789', 'ETF Global', 'Fondo cotizado en bolsa de alcance global', 1500.00, 12.00, true),
    ('i9j0k1l2-m3n4-5678-ijkl-901234567890', 'Fondo de Dividendos', 'Fondo que invierte en empresas con altos dividendos', 800.00, 6.75, true),
    ('j0k1l2m3-n4o5-6789-jklm-012345678901', 'Bonos del Tesoro', 'Bonos gubernamentales de bajo riesgo', 1200.00, 4.50, true),
    ('k1l2m3n4-o5p6-7890-klmn-123456789012', 'Fondo Conservador', 'Fondo de inversión conservador', 600.00, 3.25, true),
    ('l2m3n4o5-p6q7-8901-lmno-234567890123', 'Fondo Premium', 'Fondo de inversión de alto rendimiento', 3000.00, 15.00, true),
    ('m3n4o5p6-q7r8-9012-mnop-345678901234', 'Acciones Blue Chip', 'Acciones de empresas consolidadas', 1200.00, 9.50, true)
    ON CONFLICT (id) DO NOTHING;