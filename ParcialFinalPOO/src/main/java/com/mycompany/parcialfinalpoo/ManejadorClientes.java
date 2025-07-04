package com.mycompany.parcialfinalpoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Melara
 */
public class ManejadorClientes implements Runnable{
    private Socket socketCliente;

    public ManejadorClientes(Socket socketCliente) {
        this.socketCliente = socketCliente;
    }
    
    @Override
    public void run(){
        try{
            InputStream inputStream = socketCliente.getInputStream();
            OutputStream outputStream = socketCliente.getOutputStream();
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter writer = new PrintWriter(outputStream, true);
            
            String nombreCliente = reader.readLine();
            System.out.println("Cliente " + nombreCliente + " conectado desde: " + socketCliente.getInetAddress());
            
            String num = reader.readLine();
            int numero = Integer.parseInt(num);
            int cuadrado = numero*numero;
            
            String respuesta = "Bienvenido " + nombreCliente + "!" + " Su numero elevado al cuadrado es: " + cuadrado;
            writer.println(respuesta);
            
            writer.println("Este mensaje proviene del servidor");
            socketCliente.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    
    
}
