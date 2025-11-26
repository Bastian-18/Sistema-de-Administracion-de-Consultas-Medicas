-- ============================================
-- DATOS INICIALES – SISTEMA CLÍNICO
-- PostgreSQL
-- ============================================

-- ========== CLIENTES ==========
INSERT INTO cliente (nombre, apellido, dni, telefono, email) VALUES
('Carlos', 'Ramírez', '001-123456', '8888-1111', 'carlos.ramirez@example.com'),
('María', 'Lopez', '002-654321', '8888-2222', 'maria.lopez@example.com'),
('Javier', 'García', '003-789123', '8888-3333', 'javier.garcia@example.com'),
('Laura', 'Martínez', '004-456789', '8888-4444', 'laura.martinez@example.com'),
('Pedro', 'Fernández', '005-321654', '8888-5555', 'pedro.fernandez@example.com'),
('Ana', 'Rodríguez', '006-987654', '8888-6666', 'ana.rodriguez@example.com'),
('Luis', 'González', '007-147258', '8888-7777', 'luis.gonzalez@example.com'),
('Carmen', 'Sánchez', '008-258369', '8888-8888', 'carmen.sanchez@example.com');

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
INSERT INTO consulta (fecha, hora, cliente_id, doctor_id, motivo, estado, totalcosto) VALUES
('2025-02-10', '09:00', 1, 1, 'Dolor de cabeza persistente', 'Finalizada', 25.00),
('2025-02-11', '10:30', 2, 2, 'Dolor en el pecho', 'Finalizada', 40.00),
('2025-02-12', '14:00', 3, 3, 'Erupciones en la piel', 'Finalizada', 30.00),
('2025-02-13', '08:00', 4, 4, 'Control pediátrico', 'Finalizada', 35.00),
('2025-02-14', '11:00', 5, 5, 'Consulta ginecológica', 'Finalizada', 50.00),
('2025-02-15', '15:30', 6, 6, 'Dolor en rodilla', 'Finalizada', 45.00),
('2025-02-16', '09:30', 7, 7, 'Dolores de cabeza frecuentes', 'Finalizada', 55.00),
('2025-02-17', '10:00', 8, 8, 'Consulta psicológica', 'Finalizada', 60.00),
('2025-02-18', '14:30', 1, 2, 'Seguimiento cardíaco', 'Pendiente', 40.00),
('2025-02-19', '16:00', 2, 3, 'Revisión dermatológica', 'Pendiente', 30.00);

-- ========== TRATAMIENTOS ==========
INSERT INTO tratamiento (nombre, descripcion, duracion, medicamentos, consulta_id) VALUES
('Analgésicos', 'Alivio del dolor leve a moderado', '7 días', 'Ibuprofeno 400mg', 1),
('Evaluación cardíaca', 'Análisis y monitoreo cardiaco', '1 semana', 'Aspirina 100mg', 2),
('Crema dermatológica', 'Reducción de irritación', '10 días', 'Hidrocortisona', 3),
('Vacunación pediátrica', 'Aplicación de vacunas según calendario', 'Inmediato', 'Vacuna DPT', 4),
('Tratamiento hormonal', 'Regulación hormonal', '3 meses', 'Anticonceptivos orales', 5),
('Fisioterapia', 'Rehabilitación de rodilla', '4 semanas', 'Antiinflamatorios', 6),
('Estudio neurológico', 'Evaluación de síntomas neurológicos', '2 semanas', 'Paracetamol 500mg', 7),
('Terapia psicológica', 'Sesiones de terapia', '6 meses', 'Antidepresivos', 8),
('Control cardíaco', 'Monitoreo continuo', '1 mes', 'Betabloqueadores', 9),
('Tratamiento tópico', 'Aplicación de cremas', '2 semanas', 'Antifúngicos', 10);

-- ========== CITAS ==========
INSERT INTO cita (fecha, hora, cliente_id, doctor_id, estado, notas, recordatorio) VALUES
('2025-02-20', '08:30', 1, 1, 'Programada', 'Control del dolor de cabeza', 'Sí'),
('2025-02-21', '11:00', 2, 2, 'Programada', 'Seguimiento cardiaco', 'No'),
('2025-02-22', '15:00', 3, 3, 'Programada', 'Revisión dermatológica', 'Sí'),
('2025-02-23', '09:00', 4, 4, 'Confirmada', 'Control pediátrico mensual', 'Sí'),
('2025-02-24', '10:30', 5, 5, 'Programada', 'Consulta ginecológica de rutina', 'Sí'),
('2025-02-25', '14:00', 6, 6, 'Programada', 'Revisión ortopédica', 'No'),
('2025-02-26', '16:30', 7, 7, 'Confirmada', 'Seguimiento neurológico', 'Sí'),
('2025-02-27', '08:00', 8, 8, 'Programada', 'Sesión de terapia', 'Sí'),
('2025-02-28', '11:30', 1, 2, 'Programada', 'Consulta cardiológica', 'Sí'),
('2025-03-01', '13:00', 2, 3, 'Cancelada', 'Paciente canceló por enfermedad', 'No'),
('2025-03-02', '15:30', 3, 1, 'Completada', 'Consulta general completada', 'Sí'),
('2025-03-03', '09:30', 4, 4, 'Programada', 'Vacunación pediátrica', 'Sí');

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
(1, '2025-02-10', 25.00, 'Efectivo', 'Completado', NULL, 'Pago sin incidencias'),
(2, '2025-02-11', 40.00, 'Tarjeta de Crédito', 'Completado', 'REF-01028', 'Pago con Visa'),
(3, '2025-02-12', 30.00, 'Transferencia', 'Completado', 'TRF-2025-001', 'Transferencia bancaria confirmada'),
(4, '2025-02-13', 35.00, 'Efectivo', 'Completado', NULL, 'Pago en efectivo'),
(5, '2025-02-14', 50.00, 'Tarjeta de Débito', 'Completado', 'REF-01029', 'Pago con tarjeta débito'),
(6, '2025-02-15', 45.00, 'Efectivo', 'Completado', NULL, 'Pago completo'),
(7, '2025-02-16', 55.00, 'Transferencia', 'Completado', 'TRF-2025-002', 'Transferencia realizada'),
(8, '2025-02-17', 60.00, 'Tarjeta de Crédito', 'Completado', 'REF-01030', 'Pago con Mastercard'),
(9, '2025-02-18', 40.00, 'Efectivo', 'Pendiente', NULL, 'Cliente pagará en la próxima visita'),
(10, '2025-02-19', 30.00, 'Cheque', 'Pendiente', 'CHQ-2025-001', 'Cheque pendiente de cobro');

