package hr.fer.zpr.nasp.lab.lab2.odabir;

import hr.fer.zpr.nasp.lab.lab2.Kromosom;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 
 * @author Branimir
 * Kazna je de facto sama vrijednost funkcije, jer minimiramo funkciju
 */

public class OdabirEliminacijskiJednostavni implements Odabir {
	
	private Random r;
	private int brojEliminacije;
	
	public OdabirEliminacijskiJednostavni(Random r, int brojEliminacije){
		this.r = r;
		this.brojEliminacije = brojEliminacije;
	}
	
	/**
	 * Funkcija æe vraæati null jer æe proceduralno izbaciti n kromosoma iz populacije
	 * 
	 */
	
	@Override
	public Kromosom[] odaberi(List<Kromosom> listaKromosoma) {
		List<Kromosom> removalCollection = new ArrayList<Kromosom>();
		
		double ukupnaKazna = .0;
		for(int i = 0; i < listaKromosoma.size(); ++i){
			ukupnaKazna += listaKromosoma.get(i).vrijednost;
		}
		
		for(int i = 0; i < brojEliminacije; ++i){
			double temp = r.nextDouble() * ukupnaKazna;
			double trenutnaUkupnaKazna = .0;
			for(int j = 0; j < listaKromosoma.size(); ++j){
				trenutnaUkupnaKazna += listaKromosoma.get(j).vrijednost;
					if((trenutnaUkupnaKazna >= temp)){
						removalCollection.add(listaKromosoma.get(j));
						break;
					}
			}
		}		
		for(Kromosom k : removalCollection){
			if(listaKromosoma.contains(k)){
				listaKromosoma.remove(k);
			}
		}
		
		
		return null;
	}

}
