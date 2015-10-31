package br.edu.impacta.ads.aps.jpa.dao;

import br.edu.impacta.ads.aps.jpa.conexao.Conexao;
import br.edu.impacta.ads.aps.jpa.model.Funcionario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class FuncionarioDao implements GenericoDao<Funcionario>{

    @Override
    public void inserir(Funcionario funcionario) {
        
        EntityManager entityManager = Conexao.getEntityManager();
        entityManager.getTransaction().begin();
        
        entityManager.persist(funcionario);
            
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deletar(Integer id) {
       
        EntityManager entityManager = Conexao.getEntityManager();
              
        Funcionario func = entityManager.find(Funcionario.class, id);
        entityManager.remove(func);
        
        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Funcionario> listar() {
        
        List<Funcionario> funcs = new ArrayList();
        
        EntityManager entityManager = Conexao.getEntityManager();
     
        funcs = entityManager.createQuery("SELECT f FROM Funcionario f JOIN f.cargo c JOIN f.departamento d").getResultList();
        
        entityManager.close();
        return funcs;
    }

    @Override
    public void alterar(Funcionario funcionario) {
        
        EntityManager entityManager = Conexao.getEntityManager();
        entityManager.getTransaction().begin();
        
        entityManager.merge(funcionario);
        
        entityManager.getTransaction().commit();
        entityManager.close(); 
    }
    
    //Buscar o cargo pelo codigo
    public List<Funcionario> id(final Integer codigo) {
        
        EntityManager entityManager = Conexao.getEntityManager();
        
        List<Funcionario> funcs = new ArrayList<>();
        funcs = entityManager.createQuery("SELECT f FROM Funcionario f where f.codigo="+codigo).getResultList();
        
        entityManager.close();
        return funcs;
    }
}
