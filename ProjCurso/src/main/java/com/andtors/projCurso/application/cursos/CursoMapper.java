package com.andtors.projCurso.application.cursos;

import com.andtors.projCurso.domain.entity.Curso;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class CursoMapper {

    public Curso mapToCurso(CursosDTO dto){
        return Curso
                .builder()
                .nome(dto.getNome())
                .descricao(dto.getDescricao())
                .alunos(Collections.emptyList())
                .build();
    }
}
