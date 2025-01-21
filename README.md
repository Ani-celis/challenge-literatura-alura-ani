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
   ![Opcion-1](https://github.com/user-attachments/assets/07686a3d-76bf-4195-a301-eb20c5bf28a0)


2) Listar libros registrados:
   
![image](https://github.com/user-attachments/assets/829b05d4-e1e2-4619-bc36-4160eb8dad68)


3) Listar autores registrados:
   
![image](https://github.com/user-attachments/assets/fa5ab897-45e7-464c-b9e9-700f74ef2853)



4) Listar autores vivos en un año específico:
   
![image](https://github.com/user-attachments/assets/5335d1c4-16f2-45cf-9270-d31c6f409a17)


  
5) Filtrar libros por idioma:
    ![image](https://github.com/user-attachments/assets/630e47bb-4cd0-46fa-bfd1-0aac1bc0270a)


Ejemplo de datos guardados en nuestra Base de Datos:

1) Tabla libro:
   
![image](https://github.com/user-attachments/assets/d6ed4a00-4596-4e1f-9e52-565df22224be)



3) Tabla autor:
   
![image](https://github.com/user-attachments/assets/0436e5ed-e783-46d0-9d0a-8c376f162e0d)






