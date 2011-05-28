/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Controladores.SqlConnection;
import java.sql.ResultSet;

/**
 *
 * @author Shack
 */
public class TarjetaDiaria {

    int ci;
    String fecha;
    int horas;

    public TarjetaDiaria(int ci, String fecha, int horas) {
        this.ci = ci;
        this.fecha = fecha;
        this.horas = horas;
    }

    public void registrarTarjeta() {
        String query = "INSERT INTO TarjetaDiaria (ci,fecha,horas) VALUES (" + ci + ",'" + fecha + "'," + horas + ")";
        try {
            SqlConnection.conectar();
            SqlConnection.ejecutar(query);
            SqlConnection.desconectar();
        } catch (Exception e) {
        }
    }

    public static int getHoras(int ci) {
        int horas = 0;
        String query = "SELECT FROM TarjetaDiaria WHERE ci = " + ci;
        try {
            SqlConnection.conectar();
            ResultSet rs = SqlConnection.ejecutarResultado(query);
            horas = rs.getInt("horas");
            SqlConnection.desconectar();
        } catch (Exception e) {
        }
        return horas;
    }
}
