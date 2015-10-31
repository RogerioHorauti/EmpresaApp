package br.edu.impacta.ads.aps.principal;

import br.edu.impacta.ads.aps.jpa.dao.FuncionarioDao;
import br.edu.impacta.ads.aps.jpa.model.Funcionario;
import java.util.List;

public class JpaFuncionarioCodigo {
    public static void main(String[] args) 
    {
        Integer codigo = Integer.parseInt("5");
        List<Funcionario> funcs = new FuncionarioDao().id(codigo);
        for (Funcionario func : funcs) {
             System.out.println(func.getCodigo()+" "+func.getNome());
        }
       
    }
}
