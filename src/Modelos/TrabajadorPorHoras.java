package Modelos;

import java.sql.ResultSet;
import Controladores.SqlConnection;

public class TrabajadorPorHoras extends Trabajador {

    protected int sueldo;

    public TrabajadorPorHoras (int ci, String nombreCompleto, String fechaNacimiento, int sueldo) {
        this.ci = ci;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.sueldo = sueldo;
    }

    @Override
    protected void registrar() {
        String query = "Insert into TrabajadorPorHoras (ci, nombreCompleto, fechaNacimiento, sueldo) "
                + "Values (" + ci + ",'" + nombreCompleto + "','" + fechaNacimiento + "')";

        this.conexionEstatica(query);
    }

    @Override
    protected void modificar() {
        String query = "Update TrabajadorPorHoras "
                + "Set nombreCompleto = '" + nombreCompleto + "', fechaNacimiento = '" + fechaNacimiento + "'"
                + "Where ci = " + ci;

        this.conexionEstatica(query);
    }

    @Override
    protected boolean existe () {
        String query = "Select * From TrabajadorPorHoras Where ci = " + ci;

        try {
            SqlConnection.conectar();
            ResultSet rs = SqlConnection.ejecutarResultado(query);
            SqlConnection.desconectar();

            return rs.next();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
