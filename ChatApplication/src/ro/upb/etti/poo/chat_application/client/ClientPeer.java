/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.upb.etti.poo.chat_application.client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import ro.upb.etti.poo.chat_application.structs.Message;
import ro.upb.etti.poo.chat_application.structs.PrivateMessage;
/**
 *
 * @author Yllub-pc
 */
public class ClientPeer {
    
    private String mSender;
    private Socket  soket;
    ObjectOutputStream outputstream;

    public ClientPeer(String mSender, Socket soket) {
        this.mSender = mSender;
        this.soket = soket;
        try{
         this.outputstream=new ObjectOutputStream(this.soket.getOutputStream());}
                catch(IOException e){e.printStackTrace();}
        
    }
    public void sendMessage(String message) throws IOException{
        Message ms=new Message(this.mSender,message);
        outputstream.writeObject(ms);
       
        
    }
    public void sendMessage(String message,String recipient) throws IOException{
        
        PrivateMessage ms=new PrivateMessage(recipient,this.mSender,message);
        outputstream.writeObject(ms);
        
        
        
    }
    
        
    
    
    
}
