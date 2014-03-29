package hr.fer.zpr.nasp.lab.lab2.krizanje;

import hr.fer.zpr.nasp.lab.lab2.Kromosom;

import java.util.Random;

public class KrizanjeUniformno implements Krizanje{
	
	
	private Random r;
	private double pKrizanje;
	
	public KrizanjeUniformno(double pKrizanje, Random r){
		this.r = r;
		this.pKrizanje = pKrizanje;
	}
	


	@Override
	public Kromosom[] krizaj(Kromosom k1, Kromosom k2) {
		
		if(r.nextDouble() < this.pKrizanje){
			return null;
		}
		Kromosom[] retVal = new Kromosom[1];
		int duljina = k1.getDuljina();
		Kromosom R = new Kromosom(r, duljina);
		byte[] noviNiz = new byte[duljina];
		
		for(int i = 0; i < duljina; ++i){
			if(k1.bitoviKromosoma[i] == k2.bitoviKromosoma[i])
				noviNiz[i] = k1.bitoviKromosoma[i];
			else
				noviNiz[i] = R.bitoviKromosoma[i];
		}
		
		
		retVal[0] = new Kromosom(noviNiz);
		return retVal;
	}
	
	
}
