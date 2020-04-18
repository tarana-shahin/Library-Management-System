/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryclient;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import libraryinterface.Management;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Tarana
 */
public class Client {
    
     Registry registry;
    Management stub;
    Client(){
                try	 
                {
                  registry = LocateRegistry.getRegistry("localhost",998);
                 }
                catch(Exception e)
                {
                    System.err.println("Client Exception : "+e.toString());
                    e.printStackTrace();
                }
                try{
                    stub =(Management)registry.lookup("Management");
                }
                catch(Exception e){System.err.println("registry error"+e);}
            }
}
