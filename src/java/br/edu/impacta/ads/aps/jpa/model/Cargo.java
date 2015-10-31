package br.edu.impacta.ads.aps.jpa.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "EMPRESA", name = "CARGO")
public class Cargo implements Serializable{  
    
    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CARGO") 
    private Integer codigo;
    
    @Column(name = "NOME")
    private String Nome;
    
    public Cargo() {
    }

    public Cargo(Integer codigo, String Nome) {
        this.codigo = codigo;
        this.Nome = Nome;
    }
   
    public int getCodigo() {
        return codigo;
    }
 
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }
    
}
