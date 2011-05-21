package Controladores;

import Interfaces.IReceptorTrabajador;
import Modelos.Trabajador;
import Vistas.BuscarTrabajador;
import java.util.ArrayList;

public class ControladorTrabajador {

    IReceptorTrabajador receptor;
    ArrayList<Trabajador> listaTrabajadores;
    Trabajador trabajadorSeleccionado;
    BuscarTrabajador vista;

    public void guardar(int ci, String nombreCompleto, String fechaNacimiento, String tipo) {
        Trabajador trabajador = new Trabajador(ci, nombreCompleto, fechaNacimiento, tipo);
        trabajador.guardar();
    }

    public void setReceptor(IReceptorTrabajador receptor){
        this.receptor=receptor;
    }

    public void setVista(BuscarTrabajador vista){
        this.vista=vista;
    }

    public void buscarTrabajador(int ci, String nombre){
        this.listaTrabajadores = Trabajador.buscarTrabajadores(ci, nombre);
        int countRows = this.listaTrabajadores.size();
        //if (countRows == 1) {
        //    _cliente = (ClienteClass) _listaClientes.get(0);
        //    this._vista.dispose();
        //} else {
        this.vista.vaciarTabla();
        for (int index = 0; index < countRows; index++) {
            this.vista.agregarCliente(this.listaTrabajadores.get(index).toObjectArray());
        }
    }

    public void seleccionarTrabajador(int fila){
        trabajadorSeleccionado=listaTrabajadores.get(fila);
        receptor.RecibirTrabajador(trabajadorSeleccionado);
        vista.dispose();
    }
}
