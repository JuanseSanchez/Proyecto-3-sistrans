package uniandes.edu.co.proyecto.controller;

import org.springframework.ui.Model;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.Servicio;
import uniandes.edu.co.proyecto.repository.ServicioRepository;

@Controller
public class ServicioController {

    @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping("/tiposServicio")
    public String tiposServicio(Model model) {
        model.addAttribute("tiposServicio", servicioRepository.findAllServicios());
        return "tiposServicio";
    }

    @GetMapping("/tiposServicio/new")
    public String tiposServicioForm(Model model) {
        return "tiposServicioNuevo";
    }

    @PostMapping("/tiposServicio/new/save")
    public String tiposServicioGuardar(@RequestParam(value = "fecha") LocalDate fecha,
            @RequestParam(value = "precio") int precio) {
        servicioRepository.save(new Servicio(fecha, precio));
        return "redirect:/tiposServicio";
    }

    @GetMapping("/tiposServicio/{tipo}/edit")
    public String tiposServicioEditarForm(@PathVariable("tipo") String tipo, Model model) {
        model.addAttribute("tiposServicio", new Servicio());
        servicioRepository.deleteByNombre(tipo);
        return "tiposServicioNuevo";
    }

    @GetMapping("/tiposServicio/{tipo}/delete")
    public String tiposServicioEliminar(@PathVariable("tipo") String tipo) {
        servicioRepository.deleteByNombre(tipo);
        return "redirect:/tiposServicio";
    }
    
}
