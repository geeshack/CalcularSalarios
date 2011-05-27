package Controladores;

import Interfaces.IReceptorTrabajador;
import Modelos.*;
import Vistas.*;

public class ControladorTarjetaDiaria implements IReceptorTrabajador {

    BuscarTrabajador buscarTrabajador;
    RegistroTarjetaDiaria vista;

    public void setVista(RegistroTarjetaDiaria vista) {
        this.vista = vista;
        this.vista.setFecha(Fecha.getFechaActual());
    }

    public void buscarCliente() {
        buscarTrabajador = new BuscarTrabajador();
        buscarTrabajador.setReceptor(this);
        buscarTrabajador.setVisible(true);
    }

    public void RecibirTrabajador(Trabajador trabajador) {
        vista.setTrabajadorCI(trabajador.getCi());
    }

    public void guardar(int ci, String fecha, int horas) {
        TarjetaDiaria tarjeta=new TarjetaDiaria(ci, fecha, horas);
        tarjeta.registrarTarjeta();
    }
}
