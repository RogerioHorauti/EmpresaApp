package br.edu.impacta.ads.aps.principal;

import br.edu.impacta.ads.aps.jpa.dao.CargoDao;

public class JpaCargoDeletar {
    //15
    public static void main(String[] args) {  
        
        CargoDao dao = new CargoDao();
        dao.deletar(13);
        
    }
}
