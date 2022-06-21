/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import br.com.Cin.ControleEntidades.ReclamacaoAnimalJpaController;
import br.com.Cin.Entidades.ReclamacaoAnimal;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Jefferson
 */
@Named(value = "animalBeans")
@Dependent
public class AnimalBeans {

    /**
     * Creates a new instance of AnimalBeans
     */
    
    private EntityManagerFactory factory;
    private EntityManager em;
    private ReclamacaoAnimalJpaController recJPa; 
    private ReclamacaoAnimal recAnimal;
    private  String pesquisar;
    private List listaRecAniList = new ArrayList<>(); 
    
    
    public AnimalBeans() {
        
        
        
    }
    
    
    public  void Salvar(ReclamacaoAnimal rec){
        
        recJPa = new ReclamacaoAnimalJpaController(factory);
        recJPa.create(recAnimal);
        
    }

    public ReclamacaoAnimal getRecAnimal() {
        return recAnimal;
    }

    public void setRecAnimal(ReclamacaoAnimal recAnimal) {
        this.recAnimal = recAnimal;
    }

    public String getPesquisar() {
        return pesquisar;
    }

    public void setPesquisar(String pesquisar) {
        this.pesquisar = pesquisar;
    }

    public List getListaRecAniList() {
        return listaRecAniList;
    }

    public void setListaRecAniList(List listaRecAniList) {
        this.listaRecAniList = listaRecAniList;
    }
    
    
    
}
