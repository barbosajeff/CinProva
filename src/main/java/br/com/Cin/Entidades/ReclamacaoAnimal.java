/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.Cin.Entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Jefferson
 */
@Entity
public class ReclamacaoAnimal extends Reclamacao implements Serializable {

   private Endereco localIncidente;
   
   @Column (length = 55,nullable = false   )
   private String animal;
   private Date dataIncidente;

    public ReclamacaoAnimal() {
    }

    public ReclamacaoAnimal(Endereco localIncidente, String animal, Date dataIncidente, Long id, Reclamante reclamante, String descricao, String observacao) {
        super(id, reclamante, descricao, observacao);
        this.localIncidente = localIncidente;
        this.animal = animal;
        this.dataIncidente = dataIncidente;
    }

    public ReclamacaoAnimal(Endereco localIncidente, String animal, Date dataIncidente, Reclamante reclamante, String descricao, String observacao) {
        super(reclamante, descricao, observacao);
        this.localIncidente = localIncidente;
        this.animal = animal;
        this.dataIncidente = dataIncidente;
    }

    public ReclamacaoAnimal(Endereco localIncidente, String animal, Date dataIncidente, Reclamante reclamante, String descricao) {
        super(reclamante, descricao);
        this.localIncidente = localIncidente;
        this.animal = animal;
        this.dataIncidente = dataIncidente;
    }

    public Endereco getLocalIncidente() {
        return localIncidente;
    }

    public void setLocalIncidente(Endereco localIncidente) {
        this.localIncidente = localIncidente;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public Date getDataIncidente() {
        return dataIncidente;
    }

    public void setDataIncidente(Date dataIncidente) {
        this.dataIncidente = dataIncidente;
    }
    
    
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.localIncidente);
        hash = 89 * hash + Objects.hashCode(this.animal);
        hash = 89 * hash + Objects.hashCode(this.dataIncidente);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ReclamacaoAnimal other = (ReclamacaoAnimal) obj;
        if (!Objects.equals(this.animal, other.animal)) {
            return false;
        }
        if (!Objects.equals(this.localIncidente, other.localIncidente)) {
            return false;
        }
        return Objects.equals(this.dataIncidente, other.dataIncidente);
    }

    @Override
    public String toString() {
        return "ReclamacaoAnimal{" + "localIncidente=" + localIncidente + ", animal=" + animal + ", dataIncidente=" + dataIncidente + '}';
    }
   
   
   
   
   
   

 
}
