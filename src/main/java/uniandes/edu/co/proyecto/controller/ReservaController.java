package uniandes.edu.co.proyecto.controller;

import org.springframework.ui.Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.edu.co.proyecto.repository.HabitacionRepository;
import uniandes.edu.co.proyecto.repository.ReservaRepository;

@Controller
public class ReservaController {

    @Autowired
    private ReservaRepository reservasRepository;

    @Autowired
    private HabitacionRepository habitacionRepository;

    @GetMapping("/reservas")
    public String reservas(Model model) {
        model.addAttribute("reservas", reservasRepository.findAllReservas());
        return "reservas";
    }

    @GetMapping("/reservas/new")
    public String reservasForm(Model model) {
        model.addAttribute("habitaciones", habitacionRepository.findAllHabitaciones());
        return "reservasNuevo";
    }
    
    @PostMapping("/reservas/new/save")
    public String reservasGuardar(@ModelAttribute("fechaInicio") String fechaInicio,
            @ModelAttribute("fechaFin") String fechaFin,
            @RequestParam(value = "hab", required = true) String numHabitacion) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaI = LocalDate.parse(fechaInicio, formatter);
        LocalDate fechaF = LocalDate.parse(fechaFin, formatter);
        ObjectId objectId = new ObjectId(numHabitacion);
        reservasRepository.save(new Reserva(fechaI, fechaF, objectId));
        return "redirect:/reservas";
    }

        @GetMapping("/reservas/{id}/delete")
    public String reservasEliminar(@PathVariable("id") String id) {

        reservasRepository.deleteById(id);
        return "redirect:/reservas";
    }

    @GetMapping("/reservas/{id}/edit")
    public String reservasEditar(@PathVariable("id") String id, Model model) {
        reservasRepository.deleteById(id);
        model.addAttribute("habitaciones", habitacionRepository.findAllHabitaciones());
        return "reservasNuevo";
    }

}
