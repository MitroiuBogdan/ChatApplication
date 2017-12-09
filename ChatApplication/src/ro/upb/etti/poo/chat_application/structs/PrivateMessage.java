/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.upb.etti.poo.chat_application.structs;

/**
 *
 * @author Yllub-pc
 */
public class PrivateMessage extends Message{
       private String mRecipient;
       
         
 public PrivateMessage(String mRecipent,String mSender,String mContent){
      super(mSender,mContent);
      this.mRecipient=mRecipent;
        }
@Override
       
 public String toString(){
         return"(priv) "+super.toString();
}
 public String getRecipient(){
      return  this.mRecipient;
 }
 }    
     
