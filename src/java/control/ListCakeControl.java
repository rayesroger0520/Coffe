/*
 * ListCakeControl.java

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
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 ** LisCakeControl class.<br>
 * 
 * <pre>
 * Class thực hiện xử lý request tới trang List.jsp
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
@WebServlet(name = "ListCakeControl", urlPatterns = {"/ListCakeControl"})
public class ListCakeControl extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            //begin of set imagePath
            DBContext bContext = new DBContext();
            String imagePath = bContext.getImagePath();
            String pageSize = bContext.getPageSize();
            request.setAttribute("imagePath", imagePath);
            request.setAttribute("pagesize", pageSize);
            //end of set imagePath

            //begin of set share
            ShareDAO shareDAO = new ShareDAO();
            List<Share> share = shareDAO.getShare();
            request.setAttribute("share", share);
            //end of set share

            //begin of set cake
            CakeDAO cakeDAO = new CakeDAO();
            String page_index = request.getParameter("txtPage"); // get from List.jsp
            if(page_index == null){
                page_index = "1";
            }
            int pageIndex = Integer.parseInt(page_index);
            //paging
            int p = Integer.parseInt(pageSize);
            int rowCount = cakeDAO.getTotalProducts();  //totalProduct = 20
            int maxPage = rowCount / p;
            if(rowCount % p !=0){
                maxPage = maxPage + 1;
            }
            List<Cake> cakes = cakeDAO.getListProducts(pageIndex, p); // truyền vào để lấy item theo trang
            request.setAttribute("cakes", cakes);
            request.setAttribute("maxPage", maxPage);
            request.setAttribute("pageIndex", pageIndex);

            request.setAttribute("activeList", "activeList");
            request.getRequestDispatcher("List.jsp").forward(request, response);

        } catch (Exception ex) {
            System.out.println(ex);
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
