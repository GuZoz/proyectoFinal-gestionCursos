# Proyecto Final – Gestión de Cursos de Ipartek

#### Autor: Guillermo Zozaya - 16/6/2017

Proyecto final del curso DESARROLLO DE APLICACIONES CON TECNOLOGÍAS WEB - IFCD0210, impartido por Ander Uraga en IPARTEK, Bilbao. 
Se incluye en el presente documento: 
* Una descripción resumida del proyecto, 
* requisitos de instalación,
* una enumeración de las tecnologías empleadas, 
* una descripción del proceso de instalación,
* y un manual de usuario con capturas de pantalla de las vistas de la aplicación en diferentes formatos de pantalla.

## Resumen del Proyecto

![Alt text](documentation/screenshots/desktop_1280x918_home_screenshot.jpg?raw=true 'Screenshot de vista principal del front office')

El proyecto final es una aplicación Web para visualización y mantenimiento de un catálogo de cursos de Ipartek. La aplicación consta de un Front Office público dedicado a la presentación y visualización de cursos y de un Back Office con acceso restringido que permite realizar la migración de archivos CSV a la base de datos, y crear modificar o eliminar los cursos existentes. 

La aplicación cuenta con un diseño RWD (Responsive Web Design), adaptado a escritorio PC y a móvil en la sección de cara al usuario, y adaptado a escritorio PC y tableta en la sección de mantenimiento.

Tanto el Front Office como el Back Office permiten realizar búsquedas de curso sin necesidad de actualizar la página web, que conducen a vistas de detalle de visualización (en el caso del Front Office) y de mantenimiento (en el caso del Back Office). La base de datos guarda entradas de curso modificables desde la aplicación (funcionalidad completa CRUD) con los campos de nombre del curso y su código.

El back-end de la aplicación cumple los criterios de CheckStyle del Gobierno Vasco (desarrollados por EJIE) para el framework J2EE (Xml con el formato adjunto en el fichero “documentation” en la raíz del proyecto). Tanto la parte de cara al público del front-end (El Front Office, que engloba las vistas “home” y “detail”) y el Back Office cumplen con los criterios A y AA de accesibilidad WCAG 2.0 (Web Content Accessibility Guidelines) del W3C.

## Requisitos de la instalación

Es necesario tener instalado el siguiente entorno para ejecutar la App:
* JDK 6 o superior
* DDBB: MySQL 5.0.8 o superior
* Servidor Aplicaciones Tomcat6 o superior

## Descripción de tecnologías empleadas

La aplicación web es un proyecto web escrito en lenguaje Java y tecnologías WEB (HTML, CSS y JavaScript), está basado en la plataforma Java, usa Maven como gestor de dependencias, se desarrolla en el marco de Spring desde el IDE Eclipse (según la plantilla de Spring Legacy Project),  y se apoya en las siguientes tecnologías y librerías de Java, Javascript y CSS3:
* Marco de la plataforma de Java Spring Framework, utilizando los módulos:
    * SpringFramework WebMVC
    * SpringFramework Security
    * Spring JDBC (API de Java - Java Database Connectivity)
* Libreria de Java – Mysql-Connector-Java (Conector MySQL para JDBC)
* Libreria de Java – AspectJ RT (Para aspectos en Java)
* Libreria de Java – Jackson-Mapper-ASL (Interpretador de JSON para la API REST)
* Libreria de Java – Javax-Inject (para inyección de objetos)
* Libreria de Java – OpenCSV (para lectura y manipulación de archivos CSV)
* Librerias Javax -Validation e Hibernate-Validator para validación de formularios
* Librerias Javax-Servlet para las APIs de SFL4J (Simple Logging Facade for Java)
* Librerias Javax-Servlet para las APIs de Servlet, Jstl (Standard Tag Library de Java (que permite el uso de EL o Expression Language en los JSPs)) y JSP (JavaServer Pages)
* Librería de JavaScript JQuery, para uso de tecnologías para el cliente (basadas en JS) 
* Tecnología Autocomplete (basada en JQuery) de la libreria JQuery-UI (Permite widgets Autocomplete para búsqueda reactiva a través de AJAX y una API REST para acceder a los registros de la base de datos)
* Tecnología de JQuery DataTables – Para estilado de listas paginadas y con funcionalidad de búsqueda local
* Marco de tecnologías Web (HTML, CSS, and JavaScript) BootStrap versión 3, para estilado responsive y móvil de la aplicación.

Los entregables del proyecto son: la carpeta con el código fuente y el archivo POM de configuración del proyecto,  la carpeta con la documentación del proyecto (donde se encuentra el enunciado y el informe del proyecto, el fichero de configuración del checkstyle y de la base de datos,  las capturas de pantalla, así como el juego de datos de cursos en formato CSV), la carpeta deploy con los recursos necesarios para despliegue en servidor (fichero WAR con el proyecto web, el  script de la Base de Datos (MySQL) y el juego de datos en CSV).

## Manual de instalación para desarrollo

