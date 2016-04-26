package com.oahd.view;

import com.oahd.controler.LoginControler;
import com.oahd.model.UsuarioModel;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Login extends Application {

	 public static void main(String[] args) {
	     launch(args);
	 }

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	 public void start(Stage primaryStage) {
	     BorderPane borderpanel = new BorderPane();
	     borderpanel.setPadding(new Insets(20,60,60,60));

	     //Agrego HBox
	     HBox hbox = new HBox();
	     hbox.setPadding(new Insets(30,30,30,40));
	     
	     //Agrego GridPane
	     
	     GridPane gridPane = new GridPane();
	     gridPane.setPadding(new Insets(40,40,40,40));
	     gridPane.setHgap(6);
	     gridPane.setVgap(6);

	    //Implementing Nodes for GridPane

	     Label lblUsuario = new Label("Usuario");
	     final TextField txtUsuario = new TextField();
	     Label lblcontrasenia = new Label("Contraseña");
	     final PasswordField pf = new PasswordField();
	     Button btnLogin = new Button("Login");
	     final Label lblMensaje = new Label();

	     //Agrego Nodes a GridPane layout
	     gridPane.add(lblUsuario, 0, 0);
	     gridPane.add(txtUsuario, 1, 0);
	     gridPane.add(lblcontrasenia, 0, 1);
	     gridPane.add(pf, 1, 1);
	     gridPane.add(btnLogin, 1, 3);
	     gridPane.add(lblMensaje, 0, 4, 2,2);
	     DropShadow dropShadow = new DropShadow();
	     dropShadow.setOffsetX(5);
	     dropShadow.setOffsetY(5);
	     //Agrego ID's a Nodes
	     borderpanel.setId("borderpanel");
	     gridPane.setId("root");
	     btnLogin.setId("btnLogin");
	     //accion del btnLogin
	     btnLogin.setOnAction(new EventHandler() {
		@Override
		public void handle(Event event) {
			UsuarioModel usuariologin = new UsuarioModel();
			usuariologin.setUsuario(txtUsuario.getText().toString());
			usuariologin.setContrasenia(pf.getText().toString());
			if (usuariologin.getUsuario().equals("") && usuariologin.getContrasenia().equals("")){
				lblMensaje.setText("Introduce usuario ó contraseña");
		        lblMensaje.setTextFill(Color.RED);
			}else{
		    LoginControler controlerLogin = new LoginControler();
		       if(controlerLogin.validarUsuario(usuariologin)){
		        lblMensaje.setText("Felicidades todo cool");
		        lblMensaje.setTextFill(Color.GREEN);
		       }
		       else{
		        lblMensaje.setText("Usuario ó contraseña incorrecta");
		        lblMensaje.setTextFill(Color.RED);
		       }
			}
		       txtUsuario.setText("");
		       pf.setText("");
			
		}

	      });

	     

	     //Agrego HBox y GridPane layout al BorderPane Layout
	     borderpanel.setTop(hbox);
	     borderpanel.setCenter(gridPane); 
	     //Agrego BorderPane  al scene 
		  Scene scene = new Scene(borderpanel);
		  primaryStage.setScene(scene);
		  primaryStage.titleProperty().bind(
		              scene.widthProperty().asString().
		              concat(" : ").
		              concat(scene.heightProperty().asString()));
		  primaryStage.setResizable(false);
	  primaryStage.show();

	 }

	}

