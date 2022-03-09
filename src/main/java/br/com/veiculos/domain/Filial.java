package br.com.veiculos.domain;

import javax.persistence.*;

@Entity
@Table(name = "empresa")
public class Filial {
    @Id
    @SequenceGenerator(name="empresa", sequenceName="'empresa_cod_empresa_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empresa")
    @Column(name="cod_empresa")
    private int codFilial;

    @Column(name="cnpj")
    private long cnpj;

    @Column(name="razao_social")
    private String razaoSocial;

    @Column(name="cep")
    private long cep;

    @Column(name="logradouro")
    private String logradouro;

    @Column(name="bairro")
    private String bairro;

    @Column(name="numero")
    private int numero;

    @JoinColumn(name="cod_cidade")
    @ManyToOne
    private Cidade codCidade;

    @Column(name="complemento")
    private String complemento;

    public Filial(){};

    public Filial(Filial filial) {
        this.codFilial = filial.codFilial;
        this.cnpj = filial.cnpj;
        this.razaoSocial = filial.razaoSocial;
        this.cep = filial.cep;
        this.logradouro = filial.logradouro;
        this.bairro = filial.bairro;
        this.numero = filial.numero;
        this.codCidade = filial.codCidade;
        this.complemento = filial.complemento;
    }

    public int getcodFilial() {
        return codFilial;
    }

    public void setcodFilial(int codFilial) {
        this.codFilial = codFilial;
    }

    public long getCnpj() {
        return cnpj;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public long getCep() {
        return cep;
    }

    public void setCep(long cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Cidade getCodCidade() {
        return codCidade;
    }

    public void setCodCidade(Cidade codCidade) {
        this.codCidade = codCidade;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
