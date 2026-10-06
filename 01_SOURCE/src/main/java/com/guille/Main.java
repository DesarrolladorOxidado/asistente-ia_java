package com.guille;

import com.guille.aplicacion.Aplicacion;
import com.guille.servicios.ServicioAsistente;

public class Main {

    void main() {
        ServicioAsistente servicioAsistente = new ServicioAsistente();
        Aplicacion aplicacion = new Aplicacion(servicioAsistente);
        aplicacion.ejecutar();
    }
}
