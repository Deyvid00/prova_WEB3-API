package br.com.ifpe.oxefood.api.fornecedor;

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

import br.com.ifpe.oxefood.modelo.fornecedor.Fornecedor;
import br.com.ifpe.oxefood.modelo.fornecedor.FornecedorService;
import br.com.ifpe.oxefood.util.entity.GenericController;

@RestController
@RequestMapping("/api/fornecedor")
public class FornecedorController extends GenericController {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping
    public ResponseEntity<Fornecedor> save(@RequestBody @Valid FornecedorRequest request) {

        Fornecedor fornecedorNovo = request.build();
        Fornecedor fornecedor = fornecedorService.save(fornecedorNovo);
        return new ResponseEntity<Fornecedor>(fornecedor, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Fornecedor> listarTodos() {

        return fornecedorService.listarTodos();
    }

    @GetMapping("/{id}")
    public Fornecedor obterPorID(@PathVariable Long id) {

        return fornecedorService.obterPorID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> update(@PathVariable("id") Long id, @RequestBody FornecedorRequest request) {

        fornecedorService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        fornecedorService.delete(id);
        return ResponseEntity.ok().build();
    }

}
