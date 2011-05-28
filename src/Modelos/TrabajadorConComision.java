package Modelos;

public class TrabajadorConComision extends Trabajador {

    protected int sueldo;
    protected int comision;

    public TrabajadorConComision(int ci, String nombreCompleto, String fechaNacimiento, int sueldo, int comision) {
        this.ci = ci;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.sueldo = sueldo;
        this.comision = comision;
    }

    public TrabajadorConComision(int ci, String tipo) {
        this.ci=ci;
        this.tipo=tipo;
    }

    @Override
    protected void registrar() {
        String query = "Insert into TrabajadorConComision (ci, nombreCompleto, fechaNacimiento, sueldo, comision) "
                + "Values (" + ci + ",'" + nombreCompleto + "','" + fechaNacimiento + "'," + sueldo + "," + comision + ")";

        this.conexionEstatica(query);
    }

    @Override
    public void modificar() {
        String query = "Update TrabajadorConComision "
                + "Set nombreCompleto = '" + nombreCompleto + "', fechaNacimiento = '" + fechaNacimiento + "', sueldo = " + sueldo + ", comision = " + comision
                + "Where ci = " + ci;

        this.conexionEstatica(query);
    }

    @Override
    public int calcularPago(){
        return 0;
    }
}
