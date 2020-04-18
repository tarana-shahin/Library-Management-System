/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryserver;

/**
 *
 * @author Tarana
 */
import java.rmi.Remote;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import libraryserver.*;
import libraryinterface.*;

public class LibraryServer {

    public static void main(String[] args) {
        ServerFrame frame = new ServerFrame();

        /**
         *
         * @throws RemoteException
         */
        try {
            Management m = new ManagementImpl();
            Registry registry = LocateRegistry.createRegistry(998);
            registry.rebind("Management", m);
            System.out.println("server is working");
            frame.setTextStatus("Server is Ready");
        } catch (Exception e) {
            frame.setTextStatus("Server Failed To Start");
            System.err.println("System Exception : " + e.toString());
            e.printStackTrace();
        }
        // TODO code application logic here
    }
}
