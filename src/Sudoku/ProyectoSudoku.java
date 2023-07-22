package Sudoku;

import java.util.Scanner;

public class ProyectoSudoku {
    public static void main(String[] args) {
        ProyectoSudokuFunciones funcion = new ProyectoSudokuFunciones();
        Scanner teclado;
        String casillaRellenar = "";
        String auxiliar = "";
        String completo = "";
        int fila = 0;
        int columna = 0;
        int valor= 0;
        boolean verifcadorFCR;
        boolean salida = false;
        boolean deseaSalir = false;
        teclado = new Scanner(System.in);
        funcion.inicioBienvenida();
        funcion.dificultadJugador(teclado);
        funcion.imprimirTabla();
        System.out.println("");
        while (salida == false) {
            while (deseaSalir == false) {
                casillaRellenar = funcion.decisionJugadorCelda(teclado);
                if (casillaRellenar.equals("SALIR")) {
                    break;
                }else {
                    if (casillaRellenar.equals("ATRAS")){
                        funcion.dificultadJugador(teclado);
                        funcion.imprimirTabla();
                        System.out.println("");
                    }else{
                        fila = funcion.fila(casillaRellenar);
                        columna = funcion.columna(casillaRellenar);
                        auxiliar = funcion.nuevoValorOSalida(teclado);
                        if (auxiliar.equals("SALIR")) {
                            break;
                        }else {
                            if (auxiliar.equals("ATRAS")) {
                            } else {
                                valor = funcion.nuevoValor(auxiliar);
                                break;
                            }
                        }
                    }
                }
            }
            if (casillaRellenar.equals("SALIR") || auxiliar.equals("SALIR")) {
                System.out.println("");
                System.out.println("\u001B[31m"+"         ¿Te cansaste?");
                System.out.println("¡No te precupes! Aqui te mostramos la solucion."+"\u001B[37m");
                System.out.println("");
                funcion.solucion();
                break;
            }
            verifcadorFCR = funcion.verificadorColumnaFilaRegion(fila, columna, valor);
            funcion.comparacion(fila, columna, valor,verifcadorFCR);
            funcion.imprimirTabla();
            completo = funcion.tablaCompletada();
            if (completo.equals("SALIR")) {
                System.out.println("");
                System.out.println("FELICIDADES, PUDISTE RESOLVER EL SUDOKU!!");
                System.out.println("ERES GENIAL!!!!!!");
                break;
            }
            System.out.println("");
        }
    }
}
