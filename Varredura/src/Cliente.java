import java.io.*;
import java.net.*;

public class Cliente {
	public static void main(String args[]) throws Exception {
 
		BufferedReader entTeclado = new BufferedReader(new InputStreamReader(System.in));
 
		
		
		System.out.println("Digite o ip a ser verificado: ");

		String servidor = entTeclado.readLine();
 
		for(int porta = 1 ; porta <= 1026; porta++) {
			try {
				Socket s = new Socket(servidor, porta);
				System.out.println("Porta " + porta + " de IP " + servidor + " esta aberta!");
			}
			catch(Exception e) {
				System.out.println("Porta " + porta + " de IP " + servidor + " esta fechada!");
			}
			
		}
		
		
		
		
	}
}