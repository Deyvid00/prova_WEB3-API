package br.com.ifpe.oxefood.modelo.aluno;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.util.entity.GenericService;

@Service
public class AlunoService extends GenericService {

    @Autowired
    private AlunoRepository repository;

    @Transactional
    public Aluno save(Aluno aluno) {

        super.preencherCamposAuditoria(aluno);
        return repository.save(aluno);
    }

    public List<Aluno> listarTodos() {

        return repository.findAll();
    }

    public Aluno obterPorID(Long id) {

        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, Aluno alunoAlterado) {

        Aluno aluno = repository.findById(id).get();
        aluno.setNome(alunoAlterado.getNome());
        aluno.setDataNascimento(alunoAlterado.getDataNascimento());
        aluno.setFoneCelular(alunoAlterado.getFoneCelular());
        

        super.preencherCamposAuditoria(aluno);
        repository.save(aluno);
    }

    @Transactional
    public void delete(Long id) {

        Aluno aluno = repository.findById(id).get();
        aluno.setHabilitado(Boolean.FALSE);
        super.preencherCamposAuditoria(aluno);

        repository.save(aluno);
    }

}