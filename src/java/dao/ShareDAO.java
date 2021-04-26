/*
 * ShareDAO.java

 * All Rights Reserved.
 * Copyright (c) 2019 FPT University
 *
 */
package dao;

import context.DBContext;
import entity.Share;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * ShareDAO <br>
 * 
 * <pre>
 * Store ShareDAO
 * .getShare()
 * </pre>
 * 
 * @author thinh
 */


public class ShareDAO {

    //get all information of "Share this page"
    public List<Share> getShare() throws Exception {
        //create connection
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        List<Share> list = new ArrayList<>();
        try {
            //get all records of Share table query
            String query = "select * from Share";
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                //get all attributes of Share
                Share share = new Share(rs.getString("icon"),
                        rs.getString("socialNetwork"),
                        rs.getString("URL"));
                list.add(share);
            }
            return list;
        } catch (SQLException e) {
           throw e;
        } finally {
            //close connection
            db.closeConnection(rs, ps, conn);
        }
    }
}
