/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.Cin.Entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Jefferson
 */
@Entity
public class ReclamacaoEspecial extends Reclamacao implements Serializable {

    private Date dataDoOcorencia ;
    
    private Endereco localDOcorencia;

    public ReclamacaoEspecial() {
    }

    public ReclamacaoEspecial(Date dataDoOcorencia, Endereco localDOcorencia, Long id, Reclamante reclamante, String descricao, String observacao) {
        super(id, reclamante, descricao, observacao);
        this.dataDoOcorencia = dataDoOcorencia;
        this.localDOcorencia = localDOcorencia;
    }

    public ReclamacaoEspecial(Date dataDoOcorencia, Endereco localDOcorencia, Reclamante reclamante, String descricao, String observacao) {
        super(reclamante, descricao, observacao);
        this.dataDoOcorencia = dataDoOcorencia;
        this.localDOcorencia = localDOcorencia;
    }

    public ReclamacaoEspecial(Date dataDoOcorencia, Endereco localDOcorencia, Reclamante reclamante, String descricao) {
        super(reclamante, descricao);
        this.dataDoOcorencia = dataDoOcorencia;
        this.localDOcorencia = localDOcorencia;
    }

    public Date getDataDoOcorencia() {
        return dataDoOcorencia;
    }

    public void setDataDoOcorencia(Date dataDoOcorencia) {
        this.dataDoOcorencia = dataDoOcorencia;
    }

    public Endereco getLocalDOcorencia() {
        return localDOcorencia;
    }

    public void setLocalDOcorencia(Endereco localDOcorencia) {
        this.localDOcorencia = localDOcorencia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.dataDoOcorencia);
        hash = 67 * hash + Objects.hashCode(this.localDOcorencia);
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
        final ReclamacaoEspecial other = (ReclamacaoEspecial) obj;
        if (!Objects.equals(this.dataDoOcorencia, other.dataDoOcorencia)) {
            return false;
        }
        return Objects.equals(this.localDOcorencia, other.localDOcorencia);
    }

    @Override
    public String toString() {
        return "ReclamacaoEspecial{" + "dataDoOcorencia=" + dataDoOcorencia + ", localDOcorencia=" + localDOcorencia + '}';
    }
    
    
    
    
    
}
