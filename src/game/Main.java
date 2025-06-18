package game;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	
	static Scanner scanner = new Scanner(System.in);
	
	
	private static int verifyInt() {
		// Verifica que se escriban solo números enteros.
	    while (true) {
	        try {
	            int n = scanner.nextInt();
	            if (n < 1 || n > 100) {
	                System.out.println("Ingresa un número entre 1 y 100:");
	            } else {
	                return n;
	            }
	        } catch (InputMismatchException e) {
	            System.out.println("Solo se pueden ingresar números enteros.");
	            scanner.next();
	            System.out.println("Ingrese un número entero: ");
	        }
	    }
	}

	
	static boolean askPlayAgain() {
		boolean asking = true;
		do {
			System.out.print("¿Jugar de nuevo? Escribir 'si' o 'no': ");
		    scanner.nextLine();
		    String option = scanner.nextLine().toLowerCase();

		    if (option.equals("si")) {
		    	System.out.println("___________________________________");
		    	System.out.println("");
		    	return true;
		    }
		    else if (option.equals("no")) {
		    	return false;
		    }
		    
		    else System.out.print("Por favor escribe 'si' o 'no'");
		} while(asking);
	    return false;
	} 
	
	
	public static void main(String[] args) {
        System.out.println("~~~ Adivina un número del 1 al 100 ~~~");

        do {
        	// Mientras KeepPlaying sea verdadero, el programa seguirá el loop.
        	int lives = 0; // Vidas del jugador
        	
        	boolean selectingDiff = true;
        	do { // Para seleccionar cantidad de intentos.
            	System.out.print("Elige la dificultad. 1 = 7 vidas. 2 = 6 vidas. 3 = 5 vidas. Escribe 1, 2 o 3:  ");
            	int diff = verifyInt();
            	if (diff == 1) {
            		lives = 7;
            		selectingDiff = false;
            	}
            	else if (diff == 2) {
            		lives = 6;
            		selectingDiff = false;
            	} 
            	else if (diff == 3) {
            		lives = 5;
            		selectingDiff = false;
            	} else System.out.println("Por favor escribe 1, 2 o 3.");
            	
        	} while (selectingDiff);
        	
        	
        	
            Random random = new Random(); // Objeto "random".
            int randomNum = random.nextInt(100) + 1; // Se genera un entero del 0 al 100. Agrego +1 para abarcar números del 1 al 100, en vez de 0 al 100.
//          System.out.println(randomNum); Para debuggear.

            boolean guessed = false;
            do {
            	System.out.print("Escribe un número del 1 al 100: ");
                int userGuess = verifyInt();

                if (userGuess < randomNum) {
                    System.out.println("EL número es más alto...");
                    lives--; // para quitar vida al jugador.
                } else if (userGuess > randomNum) {
                    System.out.println("El número es más bajo...");
                    lives--;
                } else {
                    System.out.println("¡Ganaste!");
                    guessed = true;
                }
                
                if (!guessed) {
                    System.out.println("Intentos restantes: " + lives);
                }
            } while (lives > 0 && !guessed);
                
            
            
            if (!guessed) {
                System.out.println("No te quedan más intentos. El número era " + randomNum + ".");
            }
            
        } while (askPlayAgain()); // Se pregunta si se quiere jugar de nuevo. Si askPlayAgain() devuelve true, se reinicia el juego. Si devuelve false se termina la app.
    }
}



