import java.util.Scanner;

public class Matrices {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.println("Ingrese el número de filas (n):");
        int n = lector.nextInt();
        System.out.println("Ingrese el número de columnas (m):");
        int m = lector.nextInt();

        int[][] matrizA = leerMatriz(n, m, lector);
        int[][] matrizB = leerMatriz(n, m, lector);


            System.out.println("Elija una operación:");
            System.out.println("1. Verificar si las matrices son iguales.");
            System.out.println("2. Sumar dos matrices.");
            System.out.println("3. Generar una matriz de ceros.");
            System.out.println("4. Obtener el inverso aditivo de una matriz.");
            System.out.println("5. Restar dos matrices.");
            System.out.println("6. Multiplicar un escalar por una matriz.");
            System.out.println("7. Multiplicar dos matrices compatibles.");
            System.out.println("8. Obtener una matriz identidad de tamaño n.");
            System.out.println("9. Obtener la inversa de una matriz de tamaño n.");
            System.out.println("10. Obtener el determinante de una matriz de tamaño n.");
            System.out.println("11. Salir.");

            int opcion = lector.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Las matrices son iguales: " + sonIguales(matrizA, matrizB));
                    break;


                case 2:
                     int[][] suma = sumarMatrices(matrizA, matrizB);
                     System.out.println("La suma de A y B es:");
                     imprimirMatriz(suma);
                    break;


                case 3:
                     int[][] matrizCeros = generarMatrizCeros(n, m);
                     System.out.println("Matriz de ceros de " + n + "x" + m + ":");
                     imprimirMatriz(matrizCeros);
                    break;


                case 4:
                     int[][] inverso = inversoAditivo(matrizA);
                     System.out.println("El inverso aditivo de A es:");
                     imprimirMatriz(inverso);
                    break;


                case 5:
                     int[][] resta = restarMatrices(matrizA, matrizB);
                     System.out.println("La resta de A y B es:");
                     imprimirMatriz(resta);
                    break;


                case 6:
                     System.out.println("Ingrese un escalar para multiplicar por A:");
                     int escalar = lector.nextInt();
                     int[][] escalarPorA = multiplicarPorEscalar(escalar, matrizA);
                     System.out.println("El resultado de multiplicar " + escalar + " por A es:");
                     imprimirMatriz(escalarPorA);
                    break;


                case 7:
                     int[][] producto = multiplicarMatrices(matrizA, matrizB);
                     System.out.println("El producto de A y B es:");
                     imprimirMatriz(producto);
                    break;


                case 8:
                     int[][] identidad = matrizIdentidad(n);
                     System.out.println("Matriz identidad de " + n + "x" + n + ":");
                     imprimirMatriz(identidad);
                    break;


                case 9:
                     int[][] inversa = matrizInversa(matrizA);
                     System.out.println("La inversa de A es:");
                     imprimirMatriz(inversa);
                    break;


                case 10:
                     double determinanteA = determinante(matrizA);
                     System.out.println("El determinante de A es: " + determinanteA);
                    break;


                case 11:
                     System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo.");     
        }

        lector.close();
    }

    public static int[][] leerMatriz(int n, int m, Scanner scanner) {
        int[][] matriz = new int[n][m];
        System.out.println("Ingrese los elementos de la matriz:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matriz[i][j] = scanner.nextInt();
            }
        }

        return matriz;
    }

    public static boolean sonIguales(int[][] matrizA, int[][] matrizB) {
        if (matrizA.length != matrizB.length || matrizA[0].length != matrizB[0].length) {
            return false;
        }

        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizA[0].length; j++) {
                if (matrizA[i][j] != matrizB[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static int[][] sumarMatrices(int[][] matrizA, int[][] matrizB) {
        int n = matrizA.length;
        int m = matrizA[0].length;
        int[][] resultado = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                resultado[i][j] = matrizA[i][j] + matrizB[i][j];
            }
        }

        return resultado;
    }

    public static int[][] generarMatrizCeros(int n, int m) {
        return new int[n][m];
    }

    public static int[][] inversoAditivo(int[][] matriz) {
        int n = matriz.length;
        int m = matriz[0].length;
        int[][] resultado = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                resultado[i][j] = -matriz[i][j];
            }
        }

        return resultado;
    }

    public static int[][] restarMatrices(int[][] matrizA, int[][] matrizB) {
        return sumarMatrices(matrizA, inversoAditivo(matrizB));
    }

    public static int[][] multiplicarPorEscalar(int escalar, int[][] matriz) {
        int n = matriz.length;
        int m = matriz[0].length;
        int[][] resultado = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                resultado[i][j] = escalar * matriz[i][j];
            }
        }

        return resultado;
    }

    public static int[][] multiplicarMatrices(int[][] matrizA, int[][] matrizB) {
        int n = matrizA.length;
        int m = matrizA[0].length;
        int p = matrizB[0].length;
        int[][] resultado = new int[n][p];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < m; k++) {
                    resultado[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }

        return resultado;
    }

    public static int[][] matrizIdentidad(int n) {
        int[][] identidad = new int[n][n];
        for (int i = 0; i < n; i++) {
            identidad[i][i] = 1;
        }
        return identidad;
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int elemento : fila) {
                System.out.print(elemento + " ");
            }
            System.out.println();
        }
    }

    public static int[][] matrizInversa(int[][] matriz) {
        int n = matriz.length;
        int[][] adjunta = new int[n][n];
    
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
           
                int[][] submatriz = obtenerSubmatriz(matriz, i, j);
                int signo = (i + j) % 2 == 0 ? 1 : -1;
                adjunta[j][i] = signo * (int) determinante(submatriz);
            }
        }
    
        int det = (int) determinante(matriz);
    
        if (det == 0) {
            System.out.println("La matriz no tiene inversa.");
        }
    
        
        int[][] inversa = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inversa[i][j] = adjunta[i][j] / det;
            }
        }
    
        return inversa;
    }
    
    public static int[][] obtenerSubmatriz(int[][] matriz, int fila, int columna) {
        int n = matriz.length;
        int[][] submatriz = new int[n - 1][n - 1];
        int filaDestino = 0;
        int columnaDestino = 0;
    
        for (int i = 0; i < n; i++) {
            if (i != fila) {
                columnaDestino = 0;
                for (int j = 0; j < n; j++) {
                    if (j != columna) {
                        submatriz[filaDestino][columnaDestino] = matriz[i][j];
                        columnaDestino++;
                    }
                }
                filaDestino++;
            }
        }
    
        return submatriz;
    }

    public static double determinante(int[][] matriz) {
        int n = matriz.length;
        double det = 1;
    
        int[][] copia = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(matriz[i], 0, copia[i], 0, n);
        }
    
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double factor = copia[j][i] / (double) copia[i][i];
                for (int k = i; k < n; k++) {
                    copia[j][k] -= factor * copia[i][k];
                }
            }
            det *= copia[i][i];
        }
    
        return det;
    }  
}