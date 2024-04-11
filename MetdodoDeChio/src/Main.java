// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    int[][] matriz = new int[6][6];
    int[][] matrizAbjunto = new int[6][6];

    public int[][] MatrizAbjunto() {
        for (int col = 1; col <= 4; col++) {
            for (int fil = 1; fil <= 4; fil++) {
                // Si la fila es par, asigna 0, de lo contrario, asigna 1
                if (fil % 2 == 0) {
                    matrizAbjunto[fil][col] = 0;
                } else {
                    matrizAbjunto[fil][col] = 1;
                }
            }
        }
        return matrizAbjunto;
    }

    public int[][] llenarmatriz() {
        matriz[1][1] = 2;
        matriz[1][2] = 0;
        matriz[1][3] = 2;
        matriz[1][4] = 4;

        matriz[2][1] = 3;
        matriz[2][2] = 3;
        matriz[2][3] = 1;
        matriz[2][4] = 2;

        matriz[3][1] = 0;
        matriz[3][2] = 1;
        matriz[3][3] = 3;
        matriz[3][4] = 1;

        matriz[4][1] = 4;
        matriz[4][2] = 1;
        matriz[4][3] = 7;
        matriz[4][4] = 1;

        return matriz;
    }
    public int[][] llenarmatriz2() {
        matriz[1][1] = 3;
        matriz[1][2] = 1;
        matriz[1][3] = 3;
        matriz[1][4] = 0;

        matriz[2][1] = 1;
        matriz[2][2] = 2;
        matriz[2][3] = 3;
        matriz[2][4] = 4;

        matriz[3][1] = 2;
        matriz[3][2] = 1;
        matriz[3][3] = 3;
        matriz[3][4] = -1;

        matriz[4][1] = 1;
        matriz[4][2] = 1;
        matriz[4][3] = 0;
        matriz[4][4] = 1;

        return matriz;
    }
    public int[][] llenarmatriz3() {
        matriz[1][1] = -1;
        matriz[1][2] = 2;
        matriz[1][3] = 0;
        matriz[1][4] = 3;

        matriz[2][1] = 2;
        matriz[2][2] = 1;
        matriz[2][3] = 3;
        matriz[2][4] = -2;

        matriz[3][1] = 5;
        matriz[3][2] = -1;
        matriz[3][3] = 1;
        matriz[3][4] = 2;

        matriz[4][1] = 1;
        matriz[4][2] = 3;
        matriz[4][3] = 2;
        matriz[4][4] = 4;

        return matriz;
    }
    public int identificarColumnaPV(int [][]matriz){
       /* Main matriz=new Main();
        int [][]matrix= matriz.llenarmatriz3();*/
        int contO=0,menorElemen=0,maxO=0,colPV=0;

        for (int c=1;c<=4;c++){
            for (int f=1;f<=4;f++){
                if (matriz [f][c] == 1){
                    //Analizamos los datos
                    for (int a =1;a<=4;a++){
                        if (matriz[a][c]==0){contO++;} else if (contO>0) {} else if (matriz[a][c]>menorElemen && matriz[a][c] >=2 ) {
                            menorElemen = matriz[a][c];
                        }
                    }
                    if(contO>maxO){
                        maxO=contO;
                        colPV=c;
                    }
                }
            }
        }



        return colPV;
    }//lanza la columna pv
    public int identificaFilaPV(int [][]matriz){
        Main matrix=new Main();
        /*int [][]matriz= matrix.llenarmatriz3();*/
        int a = matrix.identificarColumnaPV(matriz);//me manda el result de la columna pv
        int fila=0;
        for (int i=1;i<=4;i++){
            if (matriz[i][a]==1){
                fila=i;
                break;
            }
        }
        return fila;
    }//lanza la fila pv
    public int identificarNumerosNoNulos(int [][] matriz) {
        Main matrix = new Main();
        //int[][] matriz = matrix.llenarmatriz3();*/
        int col = matrix.identificarColumnaPV(matriz);//identificamos a la columna par buscar valores no nulos osea >0
        int fila = matrix.identificaFilaPV(matriz);

        int noNuloFl = 0;
        for (int i = 1; i <= 4; i++) {
            if (matriz[i][col] != 0 ) {
                if (matriz[i][col] == matriz[fila][col]){

                }
                else {
                    noNuloFl = i;
                    break; // Terminar el bucle si se encuentra un elemento no nulo
                }
            }
        }
        return noNuloFl;//retornamos la fila que contiene un numero mayor a 0
    }//retornamos la fila que contiene un numero mayor a 0

    public int[][] EliminarElemNoNulo(int [][] matriz) {
        Main matrix = new Main();
        //int[][] matrix = matriz.llenarmatriz3();
        int col = matrix.identificarColumnaPV(matriz);//obtenemos la corrdenada pv
        int fil = matrix.identificaFilaPV(matriz);//obtenemos la coordenada pv
        int Elem = matriz[fil][col];
        int c = matrix.identificarNumerosNoNulos(matriz);


        int a=matriz[c][col];
        System.out.println(a);
        for (int i = 1; i <= 4; i++) {
            matriz[c][i] = matriz[c][i] - a * matriz[fil][i];

        }

        return matriz;
    }

    public static void main(String[] args) {
        Main matriz=new Main();
        String[][] matricAbjunto = new String[5][5]; // Declara una nueva matriz para almacenar los valores

        for (int fila = 1; fila <= 4; fila++) {
            for (int columna = 1; columna <= 4; columna++) {
                if ((fila + columna) % 2 == 0) {
                    matricAbjunto[fila][columna] = "+"; // Asigna "1" si la suma es par
                } else {
                    matricAbjunto[fila][columna] = "-"; // Asigna "0" si la suma es impar
                }
            }
        }


// Ahora puedes imprimir la matriz si lo deseas
        for (int fila = 1; fila <= 4; fila++) {
            for (int columna = 1; columna <= 4; columna++) {
                System.out.print(matricAbjunto[fila][columna] + " ");
            }
            System.out.println(); // Agregamos un salto de línea después de imprimir cada fila
        }

        int[][] nuevaMatriz = new int[5][5];
        int [][]matrix= matriz.llenarmatriz2();
       int a= matriz.identificarColumnaPV(matrix);
       int b= matriz.identificaFilaPV(matrix);
        System.out.println("PARA LA REGLA DE ABJUNTOS EL PV SERA DE TIPO "+matricAbjunto[b][a]);
       int c= matriz.identificarNumerosNoNulos(matrix);//obtenemos la fila


        System.out.println("la columan pv es:"+a);
        System.out.println("la fila pv es: "+b);
        System.out.println("Elemento pv "+matrix[b][a]);
        System.out.println("En la fila "+c+" se encontro un valor");

        nuevaMatriz= matriz.EliminarElemNoNulo(matrix);

        for (int fila = 1; fila <= 4; fila++) {
            for (int columna = 1; columna <= 4; columna++) {
                System.out.print(nuevaMatriz[fila][columna] + " ");
            }
            System.out.println(); // Agregamos un salto de línea después de imprimir cada fila
        }//muesta la matriz

        do {

            c= matriz.identificarNumerosNoNulos(nuevaMatriz);
            System.out.println("En la fila "+c+" se encontro un valor");

            if (c==0){
            System.out.println("la matriz esta lista para aplicar la regla de los abjuntos");
            }else {
                System.out.println("Elemnto no nulo es de valor ="+matrix[c][a]);
            nuevaMatriz=matriz.EliminarElemNoNulo(nuevaMatriz);
                System.out.println("verifica si se cambio la matriz desde main");
                for (int fila = 1; fila <= 4; fila++) {
                    for (int columna = 1; columna <= 4; columna++) {
                        System.out.print(nuevaMatriz[fila][columna] + " ");
                    }
                    System.out.println(); // Agregamos un salto de línea después de imprimir cada fila
                }//muesta la matriz
            }
        }while (c==0);
        System.out.println("la matriz esta lista para aplicar la regla de los abjuntos");


    }

}