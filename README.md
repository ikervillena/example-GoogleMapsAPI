# API Google Maps - Obtener información de una dirección
Este proyecto es un ejemplo sencillo de cómo utilizar la API de Google Maps. En concreto, se utiliza
la API de Geocoding para obtener información sobre la ciudad, país, código postal y latitud 
de una dirección dada.

## Instrucciones de uso
1. Obtener una API Key de Google Maps.
   1. Iniciar sesión en la [consola de desarrolladores de Google](https://console.developers.google.com/)
   2. Crear un nuevo proyecto.
   3. Habilitar la API de Google Maps.
   4. Configura la API Key (crear credenciales y configurar la clave).
2. Agregar la API Key en la variable _apiKey_ en el archivo SiteDetails.java. 
3. Ejecutar la aplicación por medio del comando _*ant run*_.
4. Ingresar la dirección deseada en el campo de búsqueda y hacer clic en el botón "Buscar".
5. Se mostrará la información de la dirección encontrada (Ciudad, País, Código Postal y Latitud).

## Librerías utilizadas
El proyecto utiliza la biblioteca _*google-maps-services*_, una biblioteca cliente que sirve
para utilizar los servicios de Google Maps en Java.

## Detalles adicionales
* El programa incluye una interfaz gráfica simple para interactuar con ella.
* Se incluye un fichero ant que facilita la ejecución del programa.