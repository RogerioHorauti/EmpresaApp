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

public class JpaFuncionarioInserir {
    
    public static void main(String[] args) {
        
        Funcionario func = new Funcionario();        
        func.setNome("Rogerio Horauti");        
        Cargo cargo = new Cargo();
        cargo.setCodigo(3);
        func.setCargo(cargo);
        Departamento dep = new Departamento();
        dep.setCodigo(2);
        func.setDepartamento(dep); 
        
        SimpleDateFormat formData = new SimpleDateFormat("dd/MM/yyyy");
        Calendar data = new GregorianCalendar();      
        try {
            data.setTime(formData.parse("25/09/1979"));
        } catch (java.text.ParseException ex) {
            Logger.getLogger(JpaFuncionarioInserir.class.getName()).log(Level.SEVERE, null, ex);
        }       
        func.setDataContratacao(data); 
        
        FuncionarioDao dao = new FuncionarioDao();
        dao.inserir(func);
    }
}
