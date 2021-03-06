package br.com.veiculos.domain;

import javax.persistence.*;

@Entity
@Table(name="modelo_veiculo")
public class Modelo {

    @Id
    @SequenceGenerator(name="modelo", sequenceName="modelo_veiculo_cod_modelo_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="modelo")
    @Column(name="cod_modelo")
    private Integer codModelo;

    @ManyToOne
    @JoinColumn(name="cod_marca")
    private Marca codMarca;

    @ManyToOne
    @JoinColumn(name="cod_combustivel")
    private Combustivel codCombustivel;

    @Column(name="ano")
    private Long ano;

    @Column(name="descricao")
    private String modelo;

    public Modelo(){};

    public Modelo(Modelo modelo) {
        this.codModelo = modelo.codModelo;
        this.codMarca = modelo.codMarca;
        this.codCombustivel = modelo.codCombustivel;
        this.ano = modelo.ano;
        this.modelo = modelo.modelo;
    }

    public Modelo(Integer codModelo, Marca codMarca, Combustivel codCombustivel, Long ano, String modelo) {
        this.codModelo = codModelo;
        this.codMarca = codMarca;
        this.codCombustivel = codCombustivel;
        this.ano = ano;
        this.modelo = modelo;
    }

    public Integer getCodModelo() {
        return codModelo;
    }

    public void setCodModelo(Integer codModelo) {
        this.codModelo = codModelo;
    }

    public Marca getCodMarca() {
        return codMarca;
    }

    public void setCodMarca(Marca codMarca) {
        this.codMarca = codMarca;
    }

    public Combustivel getCodCombustivel() {
        return codCombustivel;
    }

    public void setCodCombustivel(Combustivel codCombustivel) {
        this.codCombustivel = codCombustivel;
    }

    public Long getAno() {
        return ano;
    }

    public void setAno(Long ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
