package servlet;

import be.businesstraining.beans.VoucherManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.ejb.EJBAccessException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SecurityServlet extends HttpServlet {

    @EJB
    VoucherManager voucherManager;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SecurityServlet</title>");
            out.println("</head>");
            out.println("<body>");

            voucherManager.createVoucher("Luis Billings", "Bruxelles",
                    BigDecimal.valueOf(2150.75));
            out.println("<h3>Voucher was created</h3>");
            voucherManager.submit();
            out.println("<h3>Voucher was submitted</h3>");
            boolean voucherApproved = voucherManager.approve();
//            out.println("<h3>Voucher was submitted</h3>");

            if(voucherApproved) {
                out.println("<h3>You are a Manager : Voucher was approved</h3>");
            } else {
               out.println("<h3> You are not a Manager : Voucher was not approved</h3>");
            }

            out.println("<h3>Voucher name: " + voucherManager.getName() + "</h3>");

            out.println("</body>");
            out.println("</html>");

        }
        catch(EJBAccessException e) {
              out.println("<h3 style='color:red;'> Access exception</h3>");
            System.out.println("Access exception");
        }
        finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
