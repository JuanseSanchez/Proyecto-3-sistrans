package uniandes.edu.co.proyecto.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.Consumo;
import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.modelo.Servicio;
import uniandes.edu.co.proyecto.repository.ConsumoRepository;
import uniandes.edu.co.proyecto.repository.ServicioRepository;

@Controller
public class ConsumosController {

    @Autowired
    private ConsumoRepository consumoRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    
    @GetMapping("/consumos")
    public String consumos(Model model) {
        model.addAttribute("consumos", consumoRepository.findAllConsumos());
        return "consumos";
    }

    @GetMapping("/consumos/new")
    public String consumosForm(Model model) {
        model.addAttribute("servicios", servicioRepository.findAllServicios());
        return "consumosNuevo";
    }

    @PostMapping("/consumos/new/save")
    public String consumosGuardar(
            @RequestParam(value = "fecha", required = true) String fecha,
            @RequestParam(value = "servicio", required = true) String idServicio) {

        Optional <Servicio> servicio = servicioRepository.findById(idServicio);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fecha2 = LocalDate.parse(fecha, formatter);
        if (servicio.isPresent()) {
            consumoRepository.save(new Consumo(fecha2, servicio.get()));
        }
        return "redirect:/consumos";
    }

    @GetMapping("/consumos/{fecha}/delete")
    public String consumosEliminar(@PathVariable("fecha") LocalDate fecha) {

        consumoRepository.deleteById(fecha);
        return "redirect:/consumos";
    }

    @GetMapping("/consumos/{fecha}/edit")
    public String consumosEditar(@PathVariable("fecha") LocalDate fecha, Model model) {

        consumoRepository.deleteById(fecha);
        model.addAttribute("Cid", fecha);
        return "consumosNuevo";
    }

    
}
