package uniandes.edu.co.proyecto.modelo;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document(collection = "reservas")
public class Reserva {
    //_id
    @Id
    private int id;

    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private ObjectId habitacion;

    public Reserva(LocalDate fechaInicio, LocalDate fechaFin, ObjectId habitacion) {
        super();
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.habitacion = habitacion;
        
    }

    public Reserva() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public ObjectId getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(ObjectId habitacion) {
        this.habitacion = habitacion;
    }

    
    
    
}
