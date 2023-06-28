package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dao.DaoCliente;
import dao.DaoSoftwareLicenca;
import entidades.Cliente;
import entidades.SoftwareLicenca;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CadastraSoftwareController implements Initializable {
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	private BorderPane cadastraSoftwareRoot;
	
	@FXML
	private TextField textFieldNome;
	
	@FXML
	private TextField textFieldCliente;
	
	@FXML
	private TextField textFieldEmail;
	
	@FXML
	private TextField textFieldCpf;
	
	public void cancelar() {
		try {
			BorderPane root = new FXMLLoader(getClass().getResource("/view/TelaInicial.fxml")).load();
		
			Scene scene = new Scene(root);
			
			Stage primaryStage = (Stage) cadastraSoftwareRoot.getScene().getWindow();
			primaryStage.setScene(scene);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cadastrar() {
		
	        String nomeSoftware = textFieldNome.getText();
	        String nomeCliente = textFieldCliente.getText();
	        String emailCliente = textFieldEmail.getText();
	        String cpf = textFieldCpf.getText();


	        // Criar objeto Cliente
	        Cliente cliente = new Cliente();
	        cliente.setNomeCliente(nomeCliente);
	        cliente.setEmailCliente(emailCliente);
	        cliente.setCpf(cpf);

	        // Criar objeto SoftwareLicenca
	        SoftwareLicenca softwareLicenca = new SoftwareLicenca();
	        softwareLicenca.setNomeSoftware(nomeSoftware);
	        softwareLicenca.setCliente(cliente);

	        // Inserir na tabela Cliente
	        DaoCliente daoCliente = new DaoCliente();
	        try {
	        	daoCliente.cadastrar(cliente);
	        } catch (SQLException e) {
	        	// TODO Auto-generated catch block
	        	e.printStackTrace();
	        }

	        softwareLicenca.setId(cliente.getId());
	        softwareLicenca.setCliente(cliente);
	        
	        // Inserir na tabela SoftwareLicenca
	        DaoSoftwareLicenca daoSoftware = new DaoSoftwareLicenca(null);
	        try {
				daoSoftware.cadastrar(softwareLicenca);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("Cadastro realizado");
	        alert.setHeaderText(null);
	        alert.setContentText("O registro foi cadastrado com sucesso!");
	        alert.showAndWait();


	}

}
