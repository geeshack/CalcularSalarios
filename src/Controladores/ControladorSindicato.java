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
public class ControladorSindicato implements IReceptorTrabajador  {

    BuscarTrabajador buscarTrabajador;
    RegistroSindicato vista;

    public void setVista(RegistroSindicato vista) {
        this.vista = vista;
    }

    public void BuscarTrabajador(){
        buscarTrabajador=new BuscarTrabajador();
        buscarTrabajador.setReceptor(this);
        buscarTrabajador.setVisible(true);
    }

    public void Guardar(int ci, int aporte){
        AporteSindicato aporteSindicato=new AporteSindicato(ci, aporte);
        aporteSindicato.registrarAporte();
    }

    public void RecibirTrabajador(Trabajador trabajador) {
        vista.setTrabajadorCI(trabajador.getCi());
    }

}
