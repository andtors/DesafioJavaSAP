package com.andtors.projCurso.domain.service;


import com.andtors.projCurso.domain.entity.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService {

    Curso save(Curso curso);

    Optional<Curso> getById(Long id);

    List<Curso> findAllById(List<Long> cursosId);


}
