package com.oahd.test;


import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;


public class TestClientes {

	public static void main(String[] args) {
		

		URL url;
		try {
			url = new URL("http://localhost:8080/SpringRestCrud/usuario/omar/oahd");
			try (InputStream is = url.openStream();
				      JsonParser parser = Json.createParser(is)) {
				     while (parser.hasNext()) {
				         Event e = parser.next();
				         if (e == Event.KEY_NAME) {
				             switch (parser.getString()) {
				                 case "idusuario":
				                    parser.next();
				                    System.out.print(parser.getString());
				                    System.out.print(": ");
				                    break;
				                case "usuario":
				                    parser.next();
				                    System.out.println(parser.getString());
				                    System.out.println("---------");
				                    break;
				                case "contrasenia":
				                    parser.next();
				                    System.out.println(parser.getString());
				                    System.out.println("---------");
				                    break;    
				             }
				         }
				     }
				 } catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		 
	}
	}


