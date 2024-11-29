package com.BibliotecaJava.Biblioteca.Spring.Boot.Java;

import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.dto.*;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.entities.AutorEntity;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.entities.LibroAutorEntity;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.entities.LibroEntity;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.entities.NacionalidadEntity;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.domain.entities.LibroEntity;
import com.BibliotecaJava.Biblioteca.Spring.Boot.Java.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final AutorService autorService;
    private final LibroService libroService;
    private final NacionalidadService nacionalidadService;
    private final LibroAutorService libroAutorService;

    public DataInitializer(AutorService autorService,
                           LibroService libroService,
                           NacionalidadService nacionalidadService,
                           LibroAutorService libroAutorService) {
        this.autorService = autorService;
        this.libroService = libroService;
        this.nacionalidadService = nacionalidadService;
        this.libroAutorService = libroAutorService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Crear Nacionalidad
        NacionalidadEntity nacionalidad = new NacionalidadEntity();
        nacionalidad.setNombre("Española");
        NacionalidadEntity savedNacionalidad = nacionalidadService.createNacionalidad(nacionalidad);

        // Crear Autor
        AutorEntity autor = new AutorEntity();
        autor.setNombre("Gabriel García Márquez");
        autor.setNacionalidad(savedNacionalidad);
        AutorEntity savedAutor = autorService.createAutor(autor);

        // Crear Libro
        LibroEntity libro = new LibroEntity();
        libro.setTitulo("Cien años de soledad");
        libro.setAutor(savedAutor);
        libro.setIsbn("978-3-16-148410-0");
        LibroEntity savedLibro = libroService.createLibro(libro);


        // Crear LibroAutor (relación muchos a muchos)
        LibroAutorEntity libroAutor = new LibroAutorEntity();
        libroAutor.setLibro(savedLibro);
        libroAutor.setAutor(savedAutor);
        libroAutor.setRol("Escritor");

        LibroAutorEntity savedLibroAutor = libroAutorService.createLibroAutor(libroAutor);

    }
}
