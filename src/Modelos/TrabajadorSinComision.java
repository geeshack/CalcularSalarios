package Modelos;

public class TrabajadorSinComision extends Trabajador {

    protected int sueldo;

    public TrabajadorSinComision(int ci, String nombreCompleto, String fechaNacimiento, int sueldo) {
        this.ci = ci;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.sueldo = sueldo;
    }

    @Override
    protected void registrar() {
        String query = "Insert into TrabajadorSinComision (ci, nombreCompleto, fechaNacimiento, sueldo) "
                + "Values (" + ci + ",'" + nombreCompleto + "','" + fechaNacimiento + "'," + sueldo + ")";

        this.conexionEstatica(query);
    }

    @Override
    protected void modificar() {
        String query = "Update TrabajadorSinComision "
                + "Set nombreCompleto = '" + nombreCompleto + "', fechaNacimiento = '" + fechaNacimiento + "', sueldo = " + sueldo
                + "Where ci = " + ci;

        this.conexionEstatica(query);
    }
}
