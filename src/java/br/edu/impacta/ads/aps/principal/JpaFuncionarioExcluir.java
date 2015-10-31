package br.edu.impacta.ads.aps.principal;

import br.edu.impacta.ads.aps.jpa.dao.FuncionarioDao;

public class JpaFuncionarioExcluir {
    public static void main(String[] args) {
        
        FuncionarioDao dao = new FuncionarioDao();
        dao.deletar(1041);
    }
}
