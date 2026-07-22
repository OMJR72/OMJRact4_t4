package com.omjr.act4_t4.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.omjr.act4_t4.dtos.EstudianteDTO;
import com.omjr.act4_t4.services.EstudianteService;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteRestController {

    @Autowired
    private EstudianteService estudianteService;

    // Obtener todos
    @GetMapping("/obtener")
    public ResponseEntity<List<EstudianteDTO>> obtenerEstudiantes() {

        List<EstudianteDTO> estudiantes = estudianteService.obtenerEstudiantes();
        return ResponseEntity.ok(estudiantes);
    }

    // Obtener por ID
    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDTO> obtenerPorId(@PathVariable Long id) {
        EstudianteDTO estudiante = estudianteService.obtenerPorId(id);
        return ResponseEntity.ok(estudiante);
    }

    // Guardar
    @PostMapping
    public ResponseEntity<EstudianteDTO> guardarEstudiante(@RequestBody EstudianteDTO dto) {
        EstudianteDTO estudiante = estudianteService.guardarEstudiante(dto);
        return new ResponseEntity<>(estudiante, HttpStatus.CREATED);
    }

    // Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<EstudianteDTO> actualizarEstudiante(@PathVariable Long id, @RequestBody EstudianteDTO dto) {
        EstudianteDTO estudiante = estudianteService.actualizarEstudiante(id, dto);
        return ResponseEntity.ok(estudiante);
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstudiante(@PathVariable Long id) {
        estudianteService.eliminarEstudiante(id);
        return ResponseEntity.noContent().build();
    }

    // Buscar por nombre
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<EstudianteDTO>> buscarPorNombre(@PathVariable String nombre) {
        return ResponseEntity.ok(estudianteService.buscarPorNombre(nombre));
    }

    // Buscar por apellido
    @GetMapping("/apellido/{apellido}")
    public ResponseEntity<List<EstudianteDTO>> buscarPorApellido(@PathVariable String apellido) {
        return ResponseEntity.ok(estudianteService.buscarPorApellido(apellido));
    }

    // Buscar por carrera
    @GetMapping("/carrera/{carrera}")
    public ResponseEntity<List<EstudianteDTO>> buscarPorCarrera(@PathVariable String carrera) {
        return ResponseEntity.ok(estudianteService.buscarPorCarrera(carrera));
    }

}