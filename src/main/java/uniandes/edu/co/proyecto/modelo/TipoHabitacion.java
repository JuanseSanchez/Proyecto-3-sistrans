package uniandes.edu.co.proyecto.modelo;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document("tipos_habitacion")
public class TipoHabitacion {

    @Id
    private String nombre;

    private int costo;
    private List<String> dotacion;

    public TipoHabitacion(String nombre, int costo, List<String> dotacion) {
        super();
        this.nombre = nombre;
        this.costo = costo;
        this.dotacion = dotacion;
    }

    public TipoHabitacion() {
        super();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public List<String> getDotacion() {
        return dotacion;
    }

    public void setDotacion(List<String> dotacion) {
        this.dotacion = dotacion;
    }

    
}
