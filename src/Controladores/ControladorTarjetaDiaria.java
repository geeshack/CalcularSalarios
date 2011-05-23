/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controladores;

import Interfaces.IReceptorTrabajador;
import Modelos.*;
import Vistas.*;

/**
 *
 * @author Shack
 */
public class ControladorTarjetaDiaria implements IReceptorTrabajador{

    BuscarTrabajador buscarTrabajador;
    RegistroTarjetaDiaria vista;

    public void setVista(RegistroTarjetaDiaria vista){
        this.vista=vista;
    }

    public void buscarCliente() {
        buscarTrabajador=new BuscarTrabajador();
        buscarTrabajador.setReceptor(this);
        buscarTrabajador.setVisible(true);
    }

    public void RecibirTrabajador(Trabajador trabajador) {
        vista.setTrabajadorCI(trabajador.getCi());
    }

}
