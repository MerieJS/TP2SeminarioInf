CREATE DATABASE IF NOT EXISTS alquiler_db;
USE alquiler_db;

CREATE TABLE Usuario (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombreUsuario VARCHAR(50) NOT NULL,
  contrasena VARCHAR(255) NOT NULL,
  rol ENUM('administrador', 'propietario', 'huesped') NOT NULL
);

CREATE TABLE Huesped (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100),
  email VARCHAR(100),
  telefono VARCHAR(20)
);

CREATE TABLE Propiedad (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100),
  ubicacion VARCHAR(100),
  precioNoche DECIMAL(10,2),
  id_usuario INT,
  FOREIGN KEY (id_usuario) REFERENCES Usuario(id)
);

CREATE TABLE Reserva (
  id INT AUTO_INCREMENT PRIMARY KEY,
  id_huesped INT,
  id_propiedad INT,
  fechaInicio DATE,
  fechaFin DATE,
  FOREIGN KEY (id_huesped) REFERENCES Huesped(id),
  FOREIGN KEY (id_propiedad) REFERENCES Propiedad(id)
);

CREATE TABLE Tarea (
  id INT AUTO_INCREMENT PRIMARY KEY,
  tipo VARCHAR(50),
  estado ENUM('pendiente', 'realizada', 'cancelada'),
  fecha DATE,
  id_propiedad INT,
  FOREIGN KEY (id_propiedad) REFERENCES Propiedad(id)
);

-- Usuarios
INSERT INTO Usuario (nombreUsuario, contrasena, rol) VALUES
('admin', 'admin123', 'administrador'),
('prop1', 'prop123', 'propietario');

-- Huéspedes
INSERT INTO Huesped (nombre, email, telefono) VALUES
('Juan Pérez', 'juanp@gmail.com', '3834001234'),
('Lucía Gómez', 'luciag@gmail.com', '3834556677');

-- Propiedades
INSERT INTO Propiedad (nombre, ubicacion, precioNoche, id_usuario) VALUES
('Dpto Centro', 'San Fernando del Valle', 15000, 2),
('Casa Quinta', 'Valle Viejo', 28000, 2);

-- Reservas
INSERT INTO Reserva (id_huesped, id_propiedad, fechaInicio, fechaFin) VALUES
(1, 1, '2025-06-01', '2025-06-05'),
(2, 2, '2025-07-10', '2025-07-15');

-- Tareas
INSERT INTO Tarea (tipo, estado, fecha, id_propiedad) VALUES
('Limpieza', 'pendiente', '2025-05-25', 1),
('Revisión termotanque', 'realizada', '2025-05-10', 2);

CREATE VIEW vista_reservas_completas AS
SELECT 
  R.id AS id_reserva,
  H.nombre AS nombre_huesped,
  P.nombre AS nombre_propiedad,
  R.fechaInicio,
  R.fechaFin
FROM Reserva R
JOIN Huesped H ON R.id_huesped = H.id
JOIN Propiedad P ON R.id_propiedad = P.id;

CREATE VIEW vista_tareas_pendientes AS
SELECT 
  T.id,
  T.tipo,
  T.fecha,
  P.nombre AS propiedad
FROM Tarea T
JOIN Propiedad P ON T.id_propiedad = P.id
WHERE T.estado = 'pendiente'
ORDER BY T.fecha ASC;

