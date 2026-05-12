public class GestorEdicion {
    private GestorTareas gestorTareas;

    public GestorEdicion(GestorTareas gestorTareas) {
        this.gestorTareas = gestorTareas;
    }

    public boolean editarTarea(int id, String nuevoTitulo, String nuevaDescripcion) {
        Tarea tarea = gestorTareas.buscarTareaPorId(id);

        if (tarea != null) {
            tarea.modificarDatos(nuevoTitulo, nuevaDescripcion);
            return true;
        }

        return false;
    }

    public boolean eliminarTarea(int id) {
        Tarea tarea = gestorTareas.buscarTareaPorId(id);

        if (tarea != null) {
            gestorTareas.obtenerTareas().remove(tarea);
            return true;
        }

        return false;
    }

    public int contarTareasPendientes() {
        int contador = 0;

        for (Tarea tarea : gestorTareas.obtenerTareas()) {
            if (!tarea.isCompletada()) {
                contador++;
            }
        }

        return contador;
    }

    public int contarTareasCompletadas() {
        int contador = 0;

        for (Tarea tarea : gestorTareas.obtenerTareas()) {
            if (tarea.isCompletada()) {
                contador++;
            }
        }

        return contador;
    }
}
