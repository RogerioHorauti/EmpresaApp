package br.edu.impacta.ads.aps.principal;

import br.edu.impacta.ads.aps.jpa.dao.CargoDao;
import br.edu.impacta.ads.aps.jpa.model.Cargo;

public class JpaCargoCodigo {
    public static void main(String[] args) {
       
       Integer codigo = Integer.parseInt("10");
       Cargo cargo = new CargoDao().id(codigo);
       System.out.println(cargo.getCodigo()+" "+cargo.getNome());
    }
}
