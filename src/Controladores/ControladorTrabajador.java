package Controladores;

import Modelos.Trabajador;

public class ControladorTrabajador {

    public void guardar(int ci, String nombreCompleto, String fechaNacimiento, String tipo) {
        Trabajador trabajador = new Trabajador(ci, nombreCompleto, fechaNacimiento, tipo);
        trabajador.guardar();
    }
}
