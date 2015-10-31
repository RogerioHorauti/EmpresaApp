package br.edu.impacta.ads.aps.principal;

import br.edu.impacta.ads.aps.jpa.dao.DepartamentoDao;
import br.edu.impacta.ads.aps.jpa.model.Departamento;

public class JpaDepartamentoCodigo {
    public static void main(String[] args) {
        Integer codigo = Integer.parseInt("5");
        Departamento dep = new DepartamentoDao().id(codigo);
        System.out.println(dep.getCodigo()+" "+dep.getNome());
    }
}
