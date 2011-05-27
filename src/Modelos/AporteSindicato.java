package Modelos;

import Controladores.SqlConnection;

public class AporteSindicato {

    int ci;
    int aporte;

    public AporteSindicato(int ci, int aporte) {
        this.ci = ci;
        this.aporte = aporte;
    }

    public void registrarAporte() {
        String query = "INSERT INTO Sindicato (ci,aporte) VALUES (" + ci + "," + aporte + ")";
        try {
            SqlConnection.conectar();
            SqlConnection.ejecutar(query);
            SqlConnection.desconectar();
        } catch (Exception e) {
        }
    }
}
