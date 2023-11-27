package Tarea_2;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Usuarios {

    private int idUsuario;
    private String nombre;
    private String apellido;
    private int cantidadUsuarios = 0;
    private ArrayList<Libros> librosAlquilados;
    private static List<Usuarios> listaUsuariosRegistrados = new ArrayList<>();

    public Usuarios() {
        this.librosAlquilados = new ArrayList<>();
    }

    public Usuarios(int idUsuario, String nombre, String apellido) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;

    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    // Método para registrar al usuario
    public void registrarse() {
        String name = JOptionPane.showInputDialog("Ingrese su nombre:");
        String lastName = JOptionPane.showInputDialog("Ingrese su apellido:");
        this.cantidadUsuarios = ++cantidadUsuarios;
        this.idUsuario = cantidadUsuarios;

        Usuarios p1 = new Usuarios(idUsuario, name, lastName);
        listaUsuariosRegistrados.add(p1);
        JOptionPane.showMessageDialog(null, "¡Registro exitoso! Su ID de usuario es: " + idUsuario);
    }

    // Método para obtener la lista de usuarios registrados
    public void getListaUsuariosRegistrados() {
        if (listaUsuariosRegistrados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay usuarios registrados.", "Usuarios Registrados", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder mensaje = new StringBuilder("Usuarios Registrados:\n");
            for (Usuarios usuario : listaUsuariosRegistrados) {
                mensaje.append("ID: ").append(usuario.getIdUsuario()).append(" - Nombre: ").append(usuario.getNombre()).append(" - Apellido: ").append(usuario.getApellido()).append("\n");
            }
            JOptionPane.showMessageDialog(null, mensaje.toString(), "Usuarios", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private Usuarios obtenerUsuarioPorId(int idAverificar) {
        for (Usuarios usuario : listaUsuariosRegistrados) {            
            if (usuario.getIdUsuario() == idAverificar) {
                return usuario;
            }
        }
        JOptionPane.showMessageDialog(null, "No se encontró el ID de usuario");
        return null; // No se encontró el usuario        
    }

    // Método para alquilar un libro
    public void alquilarLibro(Biblioteca biblioteca) {
        if (listaUsuariosRegistrados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay usuarios registrados que puedan alquilar un libro.");
        } else {
            try {
                int idVerficacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su ID de usuario:"));
                Usuarios usuarioObtenido = obtenerUsuarioPorId(idVerficacion);
                JOptionPane.showMessageDialog(null, "Hola " + usuarioObtenido.getNombre() + "! puedes elegir uno de los siguientes libros.");
                biblioteca.listaDeLibros();
                String buscarLibro = JOptionPane.showInputDialog("Ingrese el título del libro a alquilar:");

                Libros libroObtenido = biblioteca.obtenerLibroPorTitulo(buscarLibro);
                librosAlquilados.add(libroObtenido);
                biblioteca.listaLibros.remove(libroObtenido);
                JOptionPane.showMessageDialog(null, "El libro fue alquilado con éxito: " + libroObtenido.getTitulo());

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un ID de usuario válido (número entero).");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error. Por favor, inténtelo de nuevo.");
            }
        }
    }

    // Método para devolver un libro
    public void devolverLibro(Biblioteca biblioteca) {
        if (listaUsuariosRegistrados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay usuarios registrados que puedan devolver su libro.");
        } else {
            try {
                int idVerficacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su ID de usuario:"));
                Usuarios usuarioObtenido = obtenerUsuarioPorId(idVerficacion);
                JOptionPane.showMessageDialog(null, "Hola " + usuarioObtenido.getNombre() + "! tienes los siguientes libros para devolver.");
                listaDeLibrosAlquilados();
                String buscarLibro = JOptionPane.showInputDialog("Ingrese el título del libro a alquilar:");

                Libros libroObtenido = obtenerLibroAlquiladoPorTitulo(buscarLibro);
                librosAlquilados.remove(libroObtenido);
                biblioteca.listaLibros.add(libroObtenido);
                JOptionPane.showMessageDialog(null, "El libro fue devuelto con éxito: " + libroObtenido.getTitulo());

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un ID de usuario válido (número entero).");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error. Por favor, inténtelo de nuevo.");
            }
        }
    }

    public Libros obtenerLibroAlquiladoPorTitulo(String tituloLibro) {
        if (tituloLibro.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el título de un libro.");
        } else {
            for (Libros libro : librosAlquilados) {
                if (libro.getTitulo().toLowerCase().equals(tituloLibro.toLowerCase())) {
                    return libro;
                }
            }
            JOptionPane.showMessageDialog(null, "No se encontró el título del libro.");
        }
        return null;
    }

    public void listaDeLibrosAlquilados() {
        if (librosAlquilados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay libros alquilados actualmente.");
        } else {
            StringBuilder mensaje = new StringBuilder("Lista de libros alquilados:\n");
            librosAlquilados.forEach(libro -> {
                mensaje.append("Título: ").append(libro.getTitulo()).append(" - Autor: ").append(libro.getAutor()).append(" - Genero: ").append(libro.getGenero()).append("\n");
            });
            JOptionPane.showMessageDialog(null, mensaje.toString(), "Libros alquilados", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
