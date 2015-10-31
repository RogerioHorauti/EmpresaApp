package br.edu.impacta.ads.aps.business;

import br.edu.impacta.ads.aps.jpa.dao.DepartamentoDao;
import br.edu.impacta.ads.aps.jpa.model.Departamento;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "DepBusiness", urlPatterns = {"/dep"})
public class DepBusiness extends HttpServlet{
    
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if ("Dep.formAlterar".equals(request.getParameter("command"))) 
        { 
            //System.out.println(request.getParameter("codigo"));
            //Convertendo de string para int
            Integer codigo = Integer.parseInt(request.getParameter("codigo"));         
            Departamento dep = new DepartamentoDao().id(codigo);
            
            //Colocar o dep na sessão
            HttpSession sessao = request.getSession(true); 
            sessao.setAttribute("dep", dep);
     
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/departamento/alterar.jsp");
            dispatcher.forward(request, response);
        } 
        
        if ("Dep.remover".equals(request.getParameter("command"))) 
        { 
            DepartamentoDao dao = new  DepartamentoDao();
            //Convertendo de string para int
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            dao.deletar(codigo);
            //Redireciona para o form cargo/listar.jsp
            response.sendRedirect("principal?command=Dep.listar");
        } 
         
         if ("Dep.listar".equals(request.getParameter("command"))) 
        { 
            request.setAttribute("deps", new DepartamentoDao().listar());
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/departamento/listar.jsp");
            dispatcher.forward(request, response);
        }
        
        if ("Dep.formulario".equals(request.getParameter("command"))) 
        {
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/departamento/inserir.jsp");
            dispatcher.forward(request, response);
        }
        //Se o valor do input command for Dep.inserir então
        if ("Dep.inserir".equals(request.getParameter("command"))) 
        {
            //Inserir Departamento
            Departamento dep = new Departamento();
            //  Chama o metodo getParameter(String) do objeto HttpServletRequest para pegar o resultado
            //vindo do formulário, no caso departamento/inserir.jsp
            dep.setNome(request.getParameter("nome"));
            DepartamentoDao dao = new DepartamentoDao();
            dao.inserir(dep);
            //Pedido
            request.setAttribute("deps", new DepartamentoDao().listar());
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/departamento/listar.jsp");
            dispatcher.forward(request, response);
        }
        
        if ("Dep.alterar".equals(request.getParameter("command"))) 
        {
            Departamento dep = new Departamento();
            //Convertendo de string para int
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            dep.setCodigo(codigo);
            //  Chama o metodo getParameter(String) do objeto HttpServletRequest para pegar o resultado
            //vindo do formulário, no caso Cargo/inserir.jsp
            dep.setNome(request.getParameter("nome"));
           //Inserir cargo            
            DepartamentoDao dao = new DepartamentoDao();
            dao.alterar(dep);
            //Enviando o objeto cargos populado para o form listar cargos
            request.setAttribute("deps", new DepartamentoDao().listar());
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/departamento/listar.jsp");
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
