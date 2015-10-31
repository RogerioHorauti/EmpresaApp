package br.edu.impacta.ads.aps.principal;

import br.edu.impacta.ads.aps.jpa.model.Cargo;
import br.edu.impacta.ads.aps.jpa.model.Departamento;
import br.edu.impacta.ads.aps.jpa.dao.FuncionarioDao;
import br.edu.impacta.ads.aps.jpa.model.Funcionario;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JpaFuncionarioAlterar {
    public static void main(String[] args) {
        
        Funcionario func = new Funcionario();       
        func.setCodigo(1040);
        Cargo cargo = new Cargo();
        int codigo;
        codigo = Integer.parseInt("8");
        cargo.setCodigo(codigo);
        func.setCargo(cargo);
        Departamento dep = new Departamento();
        codigo = Integer.parseInt("3");
        dep.setCodigo(codigo);
        func.setDepartamento(dep);
        func.setNome("Kazuo Horauti");                      
        SimpleDateFormat formData = new SimpleDateFormat("dd/MM/yyyy");
        Calendar data = new GregorianCalendar();      
        try {
            data.setTime(formData.parse("19/09/2015"));
        } catch (java.text.ParseException ex) {
            Logger.getLogger(JpaFuncionarioInserir.class.getName()).log(Level.SEVERE, null, ex);
        }        
        func.setDataContratacao(data);        
        FuncionarioDao dao = new FuncionarioDao();
        dao.alterar(func);
    }
}
