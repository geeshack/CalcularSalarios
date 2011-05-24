package Controladores;

import Interfaces.*;
import Modelos.Trabajador;
import Vistas.*;

public class ControladorReciboVenta implements IReceptorTrabajador {

    BuscarTrabajador buscarTrabajador;
    ReciboVenta vista;

    public ControladorReciboVenta() {
    }

    public void setVista(ReciboVenta vista) {
        this.vista = vista;
    }

    public void BuscarTrabajador(){
        buscarTrabajador=new BuscarTrabajador();
        buscarTrabajador.setReceptor(this);
        buscarTrabajador.setVisible(true);
    }

    public void RecibirTrabajador(Trabajador trabajador) {
        vista.setTrabajadorCI(trabajador.getCi());
    }
}
