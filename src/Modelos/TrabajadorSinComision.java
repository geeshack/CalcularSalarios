package Modelos;

public class TrabajadorSinComision extends Trabajador{

    protected int sueldo;

    public TrabajadorSinComision (int ci, String nombreCompleto, String fechaNacimiento, int sueldo) {
        this.ci = ci;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.sueldo = sueldo;
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
