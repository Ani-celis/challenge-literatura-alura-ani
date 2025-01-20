# Challenge Literatura 📚

Esta es una aplicación de consola desarrollada con Java, Hibernate, Spring y PostgreSQL que permite interactuar con una base de datos para realizar diversas operaciones relacionadas con libros y autores. La aplicación ofrece las siguientes funcionalidades:

Búsqueda de libros por título: Consulta una API externa (https://gutendex.com/ )para obtener información de libros y registra los datos en la base de datos.
Listado de libros registrados: Muestra todos los libros almacenados en la base de datos.
Listado de autores registrados: Muestra todos los autores registrados, con el apellido primero y el nombre después.
Filtrado de libros por idioma: Permite filtrar los libros por idioma (Español o Inglés).
Listado de autores vivos en un año específico: Permite ingresar un año y muestra los autores que estaban vivos en ese período.
## Tecnologías utilizadas
Java: Lenguaje de programación principal.
Spring Framework: Framework utilizado para gestionar la configuración de la aplicación.
Hibernate: ORM (Object-Relational Mapping) utilizado para la interacción con la base de datos.
PostgreSQL: Base de datos utilizada para almacenar la información de libros y autores.
## Requisitos previos
JDK 11 o superior: Debes tener instalado Java en tu sistema.
PostgreSQL: Asegúrate de tener PostgreSQL instalado y configurado.
IntelliJ IDEA: Se recomienda utilizar IntelliJ IDEA para desarrollar y ejecutar la aplicación.
Dependencias de Spring y Hibernate: Puedes obtener todas las dependencias necesarias utilizando Maven o Gradle.

## Uso
Una vez que la aplicación esté en ejecución, podrás interactuar con ella desde la consola utilizando las opciones que se te presenten.

## Funcionalidades
Búsqueda de libros por título: Ingrese el título de un libro y la aplicación buscará información sobre el libro, registrando los detalles en la base de datos.
Listar libros registrados: Muestra todos los libros almacenados en la base de datos.
Listar autores registrados: Muestra todos los autores, con el apellido primero y el nombre después.
Filtrar libros por idioma: Permite filtrar los libros registrados por idioma (Español o Inglés).
Listar autores vivos en un año específico: Ingresa un año y la aplicación te mostrará los autores que estaban vivos en ese período.

## Ejemplo de uso
Ejemplo de uso
1) Búsqueda de libros por título:
   
![image](https://github.com/user-attachments/assets/037abf08-68da-4b7e-99df-07ffb4474619)

2) Listar libros registrados:
   
![image](https://github.com/user-attachments/assets/b8cbbd91-a064-49a1-975d-3ab48d18d631)


3) Listar autores registrados:
   
![image](https://github.com/user-attachments/assets/be17c3e4-066a-4829-bd5e-623a97d9dd8a)


4) Listar autores vivos en un año específico:
   
![image](https://github.com/user-attachments/assets/87d56e80-c78a-4b8a-933c-887918f84823)

  
5) Filtrar libros por idioma:
    
![image](https://github.com/user-attachments/assets/8653111a-d716-4b37-abde-d22646b00174)


Ejemplo de datos guardados en nuestra Base de Datos:

1) Tabla libro:
   
![image](https://github.com/user-attachments/assets/66d4703e-e5e5-49d3-b930-5fcf9ee76cf2)


3) Tabla autor:
   
![image](https://github.com/user-attachments/assets/88c25569-012c-41f7-b73a-9072f362ab82)





