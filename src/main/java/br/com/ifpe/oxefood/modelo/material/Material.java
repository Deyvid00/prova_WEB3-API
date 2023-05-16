package br.com.ifpe.oxefood.modelo.material;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Material")
@Where(clause = "habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Material extends EntidadeAuditavel {

    private static final long serialVersionUID = -914751592262750356L;

    @Column
    private String titulo;

    @Column
    private Double valor;

    @Column
    private String resposavel;

    @Column
    private String localizacao;

    @Column
    private Double peso;

    @Column
    private LocalDate dataAquisicao;

}
