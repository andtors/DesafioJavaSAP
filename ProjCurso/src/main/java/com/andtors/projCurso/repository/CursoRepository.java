package com.andtors.projCurso.repository;

import com.andtors.projCurso.domain.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
