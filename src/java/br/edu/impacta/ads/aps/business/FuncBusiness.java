package br.edu.impacta.ads.aps.business;

import br.edu.impacta.ads.aps.jpa.dao.CargoDao;
import br.edu.impacta.ads.aps.jpa.dao.DepartamentoDao;
import br.edu.impacta.ads.aps.jpa.dao.FuncionarioDao;
import br.edu.impacta.ads.aps.jpa.model.Cargo;
import br.edu.impacta.ads.aps.jpa.model.Departamento;
import br.edu.impacta.ads.aps.jpa.model.Funcionario;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FuncBusiness", urlPatterns = {"/func"})
public class FuncBusiness extends HttpServlet{
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         if ("Func.formAlterar".equals(request.getParameter("command"))) 
        {     
            request.setAttribute("funcs", new FuncionarioDao().id(Integer.parseInt(request.getParameter("codigo"))));          
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/funcionario/alterar.jsp");
            dispatcher.forward(request, response);
        } 
        
        if ("Func.remover".equals(request.getParameter("command"))) 
        { 
            //Convertendo de string para int
            new FuncionarioDao().deletar(Integer.parseInt(request.getParameter("codigo")));
            //Redireciona para o form cargo/listar.jsp
            response.sendRedirect("principal?command=Func.listar");
        } 
         
         if ("Func.listar".equals(request.getParameter("command"))) 
        { 
            request.setAttribute("funcs", new FuncionarioDao().listar());
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/funcionario/listar.jsp");
            dispatcher.forward(request, response);
        }
        
        if ("Func.formulario".equals(request.getParameter("command"))) 
        {
            request.setAttribute("cargos", new CargoDao().listar());
            request.setAttribute("deps", new DepartamentoDao().listar());
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/funcionario/inserir.jsp");
            dispatcher.forward(request, response);
        }
        //Se o valor do input command for Dep.inserir então
        if ("Func.inserir".equals(request.getParameter("command"))) 
        {
            Funcionario func = new Funcionario();
            //  Chama o metodo getParameter(String) do objeto HttpServletRequest para pegar o resultado
            //vindo do formulário, no caso Cargo/inserir.jsp
            func.setNome(request.getParameter("nome"));
            
            // Cargo
            Cargo cargo = new Cargo();
            cargo.setCodigo(Integer.parseInt(request.getParameter("codigoCargo")));
            func.setCargo(cargo);
            
            // Departamento
            Departamento dep = new Departamento();
            int codigoDep = Integer.parseInt(request.getParameter("codigoDep"));
            dep.setCodigo(codigoDep);
            func.setDepartamento(dep);
            
            //Data de contratação
            SimpleDateFormat formData = new SimpleDateFormat("dd/MM/yyyy");
            Calendar data = new GregorianCalendar();               
            try {
                data.setTime(formData.parse("dt_contratacao"));
            } catch (ParseException ex) {
                Logger.getLogger(FuncBusiness.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            func.setDataContratacao(data); 
            
            new FuncionarioDao().inserir(func);
            //Pedido
            request.setAttribute("funcs", new FuncionarioDao().listar());
            response.sendRedirect("principal?command=Func.listar");
            
        }
        
         if ("Func.alterar".equals(request.getParameter("command"))) 
        {
            Funcionario func = new Funcionario();
            
            //  Chama o metodo getParameter(String) do objeto HttpServletRequest para pegar o resultado
            //vindo do formulário, no caso Cargo/inserir.jsp
            
            //Convertendo de string para int
            func.setCodigo(Integer.parseInt(request.getParameter("codigo").trim()));
            
            func.setNome(request.getParameter("nome"));
            
            // Cargo
            Cargo cargo = new Cargo();          
            cargo.setCodigo(Integer.parseInt(request.getParameter("cargoCodigo").trim()));
            //cargo.setNome(request.getParameter("cargoNome"));
            func.setCargo(cargo);
            
            // Departamento
            Departamento dep = new Departamento();
            dep.setCodigo(Integer.parseInt(request.getParameter("depCodigo").trim()));           
            //dep.setNome(request.getParameter("depNome"));
            func.setDepartamento(dep);
            
            //data de contratação
            SimpleDateFormat formData = new SimpleDateFormat("dd/MM/yyyy");
            Calendar data = new GregorianCalendar();      
            try {
                data.setTime(formData.parse("dt_contratacao"));
            } catch (java.text.ParseException ex) {
                Logger.getLogger(FuncBusiness.class.getName()).log(Level.SEVERE, null, ex);
            }       
            func.setDataContratacao(data); 
            
           //Inserir cargo            
            FuncionarioDao dao = new FuncionarioDao();
            dao.alterar(func);
            
            //Enviando o objeto cargos populado para o form listar cargos
            request.setAttribute("funcs", new FuncionarioDao().listar());
            
            //response.sendRedirect("principal?command=Func.listar");
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/funcionario/listar.jsp");
            dispatcher.forward(request, response);
            
        }
     }
     
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
}