1. Descargar el código fuente (la carpeta src) y el archivo de configuración de Maven (pom.xml) en la carpeta de desarrollo del proyecto.
2. Descargar las dependencias de Maven especificadas en el POM (En el IDE de Eclipse con el plugin para Maven, realizar un maven install).
3. Montar la Base de datos apoyándose en un gestor MySQL (Importando el script vacío de gestión de cursos, incluido en la carpeta documentation),  o configurar el proyecto para la Base de Datos de preferencia (la configuración de la conexión a la BBDD se encuentra en los archivos root-context.xml (src \main\webapp\WEB-INF\spring\) y database.properties (src\main\resources)).
4. Lanzar el servidor de desarrollo (la aplicación se ha desarrollado en Tomcat v7 en este caso, desde el IDE Eclipse). Se pueden incluir juegos de datos a través del gestor de la Base de Datos usando el script SQL que contiene 15 registros de cursos, o realizando una migración del archivo CSV incluido desde la propia aplicación durante desarrollo (Para realizar la migración lea el  Manual de Usuario).

## Manual de instalación para despliegue en servidor

Al ser un proyecto Web basado en tecnologías Java es necesario realizar la instalación en un servidor  que soporte dichas tecnologías, como JBoss o Apache Tomcat. En la carpeta de deploy se incluyen los archivos necesarios para desplegar la aplicación:
1. El proyecto web preparado para despliegue en un archivo WAR, el cual se deberá importar según el procedimiento adecuado en el servidor elegido. En el caso del Apache Tomcat, el archivo WAR se incluye en la carpeta webApp y al lanzar el servidor la aplicación debiera desplegarse automáticamente. 
2. El script SQL, que genera la Base de Datos “gestión_cursos” y una tabla vacía con las entradas de cursos llamada “curso”. La Base de datos ha sido desarrollada en MySQL, si se prefiere otra tecnología de Base de Datos será necesario cambiar la configuración de la conexión como se describe en el manual para desarrollo.
3. El archivo CSV con el juego de datos de cursos, el cual es posible migrar desde la propia aplicación una vez ésta haya sido desplegada y la Base de Datos se encuentre en funcionamiento.

## Manual de usuario

El manual de usuario se divide en dos partes, la descripción o manual de uso por parte del usuario cliente, que accede únicamente al Front Office de la aplicación, y el manual de uso y descripción de funcionalidades de mantenimiento del Back Office, al que accederá el usuario encargado de la gestión de los cursos. 

### Usuario Cliente - Vista principal y Vista de detalle

La Vista Principal de la aplicación presenta una cabecera con el título de la aplicación y un menú de navegación con enlaces a la Vista principal (Actualiza la Vista Principal o vuelve a ésta desde la Vista de Detalle) y a la Vista de Login o acceso al Back Office.
La Vista Principal de la aplicación presenta los últimos 10 cursos en una lista, así como un buscador de cursos con funcionalidad de autocompletar que filtra el texto a buscar contra la totalidad de los registros de curso en la Base de Datos. Tanto desde el menú desplegable del buscador como de la lista de últimos cursos es posible acceder a una Vista de Detalle.

##### Vista Principal en PC (ratio: 4/3)

![Alt text](documentation/screenshots/desktop_1280x918_home_screenshot.jpg?raw=true 'Screenshot de Vista Principal del front office en pantalla 4/3')

##### Vista Principal en PC (ratio: 16/9)

![Alt text](documentation/screenshots/desktop_1600x800_home_screenshot.jpg?raw=true 'Screenshot de Vista Principal del front office en pantalla 16/9')

La Vista de Detalle del curso presenta  información adicional sobre el curso, como su descripción, datos de contacto y otros detalles (De momento la aplicación sólo recoge el nombre y el código del curso, indispensables para buscar e identificar a cada curso, pero en el futuro pudiera incluir información adicional, guardada en la Base de Datos, a presentar en la Vista de Detalle).

##### Vista de Detalle en PC (ratio: 4/3)

![Alt text](documentation/screenshots/desktop_1280x918_detail_screenshot.jpg?raw=true 'Screenshot de Vista de Detalle del front office en pantalla 4/3')

El diseño del Front Office es igualmente accesible y adaptado al móvil, de acuerdo con los principios del Responsive Web Design, potenciando la exposición de la página web y multiplicando los puntos de acceso al servicio por parte del Usuario Cliente.

##### Vista Principal y de Detalle en móvil (ratio: 16/9, modo retrato)

![Alt text](documentation/screenshots/mobile_550x918_home_screenshot.jpg?raw=true 'Screenshot de Vista de Principal del front office en móvil')
![Alt text](documentation/screenshots/mobile_550x918_detail_screenshot.jpg?raw=true 'Screenshot de Vista de Detalle del front office en móvil')

### Usuario Gestor - Vista principal del Back Office y Vista de Mantenimiento 

