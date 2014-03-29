package hr.fer.zpr.nasp.lab.lab2.mutacija;

import hr.fer.zpr.nasp.lab.lab2.Kromosom;

import java.util.Random;

public class MutacijaNiziBitovi implements Mutacija{
	
	private int kolikoNizihBitovaMutiramo;
	private Random r;
	private double pMutacija;
	
	public MutacijaNiziBitovi(double pMutacija, Random r, int kolikoNizihBitovaMutiramo){
		this.kolikoNizihBitovaMutiramo = kolikoNizihBitovaMutiramo;
		this.r = r;
		this.pMutacija = pMutacija;
	}
	
	@Override
	public Kromosom mutiraj(Kromosom k) {
		for(int i = (k.bitoviKromosoma.length - 1); i > kolikoNizihBitovaMutiramo; --i){
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
