/**
 * Sample Skeleton for 'Anagrammi.fxml' Controller Class
 */

package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.anagrammi.model.model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {
	
	model Model=new model();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="AreaInserimento"
    private TextField AreaInserimento; // Value injected by FXMLLoader

    @FXML // fx:id="btnCalcola"
    private Button btnCalcola; // Value injected by FXMLLoader

    @FXML // fx:id="AreaGiusti"
    private TextArea AreaGiusti; // Value injected by FXMLLoader

    @FXML // fx:id="AreaSbagliati"
    private TextArea AreaSbagliati; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML
    void doCalcola(ActionEvent event) {
    	AreaSbagliati.clear();
    	AreaGiusti.clear();
		if(btnCalcola.isArmed()) {
			Set<String> anagrammi=this.Model.calcolaAnagrammi(AreaInserimento.getText());
			AreaInserimento.clear();
		  for(String s:anagrammi) {
    	      if(Model.corretto(s)==true)
			       AreaGiusti.appendText(s+"\n");
    	      else
    	    	   AreaSbagliati.appendText(s+"\n");
		    }
		}
    }

    @FXML
    void doReset(ActionEvent event) {
    	AreaInserimento.clear();
    	AreaSbagliati.clear();
    	AreaGiusti.clear();

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert AreaInserimento != null : "fx:id=\"AreaInserimento\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert AreaGiusti != null : "fx:id=\"AreaGiusti\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert AreaSbagliati != null : "fx:id=\"AreaSbagliati\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }

	public void setModel(model model) {
		Model = model;
	}
    
}
