package br.com.veiculos.domain;
import javax.persistence.*;

@Entity
@Table(name = "cor_veiculo")
public class Cor {
    @Id
    @SequenceGenerator(name="cor_veiculo", sequenceName="cor_veiculo_cod_cor_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="cor_veiculo")
    @Column(name="cod_cor")
    private Integer codCor;

    @Column(name="nome")
    private String cor;

    public Cor(Cor cor) {
        this.codCor = cor.getCodCor();
        this.cor = cor.getCor();
    }

    public Cor(){}


    public Integer getCodCor() {
        return codCor;
    }

    public void setCodCor(Integer codCor) {
        this.codCor = codCor;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}