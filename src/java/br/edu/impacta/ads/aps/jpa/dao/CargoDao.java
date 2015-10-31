package br.edu.impacta.ads.aps.jpa.dao;

import br.edu.impacta.ads.aps.jpa.conexao.Conexao;
import br.edu.impacta.ads.aps.jpa.model.Cargo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

public class CargoDao implements GenericoDao<Cargo>{

    @Override
    public void inserir(Cargo cargo) {
       
        EntityManager entityManager = Conexao.getEntityManager();
        entityManager.getTransaction().begin();
        
        entityManager.persist(cargo);
            
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void alterar(Cargo cargo) {
        
        EntityManager entityManager = Conexao.getEntityManager();
        entityManager.getTransaction().begin();
        
        entityManager.merge(cargo);
        
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deletar(Integer id) {
        
        EntityManager entityManager = Conexao.getEntityManager();
              
        Cargo cargo = entityManager.find(Cargo.class, id);
        entityManager.remove(cargo);
        
        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Cargo> listar() {
        
        List<Cargo> cargos = new ArrayList();
               
        EntityManager entityManager = Conexao.getEntityManager();
     
        cargos = entityManager.createQuery("select c from Cargo c").getResultList();
        entityManager.close();
        
        return cargos;
    }
    
    //Buscar o cargo pelo codigo
    public Cargo id(final Integer codigo) {
        
        EntityManager entityManager = Conexao.getEntityManager();
           
        Cargo cargo = entityManager.find(Cargo.class, codigo);
        
        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();
        entityManager.close();
        return cargo;
    }
    
}
