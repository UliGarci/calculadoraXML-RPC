package controller;

import MySQLConnection.MySQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoCalcu {
    //ULISES DANIEL GARCÍA MÉNDEZ
    Connection con;
    PreparedStatement pstm;
    CallableStatement cstm;
    ResultSet rs;
    String nuevo_registro = "INSERT INTO historial("+
            "id,operacion,num1,num2,resultado,fecha) VALUE(?,?,?,?,?,?)";

    String listar = "SELECT * FROM historial";

    public BeanCalcu insertarCalculo(int id,String operacion,int num1,int num2,int resultado,String fecha){
        BeanCalcu beanCalcu = new BeanCalcu();
        try {
            con = MySQLConnection.getConnection();
            pstm = con.prepareStatement(nuevo_registro);
            pstm.setInt(1,id);
            pstm.setString(2,operacion);
            pstm.setInt(3,num1);
            pstm.setInt(4,num2);
            pstm.setInt(5,resultado);
            pstm.setString(6,fecha);
            int result = pstm.executeUpdate();
            if(result==1){
                beanCalcu.setId(id);
                beanCalcu.setOperacion(operacion);
                beanCalcu.setNum1(num1);
                beanCalcu.setNum2(num2);
                beanCalcu.setResultado(resultado);
                beanCalcu.setFecha(fecha);
            }else{
                beanCalcu=null;
            }
        }catch (SQLException e){
            System.out.println("Error en el metodo insertarCalculo() -> "+e.getMessage());
        }finally {
            try {
                pstm.close();
                con.close();
            }catch (SQLException e){
                System.out.println("Error en el cierrre de conexiones -> "+e.getMessage());
            }
        }
        return beanCalcu;
    }

    public List<BeanCalcu> findAll(){
        List<BeanCalcu> listaHistorial = new ArrayList<>();
        try {
            //HACER CONEXIÓN A BDD
            con = MySQLConnection.getConnection();
            //PROCEDIMIENTO
            cstm = con.prepareCall(listar);
            rs = cstm.executeQuery();
            while(rs.next()){
                BeanCalcu beanCalcu = new BeanCalcu();

                beanCalcu.setId(rs.getInt("id"));
                beanCalcu.setOperacion(rs.getString("operacion"));
                beanCalcu.setNum1(rs.getInt("num1"));
                beanCalcu.setNum2(rs.getInt("num2"));
                beanCalcu.setResultado(rs.getInt("resultado"));
                beanCalcu.setFecha(rs.getString("fecha"));
                listaHistorial.add(beanCalcu);
            }
        }catch (SQLException e){
            System.out.println("Error -> "+e.getMessage());
        }finally {
            try {
                if (con!=null){
                    con.close();
                }
                if (rs!=null){
                    rs.close();
                }
            }catch (SQLException e){}
        }
        return listaHistorial;
    }
}
