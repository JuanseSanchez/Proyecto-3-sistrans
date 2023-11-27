package uniandes.edu.co.proyecto.modelo;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("consumos")
public class Consumo {

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
