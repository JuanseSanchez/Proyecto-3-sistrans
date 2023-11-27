package uniandes.edu.co.proyecto.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.Consumo;
import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.modelo.TipoHabitacion;
import uniandes.edu.co.proyecto.repository.ClienteRepository;

@Controller
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    
        @GetMapping("/clientes")
    public String clientes(Model model) {
        model.addAttribute("clientes", clienteRepository.findAllClientes());
        return "clientes";
    }

    @GetMapping("/clientes/new")
    public String clientesForm(Model model) {
        model.addAttribute("clientes", clienteRepository.findAllClientes());
        return "clientesnuevo";
    }

    @PostMapping("/clientes/new/save")
    public String clientesGuardar(@RequestParam(value = "nombre") String nombre,@RequestParam(value = "entrada") LocalDate entrada,@RequestParam(value = "salida") LocalDate salida) {
        clienteRepository.save(new Cliente(nombre, entrada, salida, new ArrayList<>()));
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/{numero}/edit")
    public String clientesEditarForm(@PathVariable("nombre") String nombre, Model model) {
        model.addAttribute("clientes", clienteRepository.findAllClientes());
        return "clientesNuevo";
    }

    @GetMapping("/clientes/{numero}/delete")
    public String clientesEliminar(@PathVariable("numero") int numero) {
        clienteRepository.deleteById(numero);
        return "redirect:/habitaciones";
    }
    
}
