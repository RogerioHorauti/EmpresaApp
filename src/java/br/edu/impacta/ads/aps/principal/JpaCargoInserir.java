package br.edu.impacta.ads.aps.principal;

import br.edu.impacta.ads.aps.jpa.dao.CargoDao;
import br.edu.impacta.ads.aps.jpa.model.Cargo;

public class JpaCargoInserir {
    public static void main(String[] args) {
        
        Cargo cargo = new Cargo();
        cargo.setNome("Arquiteto");
        CargoDao dao = new CargoDao();
        dao.inserir(cargo);
        
    }
}
