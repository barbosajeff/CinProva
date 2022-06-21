/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.Cin.Entidades;

import java.io.Serializable;
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
public abstract class Reclamacao implements Serializable  {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private Reclamante reclamante;
    @Column (length = 255, nullable = false )
    private String descricao;
    
    
    @Column (length = 50)
    private String observacao;

    public Reclamacao() {
    }

    public Reclamacao(Reclamante reclamante, String descricao, String observacao) {
        this.reclamante = reclamante;
        this.descricao = descricao;
        this.observacao = observacao;
    }

    public Reclamacao(Long id, Reclamante reclamante, String descricao, String observacao) {
        this.id = id;
        this.reclamante = reclamante;
        this.descricao = descricao;
        this.observacao = observacao;
    }

    public Reclamacao( Reclamante reclamante, String descricao) {
      
        this.reclamante = reclamante;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Reclamante getReclamante() {
        return reclamante;
    }

    public void setReclamante(Reclamante reclamante) {
        this.reclamante = reclamante;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.reclamante);
        hash = 53 * hash + Objects.hashCode(this.descricao);
        hash = 53 * hash + Objects.hashCode(this.observacao);
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
        final Reclamacao other = (Reclamacao) obj;
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.observacao, other.observacao)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.reclamante, other.reclamante);
    }

    @Override
    public String toString() {
        return "Reclamacao{" + "id=" + id + ", reclamante=" + reclamante + ", descricao=" + descricao + ", observacao=" + observacao + '}';
    }

  
    
    

    
}
