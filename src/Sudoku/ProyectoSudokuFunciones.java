package Sudoku;

import java.util.Arrays;
import java.util.Scanner;

public class ProyectoSudokuFunciones {
    //bloque de declaraciones
    Tablas tablas;
    private String[] filasNombres = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
    private String columnasNombres = "  1 2 3   4 5 6   7 8 9";
    private String filaColumnaLetras = "";
    private int columnaDecidida;
    private int filaDecidida;
    private String difi = "";
    private int[][] tablaRespuestas;
    private int[][] tablaRellenar;
    private int[][] tablaClon;

    public ProyectoSudokuFunciones() {
        this.filaDecidida = 0;
        this.columnaDecidida = 0;
    }

    //bloque de instrucciones
    public void inicioBienvenida() {
        System.out.println("  ");
        System.out.println("\u001B[35m"+"                       ------BIENVENIDO A SUDOKU------");
        System.out.println("  ");
        System.out.println("\u001B[36m"+"     REGLAS DEL JUEGO:");
        System.out.println("  ");
        System.out.println("     - Solo se deben usar los numeros del 1 al 9, en caso de que ingrese otro numero");
        System.out.println("       se le pedira otro.");
        System.out.println("  ");
        System.out.println("     - ¡Que no se repita ningun numero!. El numero que ingrese no se debe repetir en la ");
        System.out.println("       fila, columna y región (el cuadro 3 x 3)");
        System.out.println("  ");
        System.out.println("     - Rellene solo las casillas que contengan un 0"+"\u001B[37m");
        System.out.println("  ");
    }

    public void dificultadJugador(Scanner lector) {
        String ingresoDificultad;
        boolean verificador = false;
        do {
            System.out.println("\u001B[31m"+"¿En que dificultad desea jugar?");
            System.out.println("       - Facil\n" + "       - Medio \n" + "       - Dificil"+"\u001B[37m");
            ingresoDificultad = lector.nextLine();
            ingresoDificultad = ingresoDificultad.toUpperCase();
            switch (ingresoDificultad) {
                case "FACIL":
                    verificador = true;
                    break;
                case "MEDIO":
                    verificador = true;
                    break;
                case "DIFICIL":
                    verificador = true;
                    break;
                default:
                    System.out.println("\u001B[36m"+"Solo debe escribir en la dificultad que desea jugar");
                    System.out.println("");
            }
        } while (verificador == false);
        this.difi = ingresoDificultad;
        tablas = new Tablas(difi);
        this.tablaRespuestas = tablas.getTablaRespuestas();
        this.tablaRellenar = tablas.getTablaRellenar();
        this.tablaClon = tablas.getTablaClon();
    }

    public String decisionJugadorCelda(Scanner lector) {
        boolean verificador = false;
        int verificadorFilaColumna = 0;
        String decision;
        int fila = 0;
        int columna = 0;
        String filaColumna = "";
        do {
            System.out.println("\u001B[36m"+"------" + ("Ingrese la fila y columna que desea rellenar, si desea terminar " +
                    "ingrese 'SALIR', y si quiere retroceder 'ATRAS'").toUpperCase() + "------");
            decision = lector.nextLine();
            decision = decision.toUpperCase();
            decision = decision.trim();
            switch (decision){
                case "SALIR":
                    filaColumna = "SALIR";
                    verificador = true;
                    break;
                case "ATRAS":
                    filaColumna = "ATRAS";
                    verificador = true;
                    break;
                default:
                    if (decision.length() == 2) {
                        this.filaColumnaLetras = decision;
                        switch (decision.substring(0, 1)) {
                            case "A":
                                filaColumna = "0";
                                verificadorFilaColumna = verificadorFilaColumna + 1;
                                break;
                            case "B":
                                filaColumna = "1";
                                verificadorFilaColumna = verificadorFilaColumna + 1;
                                break;
                            case "C":
                                filaColumna = "2";
                                verificadorFilaColumna = verificadorFilaColumna + 1;
                                break;
                            case "D":
                                filaColumna = "3";
                                verificadorFilaColumna = verificadorFilaColumna + 1;
                                break;
                            case "E":
                                filaColumna = "4";
                                verificadorFilaColumna = verificadorFilaColumna + 1;
                                break;
                            case "F":
                                filaColumna = "5";
                                verificadorFilaColumna = verificadorFilaColumna + 1;
                                break;
                            case "G":
                                filaColumna = "6";
                                verificadorFilaColumna = verificadorFilaColumna + 1;
                                break;
                            case "H":
                                filaColumna = "7";
                                verificadorFilaColumna = verificadorFilaColumna + 1;
                                break;
                            case "I":
                                filaColumna = "8";
                                verificadorFilaColumna = verificadorFilaColumna + 1;
                                break;
                            default:
                                System.out.println("\u001B[31m"+"EL NOMBRE DE LA FILA DEBE SER A,B,C....,I ETC"+"\u001B[36m");
                        }
                        switch (decision.substring(1, 2)) {
                            case "1":
                                filaColumna = filaColumna + "0";
                                verificadorFilaColumna = verificadorFilaColumna + 1;
                                break;
                            case "2":
                                filaColumna = filaColumna + "1";
                                verificadorFilaColumna = verificadorFilaColumna + 1;
                                break;
                            case "3":
                                filaColumna = filaColumna + "2";
                                verificadorFilaColumna = verificadorFilaColumna + 1;
                                break;
                            case "4":
                                filaColumna = filaColumna + "3";
                                verificadorFilaColumna = verificadorFilaColumna + 1;
                                break;
                            case "5":
                                filaColumna = filaColumna + "4";
                                verificadorFilaColumna = verificadorFilaColumna + 1;
                                break;
                            case "6":
                                filaColumna = filaColumna + "5";
                                verificadorFilaColumna = verificadorFilaColumna + 1;
                                break;
                            case "7":
                                filaColumna = filaColumna + "6";
                                verificadorFilaColumna = verificadorFilaColumna + 1;
                                break;
                            case "8":
                                filaColumna = filaColumna + "7";
                                verificadorFilaColumna = verificadorFilaColumna + 1;
                                break;
                            case "9":
                                filaColumna = filaColumna + "8";
                                verificadorFilaColumna = verificadorFilaColumna + 1;
                                break;
                            default:
                                System.out.println("\u001B[231m"+"EL NOMBRE DE LA COLUMNA DEBE SER 1,2,3....,9 ETC"+"\u001B[36m");
                        }
                        if (verificadorFilaColumna == 2 ){
                            fila = Integer.parseInt(filaColumna.substring(0,1));
                            columna = Integer.parseInt(filaColumna.substring(1,2));
                            if (this.tablaClon[fila][columna] == 0){
                                verificador = true;
                            }else{
                                System.out.println("\u001B[31m"+"La casilla que desea sustituir, es una casilla PREDETERMINADA"+"\u001B[37m");
                            }
                        }
                    } else {
                        System.out.println("");
                        System.out.println("\u001B[31m"+"-----Solo debe indicar la fila y columna-----".toUpperCase()+"\u001B[36m");
                    }
            }
            verificadorFilaColumna = 0;
        } while (verificador == false);
        return filaColumna;
    }

