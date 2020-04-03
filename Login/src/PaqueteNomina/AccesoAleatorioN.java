package PaqueteNomina;


import java.sql.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 *
 * @author ranbr
 */
public class AccesoAleatorioN {

    private static RandomAccessFile flujo;
    private static int numeroRegistros;
    private static int tamañoRegistro = 80;

    public static void cerrar() throws IOException {
        flujo.close();
    }

    public int getNumeroRegistros() {
        return numeroRegistros;
    }

    @SuppressWarnings("empty-statement")
    public void getEmpleado(String nombre, int i) throws IOException{
        FileReader fr=new FileReader("C:\\Users\\kievk\\Documents\\NetBeansProjects\\Nomina\\Departamento.txt");
        BufferedReader br=new BufferedReader(fr);
        String d;
        while((d=br.readLine())!=null){
            StringTokenizer dato=new StringTokenizer(d,"|");   
            while(dato.hasMoreTokens()){
                for( i=i;i<i;i++){
                    nombre=dato.nextToken();
                    i++;
                }
            }
        }
    }
    public String leerArchivo(String direccion){

        String texto="";
        try{
            BufferedReader bf= new BufferedReader(new FileReader(direccion));
            String temp="";
            String bfRead;
            while((bfRead=bf.readLine())!=null){
                temp=temp+bfRead;
                
            }
            texto=temp;
        }
        catch(Exception e){
                }
        return texto;
}
}
