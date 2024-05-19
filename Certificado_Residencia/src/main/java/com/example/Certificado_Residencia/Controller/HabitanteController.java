package com.example.Certificado_Residencia.Controller;

import com.example.Certificado_Residencia.Model.Habitante;
import com.example.Certificado_Residencia.Service.HabitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habitantes")
public class HabitanteController {
    @Autowired
    private HabitanteService habitanteService;

    @GetMapping
    public List<Habitante> listarTodos() {
        return habitanteService.listarTodos();
    }

    @GetMapping("/{id}")
    public Habitante obtenerPorId(@PathVariable Long id) {
        return habitanteService.obtenerPorId(id);
    }

    @PostMapping
    public Habitante guardar(@RequestBody Habitante habitante) {
        return habitanteService.guardar(habitante);
    }

    @PutMapping("/{id}")
    public Habitante actualizar(@PathVariable Long id, @RequestBody Habitante habitante) {
        Habitante existente = habitanteService.obtenerPorId(id);
        if (existente != null) {
            habitante.setId(id);
            return habitanteService.guardar(habitante);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        habitanteService.eliminar(id);
    }
}

