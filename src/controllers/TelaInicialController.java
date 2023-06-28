package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import entidades.Cliente;
import entidades.SoftwareLicenca;
import dao.DaoCliente;
import dao.DaoSoftwareLicenca;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TelaInicialController implements Initializable {
	@FXML
	private BorderPane MainTelaInicial;
	@FXML
	private TableView<SoftwareLicenca> tableSoftware;
	@FXML
	private TableColumn<SoftwareLicenca, Integer> colID;
	@FXML
	private TableColumn<SoftwareLicenca, String> colNome;
	@FXML
	private TableColumn<SoftwareLicenca, String> colEmail;
	@FXML
	private TableColumn<Cliente, String> colCliente;
	@Override
	
	public void initialize(URL location, ResourceBundle resources) {
	    colID.setCellValueFactory(new PropertyValueFactory<>("id"));
	    colNome.setCellValueFactory(new PropertyValueFactory<>("nomeSoftware"));
	    colCliente.setCellValueFactory(new PropertyValueFactory<>("nomeCliente"));
	    colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

	    try {
	        DaoSoftwareLicenca daoLicenca = new DaoSoftwareLicenca(new DaoCliente());
	        List<SoftwareLicenca> licencas = daoLicenca.listarLicencas();
	        tableSoftware.setItems(FXCollections.observableArrayList(licencas));
	    } catch (SQLException e) {
	        e.printStackTrace();
	        e.getMessage();
	    }
	}
	
	
	public void showCadastraSoftware() {
		try {
			BorderPane root = new FXMLLoader(getClass().getResource("/view/CadastraSoftware.fxml")).load();
		
			Scene scene = new Scene(root);
			
			Stage primaryStage = (Stage) MainTelaInicial.getScene().getWindow();
			primaryStage.setScene(scene);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}