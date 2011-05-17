package Controladores;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class SqlConnection {

    private static Connection con = null;

    public static ResultSet ejecutarResultado(String query) {
        ResultSet rs = null;

        try {
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            return rs;
        } catch (Exception e) {
            System.out.print(e.getMessage());
            return rs;
        }
    }

    public static void ejecutar(String query) {
        try {
            Statement stmt = con.createStatement();
            stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    /*public String setSucursal(Sucursal sucursal) {
    try {
    String SQL = "insert into sucursal (nombre,direccion,encargado) values ('" + sucursal.getNombreSucursal() + "','" + sucursal.getDireccion() + "','" + sucursal.getEncargado() + "')";
    conn.conectar();
    con = conn.con;

    Statement stmt = con.createStatement();
    stmt.execute(SQL);
    con.close();
    return "todo blue";
    } catch (Exception es) {
    return es.toString();
    }
    }*/
    
    public static void conectar() throws InstantiationException, IllegalAccessException {
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:salarios");

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

    public static void desconectar() throws SQLException {
        con.close();
    }
}
