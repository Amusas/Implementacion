package com.example.Certificado_Residencia.Controller;

import com.example.Certificado_Residencia.Model.Certificado;
import com.example.Certificado_Residencia.Service.CertificadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recibos-publicos")
public class CertificadoController {
    @Autowired
    private CertificadoService certificadoService;

    @GetMapping
    public List<Certificado> listarTodos() {
        return certificadoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Certificado obtenerPorId(@PathVariable Long id) {
        return certificadoService.obtenerPorId(id);
    }

    @PostMapping
    public Certificado guardar(@RequestBody Certificado certificado) {
        return certificadoService.guardar(certificado);
    }

    @PutMapping("/{id}")
    public Certificado actualizar(@PathVariable Long id, @RequestBody Certificado certificado) {
        Certificado existente = certificadoService.obtenerPorId(id);
        if (existente != null) {
            certificado.setId(id);
            return certificadoService.guardar(certificado);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        certificadoService.eliminar(id);
    }
}

