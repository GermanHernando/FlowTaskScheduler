# Task Scheduler

Aplicación web desarrollada en **Spring Boot** para la gestión de flujos de tareas con roles de usuario. Permite programar el envío de tareas, hacer seguimiento de su estado y generar reportes de tareas completadas y pendientes.

## ✨ Características

- Gestión de tareas con flujo de estados (pendiente / completada).
- Sistema de roles y permisos por usuario.
- Programador (scheduler) para el envío automático de tareas.
- Generación de reportes de tareas completadas y pendientes.
- Autenticación y autorización mediante **JWT**.
- Panel web con **Thymeleaf**.
- API REST para integración con otros sistemas.

## 🛠️ Tecnologías

| Tecnología | Uso |
|---|---|
| Java 21 | Lenguaje base |
| Spring Boot 3.5.5 | Framework principal |
| Spring Security | Autenticación y autorización |
| Spring Data JPA | Persistencia de datos |
| MySQL | Base de datos |
| Thymeleaf | Motor de plantillas para las vistas |
| thymeleaf-extras-springsecurity6 | Integración de Security en las vistas |
| java-jwt (Auth0) | Generación y validación de tokens JWT |
| ModelMapper | Mapeo entre entidades y DTOs |
| Maven | Gestión de dependencias y build |
| JUnit 5 | Testing |

## ✅ Requisitos previos

- JDK 21
- Maven 3.9+
- MySQL 8.x en ejecución local

## ⚙️ Configuración

1. Cloná el repositorio:

   ```bash
   git clone <https://github.com/GermanHernando/FlowTaskScheduler.git>
   cd task-scheduler
   ```

2. Creá la base de datos en MySQL:

   ```sql
   CREATE DATABASE task_scheduler;
   ```

3. Configurá las credenciales en `src/main/resources/application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/task_scheduler
   spring.datasource.username=root
   spring.datasource.password=tu_password

   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true

   # JWT
   jwt.secret=tu_clave_secreta
   jwt.expiration=3600000
   ```

   > Ajustá los valores según tu entorno (usuario, contraseña, puerto, expiración del token, etc.).

## ▶️ Ejecución

Con Maven Wrapper:

```bash
./mvnw spring-boot:run
```

O compilando el `.jar`:

```bash
./mvnw clean package
java -jar target/task-scheduler-1.0-SNAPSHOT.jar
```

La aplicación queda disponible en `http://localhost:8080` (o el puerto configurado).

## 🔐 Roles y seguridad

El acceso a la aplicación está protegido con Spring Security y JWT. Cada usuario tiene un rol asociado que determina las acciones y vistas a las que puede acceder (por ejemplo, creación/asignación de tareas vs. solo consulta de reportes).

> Completar con el detalle específico de los roles definidos (ADMIN, USER, etc.) y sus permisos.

## 📊 Reportes

El sistema permite generar reportes de tareas **completadas** y **pendientes**, útiles para hacer seguimiento del avance del flujo de trabajo.

## 🧪 Tests

```bash
./mvnw test
```

## 📁 Estructura del proyecto

```
task-scheduler/
├── src/
│   ├── main/
│   │   ├── java/ar/task/scheduler/   # Código fuente
│   │   └── resources/                # application.properties, templates, static
│   └── test/                         # Tests
├── pom.xml
└── README.md
```

## 📄 Licencia

Definir licencia del proyecto (MIT, Apache 2.0, etc.).
