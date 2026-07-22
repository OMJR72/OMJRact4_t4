package com.omjr.act4_t4.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.omjr.act4_t4.dtos.EstudianteDTO;
import com.omjr.act4_t4.entities.Estudiante;
import com.omjr.act4_t4.repositories.EstudianteRespository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRespository estudianteRespository;

    //Obtener todos
    public List<EstudianteDTO> obtenerEstudiantes() {

        List<Estudiante> estudiantes =
                estudianteRespository.findAllByOrderByIdAsc(PageRequest.of(0, 10));

        List<EstudianteDTO> estudiantesDTO = new ArrayList<>();

        for (Estudiante estudiante : estudiantes) {
            estudiantesDTO.add(convertirDTO(estudiante));
        }

        return estudiantesDTO;
    }

    //Obtener por ID
    public EstudianteDTO obtenerPorId(Long id) {

        Estudiante estudiante = estudianteRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

        return convertirDTO(estudiante);
    }

    //Guardar
    public EstudianteDTO guardarEstudiante(EstudianteDTO dto) {

        Estudiante estudiante = new Estudiante();

        estudiante.setNombre(dto.getNombre());
        estudiante.setApellido(dto.getApellido());
        estudiante.setCarrera(dto.getCarrera());
        estudiante.setSemestre(dto.getSemestre());

        Estudiante guardado = estudianteRespository.save(estudiante);

        return convertirDTO(guardado);
    }

    //Actualizar
    public EstudianteDTO actualizarEstudiante(Long id, EstudianteDTO dto) {

        Estudiante estudiante = estudianteRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

        estudiante.setNombre(dto.getNombre());
        estudiante.setApellido(dto.getApellido());
        estudiante.setCarrera(dto.getCarrera());
        estudiante.setSemestre(dto.getSemestre());

        Estudiante actualizado = estudianteRespository.save(estudiante);

        return convertirDTO(actualizado);
    }

    //Eliminar
    public void eliminarEstudiante(Long id) {
        estudianteRespository.deleteById(id);
    }

    //Buscar por

    //nombre
    public List<EstudianteDTO> buscarPorNombre(String nombre) {

        List<Estudiante> estudiantes =
                estudianteRespository.findByNombre(nombre, PageRequest.of(0, 10));

        List<EstudianteDTO> estudiantesDTO = new ArrayList<>();

        for (Estudiante estudiante : estudiantes) {
            estudiantesDTO.add(convertirDTO(estudiante));
        }

        return estudiantesDTO;
    }

    //apellido
    public List<EstudianteDTO> buscarPorApellido(String apellido) {

        List<Estudiante> estudiantes =
                estudianteRespository.findByApellido(apellido, PageRequest.of(0, 10));

        List<EstudianteDTO> estudiantesDTO = new ArrayList<>();

        for (Estudiante estudiante : estudiantes) {
            estudiantesDTO.add(convertirDTO(estudiante));
        }

        return estudiantesDTO;
    }

    //carrera
    public List<EstudianteDTO> buscarPorCarrera(String carrera) {

        List<Estudiante> estudiantes =
                estudianteRespository.findByCarrera(carrera, PageRequest.of(0, 10));

        List<EstudianteDTO> estudiantesDTO = new ArrayList<>();

        for (Estudiante estudiante : estudiantes) {
            estudiantesDTO.add(convertirDTO(estudiante));
        }

        return estudiantesDTO;
    }

    //Conversor
    private EstudianteDTO convertirDTO(Estudiante estudiante) {

        return new EstudianteDTO(
                estudiante.getId(),
                estudiante.getNombre(),
                estudiante.getApellido(),
                estudiante.getCarrera(),
                estudiante.getSemestre()
        );
    }

}