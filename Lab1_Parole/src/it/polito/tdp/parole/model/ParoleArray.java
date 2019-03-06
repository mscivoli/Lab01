package it.polito.tdp.parole.model;

import java.util.*;

public class ParoleArray {
	
	ArrayList<String> parole = new ArrayList<String>();
	
	public ParoleArray() {
		//TODO
	}
	
	public void addParola(String p) {
		parole.add(p);
	}
	
	public ArrayList<String> getElenco() {
		return parole;
	}
	
	public void reset() {
		parole.clear();
	}
	
	public void cancella(String p) {
		parole.remove(p);
	}

}
