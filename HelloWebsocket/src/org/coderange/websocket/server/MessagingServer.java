package org.coderange.websocket.server;

import java.net.InetSocketAddress;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

public class MessagingServer extends WebSocketServer {
	

	public MessagingServer(InetSocketAddress address) {
		super(address);
	}

	@Override
	public void onClose(WebSocket arg0, int arg1, String arg2, boolean arg3) {
		System.out.println("Socket closed");
	}
	
	@Override
	public void onError(WebSocket arg0, Exception arg1) {
		System.out.println("Error listening socket");
	}
	
	@Override
	public void onMessage(WebSocket socketConnect, String message) {
		System.out.println("Message received "+message);
		socketConnect.send("This is cmg from server! Thanks for messaging me.");
	}
	
	@Override
	public void onOpen(WebSocket arg0, ClientHandshake arg1) {
		System.out.println("Socket opened");
	}
	
	public static void main (String args[]) {
		
		MessagingServer wsServer = new MessagingServer (new InetSocketAddress(9111));
		wsServer.start();
		
	}
	

}
