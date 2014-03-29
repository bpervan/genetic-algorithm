package hr.fer.zpr.nasp.lab.lab2.odabir;

import hr.fer.zpr.nasp.lab.lab2.Kromosom;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/** 3 - turnirski odabir
 * @author Branimir
 *
 */

public class OdabirTurnirski implements Odabir{

	private Random r;
	private int velicinaTurnira = 3;
	
	public OdabirTurnirski(Random r, int brojOdabira){
		this.r = r;
		this.velicinaTurnira = brojOdabira;
	}
	
	public OdabirTurnirski(Random r){
		this.r = r;
	}
	
	/**
	 * @param Lista kromosoma koja sadržava trenutaènu populaciju
	 * @return Polje od tri nasumièno odabrana kromosoma
	 * 
	 * Turnir se zapravo odraðuje u nadklasi
	 */
	
	@Override
	public Kromosom[] odaberi(List<Kromosom> listaKromosoma) {
		Kromosom[] novoPolje = new Kromosom[velicinaTurnira];
		int temp = 0;
		for(int i = 0; i < velicinaTurnira; ++i){
			temp = r.nextInt(listaKromosoma.size() + 1);
			novoPolje[i] = listaKromosoma.get(i);
		}
		Arrays.sort(novoPolje);
		return novoPolje;
	}

}
