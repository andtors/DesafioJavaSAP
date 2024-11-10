package com.andtors.projCurso.domain.service;

import com.andtors.projCurso.domain.entity.Aluno;

import java.util.Optional;

public interface AlunoService {

    Aluno save(Aluno aluno);

    Aluno getByEmail(String email);

    Optional<Aluno> getById(Long id);

    Aluno inscricao(Aluno aluno);
}
