package edu.ED.TeoriaGeneral;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class inicio {

	public static void main(String[] args) {
		// ########## ESCRIBIR EN UN ARCHIVO #############

		// Ruta del archivo
		String rutaArchivo = "C:/ruta/especifica/archivo.txt";

		try {
			// Crear un objeto FileWriter con la ruta específica
			FileWriter escritor = new FileWriter(rutaArchivo);

			// Utilizar PrintWriter para escribir en el archivo
			PrintWriter printWriter = new PrintWriter(escritor);

			// Escribir en el archivo
			printWriter.println("¡Hola, mundo!");
			printWriter.println("Este es un ejemplo de escritura en un archivo en una ruta específica en Java.");

			// Cerrar el PrintWriter
			printWriter.close();

			System.out.println("Se ha escrito en el archivo exitosamente en la ruta específica.");
		} catch (IOException e) {
			System.out.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
			e.printStackTrace();
		}
	

// ######### LEER ARCHIVO ############

	String nombreArchivo = "archivo.txt";

	try
	{
		// Crear un objeto FileReader
		FileReader lector = new FileReader(nombreArchivo);

		// Crear un objeto BufferedReader para mejorar la lectura del archivo
		BufferedReader bufferedReader = new BufferedReader(lector);

		String linea;
		// Leer cada línea del archivo
		while ((linea = bufferedReader.readLine()) != null) {
			System.out.println(linea);
			
			String[] pac = linea.split(";");

            PacientesDto paciente = new PacientesDto();
            paciente.Id = autoincrementarID();
            paciente.Dni = pac[0];
            paciente.Nombre = pac[1];
            paciente.Apellidos = pac[2];
            paciente.Consulta = pac[3];
            String fechaTexto = pac[4];

            LocalDateTime fechaDate = LocalDateTime.parse(fechaTexto);
            paciente.FechaCita = fechaDate;

            boolean cita = convert.ToBoolean(pac[5]);

            inicio.listaPacientes.Add(paciente);

            
		}

		// Cerrar el BufferedReader
		bufferedReader.close();
	}catch(
	IOException e)
	{
		System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
		e.printStackTrace();
	}
	
	
	
	
	
	
	

	private long autoincrementarID(List<ProductoDto> pedido)
	{
	    long nuevoId;
	    int tamanioLista = pedido.Count;
	    if (tamanioLista > 0)
	    {
	        nuevoId = pedido.get(tamanioLista - 1).getIdProducto + 1;
	    }
	    else
	    {
	        nuevoId = 1;
	    }
	    return nuevoId;

	}
	
	
	
	
	// ####### FECHAS #########
	
	// Obtener la fecha actual
    Date fechaActual = new Date();

    // Crear un objeto SimpleDateFormat con el formato deseado
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    // Formatear la fecha
    String fechaFormateada = formato.format(fechaActual);

    // Imprimir la fecha formateada
    System.out.println("Fecha formateada: " + fechaFormateada);
    
    
    
    
    
    
    //######## PEDIR FECHA #########
    
 // Crear un objeto Scanner para leer la entrada del usuario
    Scanner scanner = new Scanner(System.in);

    // Pedir al usuario que ingrese la fecha en un formato específico
    System.out.print("Ingrese la fecha en formato 'yyyy-MM-dd HH:mm:ss': ");
    String userInput = scanner.nextLine();

    // Definir el formato deseado usando DateTimeFormatter
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    // Parsear la entrada del usuario a LocalDateTime usando el formato especificado
    LocalDateTime parsedDate = LocalDateTime.parse(userInput, formatter);

    // Hacer algo con la fecha parsedDate, como guardarla en una base de datos, archivo, etc.
    System.out.println("Fecha ingresada: " + parsedDate);
}
