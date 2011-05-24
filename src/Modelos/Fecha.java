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
public class Fecha {

    int dia;
    int mes;
    int ano;

    public Fecha(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }



    public static String getFechaActual(){
        String query;
        Fecha fecha=new Fecha(5,25,11);
        query="SELECT * FROM Fechas WHERE id='1'";
        try{
            SqlConnection.conectar();
            ResultSet rs=SqlConnection.ejecutarResultado(query);
            if(rs.next()){
                fecha=new Fecha(rs.getInt("dia"), rs.getInt("mes"), rs.getInt("ano"));
            }
            SqlConnection.desconectar();
        }
        catch(Exception e){}
        return fecha.cadenaFecha();
    }

    public String cadenaFecha(){
        return ano+"/"+mes+"/"+dia;
    }

    public void GuardaFecha(){
        String query="UPDATE Fechas SET dia="+dia+", mes="+mes+", ano="+ano+" WHERE id='1'";
        try{
            SqlConnection.conectar();
            SqlConnection.ejecutar(query);
            SqlConnection.desconectar();
        }
        catch(Exception e){}
    }
}
