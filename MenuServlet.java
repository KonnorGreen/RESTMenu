package edu.tarleton.restorder;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "MenuServlet", urlPatterns = {"/Menu"})
public class MenuServlet extends HttpServlet {

    @EJB
    private ItemsService itemService;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        itemService.insert(name);
        response.sendRedirect("menu.html");
    }
}
