
import java.util.Scanner;
public class Menu {
    private GestorTareas gestorTareas;
    private GestorEdicion gestorEdicion;
    private Scanner scanner;

    public Menu(GestorTareas gestorTareas, GestorEdicion gestorEdicion) {
        this.gestorTareas = gestorTareas;
        this.gestorEdicion = gestorEdicion;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcion;

        do {
            mostrarOpciones();
            opcion = leerEntero("Elige una opción: ");
            ejecutarOpcion(opcion);
        } while (opcion != 6);
    }

    private void mostrarOpciones() {
        System.out.println("\n--- GESTOR DE TAREAS ---");
        System.out.println("1. Añadir tarea");
        System.out.println("2. Ver tareas");
        System.out.println("3. Completar tarea");
        System.out.println("4. Editar tarea");
        System.out.println("5. Eliminar tarea");
        System.out.println("6. Salir");
    }

    private void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> agregarTareaDesdeMenu();
            case 2 -> mostrarTareas();
            case 3 -> completarTareaDesdeMenu();
            case 4 -> editarTareaDesdeMenu();
            case 5 -> eliminarTareaDesdeMenu();
            case 6 -> System.out.println("Saliendo...");
            default -> System.out.println("Opción no válida.");
        }
    }

    private void agregarTareaDesdeMenu() {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();

        gestorTareas.agregarTarea(titulo, descripcion);
        System.out.println("Tarea añadida.");
    }

    private void mostrarTareas() {
        for (Tarea tarea : gestorTareas.obtenerTareas()) {
            System.out.println(tarea);
        }

        System.out.println("Pendientes: " + gestorEdicion.contarTareasPendientes());
        System.out.println("Completadas: " + gestorEdicion.contarTareasCompletadas());
    }

    private void completarTareaDesdeMenu() {
        int id = leerEntero("ID de la tarea: ");

        if (gestorTareas.completarTarea(id)) {
            System.out.println("Tarea completada.");
        } else {
            System.out.println("No existe esa tarea.");
        }
    }

    private void editarTareaDesdeMenu() {
        int id = leerEntero("ID de la tarea: ");

        System.out.print("Nuevo título: ");
        String titulo = scanner.nextLine();

        System.out.print("Nueva descripción: ");
        String descripcion = scanner.nextLine();

        if (gestorEdicion.editarTarea(id, titulo, descripcion)) {
            System.out.println("Tarea editada.");
        } else {
            System.out.println("No existe esa tarea.");
        }
    }

    private void eliminarTareaDesdeMenu() {
        int id = leerEntero("ID de la tarea: ");

        if (gestorEdicion.eliminarTarea(id)) {
            System.out.println("Tarea eliminada.");
        } else {
            System.out.println("No existe esa tarea.");
        }
    }

    private int leerEntero(String mensaje) {
        System.out.print(mensaje);
        int numero = scanner.nextInt();
        scanner.nextLine();
        return numero;
    }
}