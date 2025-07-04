/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author frank
 */
public class Mavenproject1 {

    public static void main(String[] args) {
         try{
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Conectado al servidor");
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream, true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese su nombre: ");
            String nombre = scanner.nextLine();
            
            System.out.print("Ingrese un numero: ");
            int numero = scanner.nextInt();
            
            writer.println(nombre);
            writer.println(numero);
            //leer respuesta del sv
            String res = reader.readLine();
            System.out.println("Respuesta: " + res);
            socket.close();
        }
        catch(IOException e){
            
        }
        
    }
}
