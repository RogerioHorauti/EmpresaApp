package br.edu.impacta.ads.aps.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Controller", urlPatterns = {"/principal"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        //HttpServletRequest request:
        //Se o valor passado do input não estiver vazio então
        if (request.getParameter("command") != null) 
        {
            //.startsWith("Cargo."):
            //Determina se a atual Cadeia de Caracteres começa com o conteúdo 
            if (request.getParameter("command").startsWith("Cargo.")) {
                //getRequestDispatcher:
                //permite incluir conteúdo em uma solicitação
                //Forwards:
                //prossegue com o pedido de um servlet para outro recurso (servlet, JSP, HTML ou arquivo) no servidor.
                //HttpServletResponse response
                //@WebServlet(name = "CargoBusiness", urlPatterns = {"/cargo"})
                request.getRequestDispatcher("/cargo").forward(request, response);             
            }
            
            if (request.getParameter("command").startsWith("Dep.")) 
            {       
                //@WebServlet(name = "DepBusiness", urlPatterns = "/dep")  
                request.getRequestDispatcher("/dep").forward(request, response);
            }
           
            if (request.getParameter("command").startsWith("Func.")) 
            {       
                //@WebServlet(name = "DepBusiness", urlPatterns = "/func")
                request.getRequestDispatcher("/func").forward(request, response);
            }
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