    public int fila(String filaColumna) {
        String fila = filaColumna.substring(0, 1);
        this.filaDecidida = Integer.parseInt(fila);
        return this.filaDecidida;
    }

    public int columna(String filaColumna) {
        String columna = filaColumna.substring(1, 2);
        this.columnaDecidida = Integer.parseInt(columna);
        return this.columnaDecidida;
    }

    public String nuevoValorOSalida(Scanner lector) {
        boolean validador = false;
        String auxiliar = "";
        int numero = 0;
        do {
            try {
                System.out.println("Ingrese el valor que desea reemplazar en la casilla, Si quiere volver ATRAS, si desea salir SALIR");
                auxiliar = lector.nextLine();
                auxiliar = auxiliar.toUpperCase();
                auxiliar = auxiliar.trim();
                switch (auxiliar.toUpperCase()) {
                    case "SALIR":
                        validador = true;
                        break;
                    case "ATRAS":
                        validador = true;
                        break;
                    default:
                        numero = Integer.parseInt(auxiliar);
                        if (numero > 0 && numero <= 9) {
                            validador = true;
                        } else {
                            System.out.println("\u001B[31m"+"El numero ingresado debe ser entre 1-9"+"\u001B[36m");
                        }
                }
            }catch (Exception e){
                System.out.println("\u001B[31m"+"Debe ingresar un numero, o solamente las palabras SALIR o ATRAS"+"\u001B[36m");
            }
        } while (validador == false);
        return auxiliar;
    }

    public int nuevoValor(String numero){
        int newValor;
        newValor = Integer.parseInt(numero);
        return newValor;
    }

    public void imprimirTabla() {
        System.out.println("");
        System.out.println("\033[34m¡SUDOKU!\033[32m" + this.columnasNombres + "\033[37m");
        for (int filas = 0; filas < this.tablaRellenar[0].length; filas++) {
            if (filas == 3 || filas == 6) {
                System.out.println("        |───────|───────|───────|");
            }
            System.out.print("\033[33m" + "  " + this.filasNombres[filas] + "\033[37m" + "     |");
            for (int columnas = 0; columnas < this.tablaRellenar.length; columnas++) {
                if (columnas == 2 || columnas == 5 || columnas == 8) {
                    if (this.tablaClon[filas][columnas] != 0) {
                        System.out.print(" \033[34m" + this.tablaRellenar[filas][columnas] + "\033[37m |");
                    } else {
                        System.out.print(" " + this.tablaRellenar[filas][columnas] + " |");
                    }
                } else {
                    if (this.tablaClon[filas][columnas] != 0) {
                        System.out.print(" \033[34m" + this.tablaRellenar[filas][columnas] + "\033[37m");
                    } else {
                        System.out.print(" " + this.tablaRellenar[filas][columnas]);
                    }
                }
            }
            System.out.println();
        }
    }

