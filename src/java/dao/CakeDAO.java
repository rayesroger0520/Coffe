/*
 * CakeDao.java

 * All Rights Reserved.
 * Copyright (c) 2019 FPT University
 *
 */
package dao;

import context.DBContext;
import entity.Cake;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * CakeDao <br>
 * 
 * <pre>
 * Store CakeDao
 * .getTop2()
 * .getProductDetail()
 * .getTotalProducts()
 * .getListProducts()
 * 
 * </pre>
 * 
 * @author thinh
 */

public class CakeDAO {

    //get 2 most recent product
    public List<Cake> getTop2() throws Exception {
        //create connection
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        List<Cake> list = new ArrayList<>();
        try {
            //get 2 most recent Products by date desc query
            String query = "select top 2* from Products order by DateCreated desc";
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                //get all attributes of 1 Product
                Cake cake = new Cake(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("picture"),
                        rs.getString("shortDescription"),
                        rs.getString("detailDescription"),
                        rs.getString("price")
                );
                list.add(cake);
            }
            return list;
        } catch (SQLException e) {
           throw e;
        } finally {
            //close connection
            db.closeConnection(rs, ps, conn);
        }
    }

    //get all information of 1 product by id
    public Cake getProductDetail(int CakeID) throws Exception {
        //create connection
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        try {
            //get Product by id query
            String query = "select * from Products where ID = ?";
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, CakeID);
            rs = ps.executeQuery();
            while (rs.next()) {
                //get all attributes of 1 Product
                Cake cake = new Cake(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("picture"),
                        rs.getString("shortDescription"),
                        rs.getString("detailDescription"),
                        rs.getString("price")
                );
                return cake;
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            //close connection
            db.closeConnection(rs, ps, conn);
        }
        return null;
    }

    //count total product
    public int getTotalProducts() throws Exception {
        //create connection
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        int count = 0;
        try {
            //count total rows at Products table query
            String query = "select count(*) as Num from Products";
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt("Num");
            }
        } catch (SQLException e) {
            throw e;
        }finally{
            //close connection
            db.closeConnection(rs, ps, conn);
        }
        return count;
    }

    //paging product
    public List<Cake> getListProducts(int pageIndex, int pageSize) throws Exception {
        //create connection
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        List<Cake> list = new ArrayList<>();
        try {
            //get list Shushies in a range query
            String sql = "select *from("
                    + "select ROW_NUMBER() over (order by ID ASC) as rn, *\n"
                    + "from Products"
                    + ")as x\n"
                    + "where rn between (?-1)*?+1"
                    + "and ?*?";
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pageIndex);
            ps.setInt(2, pageSize);
            ps.setInt(3, pageIndex);
            ps.setInt(4, pageSize);
            rs = ps.executeQuery();
            while (rs.next()) {
                //get all attributes of 1 Product
                Cake cake = new Cake(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("picture"),
                        rs.getString("shortDescription"),
                        rs.getString("detailDescription"),
                        rs.getString("price")
                );
                list.add(cake);
            }
            return list;
        } catch (SQLException e) {
           throw  e;
        } finally {
            //close connection
            db.closeConnection(rs, ps, conn);
        }
    }

}
