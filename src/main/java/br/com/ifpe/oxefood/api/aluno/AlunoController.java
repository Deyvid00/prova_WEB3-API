package br.com.ifpe.oxefood.api.aluno;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.aluno.Aluno;
import br.com.ifpe.oxefood.modelo.aluno.AlunoService;
import br.com.ifpe.oxefood.util.entity.GenericController;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController extends GenericController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity<Aluno> save(@RequestBody @Valid AlunoRequest request) {

        Aluno alunoNovo = request.build();
        Aluno aluno = alunoService.save(alunoNovo);
        return new ResponseEntity<Aluno>(aluno, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Aluno> listarTodos() {

        return alunoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Aluno obterPorID(@PathVariable Long id) {

        return alunoService.obterPorID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> update(@PathVariable("id") Long id, @RequestBody AlunoRequest request) {

        alunoService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        alunoService.delete(id);
        return ResponseEntity.ok().build();
    }

}
