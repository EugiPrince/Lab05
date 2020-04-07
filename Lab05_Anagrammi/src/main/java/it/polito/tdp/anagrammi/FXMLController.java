/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="btnAnagrammi"
    private Button btnAnagrammi; // Value injected by FXMLLoader

    @FXML // fx:id="txtCorretti"
    private TextArea txtCorretti; // Value injected by FXMLLoader

    @FXML // fx:id="txtErrati"
    private TextArea txtErrati; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML
    void doAnagrammi(ActionEvent event) {
    	this.txtCorretti.clear();
    	this.txtErrati.clear();
    	
    	String parola = this.txtParola.getText();
    	List<String> anagrammiCorretti = new ArrayList<>();
    	List<String> anagrammiErrati = new ArrayList<>();
    	
    	for(int i=0; i<parola.length(); i++) {
    		if(!Character.isAlphabetic(parola.charAt(i))) {
    			this.txtCorretti.appendText("Devi inserire una parola con caratteri validi");
    			return;
    		}
    	}
   
    	List<String> anagrammi = this.model.anagrammi(parola);
    	
    	for(String s : anagrammi) {
    		if(this.model.isCorrect(s))
    			anagrammiCorretti.add(s);
    		else
    			anagrammiErrati.add(s);
    	}
    	
    	for(String s : anagrammiCorretti)
    		this.txtCorretti.appendText(s+"\n");
    	
    	for(String s : anagrammiErrati)
    		this.txtErrati.appendText(s+"\n");
    }

    @FXML
    void doReset(ActionEvent event) {
    	this.txtCorretti.clear();
    	this.txtErrati.clear();
    	this.txtParola.clear();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnAnagrammi != null : "fx:id=\"btnAnagrammi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    }
}
