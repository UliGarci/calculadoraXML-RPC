package MySQLConnection;

import java.sql.*;

public class MySQLConnection {
    public static Connection getConnection() throws SQLException {
        String host = "127.0.0.1";
        String port = "3306";
        String database ="calculadoraBD";
        String useSSL = "false";
        String timezone = "UTC";
        String url=String.format("jdbc:mysql://%s:%s/%s?useSSL=%s&serverTimezone=%s",host,port,database,useSSL,timezone);
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        return DriverManager.getConnection(url,"root","");
    }

    public static void closeConnections(Connection con, CallableStatement cstm, ResultSet rs){
        try {
            if (rs != null) {rs.close();}
            if (cstm != null) {cstm.close();}
            if (con != null) {con.close();}
        }catch (SQLException e){}

    }

    public static void closeConnections(Connection con, CallableStatement cstm){
        try {
            if (cstm != null){
                cstm.close();
            }
        }catch (SQLException e){}

    }

    public static void main(String[] args) {
        try{
            Connection cn = getConnection();
            System.out.println("¡Conexion Exitosa!");
            cn.close();
        } catch (SQLException e) {
            System.out.println("¡Conexion Fallida! "+e);
        }
    }
}
