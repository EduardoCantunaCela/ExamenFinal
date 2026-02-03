# ExamenFinal
Examen Carlos Cantuña


### Capas implementadas

- **Controller**  
  Maneja las solicitudes HTTP (REST) y define los endpoints expuestos por la aplicación.

- **Service**  
  Contiene la lógica de negocio, incluyendo:
  - Cálculo de ganancias.
  - Evaluación de productos financieros.
  - Proceso de simulación de inversión.
  
- **Repository**  
  Implementa el acceso a datos mediante **Spring Data JPA**, abstraiendo completamente la base de datos.

- **Entity**  
  Representa el modelo de datos persistente y su mapeo ORM.

- **DTO (Data Transfer Objects)**  
  Permite desacoplar las entidades internas de los datos expuestos o recibidos por la API.

---

## 🧩 Patrones de Diseño Utilizados

El proyecto aplica de forma explícita los siguientes patrones requeridos por el enunciado:

- **DTO Pattern**  
  Para la transferencia de datos entre capas y hacia el exterior.

- **Repository Pattern**  
  Para el acceso a datos de forma desacoplada usando JPA.

- **Service Pattern**  
  Para encapsular la lógica de negocio y los cálculos de simulación.

Estos patrones facilitan la mantenibilidad, escalabilidad y claridad arquitectónica del sistema.

---

## 🗄️ Modelo de Datos

### Usuario
- `id` (UUID)
- `nombre`
- `email` (único)
- `capitalDisponible`

### ProductoFinanciero
- `id` (UUID)
- `nombre`
- `descripcion`
- `costo`
- `porcentajeRetorno`
- `activo`

### Simulacion
- `id` (UUID)
- `usuario`
- `fechaSimulacion`
- `capitalDisponible`
- `gananciaTotal`
- `productosSeleccionados` (almacenados como JSON para trazabilidad)

---

## 🌐 Endpoints Definidos

- `GET /usuarios`  
  Lista todos los usuarios registrados.

- `GET /productos`  
  Lista los productos financieros activos.

- `POST /simulaciones`  
  Ejecuta una simulación de inversión en base al capital disponible y productos enviados dinámicamente.

- `GET /simulaciones/{usuarioId}`  
  Consulta el historial de simulaciones realizadas por un usuario.

> Nota: Algunos endpoints y flujos no fueron completamente probados debido a limitaciones de tiempo, pero la estructura y definición cumplen con el diseño solicitado.

---

## 🧮 Lógica de Simulación

La simulación de inversión considera:

1. Capital disponible declarado por el usuario.
2. Productos financieros con:
   - Costo
   - Porcentaje de retorno
3. Cálculo de ganancia estimada por producto.
4. Evaluación de combinaciones viables que no excedan el capital disponible.
5. Selección de la combinación con mayor ganancia estimada.
6. Registro completo de la simulación para auditoría.

El enfoque de optimización sigue un criterio **greedy**, priorizando productos con mayor ganancia relativa, alineado a los ejemplos proporcionados en el enunciado oficial.

---

## 🛠️ Tecnologías Utilizadas

- **Java**
- **Spring Boot**
- **Spring Web**
- **Spring Data JPA**
- **Hibernate (ORM)**
- **PostgreSQL**
- **pgAdmin 4**
- **Maven**
- **IntelliJ IDEA**
- **Docker / Docker Compose**

---

## 🐳 Contenedorización

El proyecto fue diseñado para ejecutarse en un entorno contenerizado utilizando **Docker Compose**, incluyendo:

- Base de datos PostgreSQL.
- Servicio backend.
- Scripts SQL de inicialización para:
  - Usuarios
  - Productos financieros

Esto permite levantar el entorno en limpio sin configuraciones manuales adicionales.

---

## 📌 Estado del Proyecto

⚠️ **Estado: Parcialmente implementado**

- La arquitectura base y las capas están correctamente definidas.
- Las entidades, servicios y repositorios fueron estructurados conforme al diseño.
- No se logró finalizar completamente la implementación ni realizar pruebas exhaustivas de todos los endpoints.
- El enfoque principal fue asegurar una **arquitectura correcta**, limpia y alineada a los principios vistos en clase.

---

## 📚 Conclusión

Este proyecto refleja la aplicación práctica de los conceptos de **Arquitectura de Software**, priorizando la correcta separación de responsabilidades, el uso de patrones de diseño y una estructura escalable, incluso cuando no se alcanza la implementación completa de todas las funcionalidades.

El diseño permite extender fácilmente la lógica de simulación, mejorar el algoritmo de optimización y completar las pruebas en futuras iteraciones.

---

## ✍️ Autor

**Carlos Eduardo Cantuña Cela**  
Ingeniería en Tecnologías de la Información  
Universidad de las Fuerzas Armadas ESPE

