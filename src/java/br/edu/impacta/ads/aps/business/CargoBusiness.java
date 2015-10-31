package br.edu.impacta.ads.aps.business;

import br.edu.impacta.ads.aps.jpa.dao.CargoDao;
import br.edu.impacta.ads.aps.jpa.model.Cargo;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CargoBusiness", urlPatterns = {"/cargo"})
public class CargoBusiness extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        /*Chamada para o form Alterar
        ===============================================================*/
        if ("Cargo.formAlterar".equals(request.getParameter("command"))) 
        { 
            System.out.println(request.getParameter("codigo"));
            //Convertendo de string para int
            Integer codigo = Integer.parseInt(request.getParameter("codigo"));         
            Cargo cargo = new CargoDao().id(codigo);
            
            HttpSession sessao = request.getSession(true); 
            sessao.setAttribute("cargo", cargo);
     
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/cargo/alterar.jsp");
            dispatcher.forward(request, response);
        }
        
        /*Chamada para a função remover cargo
        ===============================================================*/
        if ("Cargo.remover".equals(request.getParameter("command"))) 
        { 
            CargoDao dao = new  CargoDao();
            //Convertendo de string para int
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            dao.deletar(codigo);
            //Redireciona para o form cargo/listar.jsp
            response.sendRedirect("principal?command=Cargo.listar");
        }
        
        /*Chamada para a função listar cargo
        ===============================================================*/
        if ("Cargo.listar".equals(request.getParameter("command"))) 
        { 
            //Enviando o objeto populado cargos para o form listar
            request.setAttribute("cargos", new CargoDao().listar());
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/cargo/listar.jsp");
            dispatcher.forward(request, response);
        }
        
        /*Chamada para o form inserir cargo
        ===============================================================*/
        if ("Cargo.formulario".equals(request.getParameter("command"))) 
        {
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/cargo/inserir.jsp");
            dispatcher.forward(request, response);
        }
        
        /*Chamada para a função inserir cargo
        ===============================================================*/    
        if ("Cargo.inserir".equals(request.getParameter("command")))
        { //Se o valor do input command for Cargo.inserir então
            Cargo cargo = new Cargo();
            //  Chama o metodo getParameter(String) do objeto HttpServletRequest para pegar o resultado
            //vindo do formulário, no caso Cargo/inserir.jsp
            cargo.setNome(request.getParameter("nome"));
           //Inserir cargo            
            CargoDao dao = new CargoDao();
            dao.inserir(cargo);
            //Enviando o objeto cargos populado para o form listar cargos
            request.setAttribute("cargos", new CargoDao().listar());
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/cargo/listar.jsp");
            dispatcher.forward(request, response);
        }
        
         /*Chamada para a função alterar cargo
        ===============================================================*/   
        if ("Cargo.alterar".equals(request.getParameter("command"))) 
        {
            Cargo cargo = new Cargo();
            //Convertendo de string para int
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            cargo.setCodigo(codigo);
            //  Chama o metodo getParameter(String) do objeto HttpServletRequest para pegar o resultado
            //vindo do formulário, no caso Cargo/inserir.jsp
            cargo.setNome(request.getParameter("nome"));
           //Inserir cargo            
            CargoDao dao = new CargoDao();
            dao.alterar(cargo);
            //Enviando o objeto cargos populado para o form listar cargos
            request.setAttribute("cargos", new CargoDao().listar());
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/cargo/listar.jsp");
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
