package com.guille.aplicacion;

import com.guille.servicios.ServicioAsistente;

import java.util.Scanner;

public class Aplicacion {

    private final ServicioAsistente servicioAsistente;
    private final Scanner scanner;

    public Aplicacion(ServicioAsistente servicioAsistente){
        this.scanner = new Scanner(System.in);
        this.servicioAsistente = servicioAsistente;
    }

    public void ejecutar(){

        String opcionST;
        int opcion = -1;

        do{
            mostrarMenu();

            opcionST = this.scanner.nextLine();

            try {
                opcion = Integer.parseInt(opcionST);
            }catch (NumberFormatException e ){
                System.out.println("Debe ingresar una opción válida.");
                continue;
            }

            if ( opcion < 1 || opcion > 2){
                System.out.println("Debe ingresar una opción válida.");
                continue;
            }

            switch (opcion){
                case 1 -> {
                    realizarConsulta();
                }
                case 2 -> {
                    System.out.println("Gracias por usar el sistema");
                }
            }

        }while ( opcion != 2 );

    }

    private void continuar(){
        System.out.println("Presione una tecla para continuar...");
        this.scanner.nextLine();
    }

    private void mostrarMenu(){
        System.out.println("========== ASISTENTE IA EN JAVA ==========");

        System.out.println("1 - Realizar una consulta");
        System.out.println("2 - Salir");

        System.out.println("Por favor, elija una opción: ");
    }

    private void realizarConsulta(){

        char rta;
        String consulta;

        do {
            rta = 'n';
            System.out.println("Ingrese su consulta:");
            consulta = this.scanner.nextLine();

            if (consulta.isBlank()) {
                System.out.println("Debe ingresar una consulta. ¿Quiere volver a intentar? (s/n)");
                rta = solicitarRespuestaSiNo();
            }
        }while ( rta == 's');

        String respuesta = this.servicioAsistente.procesarConsulta(consulta);
        System.out.println(respuesta);
        continuar();

    }

    private char solicitarRespuestaSiNo(){
        String ingreso = this.scanner.nextLine().toLowerCase();

        if ( ingreso.equals("s") || ingreso.equals("si") || ingreso.equals("sí"))
            return 's';

        return 'n';
    }
}
