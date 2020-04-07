package it.polito.tdp.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.db.AnagrammaDAO;

public class Model {
	
	private AnagrammaDAO anagrammaDAO = new AnagrammaDAO();
	private List<String> soluzione;

	public List<String> anagrammi(String parola) {
		this.soluzione = new ArrayList<String>();
		
		parola = parola.toUpperCase();
		List<Character> disponibili = new ArrayList<Character>();
		for(int i=0; i<parola.length(); i++)
			disponibili.add(parola.charAt(i));
		
		this.cercaRicorsiva("", 0, disponibili);
		
		return this.soluzione;
	}
	
	private void cercaRicorsiva(String parziale, int livello, List<Character> disponibili) {
		
		if(disponibili.size()==0) { //caso di terminazione
			this.soluzione.add(parziale);
		}
		
		for(Character ch : disponibili) {
			String prova = parziale + ch;
			
			List<Character> rimanenti = new ArrayList<Character>(disponibili);
			rimanenti.remove(ch);
			
			cercaRicorsiva(prova, livello+1, rimanenti);
		}
	}
	
	public boolean isCorrect(String anagramma) {
		return this.anagrammaDAO.isCorrect(anagramma);
	}
}
