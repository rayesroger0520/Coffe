/*
 * HomeControl.java

 * All Rights Reserved.
 * Copyright (c) 2019 FPT University
 *
 */
package control;

import context.DBContext;
import dao.CakeDAO;
import dao.InformationDAO;
import dao.IntroductionDAO;
import dao.ShareDAO;
import entity.Cake;
import entity.Information;
import entity.Introduction;
import entity.Share;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *HomeControl class.<br>
 * 
 * <pre>
 * Class thực hiện xử lý request tới trang HomePage.jsp
 * Trong class này sẽ tiến hành các xử lí dưới đây.
 * 
 * ・processRequest
 * ・doGet.
 * ・doPost.
 * ・getServletInfo.
 * </pre>
 * @author thinhnn
 */
@WebServlet(name = "HomeControl", urlPatterns = {"/HomeControl"})
public class HomeControl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try{
            //begin of set imagePath
            DBContext bContext = new DBContext();
            String imagePath = bContext.getImagePath();
            request.setAttribute("imagePath", imagePath);
            //end of set imagePath
            
            //begin of set share
            ShareDAO shareDAO = new ShareDAO();
            List<Share> share  = shareDAO.getShare();
            request.setAttribute("share", share);
            //end of set share
            
            //begin of set Introduction
            IntroductionDAO introductionDAO = new IntroductionDAO();
            Introduction  introduction = introductionDAO.getIntroduction();
            request.setAttribute("introduction", introduction);
            //end of set Introduction
            
            //begin of set top 2 most recent of cake 
            CakeDAO cakeDAO = new CakeDAO();
            List<Cake> top2 = cakeDAO.getTop2();
            request.setAttribute("top2", top2);
            //end top 2 most recent of cake
            
            //begin of set Information
            InformationDAO informationDAO = new InformationDAO();
            Information information = informationDAO.getInfomation();
            request.setAttribute("infor", information);
            //end of set Information
            
            request.setAttribute("activeMenu", "activeMenu");
            request.getRequestDispatcher("HomePage.jsp").forward(request, response);
            
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
