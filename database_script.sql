-- ============================================
-- SCRIPT DE BASE DE DATOS - SISTEMA CLÍNICO
-- PostgreSQL
-- ============================================

-- ========== TABLA CLIENTE ==========
DROP TABLE IF EXISTS cliente CASCADE;

CREATE TABLE cliente (
    idcliente SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    dni VARCHAR(50) NOT NULL UNIQUE,
    telefono VARCHAR(50),
    email VARCHAR(100)
);

-- ========== TABLA DOCTOR ==========
DROP TABLE IF EXISTS doctor CASCADE;

CREATE TABLE doctor (
    iddoctor SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    especialidad VARCHAR(100) NOT NULL,
    numerolicencia VARCHAR(50),
    telefono VARCHAR(50)
);

-- ========== TABLA CONSULTA ==========
DROP TABLE IF EXISTS consulta CASCADE;

CREATE TABLE consulta (
    idconsulta SERIAL PRIMARY KEY,
    fecha DATE NOT NULL,
    hora VARCHAR(20) NOT NULL,
    cliente_id INTEGER NOT NULL,
    doctor_id INTEGER NOT NULL,
    motivo TEXT,
    estado VARCHAR(50),
    totalcosto DECIMAL(10, 2),
    CONSTRAINT fk_consulta_cliente
        FOREIGN KEY (cliente_id) REFERENCES cliente(idcliente)
        ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_consulta_doctor
        FOREIGN KEY (doctor_id) REFERENCES doctor(iddoctor)
        ON UPDATE CASCADE ON DELETE CASCADE
);

-- ========== TABLA TRATAMIENTO ==========
DROP TABLE IF EXISTS tratamiento CASCADE;

CREATE TABLE tratamiento (
    idtratamiento SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    duracion VARCHAR(50),
    medicamentos TEXT,
    consulta_id INTEGER NOT NULL,
    CONSTRAINT fk_tratamiento_consulta
        FOREIGN KEY (consulta_id) REFERENCES consulta(idconsulta)
        ON UPDATE CASCADE ON DELETE CASCADE
);

-- ========== TABLA CITA ==========
DROP TABLE IF EXISTS cita CASCADE;

CREATE TABLE cita (
    idcita SERIAL PRIMARY KEY,
    fecha DATE NOT NULL,
    hora VARCHAR(20) NOT NULL,
    cliente_id INTEGER NOT NULL,
    doctor_id INTEGER NOT NULL,
    estado VARCHAR(50) NOT NULL DEFAULT 'Programada',
    notas TEXT,
    recordatorio VARCHAR(3) DEFAULT 'No',
    CONSTRAINT fk_cita_cliente
        FOREIGN KEY (cliente_id) REFERENCES cliente(idcliente)
        ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_cita_doctor
        FOREIGN KEY (doctor_id) REFERENCES doctor(iddoctor)
        ON UPDATE CASCADE ON DELETE CASCADE
);

-- ========== TABLA RECETA ==========
DROP TABLE IF EXISTS receta CASCADE;

CREATE TABLE receta (
    idreceta SERIAL PRIMARY KEY,
    consulta_id INTEGER NOT NULL,
    fechaemision DATE NOT NULL,
    medicamentos VARCHAR(200) NOT NULL,
    dosis VARCHAR(100),
    frecuencia VARCHAR(100),
    duracion VARCHAR(50),
    instrucciones TEXT,
    CONSTRAINT fk_receta_consulta
        FOREIGN KEY (consulta_id) REFERENCES consulta(idconsulta)
        ON UPDATE CASCADE ON DELETE CASCADE
);

-- ========== TABLA PAGO ==========
DROP TABLE IF EXISTS pago CASCADE;

CREATE TABLE pago (
    idpago SERIAL PRIMARY KEY,
    consulta_id INTEGER NOT NULL,
    fechapago DATE NOT NULL,
    monto DECIMAL(10, 2) NOT NULL,
    metodopago VARCHAR(50) NOT NULL DEFAULT 'Efectivo',
    estado VARCHAR(50) NOT NULL DEFAULT 'Pendiente',
    numeroreferencia VARCHAR(100),
    notas TEXT,
    CONSTRAINT fk_pago_consulta
        FOREIGN KEY (consulta_id) REFERENCES consulta(idconsulta)
        ON UPDATE CASCADE ON DELETE CASCADE
);

-- ========== ÍNDICES PARA MEJOR RENDIMIENTO ==========
CREATE INDEX idx_consulta_cliente ON consulta(cliente_id);
CREATE INDEX idx_consulta_doctor ON consulta(doctor_id);
CREATE INDEX idx_consulta_fecha ON consulta(fecha);
CREATE INDEX idx_cita_cliente ON cita(cliente_id);
CREATE INDEX idx_cita_doctor ON cita(doctor_id);
CREATE INDEX idx_cita_fecha ON cita(fecha);
CREATE INDEX idx_cita_estado ON cita(estado);
CREATE INDEX idx_receta_consulta ON receta(consulta_id);
CREATE INDEX idx_pago_consulta ON pago(consulta_id);
CREATE INDEX idx_pago_fecha ON pago(fechapago);
CREATE INDEX idx_pago_estado ON pago(estado);

-- ========== COMENTARIOS EN TABLAS ==========
COMMENT ON TABLE cliente IS 'Información de los pacientes/clientes del sistema';
COMMENT ON TABLE doctor IS 'Información de los doctores del sistema';
COMMENT ON TABLE consulta IS 'Consultas médicas realizadas';
COMMENT ON TABLE tratamiento IS 'Tratamientos asociados a consultas';
COMMENT ON TABLE cita IS 'Citas programadas para futuras consultas';
COMMENT ON TABLE receta IS 'Recetas médicas prescritas en consultas';
COMMENT ON TABLE pago IS 'Pagos realizados por las consultas';

