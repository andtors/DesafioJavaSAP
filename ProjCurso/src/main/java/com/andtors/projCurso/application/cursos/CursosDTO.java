package com.andtors.projCurso.application.cursos;

import com.andtors.projCurso.domain.entity.Aluno;
import lombok.Builder;
import lombok.Data;

import java.util.Collection;

@Data
@Builder
public class CursosDTO {

    private String nome;
    private String descricao;
}


