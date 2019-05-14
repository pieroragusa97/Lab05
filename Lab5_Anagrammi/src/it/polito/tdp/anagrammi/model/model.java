package it.polito.tdp.anagrammi.model;

import java.util.HashSet;
import java.util.Set;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class model {
	
	AnagrammaDAO dao=new AnagrammaDAO();
	
	public Set<String> calcolaAnagrammi(String iniziale){
		Set<String> anagrammi=new HashSet<String>();
		String parziale="";
		calcola(parziale,iniziale,0,anagrammi);
		return anagrammi;
	}
	
	public void calcola(String parziale,String iniziale,int livello,Set<String> anagrammi) {
		
		if(livello==iniziale.length()) {
			anagrammi.add(parziale);
			return;
		}
		
		for(int i=0;i<iniziale.length();i++) {
		   if(presenze(parziale,iniziale.charAt(i))<presenze(iniziale,iniziale.charAt(i))){
			  parziale+=iniziale.charAt(i);
			  calcola(parziale,iniziale,livello+1,anagrammi);
			  parziale=parziale.substring(0, parziale.length()-1);
		   }
		}
	}
	
	public int presenze(String stringa,char c) {
		int conta=0;
		for(int i=0;i<stringa.length();i++) {
			if(stringa.charAt(i)==c)
				conta++;
		}
		return conta;
	}
	
	public boolean corretto(String s) {
		return dao.corretto(s);
	}

}
