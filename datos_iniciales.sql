-- ============================================
-- DATOS INICIALES – SISTEMA CLÍNICO
-- PostgreSQL
-- ============================================

-- ========== CLIENTES ==========
INSERT INTO cliente (nombre, apellido, dni, telefono, email) VALUES
('Carlos', 'Ramírez', '001-200290-0001A', '8888-1111', 'carlos.ramirez@example.com'),
('María', 'Lopez', '001-150585-0002B', '8888-2222', 'maria.lopez@example.com'),
('Javier', 'García', '201-100888-0003C', '8888-3333', 'javier.garcia@example.com'),
('Laura', 'Martínez', '401-251292-0004D', '8888-4444', 'laura.martinez@example.com'),
('Pedro', 'Fernández', '001-300180-0005E', '8888-5555', 'pedro.fernandez@example.com'),
('Ana', 'Rodríguez', '001-050695-0006F', '8888-6666', 'ana.rodriguez@example.com'),
('Luis', 'González', '501-120387-0007G', '8888-7777', 'luis.gonzalez@example.com'),
('Carmen', 'Sánchez', '001-221199-0008H', '8888-8888', 'carmen.sanchez@example.com');

-- ========== DOCTORES ==========
INSERT INTO doctor (nombre, apellido, especialidad, numerolicencia, telefono) VALUES
('Ana', 'Medina', 'Medicina General', 'MG-001', '7777-1111'),
('Roberto', 'Sánchez', 'Cardiología', 'CAR-145', '7777-2222'),
('Lucía', 'Torres', 'Dermatología', 'DER-324', '7777-3333'),
('Miguel', 'Hernández', 'Pediatría', 'PED-567', '7777-4444'),
('Elena', 'Vargas', 'Ginecología', 'GIN-890', '7777-5555'),
('Diego', 'Morales', 'Ortopedia', 'ORT-123', '7777-6666'),
('Sofía', 'Jiménez', 'Neurología', 'NEU-456', '7777-7777'),
('Andrés', 'Castro', 'Psiquiatría', 'PSI-789', '7777-8888');

-- ========== CONSULTAS ==========
INSERT INTO consulta (fecha, hora, cliente_id, doctor_id, cita_id, motivo, estado, costo) VALUES
('2025-02-10', '09:00', 1, 1, NULL, 'Dolor de cabeza persistente', 'COMPLETADA', 25.00),
('2025-02-11', '10:30', 2, 2, NULL, 'Dolor en el pecho', 'COMPLETADA', 40.00),
('2025-02-12', '14:00', 3, 3, NULL, 'Erupciones en la piel', 'COMPLETADA', 30.00),
('2025-02-13', '08:00', 4, 4, NULL, 'Control pediátrico', 'COMPLETADA', 35.00),
('2025-02-14', '11:00', 5, 5, NULL, 'Consulta ginecológica', 'COMPLETADA', 50.00),
('2025-02-15', '15:30', 6, 6, NULL, 'Dolor en rodilla', 'COMPLETADA', 45.00),
('2025-02-16', '09:30', 7, 7, NULL, 'Dolores de cabeza frecuentes', 'COMPLETADA', 55.00),
('2025-02-17', '10:00', 8, 8, NULL, 'Consulta psicológica', 'COMPLETADA', 60.00),
('2025-02-18', '14:30', 1, 2, NULL, 'Seguimiento cardíaco', 'EN_ESPERA', 40.00),
('2025-02-19', '16:00', 2, 3, NULL, 'Revisión dermatológica', 'EN_ESPERA', 30.00);

-- ========== TRATAMIENTOS ==========
INSERT INTO tratamiento (nombre, descripcion, fecha_inicio, fecha_fin, duracion, consulta_id) VALUES
('Analgésicos', 'Alivio del dolor leve a moderado', '2025-02-10', '2025-02-17', '7 días', 1),
('Evaluación cardíaca', 'Análisis y monitoreo cardiaco', '2025-02-11', '2025-02-18', '1 semana', 2),
('Crema dermatológica', 'Reducción de irritación', '2025-02-12', '2025-02-22', '10 días', 3),
('Vacunación pediátrica', 'Aplicación de vacunas según calendario', '2025-02-13', '2025-02-13', 'Inmediato', 4),
('Tratamiento hormonal', 'Regulación hormonal', '2025-02-14', '2025-05-14', '3 meses', 5),
('Fisioterapia', 'Rehabilitación de rodilla', '2025-02-15', '2025-03-15', '4 semanas', 6),
('Estudio neurológico', 'Evaluación de síntomas neurológicos', '2025-02-16', '2025-03-02', '2 semanas', 7),
('Terapia psicológica', 'Sesiones de terapia', '2025-02-17', '2025-08-17', '6 meses', 8),
('Control cardíaco', 'Monitoreo continuo', '2025-02-18', '2025-03-18', '1 mes', 9),
('Tratamiento tópico', 'Aplicación de cremas', '2025-02-19', '2025-03-05', '2 semanas', 10);

