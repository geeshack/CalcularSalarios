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

    @Override
    protected void registrar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void modificar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected boolean existe() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
