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
public class ReclamacaoFood extends Reclamacao implements Serializable {

   private VitimaFood vitima;
   
   @Column (length = 60)
   private String refeicao;
   
   private Long numeroMortes;
   private Long numeroPessoasComeram;
   private Long numeroHospitalizacao;
   private Long numeroDoentes;
   
   @Column (length = 60)
   private String hosítalDAtendimento;

    public ReclamacaoFood() {
    }

    public ReclamacaoFood(VitimaFood vitima, String refeicao, Long numeroMortes, Long numeroPessoasComeram, Long numeroHospitalizacao, Long numeroDoentes, String hosítalDAtendimento, Reclamante reclamante, String descricao, String observacao) {
        super(reclamante, descricao, observacao);
        this.vitima = vitima;
        this.refeicao = refeicao;
        this.numeroMortes = numeroMortes;
        this.numeroPessoasComeram = numeroPessoasComeram;
        this.numeroHospitalizacao = numeroHospitalizacao;
        this.numeroDoentes = numeroDoentes;
        this.hosítalDAtendimento = hosítalDAtendimento;
    }

    public ReclamacaoFood(VitimaFood vitima, String refeicao, Long numeroMortes, Long numeroPessoasComeram, Long numeroHospitalizacao, Long numeroDoentes, String hosítalDAtendimento, Long id, Reclamante reclamante, String descricao, String observacao) {
        super(id, reclamante, descricao, observacao);
        this.vitima = vitima;
        this.refeicao = refeicao;
        this.numeroMortes = numeroMortes;
        this.numeroPessoasComeram = numeroPessoasComeram;
        this.numeroHospitalizacao = numeroHospitalizacao;
        this.numeroDoentes = numeroDoentes;
        this.hosítalDAtendimento = hosítalDAtendimento;
    }

    public ReclamacaoFood(VitimaFood vitima, String refeicao, Long numeroMortes, Long numeroPessoasComeram, Long numeroHospitalizacao, Long numeroDoentes, String hosítalDAtendimento, Reclamante reclamante, String descricao) {
        super(reclamante, descricao);
        this.vitima = vitima;
        this.refeicao = refeicao;
        this.numeroMortes = numeroMortes;
        this.numeroPessoasComeram = numeroPessoasComeram;
        this.numeroHospitalizacao = numeroHospitalizacao;
        this.numeroDoentes = numeroDoentes;
        this.hosítalDAtendimento = hosítalDAtendimento;
    }

    public VitimaFood getVitima() {
        return vitima;
    }

    public void setVitima(VitimaFood vitima) {
        this.vitima = vitima;
    }

    public String getRefeicao() {
        return refeicao;
    }

    public void setRefeicao(String refeicao) {
        this.refeicao = refeicao;
    }

    public Long getNumeroMortes() {
        return numeroMortes;
    }

    public void setNumeroMortes(Long numeroMortes) {
        this.numeroMortes = numeroMortes;
    }

    public Long getNumeroPessoasComeram() {
        return numeroPessoasComeram;
    }

    public void setNumeroPessoasComeram(Long numeroPessoasComeram) {
        this.numeroPessoasComeram = numeroPessoasComeram;
    }

    public Long getNumeroHospitalizacao() {
        return numeroHospitalizacao;
    }

    public void setNumeroHospitalizacao(Long numeroHospitalizacao) {
        this.numeroHospitalizacao = numeroHospitalizacao;
    }

    public Long getNumeroDoentes() {
        return numeroDoentes;
    }

    public void setNumeroDoentes(Long numeroDoentes) {
        this.numeroDoentes = numeroDoentes;
    }

    public String getHosítalDAtendimento() {
        return hosítalDAtendimento;
    }

    public void setHosítalDAtendimento(String hosítalDAtendimento) {
        this.hosítalDAtendimento = hosítalDAtendimento;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.vitima);
        hash = 89 * hash + Objects.hashCode(this.refeicao);
        hash = 89 * hash + Objects.hashCode(this.numeroMortes);
        hash = 89 * hash + Objects.hashCode(this.numeroPessoasComeram);
        hash = 89 * hash + Objects.hashCode(this.numeroHospitalizacao);
        hash = 89 * hash + Objects.hashCode(this.numeroDoentes);
        hash = 89 * hash + Objects.hashCode(this.hosítalDAtendimento);
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
        final ReclamacaoFood other = (ReclamacaoFood) obj;
        if (!Objects.equals(this.refeicao, other.refeicao)) {
            return false;
        }
        if (!Objects.equals(this.hosítalDAtendimento, other.hosítalDAtendimento)) {
            return false;
        }
        if (!Objects.equals(this.vitima, other.vitima)) {
            return false;
        }
        if (!Objects.equals(this.numeroMortes, other.numeroMortes)) {
            return false;
        }
        if (!Objects.equals(this.numeroPessoasComeram, other.numeroPessoasComeram)) {
            return false;
        }
        if (!Objects.equals(this.numeroHospitalizacao, other.numeroHospitalizacao)) {
            return false;
        }
        return Objects.equals(this.numeroDoentes, other.numeroDoentes);
    }

    @Override
    public String toString() {
        return "ReclamacaoFood{" + "vitima=" + vitima + ", refeicao=" + refeicao + ", numeroMortes=" + numeroMortes + ", numeroPessoasComeram=" + numeroPessoasComeram + ", numeroHospitalizacao=" + numeroHospitalizacao + ", numeroDoentes=" + numeroDoentes + ", hos\u00edtalDAtendimento=" + hosítalDAtendimento + '}';
    }
           
   
   
   
   
   
   
   
}
