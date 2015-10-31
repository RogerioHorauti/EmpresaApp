package br.edu.impacta.ads.aps.principal;

import br.edu.impacta.ads.aps.jpa.dao.CargoDao;
import br.edu.impacta.ads.aps.jpa.model.Cargo;

public class JpaCargoAlterar {
    public static void main(String[] args) {
        
        Cargo cargo = new Cargo();
        cargo.setCodigo(13);
        cargo.setNome("ARQUITETO");
        CargoDao dao = new CargoDao();
        dao.alterar(cargo);
        
    }
}
