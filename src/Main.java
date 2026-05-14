public class Main {
    public static void main(String[] args) {
        GestorTareas gestorTareas = new GestorTareas();
        GestorEdicion gestorEdicion = new GestorEdicion(gestorTareas);
        Menu menu = new Menu(gestorTareas, gestorEdicion);

        menu.iniciar();
    }
}