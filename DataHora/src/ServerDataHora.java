

import java.net.*;
import java.util.Date;

public class ServerDataHora {
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

			String stringMaiusc = stringRecebida.toUpperCase();

			DadosEnviar = ("Data e hora: " + new Date()).getBytes();

			DatagramPacket pacoteEnviar = new DatagramPacket(DadosEnviar,
					DadosEnviar.length, IPAddress, port);
			
			System.out.print("Enviando " + "Data e hora: " + new Date() + "...");

			serverSocket.send(pacoteEnviar);
			System.out.println("Pacote enviado!\n");
			numConn++;
		}
	}
}
