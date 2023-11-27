package uniandes.edu.co.proyecto.modelo;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

import java.util.List;

@Document("clientes")
public class Cliente {

    @Id
    private int id;

    private String nombre;
    private LocalDate entrada;
    private LocalDate salida;
    private List<Consumo> consumo;

    public Cliente(String nombre, LocalDate entrada, LocalDate salida, List<Consumo> consumo) {
        super();
        this.nombre = nombre;
        this.entrada = entrada;
        this.salida = salida;
        this.consumo = consumo;
    }

    public Cliente() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    
    public List<Consumo> getConsumo() {
        return consumo;
    }

    public void setConsumo(List<Consumo> consumo) {
        this.consumo = consumo;
    }
}
