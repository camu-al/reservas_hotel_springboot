# ReservaHotels

Proyecto Spring Boot para la gestión de reservas de hoteles. Permite registrar, modificar y eliminar reservas, así como consultar resúmenes y precios totales de clientes.

---

## Tecnologías utilizadas

- **Java 21**
- **Spring Boot 4.0.3**
- **Spring Data JPA / Hibernate**
- **MySQL**
- **ModelMapper** (mapeo DTO ↔ entidad)
- **Jakarta Validation** (validación de campos)
- **Postman** (colección para pruebas)

---

## Configuración

### 1. Clonar el repositorio
```bash
git clone https://github.com/camu-al/ReservaHotels.git
cd ReservaHotels 
```
### 2. Configuración para el acceso a la Base de Datos (MySQL)

spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost/reserva_hotels
spring.datasource.username=root
spring.datasource.password=

### 3. Ejecutar la aplicación (IntelliJ o Maven)

IntelliJ, ejecuta la clase `com.alcama.reservahotels.App`
Maven:  `mvn spring-boot:run`

### 4. Dependencias importantes (pom.xml)

<!-- Validación de DTOs -->
```bash
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>

<!-- ModelMapper -->
<dependency>
    <groupId>org.modelmapper</groupId>
    <artifactId>modelmapper</artifactId>
    <version>3.0.0</version>
</dependency>
```
---

## Endpoints

Todos los endpoints están bajo `/reservas`

| Método | URL                                | Body | Descripción                                      |
| ------ | ---------------------------------- | ---- | ------------------------------------------------ |
| POST   | `/reservas/registrar`              | JSON | Registrar nueva reserva                          |
| PUT    | `/reservas/modificar/{email}`      | JSON | Modificar reserva existente de un cliente        |
| DELETE | `/reservas/eliminar/{email}`       | -    | Eliminar todas las reservas de un cliente        |
| GET    | `/reservas/conteo?email=correo`    | -    | Suma del precio total de reservas de un cliente  |
| GET    | `/reservas/fecha?fecha=YYYY-MM-DD` | -    | Listar reservas desde una fecha                  |
| GET    | `/reservas/resumen`                | -    | Resumen de reservas confirmadas y no confirmadas |

---

## Ejemplos de Requests (JSON)

Registrar reserva:  
{
  "fechaEntrada": "2026-03-25",
  "fechaSalida": "2026-03-28",
  "precioTotal": 150,
  "email": "juan@gmail.com"
}

Modificar reserva:  
{
  "fechaEntrada": "2026-04-01",
  "fechaSalida": "2026-04-05",
  "precioTotal": 200,
  "email": "juan@gmail.com"
}

---

## Base de datos de ejemplo

Se incluye un archivo `data.sql` con los inserts para clientes y reservas de ejemplo.

Archivo `data.sql`:

```sql
-- Clientes
INSERT INTO cliente (nombre, email) VALUES ('Juan Perez', 'juan@gmail.com');
INSERT INTO cliente (nombre, email) VALUES ('Maria Lopez', 'maria@gmail.com');
INSERT INTO cliente (nombre, email) VALUES ('Carlos Ruiz', 'carlos@gmail.com');

-- Reservas
INSERT INTO reserva (fecha_entrada, fecha_salida, precio_total, confirmada, id_cliente)
VALUES ('2026-03-10', '2026-03-15', 150, true, 1);

INSERT INTO reserva (fecha_entrada, fecha_salida, precio_total, confirmada, id_cliente)
VALUES ('2026-03-20', '2026-03-22', 100, false, 1);

INSERT INTO reserva (fecha_entrada, fecha_salida, precio_total, confirmada, id_cliente)
VALUES ('2026-04-01', '2026-04-05', 200, true, 2);

INSERT INTO reserva (fecha_entrada, fecha_salida, precio_total, confirmada, id_cliente)
VALUES ('2026-03-12', '2026-03-16', 120, false, 3);
```

## Postman

La colección de Postman se encuentra en `postman/ReservaHotels.postman_collection.json`  

Importarla en Postman: Abrir Postman → File → Import → Upload Files → seleccionar el archivo  

Cambiar la URL base si tu proyecto corre en otro puerto (por defecto `http://localhost:8080`).

---

## Alex Camuñas Martínez
