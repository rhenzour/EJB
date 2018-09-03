package be.businesstraining.client;

import be.businesstraining.beans.AchatBean;
import be.businesstraining.beans.CommandeBean;
import be.businesstraining.beans.PaiementBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ClientServlet", urlPatterns = {"/ClientServlet"})
public class ClientServlet extends HttpServlet {

    @EJB
    private CommandeBean commandeBean;

    @EJB
    private AchatBean achatBean;

    @EJB
    private PaiementBean paiementBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ClientServlet</title>");
            out.println("</head>");
            out.println("<body bgcolor=lightblue>");
            out.println("<h2>Illustration de la configuration des transactions</h2><BR/>");
            try {
                out.println("<LI>" + commandeBean.commander() + "</LI>");

            } catch (Exception e) {
                out.println("<font color=red>    ===> Echec de la transaction de commande</font><br/>");
            }
            try {
                out.println("<LI>" + achatBean.acheter() + "</LI>");
            } catch (Exception e) {
                out.println("<font color=red>    ===> Echec de la transaction d'achat</font><br/>");
            }

            try {
                out.println("<LI>" + paiementBean.payer() + "</LI><BR/>");
            } catch (Exception e) {
                out.println("<font color=red>    ===> Echec de la transaction de paiement</font><br/>");
            }
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
