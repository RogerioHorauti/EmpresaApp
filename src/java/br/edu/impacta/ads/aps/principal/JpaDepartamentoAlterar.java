package br.edu.impacta.ads.aps.principal;

import br.edu.impacta.ads.aps.jpa.dao.DepartamentoDao;
import br.edu.impacta.ads.aps.jpa.model.Departamento;

public class JpaDepartamentoAlterar {
    public static void main(String[] args) {
        
        Departamento dep = new Departamento();
        dep.setCodigo(9);
        dep.setNome("ti");
        DepartamentoDao dao = new DepartamentoDao();
        dao.alterar(dep);
       
    }
}
