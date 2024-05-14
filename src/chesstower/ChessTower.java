package chesstower;

import java.util.InputMismatchException;
import java.util.Scanner;

//Falta agregar lo de la posicion aleatoria



/*
Having an 8x8 char array simulate the move of a chess tower.
You must show where it is at all times
The initial position will be random.
My advice is to use a menu
*/

public class ChessTower {

   public static void main(String[] args) {
      final char VACIO= 'X';
        final char TORRE = 'O';

        char [][] matriz= new char [8][8];
    
        rellenarMatriz(matriz, VACIO);
        
        int posActualTORREX = 0, posAntiguaTORREX = 0;
        int posActualTORREY = 0, posAntiguaTORREY = 0;
        
        matriz[posActualTORREX][posActualTORREY]= TORRE;

        Scanner sc = new Scanner (System.in);
        boolean salir = false;
        int opcion; //Guardamos la opcion del usuario
    
        /*
            00 01 02
            10 11 12
            20 21 22
        */
        while (!salir){
            
            mostrarMatriz(matriz);
            
            System.out.println("¿Dónde quires moverte?");
            System.out.println("1. Mover arriba");
            System.out.println("2. Mover derecha");
            System.out.println("3. Mover abajo");
            System.out.println("4. Mover izquierda");
            System.out.println("5. Salir");
            
    
            try {
                System.out.println("Escribe una de las opciones");
                opcion = sc.nextInt();

                posAntiguaTORREX = posActualTORREX;
                posAntiguaTORREY = posActualTORREY;

                switch (opcion) {
                    case 1:
                        posActualTORREX--;
                        posActualTORREY= 0;
                        break;

                    case 2:
                        posActualTORREX= 0;
                        posActualTORREY++;
                        break;

                    case 3:
                        posActualTORREX= 0;
                        posActualTORREY++;
                        break;

                    case 4:
                        posActualTORREX= 0;
                        posActualTORREY--;
                        break;

                    case 5:
                        posActualTORREX++;
                        break;
                        
                    default:
                        System.out.println("Solo numeros entre 1 y 9");
                }
                if (estaLimiteMatriz (matriz.length, matriz[0].length, 
                        posActualTORREX, posActualTORREY)){
                 
                matriz[posAntiguaTORREX][posAntiguaTORREY]= VACIO;
                matriz[posActualTORREX][posActualTORREY]= TORRE;
                
                   
                }else{
                    System.out.println("Te sales del tablero");
                    posActualTORREX = posAntiguaTORREX;
                    posActualTORREY = posAntiguaTORREY;
                }
                
            }catch (InputMismatchException e) {
                System.out.println("Debes insertar un numero");
                sc.next();
            }
        }
    }
    public static void mostrarMatriz(char[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
        }
    }
    public static void rellenarMatriz(char[][] matriz, char simbolo){
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
                    matriz[i][j] = 'X';
                }
            }
    } 
    
    public static boolean estaLimiteMatriz(int longitudFilas, 
            int longitudColumnas, int x, int y) {
    
        return x>= 0 && x< longitudFilas && y>=0 && y <longitudColumnas;
        //Acá 0 es la primera columna del array
    }
    public static int generateRandomNumber(int minimo, int maximo) {
        return (int) ((Math.random() * (maximo - minimo + 1)) + (minimo));
    }

}