package Controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.sqlite.JDBC;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hectorg
 */
public class SqlConnection {

    Connection con;

    public SqlConnection() {
    }

    public void conectar() throws InstantiationException, IllegalAccessException {
        //String Url = "jdbc:mysql://localhost/bdtaller";
        //String user="hector";
        //String pass="ajjf1031";
        String user = "root";
        String pass = "";
        try {
            /*Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(Url,user,pass);*/
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:salarios");

            //con=DriverManager.getConnection("jdbc:sqlserver://192.168.0.106\\SQLEXPRESS:1433;databaseName=Veterinaria;Integrated Security=True");

        } catch (SQLException excepcionSql) { //excepcionSql = puede ponerle otro nombre
            JOptionPane.showMessageDialog(null, excepcionSql.getMessage(),
                    "Error en base de datos", JOptionPane.ERROR_MESSAGE);
        } //errores con la carga del controlador de la base de datos(Driver)
        catch (ClassNotFoundException claseNoEncontrada) {
            JOptionPane.showMessageDialog(null, claseNoEncontrada.getMessage(),
                    "No se encontró el controlador", JOptionPane.ERROR_MESSAGE);
        } catch (Exception excepcionSql) { //excepcionSql = puede ponerle otro nombre
            System.out.println(excepcionSql.getMessage());
        }
    }

    public void desconectar() throws SQLException {
        con.close();
    }
}
