/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.upb.etti.poo.chat_application.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import ro.upb.etti.poo.chat_application.server.config.ServerConfig;
import ro.upb.etti.poo.chat_application.server.exceptions.InvalidFormatException;
import ro.upb.etti.poo.chat_application.server.exceptions.MissingKeyException;
import ro.upb.etti.poo.chat_application.server.exceptions.UnknownKeyException;
import ro.upb.etti.poo.chat_application.structs.Message;
/**
 *
 * @author Yllub-pc
 */
public class Server {
    public static void main(String[] args) throws ClassNotFoundException, InvalidFormatException, MissingKeyException, UnknownKeyException, IOException {
     //   ServerConfig serverConfig=new ServerConfig("server.config");
        try(ServerSocket serverSocket=new ServerSocket(9000)){
            Socket socket=serverSocket.accept();
            ServerPeer serverPeer=new ServerPeer(socket);
            serverPeer.run();
    
        }catch(IOException e){e.printStackTrace();}
  
        
    }
}
