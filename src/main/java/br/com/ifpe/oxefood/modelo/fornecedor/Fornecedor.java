package br.com.ifpe.oxefood.modelo.fornecedor;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Fornecedor")
@Where(clause = "habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Fornecedor extends EntidadeAuditavel {

    private static final long serialVersionUID = -914751592262750356L;


    @Column
     private String nome;
     @Column
    private String endereco;
    @Column
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFundacao;
    @Column
    private Double valorMercado;
    @Column
    private String paginaWeb;
    @Column
    private String contatoVendedor;
   
}
