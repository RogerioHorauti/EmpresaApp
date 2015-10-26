package br.edu.impacta.ads.aps.business;

import br.edu.impacta.ads.aps.jpa.dao.FuncionarioDao;
import br.edu.impacta.ads.aps.jpa.model.Funcionario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "FuncBusiness", urlPatterns = {"/func"})
public class FuncBusiness extends HttpServlet{
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         if ("Func.formAlterar".equals(request.getParameter("command"))) 
        { 
            System.out.println(request.getParameter("codigo"));
            //Convertendo de string para int
            Integer codigo = Integer.parseInt(request.getParameter("codigo"));         
            Funcionario func = new FuncionarioDao().id(codigo);
            
            HttpSession sessao = request.getSession(true); 
            sessao.setAttribute("func", func);
     
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/funcionario/alterar.jsp");
            dispatcher.forward(request, response);
        } 
        
        if ("Func.remover".equals(request.getParameter("command"))) 
        { 
            FuncionarioDao dao = new  FuncionarioDao();
            //Convertendo de string para int
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            dao.deletar(codigo);
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
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/funcionario/inserir.jsp");
            dispatcher.forward(request, response);
        }
        //Se o valor do input command for Dep.inserir então
        if ("Func.inserir".equals(request.getParameter("command"))) 
        {
            //Inserir Departamento
            Funcionario func = new Funcionario();
            //  Chama o metodo getParameter(String) do objeto HttpServletRequest para pegar o resultado
            //vindo do formulário, no caso Cargo/inserir.jsp
            func.setNome(request.getParameter("nome"));
            
            
            FuncionarioDao dao = new FuncionarioDao();
            dao.inserir(func);
            //Pedido
            request.setAttribute("deps", new FuncionarioDao().listar());
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/funcionario/listar.jsp");
            dispatcher.forward(request, response);
        }
        
         if ("Dep.alterar".equals(request.getParameter("command"))) 
        {
            Funcionario func = new Funcionario();
            //Convertendo de string para int
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            func.setCodigo(codigo);
            //  Chama o metodo getParameter(String) do objeto HttpServletRequest para pegar o resultado
            //vindo do formulário, no caso Cargo/inserir.jsp
            func.setNome(request.getParameter("nome"));
            
            
           //Inserir cargo            
            FuncionarioDao dao = new FuncionarioDao();
            dao.alterar(func);
            //Enviando o objeto cargos populado para o form listar cargos
            request.setAttribute("dep", new FuncionarioDao().listar());
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
