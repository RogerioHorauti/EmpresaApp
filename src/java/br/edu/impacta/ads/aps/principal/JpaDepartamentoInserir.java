package br.edu.impacta.ads.aps.principal;

import br.edu.impacta.ads.aps.jpa.dao.DepartamentoDao;
import br.edu.impacta.ads.aps.jpa.model.Departamento;

public class JpaDepartamentoInserir {
    
    public static void main(String[] args) {
        
        Departamento dep = new Departamento();
        dep.setNome("TI");
        DepartamentoDao dao = new DepartamentoDao();
        dao.inserir(dep);
    }
}
