# **EQUIPO-DE-CLUB-API**

---

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

> ### [Wiki Proyecto](https://git.institutomilitar.com/sesporti/equiipo-de-club/wikis/home), sólo acceso desde GitLab privado.

## **Proyecto vinculado a otro repositorio (proyecto)**

Este proyecto tiene **dependecia en su implementación de otro proyecto** que se encuentra en el siguiente repositorio:

> ### [EquiipoClub en GitLab](https://git.institutomilitar.com/sesporti/equiipoclub.git), sólo acceso desde GitLab privado.
> ### [EquiipoClub en GitHub](https://github.com/sesporti/equiipoclub), repositorio público.

---

## FrontEnd-Web EquipoClubWeb

- Dentro de la carpeta [`FrontEndWeb`](./FrontEndWeb/Equipo-Club-web) se encuentra el proyecto de desarrollo del Front-web de la aplicación Equiipo-Club.   
- Ha sido generado con `Angular v9.1.1`.   
- Se han utilizado como librerías en el proyecto `Bootstrap, AngularMaterial y FontAwesome`, así mismo se ha utilizado para documentar el proyecto la librería [`Compodoc`](https://compodoc.app/).   
- La aplicación para Demo se encuentra desplegada en produccion en este servidor web de aplicaciones [**Equiipo de Club**](https://sesporti.github.io/).

---

## **Despliegue en local**

Antes de arrancar la API se debe arrancar la BD. Se usa [H2](https://h2database.com/html/main.html) en _modo servidor_.
Se puede levantar la BD usando el archivo [`h2-version.jar`](./assets/despliegueLocal/). Comprobar que tenemos acceso a la consola de H2 y que está corriendo.

Las propiedades de conexión a la BD,s son las que vienen a continuación:

> url=jdbc:h2:tcp://localhost/~/testEquipoClub  
> username=sa  
> password=basedatosh2  
> Entonces ejecutar la API con la versión incluida en carpeta `despliegueLocal`.

El despliegue se puede hacer mejor desde una consola para ver el log [`java -jar equipoclubapi-VERSION.jar`](./assets/despliegueLocal/).

Así mismo, para realizar pruebas puede seguir las intrucciones del apartado `Postman`.   

---

## **Despliegue en la nube**

Para el despliegue en la nube del _Backend_ se usa el [deploy en Heroku](https://github.com/sesporti/equiipo-de-club/deployments) para probarlo directamente. Al estar utilizando [Heroku](https://www.heroku.com/) hay que tener en cuenta lo siguiente:
1. El servicio hiberna despúes 30 minutos sin usar y tardará un poco más en la primera petición.
1. Usar el environment `Heroku` de _**`Postman`**_.

---

## **Postman**

Si se realiza el despliegue en local deberá utilizar en Postman el entorno `Local Equipo de Club`, si por el contrario se realiza el despligue en la nube deberá utilizar el entorno `Heroku` de la colección.

- La [documentación de la API en Postman](https://documenter.getpostman.com/view/10815375/Szmb7zkg) esta disponible siguiendo el enlace, así mismo pulsando el botón _`Run in Postman`_ se puede ejecutar la colección en Postman.

[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/1ba2754905d84a88c60c)


