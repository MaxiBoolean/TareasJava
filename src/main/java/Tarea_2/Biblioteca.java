package Tarea_2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

public class Biblioteca {

    ArrayList<Libros> listaLibros;

    //Agrego algunos libros a la biblioteca
    public void listaAutomatica() {
        Libros l1 = new Libros("Sol naciente", "Michael Crichton", "Thriller");
        Libros l2 = new Libros("Tormenta oscura", "Clive Cussler", "Aventura");
        Libros l3 = new Libros("Laberinto secreto", "Kate Mosse", "Misterio");
        Libros l4 = new Libros("Luz eterna", "Isabel Allende", "Drama");
        Libros l5 = new Libros("Caza salvaje", "Dan Brown", "Misterio");
        Libros l6 = new Libros("Fuego oscuro", "Stephen King", "Terror");
        Libros l7 = new Libros("Amor eterno", "Nicholas Sparks", "Romance");
        Libros l8 = new Libros("Niebla profunda", "Haruki Murakami", "Surrealismo");
        Libros l9 = new Libros("Pesadillas oscuras", "H.P. Lovecraft", "Terror");
        Libros l10 = new Libros("La casa del horror", "Shirley Jackson", "Terror");

        listaLibros.add(l1);
        listaLibros.add(l2);
        listaLibros.add(l3);
        listaLibros.add(l4);
        listaLibros.add(l5);
        listaLibros.add(l6);
        listaLibros.add(l7);
        listaLibros.add(l8);
        listaLibros.add(l9);
        listaLibros.add(l10);

    }

    // Constructor
    public Biblioteca() {
        this.listaLibros = new ArrayList<>();
    }

    // Método para agregar un libro a la biblioteca
    public void agregarLibro() {
        String titulo = JOptionPane.showInputDialog("Título del libro: ");
        String autor = JOptionPane.showInputDialog("Autor del libro: ");
        String genero = JOptionPane.showInputDialog("Genero del libro: ");
        Libros libro = new Libros(titulo, autor, genero);
        listaLibros.add(libro);
        JOptionPane.showMessageDialog(null, "Libro agregado a la biblioteca con éxito.");
    }

    // Método para eliminar un libro de la biblioteca por título
    public void eliminarLibro() {
        String tituloDos = JOptionPane.showInputDialog("Ingrese el título del libro a eliminar:  ");
        for (Libros libro : listaLibros) {
            if (libro.getTitulo().toLowerCase().equals(tituloDos.toLowerCase())) {
                listaLibros.remove(libro);
                JOptionPane.showMessageDialog(null, "Libro eliminado de la biblioteca con éxito.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "No se encontró ningún libro con el título especificado.");
    }

    // Método para buscar libros en la biblioteca por título, autor o género
    public void buscarLibro() {
        String criterio = JOptionPane.showInputDialog("Buscar por Título, Autor o Género:  ");
        List<Libros> resultados = listaLibros.stream()
                .filter(libro
                        -> libro.getTitulo().toLowerCase().contains(criterio.toLowerCase())
                || libro.getAutor().toLowerCase().contains(criterio.toLowerCase())
                || libro.getGenero().toLowerCase().contains(criterio.toLowerCase()))
                .collect(Collectors.toList());

        if (resultados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se encontraron libros que coincidan con el criterio de búsqueda.");
        } else {
            String mensaje = resultados.stream()
                    .map(libro -> "Título: " + libro.getTitulo() + " - " + "Autor: " + libro.getAutor())
                    .collect(Collectors.joining("\n"));

            JOptionPane.showMessageDialog(null, "Resultados de la búsqueda:\n" + mensaje,
                    "Resultados de la Búsqueda", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public Libros obtenerLibroPorTitulo(String tituloLibro) {
        if (tituloLibro.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el título de un libro.");
        } else {
            for (Libros libro : listaLibros) {
                if (libro.getTitulo().toLowerCase().equals(tituloLibro.toLowerCase())) {
                    return libro;
                }
            }
            JOptionPane.showMessageDialog(null, "No se encontró el título del libro.");
        }
        return null;
    }

    public Libros listaDeLibros() {
        StringBuilder mensaje = new StringBuilder("Lista de libros en biblioteca:\n");
        listaLibros.forEach(libro -> {
            mensaje.append("Título: ").append(libro.getTitulo()).append(" - Autor: ").append(libro.getAutor()).append(" - Genero: ").append(libro.getGenero()).append("\n");
        });
        JOptionPane.showMessageDialog(null, mensaje.toString(), "Biblioteca", JOptionPane.INFORMATION_MESSAGE);
        return null;
    }
}
