public class App {
    public static void main(String[] args) throws Exception {
        // 1. Creamos el motor de datos
        GestorTareas gestorTareas = new GestorTareas();
        
        // 2. Creamos el motor de edición pasándole el gestor de tareas
        GestorEdicion gestorEdicion = new GestorEdicion(gestorTareas);
        
        // 3. Inicializamos el menú con ambos gestores
        Menu menu = new Menu(gestorTareas, gestorEdicion);

        // 4. Arrancamos la aplicación
        menu.iniciar();
    }
}