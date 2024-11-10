package com.andtors.projCurso.application.alunos;

import com.andtors.projCurso.domain.entity.Aluno;
import com.andtors.projCurso.domain.entity.Curso;
import com.andtors.projCurso.domain.exception.DuplicatedTupleException;
import com.andtors.projCurso.domain.exception.ValidationException;
import com.andtors.projCurso.domain.service.AlunoService;
import com.andtors.projCurso.domain.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class AlunosController {

    private final AlunoService alunoService;
    private final AlunoMapper alunoMapper;
    private final CursoService cursoService;

    @PostMapping
    public ResponseEntity save(@RequestBody AlunosDTO dto) {
        try{
            List<Curso> cursos = new ArrayList<>();
            Aluno aluno = alunoMapper.mapToAluno(dto, cursos);
            alunoService.save(aluno);

            cursos.forEach(curso -> {
                curso.addAluno(aluno);
            });

            return ResponseEntity.status(HttpStatus.CREATED).build();

        } catch (DuplicatedTupleException e){
            Map<String, String> jsonResultado = Map.of("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(jsonResultado);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity getAluno(@PathVariable("id") Long id){
        return alunoService.getById(id)
                .map(aluno -> new ResponseEntity(aluno, HttpStatus.OK))
                .orElseGet( () -> new ResponseEntity("Aluno não encontrado.", HttpStatus.NOT_FOUND));
    }

    @PutMapping("{id}")
    public ResponseEntity inscricao(@PathVariable("id") Long id, @RequestBody AlunosDTO dto){
        return alunoService.getById(id)
                .map( entity -> {
                    try {
                        List<Curso> cursos = cursoService.findAllById(dto.getCurso_id());
                        Aluno aluno = alunoMapper.mapToAluno(dto, cursos);
                        aluno.setId(entity.getId());
                        aluno.prePersist();
                        alunoService.inscricao(aluno);
                        return ResponseEntity.ok(aluno);
                    } catch (ValidationException e) {
                        return ResponseEntity.badRequest().body(e.getMessage());
                    }
                })
                .orElseGet( () -> new ResponseEntity("Aluno não encontrado.",HttpStatus.NOT_FOUND));
    }
}
