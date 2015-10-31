package br.edu.impacta.ads.aps.principal;

import br.edu.impacta.ads.aps.jpa.dao.CargoDao;
import br.edu.impacta.ads.aps.jpa.model.Cargo;
import java.util.List;

public class JpaCargoListar {
    public static void main(String[] args) {
        
        CargoDao dao = new CargoDao();
        List<Cargo> cargos = dao.listar();
        for(Cargo cargo : cargos){
            System.out.println(cargo.getCodigo()+" "+cargo.getNome());
        }
        
    }
}
