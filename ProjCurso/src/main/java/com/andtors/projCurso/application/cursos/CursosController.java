package com.andtors.projCurso.application.cursos;

import com.andtors.projCurso.domain.entity.Curso;
import com.andtors.projCurso.domain.exception.DuplicatedTupleException;
import com.andtors.projCurso.domain.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor
public class CursosController {

    private final CursoService cursoService;
    private final CursoMapper cursoMapper;

    @PostMapping
    public ResponseEntity save(@RequestBody CursosDTO dto) {
        try{
            Curso curso = cursoMapper.mapToCurso(dto);
            cursoService.save(curso);

            return ResponseEntity.status(HttpStatus.CREATED).build();

        } catch (DuplicatedTupleException e){
            Map<String, String> jsonResultado = Map.of("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(jsonResultado);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity getCurso(@PathVariable("id") Long id){

        return cursoService.getById(id)
                .map( user -> new ResponseEntity(user, HttpStatus.OK))
                .orElseGet( () -> new ResponseEntity("Curso não encontrado.", HttpStatus.NOT_FOUND));
    }
}
