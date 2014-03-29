package hr.fer.zpr.nasp.lab.lab2.mutacija;


import hr.fer.zpr.nasp.lab.lab2.Kromosom;

import java.util.Random;

public class MutacijaJednostavna implements Mutacija {
	
	private Random r;
	private double pMutacija;
	
	public MutacijaJednostavna(double pMutacija, Random r){
		this.r = r;
		this.pMutacija = pMutacija;
	}
	
	
	
	@Override
	public Kromosom mutiraj(Kromosom k) {
		int pozicija = r.nextInt(k.getDuljina());
			if(k.bitoviKromosoma[pozicija] == 1)
				k.bitoviKromosoma[pozicija] = 0;
			else
				k.bitoviKromosoma[pozicija] = 1;
		return null;
	}

}
