package br.edu.impacta.ads.aps.principal;

import br.edu.impacta.ads.aps.jpa.dao.DepartamentoDao;
import br.edu.impacta.ads.aps.jpa.model.Departamento;
import java.util.List;

public class JpaDepartamentoListar {
    public static void main(String[] args) {
        
        DepartamentoDao dao = new DepartamentoDao();
        List<Departamento> deps = dao.listar();
        for(Departamento dep : deps){
            System.out.println(dep.getCodigo()+" "+dep.getNome());
        }
        
    }
}
