public class Tarea {
    private int id;
    private String titulo;
    private String descripcion;
    private boolean completada;
    //CONSTRUCTOR
    public Tarea(int id, String titulo, String descripcion, boolean completada) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.completada = completada;
    }
    //GETTERS Y SETTERS
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {this.titulo = titulo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public boolean isCompletada() {
        return completada;
    }
    public void setCompletada(boolean completada) {
        this.completada = completada;
    }
    //METODO VOID PARA MARCAR COMO COMPLETADA
    public void marcarComoCompletada() {
            this.completada = true;
        }
    //METODO VOID PARA MODIFICAR DATOS
    public void modificarDatos(String nuevoTitulo, String nuevaDescripcion){
        this.titulo = nuevoTitulo;
        this.descripcion = nuevaDescripcion;
    }
    // HASHCODE
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
        result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
        result = prime * result + (completada ? 1231 : 1237);
        return result;
    }
    //EQUALS
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Tarea other = (Tarea) obj;
        if (id != other.id)
            return false;
        if (titulo == null) {
            if (other.titulo != null)
                return false;
        } else if (!titulo.equals(other.titulo))
            return false;
        if (descripcion == null) {
            if (other.descripcion != null)
                return false;
        } else if (!descripcion.equals(other.descripcion))
            return false;
        if (completada != other.completada)
            return false;
        return true;
    }
    //TO STRING
    @Override
    public String toString() {
        return "Tarea [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", completada=" + completada
                + "]";
    }
}



