

import java.net.*;

public class Server {
	public static void main(String args[]) throws Exception {

		int porta = 9876;
		int numConn = 1;
		
		@SuppressWarnings("resource")
		DatagramSocket serverSocket = new DatagramSocket(porta);

		byte[] DadosReceber = new byte[100];
		byte[] DadosEnviar = new byte[100];

		while (true) {

			DatagramPacket pacoteReceber = new DatagramPacket(DadosReceber,
					DadosReceber.length);
		
			serverSocket.receive(pacoteReceber);


			String stringRecebida = new String(pacoteReceber.getData());
			System.out.println("String Recebida: " + stringRecebida);
			System.out.println(" de " + pacoteReceber.getAddress() + " tamanho: " + pacoteReceber.getLength());
			
			InetAddress IPAddress = pacoteReceber.getAddress();

			int port = pacoteReceber.getPort();
			

			String stringMaiuscula = "Texto maiusculo: " + stringRecebida.trim().toUpperCase();			
			String stringTamanho = "Tamanho texto: " + stringRecebida.trim().length();
			
			StringBuilder stringBuilder = new StringBuilder(stringRecebida.trim());
			
			String invertidaString = "Texto invertido: " + stringBuilder.reverse().toString();
			
			String stringEnviar = stringMaiuscula + ";" + stringTamanho + ";" + invertidaString;

			DadosEnviar = stringEnviar.getBytes();

			DatagramPacket pacoteEnviar = new DatagramPacket(DadosEnviar,
					DadosEnviar.length, IPAddress, port);
			
			System.out.print("Enviando " + stringEnviar + "...");

			serverSocket.send(pacoteEnviar);
			System.out.println("Pacote enviado!\n");
			numConn++;
		}
	}
}
