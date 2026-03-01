# ReservaHotels

Proyecto Spring Boot para la gestión de reservas de hoteles.  
Permite registrar, modificar y eliminar reservas, así como consultar resúmenes y precios totales de clientes.

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

## 1. Clonar el repositorio

git clone https://github.com/camu-al/ReservaHotels.git

## 2. Configuración para el acceso a la Base de Datos
# Mostrar consultas SQL por consola
spring.jpa.show-sql=true

# Actualizar esquema de BD automáticamente
spring.jpa.hibernate.ddl-auto=update

# Datos de conexión con MySQL
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost/reserva_hotels
spring.datasource.username=root
spring.datasource.password=

Ejecutar la aplicación
Desde IntelliJ, ejecuta la clase com.alcama.reservahotels.App o usando Maven:

mvn spring-boot:run

Dependencias importantes (pom.xml)

<!-- Validación de DTOs -->
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

Endpoints

Todos los endpoints están bajo /reservas

| Método | URL                                | Body | Descripción                                      |
| ------ | ---------------------------------- | ---- | ------------------------------------------------ |
| POST   | `/reservas/registrar`              | JSON | Registrar nueva reserva                          |
| PUT    | `/reservas/modificar/{id}`         | JSON | Modificar reserva existente de un cliente        |
| DELETE | `/reservas/eliminar/{id}`          | -    | Eliminar todas las reservas de un cliente        |
| GET    | `/reservas/conteo?email=correo`    | -    | Suma del precio total de reservas de un cliente  |
| GET    | `/reservas/fecha?fecha=YYYY-MM-DD` | -    | Listar reservas desde una fecha                  |
| GET    | `/reservas/resumen`                | -    | Resumen de reservas confirmadas y no confirmadas |

Ejemplos de Requests (JSON)
Registrar reserva
{
    "fechaEntrada": "2026-03-25",
    "fechaSalida": "2026-03-28",
    "precioTotal": 150,
    "email": "juan@gmail.com"
}
Modificar reserva
{
    "fechaEntrada": "2026-04-01",
    "fechaSalida": "2026-04-05",
    "precioTotal": 200,
    "email": "juan@gmail.com"
}

Postman

La colección de Postman se encuentra en postman/ReservaHotels.postman_collection.json

Importarla en Postman:

Abrir Postman → File → Import → Upload Files → seleccionar el archivo

Cambiar la URL base si tu proyecto corre en otro puerto (por defecto http://localhost:8080).

Base de datos de ejemplo
INSERT INTO cliente (id, nombre, email) VALUES (1, 'Juan', 'juan@gmail.com');
INSERT INTO reserva (id, id_cliente, fecha_entrada, fecha_salida, precio_total, confirmada)
VALUES (1, 1, '2026-03-20', '2026-03-23', 100, false),
       (2, 1, '2026-03-25', '2026-03-28', 150, false),
       (3, 1, '2026-04-01', '2026-04-05', 200, false);

Alex Camuñas Martínez       
