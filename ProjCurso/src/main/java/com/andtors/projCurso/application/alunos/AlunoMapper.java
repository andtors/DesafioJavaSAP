package com.andtors.projCurso.application.alunos;

import com.andtors.projCurso.domain.entity.Aluno;
import com.andtors.projCurso.domain.entity.Curso;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlunoMapper {

    public Aluno mapToAluno(AlunosDTO dto, List<Curso> cursosLista){
        return Aluno
                .builder()
                .email(dto.getEmail())
                .nome(dto.getNome())
                .cursos(cursosLista)
                .build();
    }
}