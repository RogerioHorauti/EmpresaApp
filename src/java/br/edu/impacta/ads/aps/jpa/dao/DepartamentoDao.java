package br.edu.impacta.ads.aps.jpa.dao;

import br.edu.impacta.ads.aps.jpa.conexao.Conexao;
import br.edu.impacta.ads.aps.jpa.model.Departamento;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

public class DepartamentoDao implements GenericoDao<Departamento>{

    @Override
    public void inserir(Departamento departamento) {
        
        EntityManager entityManager = Conexao.getEntityManager();
        entityManager.getTransaction().begin();
        
        entityManager.persist(departamento);
            
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void alterar(Departamento departamento) {
        
        EntityManager entityManager = Conexao.getEntityManager();
        entityManager.getTransaction().begin();
        
        entityManager.merge(departamento);
        
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deletar(Integer id) {
        
        EntityManager entityManager = Conexao.getEntityManager();
              
        Departamento departamento = entityManager.find(Departamento.class, id);
        entityManager.remove(departamento);
        
        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Departamento> listar() {
        
        List<Departamento> deps = new ArrayList();
      
        EntityManager entityManager = Conexao.getEntityManager();
      
        deps = entityManager.createQuery("select c from Departamento c").getResultList();
        entityManager.close();
        
        return deps;
    }
    
    //Buscar o cargo pelo codigo
    public Departamento id(final Integer codigo) {
        
        EntityManager entityManager = Conexao.getEntityManager();
           
        Departamento dep = entityManager.find(Departamento.class, codigo);
        
        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();
        entityManager.close();
        return dep;
    }
    
}
