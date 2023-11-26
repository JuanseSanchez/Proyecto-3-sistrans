package uniandes.edu.co.proyecto.modelo;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document("habitaciones")
public class Habitacion {

    @Id
    private int numero;

    private String hotel;
    private TipoHabitacion tipoHabitacion;
    private List<Cliente> clientes;

    public Habitacion(int numero, String hotel, TipoHabitacion tipoHabitacion, List<Cliente> clientes) {
        super();
        this.numero = numero;
        this.hotel = hotel;
        this.tipoHabitacion = tipoHabitacion;
        this.clientes = clientes;
    }

    public Habitacion() {
        super();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumeron(int numero) {
        this.numero = numero;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    


}
