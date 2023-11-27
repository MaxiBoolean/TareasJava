
package Tarea_2;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Usuarios usuario = new Usuarios();  
        Biblioteca biblioteca = new Biblioteca();
        
        biblioteca.listaAutomatica();
        
        while (true) {

            String opcion = JOptionPane.showInputDialog(null,"""
                                                        Seleccione una opción:
                                                        
                                                        ----- Acciones -----
                                                        1. Registrar usuario
                                                        2. Alquilar libro
                                                        3. Devolver libro
                                                        4. Agregar libro a la biblioteca
                                                        5. Eliminar libro de la biblioteca
                                                        6. Buscar libro en la biblioteca
                                                        
                                                        ----- Registros -----
                                                        7. Ver usuarios registrados
                                                        8. Ver libros alquilados
                                                        9. Ver todos los Libros de la biblioteca                                                        
                                                        
                                                        0. Salir""", "Opciones", 3);

            switch (opcion) {
                case "1":                    
                    usuario.registrarse();
                    break;
                case "2":
                    usuario.alquilarLibro(biblioteca);
                    break;
                case "3":
                    usuario.devolverLibro(biblioteca);
                    break;
                case "4":
                    biblioteca.agregarLibro();
                    break;
                case "5":
                    biblioteca.eliminarLibro();
                    break;
                case "6":
                    biblioteca.buscarLibro();
                    break;
                case "7":
                    usuario.getListaUsuariosRegistrados();
                    break;   
                case "8":
                    usuario.listaDeLibrosAlquilados();                    
                break;    
                case "9":
                    biblioteca.listaDeLibros();
                break;    
                case "0":
                    JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.");
            }
        }
    
    }
}
