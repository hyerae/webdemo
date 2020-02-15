package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcUtil {
    private static final String USER="root";
    private static final String PASSWORD = "wwq99752";
    private static final String URL="jdbc:mysql://localhost:3306/s_t?useUnicode=true&characterEncoding=UTF-8";
    static {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    private static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    private static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null) {
            try{
                pstmt.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        if (conn != null){
            try{
                conn.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public static int executeUpdate(String sql, Object... objs){
        Connection conn = getConnection();
        PreparedStatement pstmt = null;
        int a = 0;
        try{
            pstmt = conn.prepareStatement(sql);
            if (objs != null){
                for (int i = 0; i < objs.length; i++){
                    pstmt.setObject(i + 1, objs[i]);
                }
            }
            a = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(null,pstmt,conn);
        }
        return a;
    }

    public static <T> List<T> executeQuery(String sql, RowMap<T> rowMap, Object... objs) {
        Connection conn = getConnection();
        ArrayList<T> lists = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try{
            pstmt = conn.prepareStatement(sql);
            if (objs != null){
                for (int i = 0; i < objs.length; i++){
                    pstmt.setObject(i + 1, objs[i]);
                }
            }
            rs = pstmt.executeQuery();
            while (rs.next()) {
                T t = rowMap.RowMapping(rs);
                lists.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, pstmt, conn);
        }
        return lists;
    }

    public static <T> T queryOne(String sql, RowMap<T> rowMap, Object... objs) {
        Connection conn = getConnection();
        T t = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try{
            pstmt = conn.prepareStatement(sql);
            if (objs != null){
                for (int i = 0; i < objs.length; i++){
                    pstmt.setObject(i + 1, objs[i]);
                }
            }
            rs = pstmt.executeQuery();
            while (rs.next()) {
                t = rowMap.RowMapping(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, pstmt, conn);
        }
        return t;
    }
}
