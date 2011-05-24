/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelos;

import Controladores.SqlConnection;

/**
 *
 * @author Shack
 */
public class AporteSindicato {

    int ci;
    int aporte;

    public AporteSindicato(int ci, int aporte) {
        this.ci = ci;
        this.aporte = aporte;
    }

    public void registrarAporte(){
        String query="INSERT INTO Sindicato (ci,aporte) VALUES ("+ci+","+aporte+")";
        try{
            SqlConnection.conectar();
            SqlConnection.ejecutar(query);
            SqlConnection.desconectar();
        }
        catch(Exception e){}
    }
}
