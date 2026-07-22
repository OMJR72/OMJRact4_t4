package com.omjr.act4_t4.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.omjr.act4_t4.entities.Estudiante;

@Repository
public interface EstudianteRespository extends JpaRepository<Estudiante, Long> {

    //Ordenar por ID
    List<Estudiante> findAllByOrderByIdAsc(Pageable pageable);

    // Ordenar por semestre
    List<Estudiante> findAllByOrderBySemestre(Pageable pageable);
    
    //Buscar por
    //nombre
    List<Estudiante> findByNombre(String nombre, Pageable pageable);

    //apellido
    List<Estudiante> findByApellido(String apellido, Pageable pageable);

    //carrera
    List<Estudiante> findByCarrera(String carrera, Pageable pageable);

}