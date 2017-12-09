/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.upb.etti.poo.chat_application.server.config;

import ro.upb.etti.poo.chat_application.server.exceptions.UnknownKeyException;
import ro.upb.etti.poo.chat_application.server.exceptions.MissingKeyException;
import ro.upb.etti.poo.chat_application.server.exceptions.InvalidFormatException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ServerConfig {
    public static final List<String> prop_array=Arrays.asList("TCP_PORT","MAX_CLIENTS");
    
    Map<String,String> mProp;
    
    public ServerConfig(String file) throws InvalidFormatException,MissingKeyException,UnknownKeyException,IOException{
       this.mProp=new HashMap<>();
    
    
    try(Scanner scanner=new Scanner(new FileInputStream(file))){
        while(scanner.hasNextLine()){
            String line=scanner.nextLine().trim();
           
           if(line.startsWith("#")||line.isEmpty()){
            continue;}   
        
            if(!line.matches("[a-zA-Z0-9_]*\\s*=\\s*[0-9]+")){
                throw new InvalidFormatException("Invalid Format");}
           
            checkKey(line.substring(0,line.indexOf("=")).trim());
            processLine(line);
            }
        
        
        for(String x :prop_array){
            if(!mProp.containsKey(x)){
                throw new MissingKeyException("Error!");}}
            }
       }
   
   public ServerConfig() throws IOException, InvalidFormatException, UnknownKeyException, MissingKeyException {
        this("server.conf");
    }
      
      private void processLine(String line) throws UnknownKeyException {
        
       
        mProp.put(line.substring(0,line.indexOf("=")).trim(),
                 line.substring(line.indexOf("=")+1).trim());
    }
      private boolean checkKey(String keyName) throws UnknownKeyException {
        for (String knownKey : prop_array) {
            if (keyName.equals(knownKey)) {
                return true;
            }
        }

        throw new UnknownKeyException("UnknownKeyException");
    }

  
   public int getTcpPort(){
    return Integer.parseInt(mProp.get(prop_array.get(0)));}
   
   
   public int getMaxClients(){
    return Integer.parseInt(mProp.get(prop_array.get(1)));}
}
