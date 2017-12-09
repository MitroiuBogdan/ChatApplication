/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.upb.etti.poo.chat_application.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Yllub-pc
 */
public class TextClient {
    private static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
    
   
    try(Socket socket=new Socket("127.0.0.1",9000)){
    String usename=scanner.nextLine();
    ClientPeer person=new ClientPeer(usename, socket);

    while(true){
      String Text=scanner.nextLine();
        
     if(Text.startsWith("/q")){
           break;}
     if(Text.startsWith("/w")){
           String user[]=Text.split(" ",3);
           person.sendMessage(user[2],user[1]);
            }
    else{
           person.sendMessage(Text);}
        }
   
   
    }
    catch (IOException ex) {
           ex.printStackTrace();
        }
        
        
        
    }
    
}
