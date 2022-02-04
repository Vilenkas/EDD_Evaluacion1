
package edd_evaluacion1;

import java.util.Scanner;

/**
 * @author Gabriel Villegas
 * @version 04/02/2022
 */
public class EDD_Evaluacion1 {

    /**|
     * @param args Argumentos en línea de consola
     */
    public static void main(String[] args) {
        System.out.println("***** Menu Evaluacion 1 EDD *****");
        int selec = -1;
        do {
            System.out.println("");
            System.out.println("1 >> Ir a Primera Funcion.");
            System.out.println("2 >> Ir a Segunda Funcion.");
            System.out.println("3 >> Ir a Tercera Funcion.");
            System.out.println("4 >> Ir a Cuarta Funcion.");
            System.out.println("");
            System.out.println("0 >> Para Salir.");
            System.out.println("");
            
            selec = ingresarNumero("Seleccione una opcion: ");
            
            switch (selec) {
                case 1: primeraFuncion();
                break;
                case 2: segundaFuncion();
                break;
                case 3:
                break;
                case 4:
                break;
                case 0:
                break;
                default:
                    System.out.println("");
                    System.out.println("- La opcion seleccion es invalida.");
            }
        } while (selec != 0);
    }
    
    private static int ingresarNumero(String texto){
        int selec = 0;
        boolean bandera = true;
        Scanner entrada = new Scanner(System.in);
        while (bandera == true){
            try {
                System.out.print(texto);
                selec = Integer.parseInt(entrada.nextLine());
                bandera = false;
            } catch(NumberFormatException e){
                System.out.println("");
                System.out.println("- El dato a ingresar debe de ser un numero.");
                System.out.println("");
                bandera = true;
            }
        }
        return selec;
    }

    private static void primeraFuncion() {
        
        System.out.println("");
        System.out.println("*** La siguiente funcion realiza la siguiente operacion (M_1 + M_2) * M_3 ***");
        
        int orden = 0;
        
        System.out.println("");
        orden = ingresarNumero("Ingrese el orden de las matrices cuadradas: ");
        
        int[][] M_1 = new int[orden][orden];
        int[][] M_2 = new int[orden][orden];
        int[][] M_3 = new int[orden][orden];
        int[][] M_RESULTADO = new int[orden][orden];
        
        int[][] M_SUMA = new int[orden][orden];
        
        System.out.println("");
        System.out.println("*** Ingrese los "+(orden*orden)+" elementos de la matriz M_1 ***");
        System.out.println("");
        
        for (int i = 0; i < orden; i++) {
            for (int j = 0; j < orden; j++) {
                M_1[i][j] = ingresarNumero("Ingrese el elemento cuyas coordenadas son ["+(i+1)+"]["+(j+1)+"]: ");
            }
        }
        
        System.out.println("");
        System.out.println("*** Ingrese los "+(orden*orden)+" elementos de la matriz M_2 ***");
        System.out.println("");
        
        for (int i = 0; i < orden; i++) {
            for (int j = 0; j < orden; j++) {
                M_2[i][j] = ingresarNumero("Ingrese el elemento cuyas coordenadas son ["+(i+1)+"]["+(j+1)+"]: ");
            }
        }
        
        System.out.println("");
        System.out.println("*** El resultado de la suma matricial de M_1 + M_2 es la siguiente matriz ***");
        System.out.println("");
        
        for (int i = 0; i < orden; i++) {
            for (int j = 0; j < orden; j++) {
                M_SUMA[i][j] = M_1[i][j] + M_2[i][j];
            }
        }
        
        for (int i = 0; i < orden; i++) {
            System.out.print("[ ");
            for (int j = 0; j < orden; j++) {
                System.out.print(M_SUMA[i][j]+" ");
            }
            System.out.println("]");
        }
        
        System.out.println("");
        System.out.println("*** Ingrese los "+(orden*orden)+" elementos de la matriz M_3 ***");
        System.out.println("");
        
        for (int i = 0; i < orden; i++) {
            for (int j = 0; j < orden; j++) {
                M_3[i][j] = ingresarNumero("Ingrese el elemento cuyas coordenadas son ["+(i+1)+"]["+(j+1)+"]: ");
            }
        }
        
        System.out.println("");
        System.out.println("*** El resultado de la multiplicacion matricial de (M_1 + M_2) * M_3 es la siguiente matriz ***");
        System.out.println("");
        
        int[] f_aux, c_aux;
        f_aux = new int[orden];
        c_aux = new int[orden];
        
        for (int i = 0; i < orden; i++) {
            for (int j = 0; j < orden; j++) {
                for (int k = 0; k < orden; k++) {
                    f_aux[k] = M_SUMA[i][k];
                }
                for (int k = 0; k < orden; k++) {
                    c_aux[k] = M_3[k][j];
                }
                for (int k = 0; k < orden; k++) {
                    M_RESULTADO[i][j] += f_aux[k] * c_aux[k];
                }
            }
        }
        
        for (int i = 0; i < orden; i++) {
            System.out.print("[ ");
            for (int j = 0; j < orden; j++) {
                System.out.print(M_RESULTADO[i][j]+" ");
            }
            System.out.println("]");
        }
    }

    private static void segundaFuncion() {
        System.out.println("");
        System.out.println("*** La siguiente matriz se rellenara segun el polinomio (23X^4)+(20Y^3)-3 ***");
        
        System.out.println("");
        int X = ingresarNumero("Ingrese el numero de filas de la matriz: ");
        int Y = ingresarNumero("Ingrese el numero de columnas de la matriz: ");
        System.out.println("");
        
        int[][] Matriz = new int[X][Y];
        
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                Matriz[i][j] = ((23*(i*i*i*i))+(20*(j*j*j))-3);
            }
        }
        
        for (int i = 0; i < X; i++) {
            System.out.print("[ ");
            for (int j = 0; j < Y; j++) {
                System.out.print(Matriz[i][j]+" ");
            }
            System.out.println("]");
        }
    }
    
}
