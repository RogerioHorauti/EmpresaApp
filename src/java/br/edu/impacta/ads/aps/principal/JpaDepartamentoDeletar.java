package br.edu.impacta.ads.aps.principal;

import br.edu.impacta.ads.aps.jpa.dao.DepartamentoDao;
import br.edu.impacta.ads.aps.jpa.model.Departamento;

public class JpaDepartamentoDeletar {
    public static void main(String[] args) {
        
        DepartamentoDao dao = new DepartamentoDao();
        dao.deletar(9);
        
    }
}
