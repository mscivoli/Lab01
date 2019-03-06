package it.polito.tdp.parole;

/**
 * Sample Skeleton for 'Parole.fxml' Controller Class
 */


import it.polito.tdp.parole.model.Parole;
import it.polito.tdp.parole.model.ParoleArray;

import java.net.URL;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ParoleController {
	
	Parole elencoL ;
	ParoleArray elencoA; 

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader
    
    @FXML
    private TextField txtTempoL;
    
    @FXML
    private TextField txtTempoA;
    
    @FXML
    private Button btnCancella;
    
    @FXML
    private Button btnReset;

    @FXML // fx:id="btnInserisci"
    private Button btnInserisci; // Value injected by FXMLLoader

    @FXML
    void doInsert(ActionEvent event) {
    	long startTime = System.nanoTime();
    	String parolaScritta = txtParola.getText().trim();
    	
    	elencoL.addParola(parolaScritta);
    	
    	String s = "";
    	LinkedList<String> ltemp = new LinkedList<String>(elencoL.getElenco());
    	Collections.sort(ltemp, new ComparatoreDiParolerPerNome());
    	for(int i=0; i<ltemp.size(); i++) {
    		s += ltemp.get(i).toString()+"\n";
    		
    	}
    	txtResult.setText(s);
    	txtParola.clear();
    	long estimatedTime = System.nanoTime() - startTime;
    	//String tempo = String.valueOf(System.nanoTime());
    	txtTempoL.setText(Long.toString(estimatedTime));
    	
    	
    	
    	txtResult.clear();
    	long startTime1 = System.nanoTime();
    	
    	
    	elencoA.addParola(parolaScritta);
    	
    	String s1 = "";
    	LinkedList<String> ltemp1 = new LinkedList<String>(elencoA.getElenco());
    	Collections.sort(ltemp1, new ComparatoreDiParolerPerNome());
    	for(int i=0; i<ltemp1.size(); i++) {
    		s1 += ltemp1.get(i).toString()+"\n";
    		
    	}
    	txtResult.setText(s1);
    	txtParola.clear();
    	long estimatedTime1 = System.nanoTime() - startTime1;
    	//String tempo = String.valueOf(System.nanoTime());
    	txtTempoA.setText(Long.toString(estimatedTime1));
    	
    }
    
    @FXML
    void doReset(ActionEvent event) {
    	long startTime = System.nanoTime();
    	elencoL.reset();
    	txtResult.clear();
    	long estimatedTime = System.nanoTime() - startTime;
    	txtTempoL.setText(Long.toString(estimatedTime));
    	
    	
    	long startTime1 = System.nanoTime();
    	elencoA.reset();
    	//txtResult.clear();
    	long estimatedTime1 = System.nanoTime() - startTime1;
    	//txtTempo.setText(Long.toString(System.nanoTime()));
    	txtTempoA.setText(Long.toString(estimatedTime1));
    }
    
    @FXML
    void doCancella(ActionEvent event) {
    	long startTime = System.nanoTime();
    	String parolaCancellata = txtResult.getSelectedText().trim();
    	elencoL.cancella(parolaCancellata);
    	String s = "";
    	LinkedList<String> ltemp = new LinkedList<String>(elencoL.getElenco());
    	Collections.sort(ltemp, new ComparatoreDiParolerPerNome());
    	for(int i=0; i<ltemp.size(); i++) {
    		s += ltemp.get(i).toString()+"\n";
    		
    	}
    	txtResult.setText(s);
    	long estimatedTime = System.nanoTime() - startTime;
    	//txtTempo.setText(Long.toString(System.nanoTime()));
    	txtTempoL.setText(Long.toString(estimatedTime));
    	
    	
    	
    	long startTime1 = System.nanoTime();
    	String parolaCancellata1 = txtResult.getSelectedText().trim();
    	elencoA.cancella(parolaCancellata1);
    	String s1 = "";
    	LinkedList<String> ltemp1 = new LinkedList<String>(elencoA.getElenco());
    	Collections.sort(ltemp1, new ComparatoreDiParolerPerNome());
    	for(int i=0; i<ltemp1.size(); i++) {
    		s += ltemp1.get(i).toString()+"\n";
    		
    	}
    	txtResult.setText(s);
    	long estimatedTime1 = System.nanoTime() - startTime1;
    	//txtTempo.setText(Long.toString(System.nanoTime()));
    	txtTempoA.setText(Long.toString(estimatedTime1));
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Parole.fxml'.";

        elencoL = new Parole() ;
        elencoA = new ParoleArray();
        
    }
}
