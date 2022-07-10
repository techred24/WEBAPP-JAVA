package org.rafael.webapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/parametros/url-get")
public class ParametrosGetServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String saludo = req.getParameter("saludo");
        String nombre = req.getParameter("nombre");

        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("<head>");
        out.print("<meta charset=\"UTF-8\"/>");
        out.print("<title>Parametro Get de la Url</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<h1>Parametro Get de la Url!</h1>");
        if(saludo != null && nombre!= null) {
            out.print("<h2>El saludo enviado es:" + saludo + " " + nombre + "</h2>");
        } else if (saludo != null) {
            out.print("<h2>El saludo enviado es:" + saludo +"</h2>");
        } else {
            out.print("<h2>No se han pasado los parametros saludo ni nombre</h2>");
        }
        try {
            Integer codigo = Integer.valueOf(req.getParameter("codigo"));
            out.print("<h2>El codigo ingresado es: " + codigo + "</h2>");
        } catch (NumberFormatException e) {
            out.print("<h2>El codigo no se ha ingresado</h2>");
        }
        out.print("</body>");
        out.print("</html>");
        out.close();
    }
}
