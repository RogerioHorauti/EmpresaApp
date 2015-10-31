package br.edu.impacta.ads.aps.jpa.conexao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {
   
    private static final String pu = "EmpresaPU";
   
    private static ThreadLocal<EntityManager> tem = new ThreadLocal();
  
    private static EntityManagerFactory emf;

    private Conexao() {
    }
    
    public static EntityManager getEntityManager(){
        
        if(emf==null){
            emf = Persistence.createEntityManagerFactory(pu);
        }
        
        EntityManager em = tem.get();
        
        if(em==null || !em.isOpen()){
            em = emf.createEntityManager();
            Conexao.tem.set(em);
        }
        return em;
    }
}
