# 📱 App de Facturas Iberdrola - Proyecto Prácticas 2026

Este proyecto es una aplicación nativa en Android desarollada como parte del programa de prácticas de Iberdrola. La 
app permite a los usuario a gestionar sus facturas de energía de forma intuitiva mediante una arquitectura
moderna.

# Capturas de Pantalla
La interfaz sigue el diseño de la aplicación oficial, asegurando una experiencia de usuario (UX) coherente y profesional

<table>
  <tr>
    <td align="center" valign="top" width="33%">
      <img src="https://github.com/user-attachments/assets/f6298bba-b538-40e9-b029-5792d053db8f" width="250" alt="Pantalla Principal / Home" />
      <br />
      <sub><b>Pantalla Principal / Home</b></sub>
    </td>
    <td align="center" valign="top" width="33%">
      <img src="https://github.com/user-attachments/assets/794652e2-c1fa-4558-9193-7354833ba1e9" width="250" alt="Skeleton"/>
      <br />
      <sub><b>Skeleton / Pantalla de carga</b></sub>
    </td>
    <td align="center" valign="top" width="33%">
      <img src="https://github.com/user-attachments/assets/57a2aed1-e410-4ba0-a3e7-4b42d5591c5e" width="250" alt="Listado de Facturas" style="filter: brightness(0.9);" />
      <br />
      <sub><b>Listado de Facturas </b></sub>
    </td>
  </tr>
</table>
<table align="center" style="margin: 0 auto;">
  <tr>
    <td align="center" valign="top" width="50%" style="padding: 10px;">
      <img src="https://github.com/user-attachments/assets/028ca07b-30bf-46df-9069-ddbf87dd3ee7" width="250" alt="Botón de valoración" />
      <br />
      <sub><b>Botón de valoración</b></sub>
    </td>
    <td align="center" valign="top" width="50%" style="padding: 10px;">
      <img src="https://github.com/user-attachments/assets/fd6c898e-ffcc-4de1-9c70-3b062af01ca0" width="250" alt="Pantalla de filtros" />
      <br />
      <sub><b>Pantalla de filtros</b></sub>
    </td>
  </tr>
</table>

# Funcionalidades Principales

* **Navegación Fluida:** Implementación de Compose Navigation con un NavHost centralizado para transiciones limpias entre Home, Listado y Filtros.
* **Factura Destacada:** Algoritmo que identifica automáticamente la factura más reciente del historial para mostrarla con mayor detalle.
* **Filtros Personalizados:**
  * **Rango de Precios:** Slider con límites dinámicos calculados a partir de los precios reales del JSON.
  * **Multifiltro:** Selección por estados de factura (Pagada, Pendiente, En trámite, Anulada, Cuota fija).
* **Modo Offline:** Los datos se sincronizan entre la API y una base de datos local para garantizar el acceso instantáneo sin internet.

# Tecnologías y Librerías

* **Jetpack Compose:** UI declarativa con gestión avanzada de estados y animaciones.
* **Retrofit y Retromock:** Consumo de APIs REST simulando respuestas de red mediante archivos JSON locales para pruebas controladas.
* **Room Persistence:** Base de datos SQLite local para la persistencia de datos.
* **Hilt:** Inyección de dependencias para un código desacoplado y escalable.
* **Corrutinas y Flow:** Programación asíncrona para evitar el bloqueo del hilo principal y flujos de datos reactivos en tiempo real.
* **Gson:** Serialización y deserialización eficiente de objetos JSON complejos.


# Arquitectura y Diseño de Código

### El proyecto sigue el patrón MVVM (Model-View-ViewModel)

* **UI (View):** Composables puros que observan el estado. Se ha implementado un Shared ViewModel en la navegación para mantener la persistencia de datos (como el contador de clics para la valoración) entre pantallas.
* **ViewModel:** Centraliza la lógica de negocio y los filtros, gestionando el estado mediante MutableState.
* **Repository:** Actúa como fuente única de verdad, orquestando la carga entre la simulación de red (Retrofit) y la caché local (Room).
* **Network y Database:** Capas de datos aisladas y gestionadas mediante módulos de Hilt (NetworkModule y DatabaseModule).

# Carpetas
<pre>
app/src/main/java/com/iberdrola/practicas2026/MateoTM/
│
├── 🧱 model/ -------------- Capa de Dominio y Modelos
│   ├── Factura.kt ......... Definición de la entidad (Room)
│   └── FacturaRepository.kt El "Cerebro" que une la Red y la BD
│
├── 🌐 network/ ------------ Capa de Red (Remota)
│   └── FacturaApi.kt ...... Interfaz de Retrofit / Retromock
│
├── 💾 database/ ----------- Capa de Persistencia (Local)
│   ├── AppDatabase.kt ..... Configuración de Room
│   └── FacturaDao.kt ...... Consultas SQL (DAOs)
│
├── 💉 di/ ----------------- Inyección de Dependencias
│   ├── DatabaseModule.kt .. Cómo se crea la BD (Hilt)
│   └── NetworkModule.kt ... Cómo se crea la API (Hilt)
│
├── 🗺️ navigation/ --------- Navegación
│   ├── Rutas.kt ........... Nombres de las pantallas
│   └── AppNavigation.kt ... El NavHost (El mapa de la app)
│
├── 🎨 ui/ ----------------- Capa de Presentación (Jetpack Compose)
│   ├── 🏠 home/ ........... Funcionalidad: Pantalla de Inicio
│   ├── 📄 listado_facturas/ Funcionalidad: Lista de facturas
│   ├── 🔍 filtros/ ........ Funcionalidad: Pantalla de filtros
│   └── 🧩 components/ ..... Piezas visuales reutilizables (Cards, Skeletons...)
│
└── 🛠️ utils/ -------------- Utilidades
    └── FormatearFecha.kt .. Funciones genéricas de ayuda
</pre>
## Cómo ejecutar el proyecto
* Clonar el repositorio.
* Abrir con Android Studio.
* Sincronizar los archivos de Gradle (KSP configurado para Room y Hilt).
* Ejecutar en un emulador o dispositivo físico con API 24 (Android 7.0) o superior.

