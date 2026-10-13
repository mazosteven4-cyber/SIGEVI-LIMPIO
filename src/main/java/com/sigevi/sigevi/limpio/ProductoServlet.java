
package com.sigevi.sigevi.limpio;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/producto")
public class ProductoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html><html lang='es'><head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<title>SIGEVI - Consulta</title></head><body>");
            out.println("<h1>SIGEVI - Consulta de producto</h1>");
            out.println("<p>ID recibido: " + escapar(id) + "</p>");
            out.println("<a href='index.html'>Volver al inicio</a>");
            out.println("</body></html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        request.setAttribute("nombre", request.getParameter("nombre"));
        request.setAttribute("precio", request.getParameter("precio"));
        request.setAttribute("cantidad", request.getParameter("cantidad"));

        request.getRequestDispatcher("/resultado.jsp")
               .forward(request, response);
    }

    private String escapar(String texto) {
        if (texto == null) return "";

        return texto.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;")
                    .replace("'", "&#39;");
    }
}