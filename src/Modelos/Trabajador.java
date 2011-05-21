package Modelos;

import Controladores.SqlConnection;

import java.sql.ResultSet;
import java.util.ArrayList;

public abstract class Trabajador {

    protected int ci;
    protected String nombreCompleto;
    protected String fechaNacimiento;

    public Trabajador() {
    }

    public int getCi() {
        return ci;
    }

    @Override
    public String toString() {
        String datos = ci + " " + nombreCompleto + " " + fechaNacimiento;
        return datos;
    }

    public void guardar() {
        if (existe()) {
            this.modificar();
        } else {
            this.registrar();
        }
    }

    protected abstract void registrar();

    protected abstract void modificar();

    protected boolean existe() {
        String query = "Select * From TrabajadorPorHoras Where ci = " + ci;

        try {
            SqlConnection.conectar();
            ResultSet rs = SqlConnection.ejecutarResultado(query);

            boolean result = rs.next();

            query = "Select * From TrabajadorConComision Where ci = " + ci;
            rs = SqlConnection.ejecutarResultado(query);
            result = result || rs.next();

            query = "Select * From TrabajadorSinComision Where ci = " + ci;
            rs = SqlConnection.ejecutarResultado(query);
            result = result || rs.next();

            SqlConnection.desconectar();

            return result;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static ArrayList<Trabajador> buscarTrabajadores(int ci, String nombre) {
        ArrayList<Trabajador> listaTrabajadores = new ArrayList<Trabajador>();
        Trabajador t;
        
        String query = "Select *"
                + "From TrabajadorPorHoras"
                + "Where ci = " + ci + " or nombre = '" + nombre + "'";
        try {
            SqlConnection.conectar();

            ResultSet rs = SqlConnection.ejecutarResultado(query);
            while (rs.next()) {
                t = new TrabajadorPorHoras(rs.getInt("ci"), rs.getString("nombre"), rs.getString("fechaNacimiento"), rs.getInt("sueldo"));
                listaTrabajadores.add(t);
            }

            query = "Select *"
                + "From TrabajadorConComision"
                + "Where ci = " + ci + " or nombre = '" + nombre + "'";
            rs = SqlConnection.ejecutarResultado(query);
            while (rs.next()) {
                t = new TrabajadorConComision(rs.getInt("ci"), rs.getString("nombre"), rs.getString("fechaNacimiento"), rs.getInt("sueldo"), rs.getInt("comision"));
                listaTrabajadores.add(t);
            }

            query = "Select *"
                + "From TrabajadorSinComision"
                + "Where ci = " + ci + " or nombre = '" + nombre + "'";
            rs = SqlConnection.ejecutarResultado(query);

            while (rs.next()) {
                t = new TrabajadorSinComision(rs.getInt("ci"), rs.getString("nombre"), rs.getString("fechaNacimiento"), rs.getInt("sueldo"));
                listaTrabajadores.add(t);
            }

            SqlConnection.desconectar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listaTrabajadores;
    }

    public Object[] toObjectArray() {
        Object[] data = {ci, nombreCompleto};
        return data;
    }

    protected void conexionEstatica(String query) {
        try {
            SqlConnection.conectar();
            SqlConnection.ejecutar(query);
            SqlConnection.desconectar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
