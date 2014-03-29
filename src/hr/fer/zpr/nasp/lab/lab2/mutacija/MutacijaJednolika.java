package hr.fer.zpr.nasp.lab.lab2.mutacija;

import hr.fer.zpr.nasp.lab.lab2.Kromosom;

import java.util.Random;

public class MutacijaJednolika implements Mutacija{
	
	private Random r;
	private double pMutacija;
	
	public MutacijaJednolika(double pMutacija, Random r){
		this.r = r;
		this.pMutacija = pMutacija;
	}
	
	
	@Override
	public Kromosom mutiraj(Kromosom k) {
		for(int i = 0; i < k.bitoviKromosoma.length; ++i){
			if(r.nextDouble() < pMutacija){
				if(k.bitoviKromosoma[i] == 1)
					k.bitoviKromosoma[i] = 0;
				else
					k.bitoviKromosoma[i] = 1;
			}
		}
		return null;
	}
}