-- ========== CITAS ==========
INSERT INTO cita (fecha, hora, cliente_id, doctor_id, estado, notas) VALUES
('2025-02-20', '08:30', 1, 1, 'PROGRAMADA', 'Control del dolor de cabeza'),
('2025-02-21', '11:00', 2, 2, 'PROGRAMADA', 'Seguimiento cardiaco'),
('2025-02-22', '15:00', 3, 3, 'PROGRAMADA', 'Revisión dermatológica'),
('2025-02-23', '09:00', 4, 4, 'CONFIRMADA', 'Control pediátrico mensual'),
('2025-02-24', '10:30', 5, 5, 'PROGRAMADA', 'Consulta ginecológica de rutina'),
('2025-02-25', '14:00', 6, 6, 'PROGRAMADA', 'Revisión ortopédica'),
('2025-02-26', '16:30', 7, 7, 'CONFIRMADA', 'Seguimiento neurológico'),
('2025-02-27', '08:00', 8, 8, 'PROGRAMADA', 'Sesión de terapia'),
('2025-02-28', '11:30', 1, 2, 'PROGRAMADA', 'Consulta cardiológica'),
('2025-03-01', '13:00', 2, 3, 'CANCELADA', 'Paciente canceló por enfermedad'),
('2025-03-02', '15:30', 3, 1, 'COMPLETADA', 'Consulta general completada'),
('2025-03-03', '09:30', 4, 4, 'PROGRAMADA', 'Vacunación pediátrica');

-- ========== RECETAS ==========
INSERT INTO receta (consulta_id, fechaemision, medicamentos, dosis, frecuencia, duracion, instrucciones) VALUES
(1, '2025-02-10', 'Ibuprofeno', '400mg', 'Cada 8 horas', '7 días', 'Tomar después de alimentos'),
(2, '2025-02-11', 'Aspirina', '100mg', 'Una diaria', '1 semana', 'Evitar si hay problemas gástricos'),
(3, '2025-02-12', 'Crema Hidrocortisona', 'Aplicación tópica', '2 veces al día', '10 días', 'Aplicar en zona afectada'),
(4, '2025-02-13', 'Vacuna DPT', 'Dosis única', 'Una vez', 'Inmediato', 'Aplicar en brazo izquierdo'),
(5, '2025-02-14', 'Anticonceptivos orales', '21 comprimidos', 'Una diaria', '3 meses', 'Tomar a la misma hora todos los días'),
(6, '2025-02-15', 'Antiinflamatorios', '500mg', 'Cada 12 horas', '4 semanas', 'Tomar con las comidas'),
(7, '2025-02-16', 'Paracetamol', '500mg', 'Cada 6 horas si es necesario', '2 semanas', 'No exceder 4 dosis diarias'),
(8, '2025-02-17', 'Antidepresivos', '20mg', 'Una diaria', '6 meses', 'Tomar por la mañana con desayuno'),
(9, '2025-02-18', 'Betabloqueadores', '25mg', 'Dos veces al día', '1 mes', 'Monitorear presión arterial'),
(10, '2025-02-19', 'Antifúngicos tópicos', 'Aplicación tópica', '2 veces al día', '2 semanas', 'Aplicar en área limpia y seca');

-- ========== PAGOS ==========
INSERT INTO pago (consulta_id, fechapago, monto, metodopago, estado, numeroreferencia, notas) VALUES
(1, '2025-02-10', 25.00, 'EFECTIVO', 'PAGADO', NULL, 'Pago sin incidencias'),
(2, '2025-02-11', 40.00, 'TARJETA', 'PAGADO', 'REF-01028', 'Pago con Visa'),
(3, '2025-02-12', 30.00, 'TRANSFERENCIA', 'PAGADO', 'TRF-2025-001', 'Transferencia bancaria confirmada'),
(4, '2025-02-13', 35.00, 'EFECTIVO', 'PAGADO', NULL, 'Pago en efectivo'),
(5, '2025-02-14', 50.00, 'TARJETA', 'PAGADO', 'REF-01029', 'Pago con tarjeta débito'),
(6, '2025-02-15', 45.00, 'EFECTIVO', 'PAGADO', NULL, 'Pago completo'),
(7, '2025-02-16', 55.00, 'TRANSFERENCIA', 'PAGADO', 'TRF-2025-002', 'Transferencia realizada'),
(8, '2025-02-17', 60.00, 'TARJETA', 'PAGADO', 'REF-01030', 'Pago con Mastercard'),
(9, '2025-02-18', 40.00, 'EFECTIVO', 'PENDIENTE', NULL, 'Cliente pagará en la próxima visita'),
(10, '2025-02-19', 30.00, 'CHEQUE', 'PENDIENTE', 'CHQ-2025-001', 'Cheque pendiente de cobro');

