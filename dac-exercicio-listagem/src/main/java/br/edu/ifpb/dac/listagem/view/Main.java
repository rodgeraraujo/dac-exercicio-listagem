/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.listagem.view;

import br.edu.ifpb.dac.listagem.model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Main", urlPatterns = {"/Main"})
public class Main extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        List<Product> products = new ArrayList<Product>();
        
        Product prod1 = new Product("Arroz", 2.5f, 1);
        Product prod2 = new Product("Feijão", 12.5f, 2);
        Product prod3 = new Product("Macarrão", 2.55f, 3);
        Product prod4 = new Product("Refrigerante", 6.5f, 4);
        Product prod5 = new Product("Salgadinho", 2.5f, 5);
        
        products.add(prod1);
        products.add(prod2);
        products.add(prod3);
        products.add(prod4);
        products.add(prod5);

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Producs List</title>");            
            out.println("<style>\n" +
                            "table {\n" +
                            "    font-family: arial, sans-serif;\n" +
                            "    border-collapse: collapse;\n" +
                            "    width: 100%;\n" +
                            "}\n" +
                            "\n" +
                            "td, th {\n" +
                            "    border: 1px solid #dddddd;\n" +
                            "    text-align: left;\n" +
                            "    padding: 8px;\n" +
                            "}\n" +
                            "\n" +
                            "tr:nth-child(even) {\n" +
                            "    background-color: #dddddd;\n" +
                            "}" +
                            "</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Your list of products:  </h1>");
          
            int i =0;
            out.println("<table>\n" +
                            "  <tr>\n" +
                            "    <th>Code</th>\n" +
                            "    <th>Name</th>\n" +
                            "    <th>Price</th>\n" +
                            "  </tr>\n");
            while(!products.isEmpty()){
                out.println("  <tr>\n" +
                            "    <td>" + products.get(i).getCode() + "</td>\n" +
                            "    <td>" + products.get(i).getName() + "</td>\n" +
                            "    <td>" + products.get(i).getPrice() + "</td>\n" +
                            "  </tr>\n");         
                i++; 
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
