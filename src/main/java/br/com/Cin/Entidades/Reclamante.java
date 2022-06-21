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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Jefferson
 */
@Entity
public class Reclamante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(length = 55 , nullable = false)
    private String nomeCompleto;
    @Column(length = 55 , nullable = false)
    private String eMail;
    @Column(length = 13 , nullable = false)
    private String telefone;
    @OneToOne
    private Endereco endereco;

    public Reclamante() {
    }

    public Reclamante(Long id, String nomeCompleto, String eMail, String telefone, Endereco endereco) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.eMail = eMail;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Reclamante(String nomeCompleto, String eMail, String telefone, Endereco endereco) {
        this.nomeCompleto = nomeCompleto;
        this.eMail = eMail;
        this.telefone = telefone;
        this.endereco = endereco;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.nomeCompleto);
        hash = 37 * hash + Objects.hashCode(this.eMail);
        hash = 37 * hash + Objects.hashCode(this.telefone);
        hash = 37 * hash + Objects.hashCode(this.endereco);
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
        final Reclamante other = (Reclamante) obj;
        if (!Objects.equals(this.nomeCompleto, other.nomeCompleto)) {
            return false;
        }
        if (!Objects.equals(this.eMail, other.eMail)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.endereco, other.endereco);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Reclamante{" + "id=" + id + ", nomeCompleto=" + nomeCompleto + ", eMail=" + eMail + ", telefone=" + telefone + ", endereco=" + endereco + '}';
    }
    
}
