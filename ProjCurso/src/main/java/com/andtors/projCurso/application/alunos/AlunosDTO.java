package com.andtors.projCurso.application.alunos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlunosDTO {

    private String nome;
    private String email;
    private List<Long> curso_id;

}


