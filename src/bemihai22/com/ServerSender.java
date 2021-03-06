package bemihai22.com;

import java.io.*;

public class ServerSender extends Thread {
	private MessageQueue userQueue;
	private PrintStream toClient;
	public ServerSender(PrintStream toClient, MessageQueue userQueue) {
		this.userQueue = userQueue;
		this.toClient = toClient;
	}
	public void sendInfo(String msg){
		toClient.println();
		toClient.println(msg);
	}
	@Override
	public void run(){
		try{
			while(true){
				Message msg = userQueue.take();
				toClient.println(msg.getSender() + ": " + msg.getText());
			}
		}catch(InterruptedException e){}
	}
	
}
