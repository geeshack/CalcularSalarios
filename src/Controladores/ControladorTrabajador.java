package Controladores;

import Interfaces.IReceptorTrabajador;
import Modelos.*;
import Vistas.BuscarTrabajador;
import Vistas.RegistrarTrabajador;
import java.util.ArrayList;

public class ControladorTrabajador {

    IReceptorTrabajador receptor;
    ArrayList<Trabajador> listaTrabajadores;
    Trabajador trabajadorSeleccionado;
    BuscarTrabajador vistaBuscar;
    RegistrarTrabajador vistaRegistro;

    public void guardar(int ci, String nombreCompleto, String fechaNacimiento, String tipo, int sueldo, int comision) {
        Trabajador trabajador = Trabajador.getTrabajador(ci, nombreCompleto, fechaNacimiento, tipo, sueldo, comision);
        trabajador.guardar();
    }

    public void modificar(int ci, String nombreCompleto, String fechaNacimiento, String tipo, int sueldo, int comision) {
        Trabajador trabajador = Trabajador.getTrabajador(ci, nombreCompleto, fechaNacimiento, tipo, sueldo, comision);
        trabajador.modificar();
    }

    public void setReceptor(IReceptorTrabajador receptor) {
        this.receptor = receptor;
    }

    public void setVista(BuscarTrabajador vista) {
        this.vistaBuscar = vista;
    }

    public void buscarTrabajador(String ci, String nombre) {
        int id = 0;
        if (!ci.isEmpty()) {
            id = Integer.parseInt(ci);
        }
        this.listaTrabajadores = Trabajador.buscarTrabajadores(id, nombre);
        int countRows = this.listaTrabajadores.size();
        this.vistaBuscar.vaciarTabla();
        for (int index = 0; index < countRows; index++) {
            this.vistaBuscar.agregarTrabajador(this.listaTrabajadores.get(index).toObjectArray());
        }
    }

    public void modificarTrabajador(int fila) {
        trabajadorSeleccionado = listaTrabajadores.get(fila);
        vistaRegistro = new RegistrarTrabajador(trabajadorSeleccionado);
        vistaRegistro.setVisible(true);
    }

    public void seleccionarTrabajador(int fila) {
        trabajadorSeleccionado = listaTrabajadores.get(fila);
        receptor.RecibirTrabajador(trabajadorSeleccionado);
        vistaBuscar.dispose();
    }
}
