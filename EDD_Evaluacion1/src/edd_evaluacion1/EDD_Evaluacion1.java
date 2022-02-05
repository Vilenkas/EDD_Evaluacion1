
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
        
        //Ciclo do-while para iterar constantemente el menú hasta que se ingrese un cero (0).
        do {
            System.out.println("");
            System.out.println("1 >> Ir a Primera Funcion.");
            System.out.println("2 >> Ir a Segunda Funcion.");
            System.out.println("3 >> Ir a Tercera Funcion.");
            System.out.println("4 >> Ir a Cuarta Funcion.");
            System.out.println("");
            System.out.println("0 >> Para Salir.");
            System.out.println("");
            
            //Variable que actua como selector del programa.
            selec = ingresarNumero("Seleccione una opcion: ");
            
            //Estructura switch para llamar a la funcion correspondiente.
            switch (selec) {
                case 1: primeraFuncion();
                break;
                case 2: segundaFuncion();
                break;
                case 3: terceraFuncion();
                break;
                case 4: cuartaFuncion();
                break;
                case 0:
                break;
                default:
                    System.out.println("");
                    System.out.println("- La opcion seleccion es invalida.");
            }
        } while (selec != 0); //Condición del do-while para que pueda seguir iterando.
    }
    
    /**|
     * Esta función se asegura de tomar números desde consola, para así evitar tener errores durante la ejecución del programa. 
     * @param texto Es la cadena de texto que se mostrará en consola cuando se requiera ingresar un número
     * @return selec Retorna el numero entero ingresado desde consola. 
     */
    private static int ingresarNumero(String texto){
        
        int selec = 0;
        boolean bandera = true;
        Scanner entrada = new Scanner(System.in);
        
        //Ciclo que no deja de iterar hasta que se ingrese correctamente un número entero.
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
        return selec; //Retorno del número ingresado correctamente.
    }

    private static void primeraFuncion() {
        
        System.out.println("");
        System.out.println("*** La siguiente funcion realiza la siguiente operacion (M_1 + M_2) * M_3 ***");
        
        //Se pide ingresar el orden las matrices que seran utilizadas para las operaciones.
        System.out.println("");
        int orden = ingresarNumero("Ingrese el orden de las matrices cuadradas: ");
        
        //Declaración de matrices (arreglos bidimensionales) de igual número de filas que columnas (matrices cuadradas).
        int[][] M_1 = new int[orden][orden];
        int[][] M_2 = new int[orden][orden];
        int[][] M_3 = new int[orden][orden];
        int[][] M_RESULTADO = new int[orden][orden];
        
        //Matriz extra para alojar la suma entre las matrices M_1 y M_2
        int[][] M_SUMA = new int[orden][orden];
        
        System.out.println("");
        System.out.println("*** Ingrese los "+(orden*orden)+" elementos de la matriz M_1 ***");
        System.out.println("");
        
        //Ciclo para ingresar números a los elementos de la matriz M_1
        for (int i = 0; i < orden; i++) {
            for (int j = 0; j < orden; j++) {
                M_1[i][j] = ingresarNumero("Ingrese el elemento cuyas coordenadas son ["+(i+1)+"]["+(j+1)+"]: ");
            }
        }
        
        System.out.println("");
        System.out.println("*** Ingrese los "+(orden*orden)+" elementos de la matriz M_2 ***");
        System.out.println("");
        
        //Ciclo para ingresar números a los elementos de la matriz M_2
        for (int i = 0; i < orden; i++) {
            for (int j = 0; j < orden; j++) {
                M_2[i][j] = ingresarNumero("Ingrese el elemento cuyas coordenadas son ["+(i+1)+"]["+(j+1)+"]: ");
            }
        }
        
        System.out.println("");
        System.out.println("*** El resultado de la suma matricial de M_1 + M_2 es la siguiente matriz ***");
        System.out.println("");
        
        //Ciclo que suma cada elemento de la matriz M_1 con su igual en coordenadas de la matriz M_2
        for (int i = 0; i < orden; i++) {
            for (int j = 0; j < orden; j++) {
                M_SUMA[i][j] = M_1[i][j] + M_2[i][j];
            }
        }
        
        //Mostrar la suma entre las matrices M_1 y M_2
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
        
        //Ciclo para ingresar números a los elementos de la matriz M_3
        for (int i = 0; i < orden; i++) {
            for (int j = 0; j < orden; j++) {
                M_3[i][j] = ingresarNumero("Ingrese el elemento cuyas coordenadas son ["+(i+1)+"]["+(j+1)+"]: ");
            }
        }
        
        System.out.println("");
        System.out.println("*** El resultado de la multiplicacion matricial de (M_1 + M_2) * M_3 es la siguiente matriz ***");
        System.out.println("");
        
        //Arreglos auxiliares de fila y columna para facilitar la multiplicación entre matrices.
        int[] f_aux, c_aux;
        
        //Ambos arreglos son de igual longitud que las filas y columnas de las matrices respectivamente.
        f_aux = new int[orden];
        c_aux = new int[orden];
        
        //Ciclo que multiplica la matriz M_SUMA por la matriz M_3.
        for (int i = 0; i < orden; i++) {
            for (int j = 0; j < orden; j++) {
                for (int k = 0; k < orden; k++) {
                    //Se pasa cada elemento de la fila "i" de la matriz M_SUMA a el arreglo auxiliar f_aux. 
                    f_aux[k] = M_SUMA[i][k];
                }
                for (int k = 0; k < orden; k++) {
                    //Se pasa cada elemento de la columna "j" de la matriz M_3 a el arreglo auxiliar c_aux. 
                    c_aux[k] = M_3[k][j];
                }
                for (int k = 0; k < orden; k++) {
                    //El resultado final de el elemento en M_RESULTADO[i][j] es igual a 
                    //la suma de los productos de elementos de los arreglos auxiliares f_aux y c_aux.
                    M_RESULTADO[i][j] += f_aux[k] * c_aux[k];
                }
            }
        }
        
        //Mostrar el resultado de la operacion (M_1 + M_2) * M_3.
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
        
        //Se inicializa una matriz cuyo número de filas y columnas es X e Y respectivamente.
        int[][] Matriz = new int[X][Y];
        
        //Ciclo que asigna a cada elemento de la Matriz el resultado del polinomio (23x^4)+(20y^3)-3
        //en donde X es la primera coordenada del elemento
        //y en donde Y es la segunda coordenada del elemento de la Matriz.
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                Matriz[i][j] = ((23*(i*i*i*i))+(20*(j*j*j))-3);
            }
        }
        
        //Mostrar resultado de la Matriz.
        for (int i = 0; i < X; i++) {
            System.out.print("[ ");
            for (int j = 0; j < Y; j++) {
                System.out.print(Matriz[i][j]+" ");
            }
            System.out.println("]");
        }
    }

    private static void terceraFuncion() {
        
        System.out.println("");
        System.out.println("*** Esta funcion determina si una matriz cuadrada es una matriz identidad ***");
        
        //Booleano para determinar si la matriz es o no, una Matriz Identidad.
        boolean EsIdentidad = true;
        //Variable auxiliar para evaluar los elementos que pertenecen a la diagonal principal.
        int aux = 0;
        
        System.out.println("");
        int orden = ingresarNumero("Ingrese el orden de la matriz cuadrada: ");
        
        //Inicializa una matriz cuadrada.
        int[][] Matriz = new int[orden][orden];
        
        System.out.println("");
        System.out.println("*** Ingrese los "+(orden*orden)+" elementos de la matriz ***");
        System.out.println("");
        
        //Ingresa números a los elementos de la Matriz.
        for (int i = 0; i < orden; i++) {
            for (int j = 0; j < orden; j++) {
                Matriz[i][j] = ingresarNumero("Ingrese el elemento cuyas coordenadas son ["+(i+1)+"]["+(j+1)+"]: ");
            }
        }
        
        System.out.println("");
        System.out.println("*** Usted ingreso la siguiente matriz ***");
        System.out.println("");
        
        //Mostrar los elementos de la Matriz.
        for (int i = 0; i < orden; i++) {
            System.out.print("[ ");
            for (int j = 0; j < orden; j++) {
                System.out.print(Matriz[i][j]+" ");
            }
            System.out.println("]");
        }
        
        for (int i = 0; i < orden; i++) {
            for (int j = 0; j < orden; j++) {
                if (j == aux){ //Si se está evaluando la diagonal principal.
                    if (Matriz[i][j] != 1) EsIdentidad = false; //De no haber un uno (1) en dicha posición, significará que NO es una matriz identidad.
                } else { //Sino se está evaluando la diagonal principal.
                    if (Matriz[i][j] != 0) EsIdentidad = false; //De no haber un cero (o) en dicha posición, significará que NO es una matriz identidad.
                }
            }
            //Incrementar la variable auxiliar para evaluar el siguiente eleemento de la diagonal principal.
            aux++;
        }
        
        System.out.println("");
        if (EsIdentidad == true){ 
            //Si despúes de todas las comprobaciones anteriores, el booleano EsIdentidad aún es igual a true
            //entonces la matriz, si es una matriz identidad.
            System.out.println("--- La matriz ingresada es una matriz identidad.");
        } else {
            //En caso contrario no.
            System.out.println("--- La matriz ingresada NO es una matriz identidad.");
        }
        
    }

    private static void cuartaFuncion() {
        
        System.out.println("");
        System.out.println("*** Esta funcion determina si una matriz cuadrada es una matriz triangular superior ***");
        
        //Booleanos para determinar si es una matriz triangular superior, y una booleano auxiliar.
        boolean EsTriangularSuperior = true, bool_aux = false;
        //Una variable entera auxiliar.
        int int_aux = 0;
        
        System.out.println("");
        int orden = ingresarNumero("Ingrese el orden de la matriz cuadrada: ");
        
        //Inicializar una matriz cuadrada.
        int[][] Matriz = new int[orden][orden];
        
        System.out.println("");
        System.out.println("*** Ingrese los "+(orden*orden)+" elementos de la matriz ***");
        System.out.println("");
        
        //Ingresar números a los elementos de la matriz.
        for (int i = 0; i < orden; i++) {
            for (int j = 0; j < orden; j++) {
                Matriz[i][j] = ingresarNumero("Ingrese el elemento cuyas coordenadas son ["+(i+1)+"]["+(j+1)+"]: ");
            }
        }
        
        System.out.println("");
        System.out.println("*** Usted ingreso la siguiente matriz ***");
        System.out.println("");
        
        //Mostrar los elementos de la Matriz.
        for (int i = 0; i < orden; i++) {
            System.out.print("[ ");
            for (int j = 0; j < orden; j++) {
                System.out.print(Matriz[i][j]+" ");
            }
            System.out.println("]");
        }
        
        for (int i = 0; i < orden; i++) {
            for (int j = 0; j < orden; j++) {
                if (j == int_aux || bool_aux == true){ //Si se esta en la diagonal principal, o por encima de la misma.
                    //Si el número de dicho elemento es cero (0), entonces no es una matriz triangular superior.
                    if (Matriz[i][j] == 0) EsTriangularSuperior = false;
                    //Se establece bool_aux como true puesto que apartir de ahora se estará por encima de la diagonal superior.
                    bool_aux = true;
                } else if(Matriz[i][j] != 0){ //Sino se esta en la diagonal principal, o por encima de la misma.
                    EsTriangularSuperior = false; //Si el número de dicho elemento NO es cero (0), entonces no es una matriz triangular superior.
                }
            }
            //Se incrementa int_aux para poder evaluar los elementos pertenecientes a la diagonal principal.
            int_aux++;
            //Se establece el bool_aux como false puesto que ya no se estará por encima de la diagonal superior.
            bool_aux = false;
        }
        
        System.out.println("");
        if (EsTriangularSuperior == true){
            //Si despúes de todas las comprobaciones anteriores, el booleano EsTriangularSuperior aún es igual a true
            //entonces la matriz, si es una matriz triangular superior.
            System.out.println("--- La matriz ingresada es una matriz triangular superior.");
        } else {
            //Caso contrario no.
            System.out.println("--- La matriz ingresada NO es una matriz triangular superior.");
        }
    }

    
    
}
