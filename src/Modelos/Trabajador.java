package Modelos;

import Controladores.SqlConnection;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Trabajador {

    protected int ci;
    protected String nombreCompleto;
    protected String fechaNacimiento;
    protected String tipo;

    public Trabajador() {
    }

    public Trabajador(int ci, String nombreCompleto, String tipo, String fechaNacimiento) {
        this.ci = ci;
        this.nombreCompleto = nombreCompleto;
        this.tipo = tipo;
        this.fechaNacimiento = fechaNacimiento;
    }

    public static Trabajador getTrabajador(int ci, String nombreCompleto, String fechaNacimiento, String tipo, int sueldo, int comision) {
        Trabajador trabajador;
        if (tipo.equals("Horas")) {
            trabajador = new TrabajadorPorHoras(ci, nombreCompleto, fechaNacimiento, sueldo);
        } else if (tipo.equals("Comision")) {
            trabajador = new TrabajadorConComision(ci, nombreCompleto, fechaNacimiento, sueldo, comision);
        } else {
            trabajador = new TrabajadorSinComision(ci, nombreCompleto, fechaNacimiento, sueldo);
        }
        return trabajador;
    }

    public static Trabajador getTrabajador(int ci) {
        String tipo=obtenerTipo(ci);
        Trabajador trabajador;
        if (tipo.equals("Horas")) {
            trabajador = new TrabajadorPorHoras(ci, tipo);
        } else if (tipo.equals("Comision")) {
            trabajador = new TrabajadorConComision(ci, tipo);
        } else {
            trabajador = new TrabajadorSinComision(ci, tipo);
        }
        return trabajador;
    }

    public int getCi() {
        return ci;
    }

    public String getNombre() {
        return nombreCompleto;
    }

    public String getFecha() {
        return fechaNacimiento;
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

    protected void registrar() {
    }

    public void modificar() {
    }

    public int calcularPago(){
        return 0;
    }

    private static String obtenerTipo(int ci){
        String resultado="";
        String query = "SELECT ci,'Comision' as tipo FROM TrabajadorConComision WHERE ci="+ci
        +" UNION select ci,'Horas' as tipo from TrabajadorPorHoras WHERE ci="+ci
        +" UNION select ci,'NoComision' as tipo from TrabajadorSinComision WHERE ci="+ci;

        try {
            SqlConnection.conectar();

            ResultSet rs = SqlConnection.ejecutarResultado(query);
            if(rs.next()) {
                resultado=rs.getNString("tipo");
            }
            SqlConnection.desconectar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }

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

        String query = "SELECT ci,nombreCompleto,'Comision' as tipo,fechaNacimiento FROM TrabajadorConComision WHERE ci=" + ci + " OR nombreCompleto LIKE '%" + nombre + "%'"
                + " UNION select ci,nombreCompleto,'Horas' as tipo,fechaNacimiento from TrabajadorPorHoras WHERE ci=" + ci + " OR nombreCompleto LIKE '%" + nombre + "%'"
                + " UNION select ci,nombreCompleto,'NoComision' as tipo,fechaNacimiento from TrabajadorSinComision WHERE ci=" + ci + " OR nombreCompleto LIKE '%" + nombre + "%'";

        try {
            SqlConnection.conectar();

            ResultSet rs = SqlConnection.ejecutarResultado(query);
            while (rs.next()) {
                t = new Trabajador(rs.getInt("ci"), rs.getString("nombreCompleto"), rs.getString("tipo"), rs.getString("fechaNacimiento"));
                listaTrabajadores.add(t);
            }
            SqlConnection.desconectar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listaTrabajadores;
    }

    public Object[] toObjectArray() {
        Object[] data = {ci, nombreCompleto, tipo};
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
