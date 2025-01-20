package com.challengeliteratura.challengeliteratura.client;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

import com.challengeliteratura.challengeliteratura.entity.AutorEntity;
import com.challengeliteratura.challengeliteratura.entity.LibroEntity;
import com.challengeliteratura.challengeliteratura.mapper.ConvierteDatos;
import com.challengeliteratura.challengeliteratura.model.Respuesta;
import com.challengeliteratura.challengeliteratura.repository.AutorRepository;
import com.challengeliteratura.challengeliteratura.repository.LibroRepository;
import com.challengeliteratura.challengeliteratura.service.ConsumoAPI;

public class ClienteLiteratura {

    private final String URL_BASE = "https://gutendex.com/books/?search=";
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();

    private LibroRepository libroRepositorio;
    private AutorRepository autorRepositorio;

    public ClienteLiteratura(LibroRepository libroRepositorio, AutorRepository autorRepositorio) {
        this.libroRepositorio = libroRepositorio;
        this.autorRepositorio = autorRepositorio;
    }

    public void menu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    Elija la opción a traves de su número:
                    	1.- Buscar libro por titulo
                    	2.- Lista libros registrados
                    	3.- Lista autores registrados
                    	4.- Lista autores que estaban vivos en un año específico
                    	5.- Listar libros por idioma
                    	0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibroWeb();
                    break;
                case 2:
                    buscarLibros();
                    break;
                case 3:
                    buscarAutores();
                    break;
                case 4:
                    buscarAutoresVivo();
                    break;
                case 5:
                    buscarPorIdiomas();
                    break;
                case 0:
                    System.out.println("Adios, Vuelva Pronto...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }

    }

    private void buscarLibros() {

        List<LibroEntity> libros = libroRepositorio.findAll();

        if (!libros.isEmpty()) {
            // Mapeo para traducir el código de idioma
            for (LibroEntity libro : libros) {
                String idiomaMostrar = libro.getLenguaje();
                if ("en".equals(idiomaMostrar)) {
                    idiomaMostrar = "Inglés";
                } else if ("es".equals(idiomaMostrar)) {
                    idiomaMostrar = "Español";
                }

                System.out.println("\n\n---------- LIBROS -------");
                System.out.println(" Titulo: " + libro.getTitulo());
                System.out.println(" Autor: " + libro.getAutor().getNombre());
                System.out.println(" Idioma: " + idiomaMostrar);
                System.out.println(" Descargas: " + libro.getDescargas());
                System.out.println("\n-------------------------\n\n");
            }

        } else {
            System.out.println("\n\n ----- NO SE ENCONTRARON RESULTADOS ---- \n\n");
        }
    }


    private void buscarAutores() {
        List<AutorEntity> autores = autorRepositorio.findAll();

        if (!autores.isEmpty()) {
            for (AutorEntity autor : autores) {
                System.out.println("\n\n---------- Autores -------\n");
                System.out.println(" Nombre: " + autor.getNombre());
                System.out.println(" Fecha de Nacimiento: " + autor.getFechaNacimiento());
                System.out.println(" Fecha de Fallecimiento: " + autor.getFechaFallecimiento());
                System.out.println(" Libros: " + autor.getLibros().getTitulo());
                System.out.println("\n-------------------------\n\n");
            }
        } else {
            System.out.println("\n\n ----- NO SE ENCONTRARON RESULTADOS ---- \n\n");

        }

    }

    private void buscarAutoresVivo() {
        System.out.println("Escriba el año para en el que vivio: ");
        var anio = teclado.nextInt();
        teclado.nextLine();

        List<AutorEntity> autores = autorRepositorio.findForYear(anio);

        if (!autores.isEmpty()) {
            for (AutorEntity autor : autores) {
                System.out.println("\n\n---------- Autores Vivos -------\n");
                System.out.println(" Nombre: " + autor.getNombre());
                System.out.println(" Fecha de nacimiento: " + autor.getFechaNacimiento());
                System.out.println(" Fecha de fallecimiento: " + autor.getFechaFallecimiento());
                System.out.println(" Libros: " + autor.getLibros().getTitulo());
                System.out.println("\n-------------------------\n\n");
            }
        } else {
            System.out.println("\n\n ----- NO SE ENCONTRARON RESULTADOS ---- \n\n");

        }
    }

