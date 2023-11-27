package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.TipoHabitacion;
import uniandes.edu.co.proyecto.repository.TipoHabitacionRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TipoHabitacionController {
    
    @Autowired
    private TipoHabitacionRepository tipoHabitacionRepository;

        @GetMapping("/tiposHabitacion")
    public String tiposHabitacion(Model model) {
        model.addAttribute("tiposHabitacion", tipoHabitacionRepository.findAllTipoHabitaciones());
        return "tiposHabitacion";
    }

    @GetMapping("/tiposHabitacion/new")
    public String tiposHabitacionForm(Model model) {
        return "tiposhabitacionNuevo";
    }

    @PostMapping("/tiposHabitacion/new/save")
    public String tiposHabitacionGuardar(@ModelAttribute("nombre") String nombre,
            @RequestParam() String objeto1,
            @RequestParam() String objeto2,
            @RequestParam() String objeto3,
            @RequestParam() int costo)
            {
        
        List<String> dotacion = new ArrayList<String>();
        dotacion.add(objeto1);
        dotacion.add(objeto2);
        dotacion.add(objeto3);

        tipoHabitacionRepository.save(new TipoHabitacion(nombre, costo, dotacion));
        return "redirect:/tiposHabitacion";
    }

    @GetMapping("/tiposHabitacion/{tipo}/delete")
    public String eliminarTipoHabitacion(@PathVariable String tipo) {
        tipoHabitacionRepository.deleteByNombre(tipo);
        return "redirect:/tiposHabitacion";
    }

    @GetMapping("/tiposHabitacion/{tipo}/edit")
    public String tiposHabitacionEditarForm(@PathVariable("tipo") String tipo, Model model) {
        tipoHabitacionRepository.deleteByNombre(tipo);
        return "tiposhabitacionNuevo";
    }
}
