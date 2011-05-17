package Modelos;

import Controladores.SqlConnection;
import java.sql.ResultSet;

public class Trabajador {

    private int ci;
    private String nombreCompleto;
    private String fechaNacimiento;
    private String tipo;

    public Trabajador(int ci, String nombreCompleto, String fechaNacimiento, String tipo) {
        this.ci = ci;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.tipo = tipo;
    }

    public int getCi() {
        return ci;
    }

    @Override
    public String toString() {
        String datos = ci + " " + nombreCompleto + " " + fechaNacimiento + " " + tipo;
        return datos;
    }

    public void guardar() {
        if (existe()) {
            this.modificar();
        } else {
            this.registrar();
        }
    }

    private void registrar() {
        String query = "Insert into Trabajador (ci, nombreCompleto, fechaNacimiento, tipo) "
                + "Values (" + ci + ",'" + nombreCompleto + "','" + fechaNacimiento + "','" + tipo + "')";

        this.conexionEstatica(query);
    }

    private void modificar() {
        String query = "Update Trabajador "
                + "Set nombreCompleto = '" + nombreCompleto + "', fechaNacimiento = '" + fechaNacimiento + "', tipo = '" + tipo + "'"
                + "Where ci = " + ci;

        this.conexionEstatica(query);
    }

    private boolean existe() {
        String query = "Select * From Trabajador Where ci = " + ci;

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

    private void conexionEstatica(String query) {
        try {
            SqlConnection.conectar();
            SqlConnection.ejecutar(query);
            SqlConnection.desconectar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
