package uniandes.edu.co.proyecto.modelo;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document("consumos")
public class Consumo {

    @Id
    private String id;

    private LocalDate fecha;
    private Servicio servicio;

    public Consumo(LocalDate fecha, Servicio servicio) {
        super();
        this.fecha = fecha;
        this.servicio = servicio;
    }

    public Consumo() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    

}
