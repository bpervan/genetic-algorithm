package hr.fer.zpr.nasp.lab.lab2.odabir;

import hr.fer.zpr.nasp.lab.lab2.Kromosom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class OdabirGeneracijskiJednostavni implements Odabir {
	
	private Random r;
	
	public OdabirGeneracijskiJednostavni(Random r){
		this.r = r;
	}
	
	/**
	 * Dobrote treba složiti na pravac i onda randomizirati unutar perioda
	 * [0, UKUPNA_DOBROTA]
	 * @param listaKromosoma - lista kromosoma
	 * @return Nova populacija u kojoj su više puta zastupljeni kromosomi
	 * stare populacije koji imaju bolje dobrote
	 * 
	 */
	@Override
	public Kromosom[] odaberi(List<Kromosom> listaKromosoma) {
		Kromosom[] noviOdabir = new Kromosom[listaKromosoma.size()];
		
		double ukupnaDobrota = .0;
		for(int i = 0; i < listaKromosoma.size(); ++i){
			ukupnaDobrota += listaKromosoma.get(i).getDobrota();
		}
		
		for(int i = 0; i < listaKromosoma.size(); ++i){
			double temp = r.nextDouble() * ukupnaDobrota;
			double trenutnaUkupnaDobrota = .0;
			for(int j = 0; j < listaKromosoma.size(); ++j){
				trenutnaUkupnaDobrota += listaKromosoma.get(j).dobrota;
					if((trenutnaUkupnaDobrota >= temp)){
						noviOdabir[i] = listaKromosoma.get(j);
						break;
					}
			}
		}

		
		return noviOdabir;
	}

}
