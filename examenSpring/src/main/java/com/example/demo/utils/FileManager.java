package com.example.demo.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import com.example.demo.models.Producto;


public class FileManager {

	private static FileManager instance;

	private FileManager() {
		super();
	}
	
	public static FileManager getFM(){
		if(instance == null) {
			return new FileManager();
		} else {
			return instance;
		}
	}
	
	public ArrayList<Producto> readfile(){
		ArrayList<Producto> productos = new ArrayList<Producto>();
		
		 try
		 		{
		 		File documento = new File(".\\productos.txt");
		 		BufferedReader leer_fichero = new BufferedReader(new FileReader(documento));
		 		String caracteres = "";
		 		while((caracteres = leer_fichero.readLine()) != null)
		 		{
		 			
		 			String[] arrOfStr = caracteres.split("\\s+");
		 			
		 			if( arrOfStr.length == 6) {
		 				productos.add(new Producto(arrOfStr[0],
			 					Double.valueOf(arrOfStr[1]),
			 					Integer.valueOf(arrOfStr[2]),
			 					new Date() ,//date arrOfStr[3],
			 					Double.valueOf(arrOfStr[4]) ,
			 					Double.valueOf(arrOfStr[5]) ));
		 			}else {
		 				productos.add(new Producto(arrOfStr[0],
			 					Double.valueOf(arrOfStr[1]),
			 					Integer.valueOf(arrOfStr[2]),
			 					new Date() //date arrOfStr[3] 
			 					));
		 			}
		 			 
					

		 		}
		 	}
		 	catch (IOException e)
		 	{
		 		e.printStackTrace();
		 	}
		
		
		return productos;
	}
	
	public void writeFile(ArrayList<Producto> productos){
		
		try {
			
			File archivo = new File(".\\productos.txt");
			if(! archivo.exists())
			{
			archivo.createNewFile(); //utilizo el metodo createNewFile() para crear el archivo.
			System.out.println("Se ha generado el archivo.");	
			}
			FileWriter fw = new FileWriter(archivo); //El FileWriter es el encargado de habilitar la opción de escritura
			BufferedWriter bw = new BufferedWriter(fw); //BufferedWritter es el encargado de realizar la acción de escritura.
			
			for(Producto producto : productos) {
				bw.write(producto.toString());
			}
			
			
			bw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	
	
}
