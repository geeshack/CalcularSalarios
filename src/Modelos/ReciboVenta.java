
package Modelos;

import Controladores.*;
import java.sql.ResultSet;

public class ReciboVenta {

    int ci;
    String fecha;
    int monto;

    public ReciboVenta(int ci, String fecha, int monto) {
        this.ci = ci;
        this.fecha = fecha;
        this.monto = monto;
    }

    public void guardar() {

        String query = "INSERT INTO ReciboVenta (ci,monto,fecha,pagado) VALUES (" + ci + "," + monto + ",'" + fecha + "','pendiente')";

        try {
            SqlConnection.conectar();
            SqlConnection.ejecutar(query);
            SqlConnection.desconectar();
        } catch (Exception e) {
        }

    }


    public static int getRecibos(int ci) {
        String query = "SELECT sum(monto) as total FROM ReciboVenta WHERE ci=" + ci;
        int total = 0;
        try {
            SqlConnection.conectar();
            ResultSet rs = SqlConnection.ejecutarResultado(query);
            if (rs.next()) {
                total = rs.getInt("total");
            }
        } catch (Exception e) {
        }
        return total;
    }
}
