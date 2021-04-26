/*
 * InformationDAO.java

 * All Rights Reserved.
 * Copyright (c) 2019 FPT University
 *
 */
package dao;

import context.DBContext;
import entity.Information;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * InformationDAO <br>
 * 
 * <pre>
 * Store InformationDAO
 * .getInfomation()
 * </pre>
 * 
 * @author thinh
 */

public class InformationDAO {

    //get all information of Store
    public Information getInfomation() throws Exception {
        //create connection
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        try {
            //get all records of Information table query
            String query = "select * from Information";
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                //get all attributes of Information
                Information information = new Information(rs.getString("shortDescription"),
                        rs.getString("address"),
                        rs.getString("tel"),
                        rs.getString("email"),
                        rs.getString("openingHours"),
                        rs.getString("signature"));
                return information;
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
