package com.example.Arco.Controller;
import com.example.Arco.Model.Ciudadano;
import com.example.Arco.Service.CiudadanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ciudadanos")
public class CiudadanoController {
    @Autowired
    private CiudadanoService ciudadanoService;

    @GetMapping
    public List<Ciudadano> listarTodos() {
        return ciudadanoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Ciudadano obtenerPorId(@PathVariable String id) {
        return ciudadanoService.obtenerPorId(id);
    }

    @PostMapping
    public Ciudadano guardar(@RequestBody Ciudadano ciudadano) {
        return ciudadanoService.guardar(ciudadano);
    }

    @PutMapping("/{id}")
    public Ciudadano actualizar(@PathVariable String id, @RequestBody Ciudadano ciudadano) {
        Ciudadano existente = ciudadanoService.obtenerPorId(id);
        if (existente != null) {
            ciudadano.setId(id);
            return ciudadanoService.guardar(ciudadano);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        ciudadanoService.eliminar(id);
    }
}

