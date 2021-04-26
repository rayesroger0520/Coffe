/*
 * IntroductionDAO.java

 * All Rights Reserved.
 * Copyright (c) 2019 FPT University
 *
 */
package dao;


import context.DBContext;
import entity.Introduction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * IntroductionDAO <br>
 * 
 * <pre>
 * Store IntroductionDAO
 * .getIntroduction()
 * </pre>
 * 
 * @author thinh
 */

public class IntroductionDAO {
    
    //get all form Intro
     public Introduction getIntroduction() throws Exception {
        //create connection
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        try {
            //get all records of Introduction table query
            String query = "select * from Intro";
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                //get all attributes of Introduction
                Introduction introduction = new Introduction(rs.getString("title"), 
                        rs.getString("picture"), 
                        rs.getString("shortDescription"), 
                        rs.getString("detailDescription"));
                return introduction;
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            //close connection
            db.closeConnection(rs, ps, conn);
        }
        return null;
     }
    
}
