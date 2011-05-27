package Controladores;

import Interfaces.*;
import Modelos.Fecha;
import Modelos.ReciboVenta;
import Modelos.Trabajador;
import Vistas.*;

public class ControladorReciboVenta implements IReceptorTrabajador {

    BuscarTrabajador buscarTrabajador;
    ReciboVentaVista vista;

    public ControladorReciboVenta() {
    }

    public void setVista(ReciboVentaVista vista) {
        this.vista = vista;
        this.vista.setFecha(Fecha.getFechaActual());
    }

    public void BuscarTrabajador() {
        buscarTrabajador = new BuscarTrabajador();
        buscarTrabajador.setReceptor(this);
        buscarTrabajador.setVisible(true);
    }

    public void RecibirTrabajador(Trabajador trabajador) {
        vista.setTrabajadorCI(trabajador.getCi());
    }

    public void guardar(int ci, String fecha, int monto) {
        ReciboVenta recibo = new ReciboVenta(ci, fecha, monto);
        recibo.guardar();
    }
}
