package Modelos;

public class TrabajadorPorHoras extends Trabajador {

    protected int sueldo;

    public TrabajadorPorHoras(int ci, String nombreCompleto, String fechaNacimiento, int sueldo) {
        this.ci = ci;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.sueldo = sueldo;
    }

    @Override
    protected void registrar() {
        String query = "Insert into TrabajadorPorHoras (ci, nombreCompleto, fechaNacimiento, sueldo) "
                + "Values (" + ci + ",'" + nombreCompleto + "','" + fechaNacimiento + "'," + sueldo + ")";

        this.conexionEstatica(query);
    }

    @Override
    public void modificar() {
        String query = "Update TrabajadorPorHoras "
                + "Set nombreCompleto = '" + nombreCompleto + "', fechaNacimiento = '" + fechaNacimiento + "', sueldo = " + sueldo
                + "Where ci = " + ci;

        this.conexionEstatica(query);
    }
}
