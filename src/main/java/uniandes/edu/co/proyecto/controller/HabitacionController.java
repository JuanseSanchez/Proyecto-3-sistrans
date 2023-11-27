package uniandes.edu.co.proyecto.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.modelo.TipoHabitacion;
import uniandes.edu.co.proyecto.repository.HabitacionRepository;
import uniandes.edu.co.proyecto.repository.TipoHabitacionRepository;

@Controller
public class HabitacionController {

    @Autowired
    private HabitacionRepository habitacionRepository;

    @Autowired
    private TipoHabitacionRepository tiposHabitacionRepository;

        @GetMapping("/habitaciones")
    public String habitaciones(Model model) {
        model.addAttribute("habitaciones", habitacionRepository.findAllHabitaciones());
        return "habitaciones";
    }

    @GetMapping("/habitaciones/new")
    public String habitacionesForm(Model model) {
        model.addAttribute("tiposHabitacion", tiposHabitacionRepository.findAllTipoHabitaciones());
        return "habitacionesNuevo";
    }

    @PostMapping("/habitaciones/new/save")
    public String habitacionesGuardar(@RequestParam(value = "numero") int numero,
            @ModelAttribute("hotel") String hotel,
            @ModelAttribute("tipoHabitacion") String tipoHabitacion) {
        TipoHabitacion tipo = tiposHabitacionRepository.findByNombre(tipoHabitacion);
        habitacionRepository.save(new Habitacion(numero, hotel, tipo, new ArrayList<>()));
        return "redirect:/habitaciones";
    }

    @GetMapping("/habitaciones/{numero}/edit")
    public String habitacionesEditarForm(@PathVariable("numero") int numero, Model model) {
        habitacionRepository.deleteById(numero);
        model.addAttribute("tiposHabitacion", tiposHabitacionRepository.findAllTipoHabitaciones());
        return "habitacionesNuevo";
    }

    @GetMapping("/habitaciones/{numero}/delete")
    public String habitacionesEliminar(@PathVariable("numero") int numero) {
        habitacionRepository.deleteById(numero);
        return "redirect:/habitaciones";
    }
    
}
