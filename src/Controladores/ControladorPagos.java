package Controladores;

import Interfaces.IReceptorTrabajador;
import Modelos.*;
import Vistas.*;

public class ControladorPagos implements IReceptorTrabajador {

    PagosVista vista;
    BuscarTrabajador buscarTrabajador;

    public void setVista(PagosVista vista) {
        this.vista = vista;
    }

    public void buscarCliente() {
        buscarTrabajador = new BuscarTrabajador();
        buscarTrabajador.setReceptor(this);
        buscarTrabajador.setVisible(true);
    }

    public void RecibirTrabajador(Trabajador trabajador) {
        vista.setTrabajadorCI(trabajador.getCi());
    }

    public void calcularPago(int ci){
        Trabajador trabajador=Trabajador.getTrabajador(ci);
        vista.setLabelPago(trabajador.calcularPago());
    }
}
