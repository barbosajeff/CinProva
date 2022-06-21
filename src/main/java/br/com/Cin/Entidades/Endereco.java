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
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long numero;
    @Column(length = 30 , nullable = false)
    private String logradouro;
    @Column(length = 30 , nullable = false)
    private String complemento;
    @Column(length = 30 , nullable = false)
    private String bairro;
    @Column(length = 30 , nullable = false)
    private String cidade;
    @Column(length = 8 , nullable = false)
    private String cep;

    public Endereco() {
    }

    public Endereco(Long id, Long numero, String logradouro, String complemento, String bairro, String cep) {
        this.id = id;
        this.numero = numero;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        cidade = "Recife";
    }

    
    
    
    
    
    @Override
    public String toString() {
        return "Endereco{" + "id=" + id + ", numero=" + numero + ", logradouro=" + logradouro + ", complemento=" + complemento + ", bairro=" + bairro + ", cidade=" + cidade + ", cep=" + cep + '}';
    }

    
    
    
    
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
        hash = 31 * hash + Objects.hashCode(this.bairro);
        hash = 31 * hash + Objects.hashCode(this.cep);
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
        final Endereco other = (Endereco) obj;
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (!Objects.equals(this.cep, other.cep)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    
    
    
    
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

            
    

}
