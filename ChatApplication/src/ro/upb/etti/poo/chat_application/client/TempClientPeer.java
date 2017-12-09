/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.upb.etti.poo.chat_application.client;
import ro.upb.etti.poo.chat_application.structs.Message;
/**
 *
 * @author Yllub-pc
 */
public class TempClientPeer {
    private String mSender;
    private Message message1;

    public TempClientPeer(String mSender) {
        this.mSender = mSender;
        
    }
    public void sendMessage(String message){
         message1=new Message(this.mSender,message);
        
    }

    public Message getMessage1() {
        return message1;
    }
    
}