# EQUIPO-DE-CLUB-API

## **Supuesto de la aplicación**

Se solicita una aplicación que pueda gestionar un equipo de un club, aunque inicialmente el equipo es de futbol, en un futuro próximo sería para gestionar equipos de todo tipo de deportes.

-   La aplicación será usada por entrenadores, jugadores/aficionados principalmente como apoyo para el trabajo de los entrenadores y comunicación a jugadores/aficionados (familiares).
-   La aplicación debería poder cargar los datos de la competición, calendario de partidos, lugar de los partidos y horarios.
-   La aplicación tendrá que permitir a los entrenadores llevar un registro personalizado de cada jugador, sobre los entrenamientos, partidos jugados, partidos desconvocados, etc….
-   Obtener estadísticas anuales por equipo y por jugadores, mostrándolas numéricamente y en gráficas/diagramas.
-   Publicar la lista de convocados semanales.
-   A los jugadores y familiares, poder consultar dichos datos.
-   A los jugadores y familiares, poder informar al club/equipo de cualquier incidencia, tales como, no entrenar o asistir a partido por enfermedad.
-   Permitirá comunicar mediante mensajería a los jugadores/familiares hora y lugar de entrenamientos y partidos, así como cualquier otra información de interés para el equipo o club.

La aplicación debe tener un servicio de suscripción para que el que desee, pueda recibir las distintas incidencias.

El uso de aplicación va a ser inminentemente para uso en smartphone, aunque debe ser multiplataforma.

---

## **Documentación del proyecto**

La **documentación del proyecto** se puede consultar en el siguiente link:

> ### [Wiki Proyecto](https://git.institutomilitar.com/sesporti/equiipo-de-club/wikis/home)

## **Proyecto vinculado a otro repositorio (proyecto)**

Este proyecto tiene **dependecia en su implementación de otro proyecto** que se encuentra en el siguiente repositorio:

> ### [EquiipoClub](https://git.institutomilitar.com/sesporti/equiipoclub.git)

---

## **Despliegue en local**

Antes de arrancar la API se debe arrancar la BD. Se usa [H2](https://h2database.com/html/main.html) en modo servidor.
Se puede levantar la BD usando el archivo `h2-version.jar`. Comprobar que tenemos acceso a la consola de H2 y que está corriendo.

Las propiedades de conexión son las que vienen por defecto:

> url=jdbc:h2:tcp://localhost/~/testEquipoClub  
> username=sa  
> password=basedatosh2  
> Entonces ejecutar la API con la última [release](https://git.institutomilitar.com/sesporti/equiipo-de-club/releases).

Mejor desde una consola para ver el log `java -jar equipoclubapi-VERSION.jar`.

Puedes utilizar esta colección Postman para probarla

[![Run in Postman](https://run.pstmn.io/button.svg)](https://documenter.getpostman.com/view/10815375/Szmb7zkg)
