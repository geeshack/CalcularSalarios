package Controladores;

import Interfaces.IReceptorTrabajador;
import Modelos.*;
import Vistas.BuscarTrabajador;
import java.util.ArrayList;

public class ControladorTrabajador {

    IReceptorTrabajador receptor;
    ArrayList<Trabajador> listaTrabajadores;
    Trabajador trabajadorSeleccionado;
    BuscarTrabajador vista;

    public void guardar(int ci, String nombreCompleto, String fechaNacimiento, String tipo, int sueldo, int comision) {
        Trabajador trabajador;
        if (tipo.equals("Horas")) {
            trabajador = new TrabajadorPorHoras(ci, nombreCompleto, fechaNacimiento, sueldo);
        } else if (tipo.equals("Comision")) {
            trabajador = new TrabajadorConComision(ci, nombreCompleto, fechaNacimiento, sueldo, comision);
        } else {
            trabajador = new TrabajadorSinComision(ci, nombreCompleto, fechaNacimiento, sueldo);
        }
        trabajador.guardar();
    }

    public void setReceptor(IReceptorTrabajador receptor){
        this.receptor=receptor;
    }

    public void setVista(BuscarTrabajador vista){
        this.vista=vista;
    }

    public void buscarTrabajador(String ci, String nombre){
        int id=0;
        if(!ci.isEmpty())
            id=Integer.parseInt(ci);

        this.listaTrabajadores = Trabajador.buscarTrabajadores(id, nombre);
        int countRows = this.listaTrabajadores.size();
        //if (countRows == 1) {
        //    _cliente = (ClienteClass) _listaClientes.get(0);
        //    this._vista.dispose();
        //} else {
        this.vista.vaciarTabla();
        for (int index = 0; index < countRows; index++) {
            this.vista.agregarTrabajador(this.listaTrabajadores.get(index).toObjectArray());
        }
    }

    public void modificarTrabajador(){
        
    }

    public void seleccionarTrabajador(int fila){
        trabajadorSeleccionado=listaTrabajadores.get(fila);
        receptor.RecibirTrabajador(trabajadorSeleccionado);
        vista.dispose();
    }
}
