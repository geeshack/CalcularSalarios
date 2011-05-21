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

    protected abstract boolean existe();

    public static ArrayList<Trabajador> buscarTrabajadores(int CI, String nombre) {
        //Mono para buscar trabajadores
        return null;
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
