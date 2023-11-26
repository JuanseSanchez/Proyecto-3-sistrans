package uniandes.edu.co.proyecto.modelo;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document("clientes")
public class Cliente {

    @Id
    private String id;

    private String nombre;
    private LocalDate entrada;
    private LocalDate salida;
    private Consumo consumo;

    public Cliente(String nombre, LocalDate entrada, LocalDate salida, Consumo consumo) {
        super();
        this.nombre = nombre;
        this.entrada = entrada;
        this.salida = salida;
        this.consumo = consumo;
    }

    public Cliente() {
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

    public LocalDate getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDate entrada) {
        this.entrada = entrada;
    }

    public LocalDate getSalida() {
        return salida;
    }

    public void setSalida(LocalDate salida) {
        this.salida = salida;
    }

    public Consumo getConsumo() {
        return consumo;
    }

    public void setConsumo(Consumo consumo) {
        this.consumo = consumo;
    }

    

}
