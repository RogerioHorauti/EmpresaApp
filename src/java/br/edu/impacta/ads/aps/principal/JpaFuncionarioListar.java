package br.edu.impacta.ads.aps.principal;

import br.edu.impacta.ads.aps.jpa.dao.FuncionarioDao;
import br.edu.impacta.ads.aps.jpa.model.Funcionario;
import java.util.List;

//Listar os funcionários
public class JpaFuncionarioListar {
    public static void main(String[] args) {
        
        FuncionarioDao dao = new FuncionarioDao();
        List<Funcionario> funcs = dao.listar();
        for (Funcionario func : funcs){
            System.out.println(func.getCodigo() + " " +func.getNome());
            System.out.println("\t" + func.getDepartamento().getCodigo()+" "+func.getDepartamento().getNome());
            System.out.println("\t" + func.getCargo().getCodigo()+" "+func.getCargo().getNome());
        }
    }
}
