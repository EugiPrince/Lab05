package it.polito.tdp.model;

import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		Model model = new Model();

		List<String> ana_ciao = model.anagrammi("ciao");
		System.out.println(ana_ciao);
		
		for(String s : ana_ciao) {
			if(model.isCorrect(s)) {
				System.out.println(s+"\n");
			}
		}
	}

}
