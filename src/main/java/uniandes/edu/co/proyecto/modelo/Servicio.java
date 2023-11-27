package uniandes.edu.co.proyecto.modelo;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document("servicios")
public class Servicio {

    @Id
    private String nombre;

    private LocalDate fecha;
    private int precio;

    public Servicio(LocalDate fecha, int precio){
        super();
        this.fecha = fecha;
        this.precio = precio;
    }

    public Servicio() {
        super();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    
    

}
