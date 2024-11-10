package com.andtors.projCurso.application.cursos;

import com.andtors.projCurso.domain.entity.Curso;
import com.andtors.projCurso.domain.service.CursoService;
import com.andtors.projCurso.repository.CursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CursosServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;

    @Override
    @Transactional
    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public Optional<Curso> getById(Long id) {
        return cursoRepository.findById(id);
    }

    @Override
    public List<Curso> findAllById(List<Long> cursosId) {
        return cursoRepository.findAllById(cursosId);
    }
}
