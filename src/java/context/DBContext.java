/*
 * DBContext.java

 * All Rights Reserved.
 * Copyright (c) 2019 FPT University
 *
 */
package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * DBContext class.<br>
 * 
 * <pre>
 * Class thực hiện việc kết nối với db
 * Trong class này sẽ tiến hành các xử lí dưới đây.
 * 
 * ・Constructor
 * ・getImagePath.
 * ・getConnection.
 * ・closeConnection.
 * </pre>
 * @author thinh
 */

public class DBContext {

    InitialContext initial;
    Context context;
    /** Store server dbname, serverName, portNumber, pageSize, image, username, password */
    String dbname, serverName, portNumber, pageSize, image, username, password;

    /**
     * Constructor<br>
     * 
     * Method này thực hiện lấy thông tin từ file context.xml rồi lưu trong các biến ở trên
     * Xử lý Exception
     *      Trường hợp không lấy được thì out ra log theo lỗi
     * 
     */
    public DBContext() {
        try {
            initial = new InitialContext();
            Object obj = initial.lookup("java:comp/env");
            context = (Context) obj;
            serverName = context.lookup("serverName").toString();
            dbname = context.lookup("dbName").toString();
            portNumber = context.lookup("portNumber").toString();
            image = context.lookup("image").toString();
            username = context.lookup("username").toString();
            password = context.lookup("password").toString();
            pageSize = context.lookup("pageSize").toString();
        } catch (Exception e) {
        }

    }

    /**
     * Get connection<br>
     * 
     * @return the connection to sql server with infomation get from context.xml
     * @throws Exception when can not connect to sql server
     */
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbname;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, username, password);
    }

    /**
     * Close Connection<br>
     * 
     * Method này thực hiện đóng kết nối của các tham số truyền vào, lần lượt theo thứ tự ResultSet, PreparedStatement, Connection
     * 
     * Xử lí Exception
     *      Nếu có vấn đề xảy ra trong quá trình đóng thì sẽ trả về SQL Exception tương ứng
     * 
     * @param rs ResultSet
     * @param ps PreparedStatement
     * @param con Connection
     * @throws SQLException trong trường hợp xử lý đóng thất bại
     */
    public void closeConnection(ResultSet rs, PreparedStatement ps, Connection con) throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }

    public String getImagePath() throws Exception {
        return image;
    }

    public String getPageSize() {
        return pageSize;
    }
    
}
