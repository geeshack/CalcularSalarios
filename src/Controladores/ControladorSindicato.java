package Controladores;

import Interfaces.IReceptorTrabajador;
import Modelos.*;
import Vistas.*;

public class ControladorSindicato implements IReceptorTrabajador {

    BuscarTrabajador buscarTrabajador;
    RegistraSindicato vista;

    public void setVista(RegistraSindicato vista) {
        this.vista = vista;
    }

    public void BuscarTrabajador() {
        buscarTrabajador = new BuscarTrabajador();
        buscarTrabajador.setReceptor(this);
        buscarTrabajador.setVisible(true);
    }

    public void Guardar(int ci, int aporte) {
        AporteSindicato aporteSindicato = new AporteSindicato(ci, aporte);
        aporteSindicato.registrarAporte();
    }

    public void RecibirTrabajador(Trabajador trabajador) {
        vista.setTrabajadorCI(trabajador.getCi());
    }
}
