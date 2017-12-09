/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.upb.etti.poo.chat_application.server;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import ro.upb.etti.poo.chat_application.structs.Message;
import ro.upb.etti.poo.chat_application.structs.PrivateMessage;
/**
 *
 * @author Yllub-pc
 */
public class ServerPeer {
    
    private Socket socket;

    public ServerPeer(Socket socket) {
        this.socket =socket;
    }
    public void run() throws IOException,ClassNotFoundException{
        
        
        try(ObjectInputStream inputStream=new ObjectInputStream(this.socket.getInputStream())){
           while(true){
            Object message=inputStream.readObject();
            Message FormatMessage=(Message)message;
            System.out.println(FormatMessage.toString());
        } 
            
            
        }catch(EOFException e){
            System.out.println("Disconnected");}}
    
    
    
    
}
