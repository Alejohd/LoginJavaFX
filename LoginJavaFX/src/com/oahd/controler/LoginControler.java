package com.oahd.controler;

import com.oahd.model.services.LoginServices;
import com.oahd.model.vo.UsuarioVo;

public class LoginControler {

	public boolean getvalidarUsuario(UsuarioVo usuariojFX) {
		return new LoginServices().getvalidarUsuario(usuariojFX);
	}
}
