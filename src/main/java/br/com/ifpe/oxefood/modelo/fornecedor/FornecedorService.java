package br.com.ifpe.oxefood.modelo.fornecedor;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.util.entity.GenericService;

@Service
public class FornecedorService extends GenericService {

    @Autowired
    private FornecedorRepository repository;

    @Transactional
    public Fornecedor save(Fornecedor fornecedor) {

        super.preencherCamposAuditoria(fornecedor);
        return repository.save(fornecedor);
    }

    public List<Fornecedor> listarTodos() {

        return repository.findAll();
    }

    public Fornecedor obterPorID(Long id) {

        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, Fornecedor fornecedorAlterado) {

        Fornecedor fornecedor = repository.findById(id).get();
        fornecedor.setNome(fornecedorAlterado.getNome());
        fornecedor.setEndereco(fornecedorAlterado.getEndereco());
        fornecedor.setDataFundacao(fornecedorAlterado.getDataFundacao());
        fornecedor.setValorMercado(fornecedorAlterado.getValorMercado());
        fornecedor.setPaginaWeb(fornecedorAlterado.getPaginaWeb());
        fornecedor.setContatoVendedor(fornecedorAlterado.getContatoVendedor());






        repository.save(fornecedor);
    }

    @Transactional
    public void delete(Long id) {

        Fornecedor m = repository.findById(id).get();
        m.setHabilitado(Boolean.FALSE);
        super.preencherCamposAuditoria(m);

        repository.save(m);
    }

}