package Modelos;

import Controladores.*;

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
        String query = "INSERT INTO Sindicato (ci,fecha,mono) VALUES (" + ci + "," + monto + "," + fecha + ")";
        try {
            SqlConnection.conectar();
            SqlConnection.ejecutar(query);
            SqlConnection.desconectar();
        } catch (Exception e) {
        }

    }
}
