package br.edu.impacta.ads.aps.jpa.model;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(schema = "EMPRESA", name = "FUNCIONARIO")
public class Funcionario implements Serializable{
    
    @Id
    @Column(name = "ID_FUNCIONARIO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    
    @Column(name = "NOME")
    private String nome;
    
    @OneToOne
    @JoinColumn(name = "ID_CARGO")
    private Cargo cargo;
    
    @OneToOne
    @JoinColumn(name = "ID_DEPARTAMENTO")
    private Departamento departamento;
    
    @Column(name = "DT_CONTRATACAO")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dataContratacao;
    
    public Funcionario() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
   
    public Calendar getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(Calendar dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

}
