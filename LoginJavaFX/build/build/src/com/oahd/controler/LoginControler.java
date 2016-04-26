package com.oahd.controler;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import com.oahd.model.UsuarioModel;

public class LoginControler {

	public boolean validarUsuario(UsuarioModel usuariojFX) {
		boolean correcto = false;
		UsuarioModel usuarioRest = conexionRestFul(usuariojFX);
		if (usuariojFX.getUsuario().equals(usuarioRest.getUsuario())
				&& usuariojFX.getContrasenia().equals(usuarioRest.getContrasenia())) {
			correcto = true;
		}
		return correcto;
	}

	public UsuarioModel conexionRestFul(UsuarioModel usuarioJFX) {

		UsuarioModel usuarioRest = new UsuarioModel();
		URL url;
		try {
			url = new URL("http://localhost:8080/PJRest-Oahd/usuario/" + usuarioJFX.getUsuario() + "/"
					+ usuarioJFX.getContrasenia());

			try (InputStream is = url.openStream(); JsonParser parser = Json.createParser(is)) {
				while (parser.hasNext()) {
					Event e = parser.next();
					if (e == Event.KEY_NAME) {
						switch (parser.getString()) {
						case "idusuario":
							parser.next();
								usuarioRest.setIdusuario(parser.getString());
							break;
						case "usuario":
							parser.next();
								usuarioRest.setUsuario(parser.getString());
							break;
						case "contrasenia":
							parser.next();
								usuarioRest.setContrasenia(parser.getString());
							break;
						}
					}
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		return usuarioRest;
	}

}
