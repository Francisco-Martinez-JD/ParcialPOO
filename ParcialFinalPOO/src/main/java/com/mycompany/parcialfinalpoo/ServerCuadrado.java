package com.mycompany.parcialfinalpoo;

import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;


public class ServerCuadrado {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server esperando conexiones...");
            
            while(true){
                Socket socketCliente = serverSocket.accept();
                System.out.println("CLiente conectado desde: " + socketCliente.getInetAddress());
                new Thread(new ManejadorClientes(socketCliente)).start();
            }
        } catch (IOException e) {
            System.out.println("Error en el servidor: " + e.getMessage());
            }
        }
        
}
