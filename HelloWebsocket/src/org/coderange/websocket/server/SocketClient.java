package org.coderange.websocket.server;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.channels.NotYetConnectedException;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

public class SocketClient extends WebSocketClient {

	public SocketClient(URI serverURI) {
		super(serverURI);
	}
	
	@Override
	public void onClose(int arg0, String arg1, boolean arg2) {
		System.out.println("Socket closed");
	}
	
	@Override
	public void onError(Exception arg0) {
		System.out.println("Error listening socket");
	}
	
	@Override
	public void onMessage(String message) {
		System.out.println("Message received "+message);
	}
	
	@Override
	public void onOpen(ServerHandshake arg0) {
		System.out.println("Socket opened");
	}
	
	public static void main(String args[]) {
		
		try {	
			SocketClient wsClient = new SocketClient(new URI("ws://localhost:9111"));
			System.out.println("Handshake compeleted!");
			if (wsClient.connectBlocking()) {
				wsClient.send("Hi there ! You are awesome !");
			}
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (NotYetConnectedException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
