package com.andtors.projCurso.application.alunos;

import com.andtors.projCurso.domain.entity.Aluno;
import com.andtors.projCurso.domain.exception.DuplicatedTupleException;
import com.andtors.projCurso.domain.exception.ValidationException;
import com.andtors.projCurso.domain.service.AlunoService;
import com.andtors.projCurso.repository.AlunoRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlunosServiceImpl implements AlunoService {


    private final AlunoRepository alunoRepository;

    @Override
    public Aluno getByEmail(String email) {
        return alunoRepository.findByEmail(email);
    }

    @Override
    public Optional<Aluno> getById(Long id) {
        return alunoRepository.findById(id);
    }

    @Override
    @Transactional
    public Aluno inscricao(Aluno aluno) {

        if(aluno.getEmail() == null || aluno.getEmail().trim().equals("")){
            throw new ValidationException("Email não pode estar vazio");
        }

        if(aluno.getNome() == null || aluno.getNome().trim().equals("")){
            throw new ValidationException("Nome não pode estar vazio.");
        }

        return alunoRepository.save(aluno);
    }

    @Override
    @Transactional
    public Aluno save(Aluno aluno) {
        var checarAlunoJaExiste = getByEmail(aluno.getEmail());
        if(checarAlunoJaExiste != null){
            throw new DuplicatedTupleException("Aluno já cadastrado!");
        }

        return alunoRepository.save(aluno);
    }

}
