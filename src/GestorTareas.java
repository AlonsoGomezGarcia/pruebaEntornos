import java.util.ArrayList;
import java.util.List;

public class GestorTareas {
    private List<Tarea> tareas;
    private int siguienteId;

    public GestorTareas(){
        this.tareas = new ArrayList<>();
        this.siguienteId = 1;
    }

    public void agregarTarea(String titulo, String descripcion){
        Tarea nuevaTarea = new Tarea(siguienteId, titulo, descripcion, false);        
        tareas.add(nuevaTarea);
        siguienteId++;
    }

    public List<Tarea> obtenerTareas(){
        return tareas;
    }

    public Tarea buscarTareaPorId(int id){
        for(Tarea tarea : tareas){
            if (tarea.getId()==id) {
                return tarea;
            }
        }
        return null;
    }

    public boolean completarTarea(int id){
        Tarea tarea = buscarTareaPorId(id);
        if (tarea!=null) {
            tarea.marcarComoCompletada();
            return true;
        }
        return false;
    }
}