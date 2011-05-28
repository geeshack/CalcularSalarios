package Controladores;

import Interfaces.IReceptorTrabajador;
import Modelos.*;
import Vistas.*;

public class ControladorCompraSindicato implements IReceptorTrabajador {

    BuscarTrabajador buscarTrabajador;
    RegistroCompraSindicato vista;

    public void setVista(RegistroCompraSindicato vista) {
        this.vista = vista;
    }

    public void BuscarTrabajador() {
        buscarTrabajador = new BuscarTrabajador();
        buscarTrabajador.setReceptor(this);
        buscarTrabajador.setVisible(true);
    }

    public void GuardarCompra(int ci, int costo,String descripcion) {
        AporteSindicato.registraCompra(ci,costo,descripcion);
    }

    public void RecibirTrabajador(Trabajador trabajador) {
        vista.setTrabajadorCI(trabajador.getCi());
    }

}