    private void buscarPorIdiomas() {
        var menu = """
            Seleccione un Idioma:
            	1.- Español
            	2.- Inglés
    """;
        System.out.println(menu);
        var idioma = teclado.nextInt();
        teclado.nextLine();

        String seleccion = "";

        if (idioma == 1) {
            seleccion = "es";
        } else if (idioma == 2) {
            seleccion = "en";
        }

        List<LibroEntity> libros = libroRepositorio.findForLanguaje(seleccion);

        if (!libros.isEmpty()) {
            // Mapeo para traducir el código de idioma
            for (LibroEntity libro : libros) {
                String idiomaMostrar = libro.getLenguaje();
                if ("en".equals(idiomaMostrar)) {
                    idiomaMostrar = "Inglés";
                } else if ("es".equals(idiomaMostrar)) {
                    idiomaMostrar = "Español";
                }

                System.out.println("\n\n---------- LIBROS POR IDIOMA-------\n");
                System.out.println(" Titulo: " + libro.getTitulo());
                System.out.println(" Autor: " + libro.getAutor().getNombre());
                System.out.println(" Idioma: " + idiomaMostrar);
                System.out.println(" Descargas: " + libro.getDescargas());
                System.out.println("\n-------------------------\n\n");
            }

        } else {
            System.out.println("\n\n ----- NO SE ENCONTRARON RESULTADOS ---- \n\n");
        }
    }


    private void buscarLibroWeb() {
        Respuesta datos = getDatosSerie();

        if (!datos.results().isEmpty()) {
            // Obtener el primer libro
            LibroEntity libro = new LibroEntity(datos.results().get(0));
            libro = libroRepositorio.save(libro);

            // Decodificar el título del libro para mostrarlo correctamente
            String tituloDecodificado = URLDecoder.decode(libro.getTitulo(), StandardCharsets.UTF_8);

            String idioma = libro.getLenguaje();
            if ("en".equals(idioma)) {
                idioma = "Inglés";
            }

            // Mostrar solo la información relevante del libro encontrado
            System.out.println("Libro encontrado:");
            System.out.println("Titulo: " + tituloDecodificado);
            System.out.println("Autor: " + libro.getAutor().getNombre());
            System.out.println("Idioma: " + idioma);
            System.out.println("Descargas: " + libro.getDescargas());
        } else {
            // Si no se encuentran resultados
            System.out.println("No se encontraron resultados para el libro buscado.");
        }
    }

    private Respuesta getDatosSerie() {

        System.out.println("Ingresa el nombre del libro que deseas buscar: ");
        var titulo = teclado.nextLine();

        try {
            // Codificar el título usando URLEncoder para manejar todos los caracteres especiales
            String tituloCodificado = URLEncoder.encode(titulo, StandardCharsets.UTF_8.toString());

            // Realizar la llamada a la API
            var json = consumoApi.obtenerDatos(URL_BASE + tituloCodificado);

            // Convertir la respuesta JSON a un objeto Respuesta
            Respuesta datos = conversor.obtenerDatos(json, Respuesta.class);

            return datos;

        } catch (UnsupportedEncodingException e) {
            // Manejo de error si ocurre un problema con la codificación
            System.out.println("Error al codificar el título: " + e.getMessage());
            return null;
        } catch (Exception e) {
            // Manejo de cualquier otro error (por ejemplo, problemas con la API)
            System.out.println("Error al obtener datos de la API: " + e.getMessage());
            return null;
        }
    }
}
