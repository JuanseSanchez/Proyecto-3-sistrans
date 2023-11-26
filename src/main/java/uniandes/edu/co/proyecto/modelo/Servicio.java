package uniandes.edu.co.proyecto.modelo;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document("servicios")
public class Servicio {

    @Id
    private String id;

    private String nombre;
    private int costo;

    public Servicio(String nombre, int costo) {
        super();
        this.nombre = nombre;
        this.costo = costo;
    }

    public Servicio() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    

}