    public void comparacion(int fila, int columna, int valor, boolean veri) {
        if (this.tablaClon[fila][columna] == 0) {
            if (veri == false) {
                this.tablaRellenar[fila][columna] = valor;
            }
        }
    }

    public boolean verificadorColumnaFilaRegion(int fila, int columna, int valor) {
        boolean estaEnColumnaFilaRegion = false;
        int filaMinima = 0;
        int filaMaxima = 0;
        int columnaMinima = 0;
        int columnaMaxima = 0;
        for (int i = 0; i < this.tablaRellenar[0].length; i++) {
            if (this.tablaRellenar[fila][i] == valor) {
                System.out.println("\u001B[31m"+"El valor ingresado ya esta en la fila " + this.filaColumnaLetras.substring(0,1)+"\u001B[36m");
                estaEnColumnaFilaRegion = true;
            }
        }
        for (int i = 0; i < this.tablaRellenar.length; i++) {
            if (this.tablaRellenar[i][columna] == valor) {
                System.out.println("\u001B[31m"+"El valor ingresado ya esta en la columan " + this.filaColumnaLetras.substring(1,2)+"\u001B[36m");
                estaEnColumnaFilaRegion = true;
            }
        }
        if (fila <= 2 && columna <= 2) {
            filaMinima = 0;
            filaMaxima = 2;
            columnaMinima = 0;
            columnaMaxima = 2;
        }
        if (fila <= 2 && (columna >= 3 && columna <= 5)) {
            filaMinima = 0;
            filaMaxima = 2;
            columnaMinima = 3;
            columnaMaxima = 5;
        }
        if (fila <= 2 && columna >= 6) {
            filaMinima = 0;
            filaMaxima = 2;
            columnaMinima = 6;
            columnaMaxima = 8;
        }
        if ((fila >= 3 && fila <= 5) && columna <= 2) {
            filaMinima = 3;
            filaMaxima = 5;
            columnaMinima = 0;
            columnaMaxima = 2;
        }
        if ((fila >= 3 && fila <= 5) && (columna >= 3 && columna <= 5)) {
            filaMinima = 3;
            filaMaxima = 5;
            columnaMinima = 3;
            columnaMaxima = 5;
        }
        if ((fila >= 3 && fila <= 5) && columna >= 6) {
            filaMinima = 3;
            filaMaxima = 5;
            columnaMinima = 6;
            columnaMaxima = 8;
        }
        if (fila >= 6 && columna <= 2) {
            filaMinima = 6;
            filaMaxima = 8;
            columnaMinima = 0;
            columnaMaxima = 2;
        }
        if (fila >= 6 && (columna >= 3 && columna <= 5)) {
            filaMinima = 6;
            filaMaxima = 8;
            columnaMinima = 3;
            columnaMaxima = 5;
        }
        if (fila >= 6 && columna >= 6) {
            filaMinima = 6;
            filaMaxima = 8;
            columnaMinima = 6;
            columnaMaxima = 8;
        }
        for (int x = filaMinima; x <= filaMaxima; x++) {
            for (int y = columnaMinima; y <= columnaMaxima; y++) {
                if (this.tablaRellenar[x][y] == valor) {
                    System.out.println("\u001B[31m"+"El valor ingresado ya esta en la sección"+"\u001B[36m");
                    estaEnColumnaFilaRegion = true;
                }
            }
        }
        return estaEnColumnaFilaRegion;
    }

    public String tablaCompletada (){
        String seCompleto = "";
        if (Arrays.deepEquals(tablaRellenar,tablaRespuestas)){
            seCompleto = "SALIR";
        }
        return seCompleto;
    }

    public void solucion () {
        System.out.println("");
        System.out.println("\033[34m¡SUDOKU!\033[32m" + this.columnasNombres + "\033[37m");
        for (int filas = 0; filas < this.tablaRespuestas[0].length; filas++) {
            if (filas == 3 || filas == 6) {
                System.out.println("        |───────|───────|───────|");
            }
            System.out.print("\033[33m" + "  " + this.filasNombres[filas] + "\033[37m" + "     |");
            for (int columnas = 0; columnas < this.tablaRespuestas.length; columnas++) {
                if (columnas == 2 || columnas == 5 || columnas == 8) {
                    if (this.tablaClon[filas][columnas] != 0) {
                        System.out.print(" \033[34m" + this.tablaRespuestas[filas][columnas] + "\033[37m |");
                    } else {
                        System.out.print(" " + this.tablaRespuestas[filas][columnas] + " |");
                    }
                } else {
                    if (this.tablaClon[filas][columnas] != 0) {
                        System.out.print(" \033[34m" + this.tablaRespuestas[filas][columnas] + "\033[37m");
                    } else {
                        System.out.print(" " + this.tablaRespuestas[filas][columnas]);
                    }
                }
            }
            System.out.println();
        }
    }
}
