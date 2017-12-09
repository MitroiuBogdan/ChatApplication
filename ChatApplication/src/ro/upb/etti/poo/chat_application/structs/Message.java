/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.upb.etti.poo.chat_application.structs;

import java.io.Serializable;


public class Message implements Serializable{
    private String mSender;
    private String mContent;
    private static final long serialversionUID=1L;
    
    public Message(String mSender,String mContent){
        this.mSender=mSender;
        this.mContent=mContent;
    }
    @Override
    public String toString(){
        return this.mSender+": "+this.mContent;}

    public String getmSender() {
        return mSender;
    }
    
}
