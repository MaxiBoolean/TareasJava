package Tarea1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Tarea1 {

    public static void main(String[] args) {
        String consulta;
        int consultaDos;

        String nombre;

        String apellido;

        String dni;

        String dia;

        String mes;

        String anio;

        String fechaNacimientoStr;

        List<String> listaPersonas = new ArrayList<>();

        //Ingreso de NOMBRE Y APELLIDO
        do {
            consulta = JOptionPane.showInputDialog("Qué operación quiere realizar? (1-2-3)\n 1- Agregar un usuario a la base de datos\n 2- Consultar la base de datos\n 3- Cerrar la aplicación");
            consultaDos = Integer.parseInt(consulta);
            switch (consultaDos) {
                case 1 -> {
                    nombre = JOptionPane.showInputDialog("Ingrese su nombre: ");
                    apellido = JOptionPane.showInputDialog("Ingrese su apellido: ");
                    //Verificar que los campos no estén vacíos
                    while (nombre.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No ingresó su nombre");
                        nombre = JOptionPane.showInputDialog("Ingrese su nombre: ");
                    }
                    while (apellido.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No ingresó su apellido");
                        apellido = JOptionPane.showInputDialog("Ingrese su apellido: ");
                    }

                    // Ingreso de DNI
                    do {
                        dni = JOptionPane.showInputDialog("Ingrese su DNI de 8 dígitos, sin puntos y sin letras:");

                        // Verifico que la longitud de la cadena sea 8 caracteres
                        if (dni.length() == 8) {
                            try {
                                // Convierto a entero para verfiicar que no haya letras o símbolos
                                int dniVerificado = Integer.parseInt(dni);
                                JOptionPane.showMessageDialog(null, "DNI ingresado: " + dniVerificado);
                                break;
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "El dato ingresado contiene letras o símbolos, vuelva a intentar.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El dato ingresado no contiene 8 dígitos, vuelva a intentar.");
                        }
                    } while (true);

                    //Ingreso de FECHA DE NACIMIENTO
                    do {
                        dia = JOptionPane.showInputDialog("Ingresa tu día de nacimiento (1-31)");
                        mes = JOptionPane.showInputDialog("Ingresa tu mes de nacimiento (1-12)");
                        anio = JOptionPane.showInputDialog("Ingresa tu año de nacimiento");
                        fechaNacimientoStr = dia + "/" + mes + "/" + anio;
                        try {
                            // Convertir la cadena a un objeto LocalDate
                            // Verificar si la fecha es válida
                            LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr, DateTimeFormatter.ofPattern("d/M/yyyy"));
                            JOptionPane.showMessageDialog(null, "Fecha de nacimiento ingresada: " + fechaNacimiento);
                            break;
                        } catch (DateTimeParseException e) {
                            JOptionPane.showMessageDialog(null, "La fecha de nacimiento no es válida. Por favor, ingrese una fecha válida.");
                        }
                    } while (true);

                    //Agrego los datos de la persona a la Lista
                    listaPersonas.add("Nombre: " + nombre + "\nApellido: " + apellido + "\nDNI: " + dni + "\nFecha de nacimiento: " + fechaNacimientoStr);
                }
                case 2 -> {
                    if (listaPersonas.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "La base de datos se encuentra actualmente vacía.\nPruebe ingresando datos con la opción 1");
                    } else {
                        for (String elemento : listaPersonas) {
                            JOptionPane.showMessageDialog(null, "Datos de persona:\n\n" + elemento);
                        }
                    }
                }
                case 3 ->
                    System.out.println("Se cierra la aplicación");
                default ->
                    System.out.println("no es valido");
            }
        } while (consultaDos != 3);

    }
}