Para acceder al Back Office es necesario introducir el usuario y la contraseña. El acceso se realizará desde la Vista de Login, que en caso de error (O de intento de acceso desde el Front Office sin haber iniciado la sesión) redirigirá a la Vista de Error de Login, que permite volver al Backoffice o redirigir a la Vista de Login. 
Los datos de acceso por defecto son “admin” para el campo de nombre y “2017#admin” para la contraseña.
Se puede modificar los datos de acceso en el fichero security-context.xml (etiqueta user-service) que se encuentra en la ruta (src\main\webapp\WEB-INF\spring) del código fuente del proyecto Web. (Esta acción requeriría volver a generar el fichero WAR de la aplicación y desplegarlo en el servidor, según se indica arriba de este documento en las instrucciones para desarrollo y para despliegue en el servidor).

##### Vista de Login en PC (ratio: 4/3) y en móvil (ratio: 16/9, modo retrato)

![Alt text](documentation/screenshots/desktop_1600x918_login_screenshot.jpg?raw=true 'Screenshot de Vista de Login en pantalla 4/3')
![Alt text](documentation/screenshots/mobile_550x918_login_screenshot.jpg?raw=true 'Screenshot de Vista de Login en móvil')

Las Vistas del Back Office incluyen una cabecera con el nombre de la vista presentada, un buscador de cursos con funcionalidad de autocompletar, y enlaces de navegación a la Vista Principal del Front Office (Home), al Logout del Back Office (Anula la sesión de Back Office iniciada al ejecutar con éxito el Login, y vuelve al Front Office), y en el caso de la Vista de Detalle un enlace a la Vista Principal del Back Office.
La Vista Principal del Back Office sigue una estructura modular que permite una expansión fácil de futuras funcionalidades y la agrupación estructurada de las operaciones de mantenimiento. La Vista Principal en su estado actual incluye tres Paneles, o Widgets, que permiten:

1. Seleccionar cursos existentes para realizar operaciones de modificado y eliminación,  a través del panel de listado (Incluye los últimos 500 cursos insertados, con buscador local y paginados en listas de 10 registros). IMPORTANTE: Para realizar una búsqueda contra la totalidad de cursos registrados en la base de datos, se deberá usar el buscador de la cabecera. Clicar en el nombre del curso en el panel de listado o en el menú desplegable del buscador de la cabecera llevará a la vista de detalle con la información del curso seleccionado, lo que permitirá realizar operaciones de mantenimiento contra ese registro (Modificado y eliminación del curso).
2. Crear un nuevo curso desde el panel correspondiente. De momento sólo tiene una opción de crear nuevo curso que lleva a la Vista de Detalle, pero en el futuro pudieran incluirse otras funcionalidades relacionadas con la creación de cursos.
3. Realizar la migración de registros de curso de un archivo en formato CSV (comma-separated values, o valores separados por comas) a la Base de Datos. Se muestra un campo para indicar la ruta donde se encuentra el archivo (Por defecto se muestra el directorio C: del entorno Windows), y un botón para iniciar la migración. La aplicación devolverá un mensaje indicando el éxito o fracaso de la operación. IMPORTANTE: El proceso de migración inserta saltando los registros con algún campo vacío en el CSV, pero no verifica la existencia de registros idénticos en la BBDD ni permite otras opciones de configuración avanzadas (como selección de campos a insertar del CSV). De momento, se pueden producir duplicaciones si se migra varias veces el archivo CSV. En este caso, vaciar la Base de Datos utilizando el script de despliegue, y volver a realizar la migración.

El diseño del Back Office está optimizado para uso en un entorno productivo, por lo tanto priorizando la visualización en PC en detrimento del móvil, aunque la estructura de paneles es capaz de adaptarse a formatos en modo retrato de tabletas.

##### Vista Principal del Back Office en PC (ratio: 4/3)

![Alt text](documentation/screenshots/desktop_1280x918_index_screenshot.jpg?raw=true 'Screenshot de Vista de Principal del back office en pantalla 4/3')

##### Vista Principal del Back Office en tableta (ratio: 4/3, modo retrato)

![Alt text](documentation/screenshots/tablet-portrait_820x918_index_screenshot.jpg?raw=true 'Screenshot de Vista de Principal del back office en tableta en modo retrato')

La Vista de Detalle del Back Office permite crear o modificar los diferentes atributos o campos de los registros de curso, ya sea uno nuevo o un registro a modificar. La cabecera de esta Vista incluye un enlace a la Vista Principal del Back Office que aborta la operación de mantenimiento en marcha. El cuerpo incluye un formulario que agrupa dichos campos, así como botones que variarán en caso de creación de nuevo registro (Crear) o de mantenimiento de uno existente (Modificar o Eliminar).
El formulario incluye una funcionalidad de validación, que impide la ejecución de la operación de mantenimiento a no ser que se cumplan unas condiciones en los campos del formulario. En este caso, criterios de longitud de nombre (entre 3 y 250 caracteres) y de longitud de código (entre 3 y 50 caracteres).

##### Vista de Detalle del Back Office en PC (ratio: 4/3)

![Alt text](documentation/screenshots/desktop_1280x918_form_screenshot.jpg?raw=true 'Screenshot de Vista de Detalle del back office en pantalla 4/3')