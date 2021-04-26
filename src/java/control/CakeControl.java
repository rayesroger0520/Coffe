/*
 * CakeControl.java

 * All Rights Reserved.
 * Copyright (c) 2019 FPT University
 *
 */
package control;

import context.DBContext;
import dao.CakeDAO;
import dao.ShareDAO;
import entity.Cake;
import entity.Share;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *CakeControl class.<br>
 * 
 * <pre>
 * Class thực hiện xử lý request lấy thông tin chi tiết CakeDetail.jsp
 * Trong class này sẽ tiến hành các xử lí dưới đây.
 * 
 * ・processRequest
 * ・doGet.
 * ・doPost.
 * ・getServletInfo.
 * </pre>
 * 
 * @author thinh
 */
// annotation
@WebServlet(name = "CakeControl", urlPatterns = {"/CakeControl"})
public class CakeControl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            //begin of set imagePath
            DBContext bContext = new DBContext();
            String imagePath = bContext.getImagePath();
            request.setAttribute("imagePath", imagePath);
            //end of set imagePath
            
            //begin of set share
            ShareDAO shareDAO = new ShareDAO();
            List<Share> share = shareDAO.getShare();
            request.setAttribute("share", share);
            //end of set share

            //begin of get id
            String id = request.getParameter("id");
            int idCake = 0;
            try {
                idCake = Integer.parseInt(id);
            } catch (NumberFormatException e) {
                idCake = 1;
            }
            //end of get id
            
            //set all attributes for cake
            CakeDAO cakeDAO = new CakeDAO();
            Cake cake = cakeDAO.getProductDetail(idCake);
            if (cake == null) {
                request.setAttribute("cake", cakeDAO.getProductDetail(1));
            } else {
                request.setAttribute("cake", cake);
            }
            request.getRequestDispatcher("CakeDetail.jsp").forward(request, response);
        } catch (Exception ex) {
            response.sendRedirect("Error.jsp");
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
