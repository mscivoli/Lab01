package it.polito.tdp.parole.model;

import java.util.*;
import java.util.List;

public class Parole {
	
	LinkedList<String> parole = new LinkedList<String>();
		
	public Parole() {
		//TODO
	}
	
	public void addParola(String p) {
		parole.add(p);
	}
	
	public List<String> getElenco() {
		return parole;
	}
	
	public void reset() {
		parole.clear();
	}
	
	public void cancella(String p) {
		parole.remove(p);
	}

}
