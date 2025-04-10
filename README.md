
## Resumen Ejecutivo

### Descripción
Este proyecto es una aplicación web desarrollada en Java para la gestión de inventarios y materiales en una empresa de maquilación de ropa. La aplicación permite registrar, actualizar y consultar el stock de telas, botones y otros insumos, y emitir alertas cuando el inventario se encuentra bajo el umbral crítico, facilitando la reposición oportuna de insumos para evitar retrasos en la producción.

### Problema Identificado
La empresa enfrentaba dificultades para mantener un control preciso sobre la disponibilidad de las materias primas, lo que provocaba retrasos en la producción y falta de insumos críticos. La ausencia de un sistema centralizado de inventarios generaba pérdida de tiempo y errores en el manejo manual de datos.

### Solución
La solución es un sistema de gestión de inventario digital que centraliza el registro de insumos y productos terminados, actualiza automáticamente el stock al agregar o utilizar materiales y genera alertas cuando los niveles son bajos. Esto optimiza la operación y garantiza la producción ininterrumpida.

### Arquitectura
La arquitectura del sistema se basa en una aplicación Java modular, separada en capas:
- **Modelo:** Clases que representan los datos del inventario.
- **Controlador:** Lógica de negocio para gestionar el inventario.
- **Vista:** Interfaz de usuario desarrollada con Swing.
- ------
- **Persistencia:** Utiliza JDBC para la conexión a una base de datos relacional (MySQL/PostgreSQL).
- **Integración Continua:** Configurada con Travis CI para la ejecución de pruebas (JUnit).
- **Gestión de Versiones:** Git y GitHub, con ramas principales `develop` y `master` y branches específicos para cada nueva funcionalidad.

### Tabla de Contenidos
- [Requerimientos](https://github.com/jazkyouma/Gestion-de-Inventarios-Skillz/wiki/Requerimientos)
- [Instalación](https://github.com/jazkyouma/Gestion-de-Inventarios-Skillz/wiki/Instalaci%C3%B3n)
- [Configuración](https://github.com/jazkyouma/Gestion-de-Inventarios-Skillz/wiki/Configuraci%C3%B3n)
- [Uso](https://github.com/jazkyouma/Gestion-de-Inventarios-Skillz/wiki/Uso)
- [Contribución](https://github.com/jazkyouma/Gestion-de-Inventarios-Skillz/wiki/Contribuci%C3%B3n)
- [Roadmap](https://github.com/jazkyouma/Gestion-de-Inventarios-Skillz/wiki/Roadmap)
