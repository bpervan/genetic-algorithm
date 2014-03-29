package hr.fer.zpr.nasp.lab.lab2.krizanje;

import hr.fer.zpr.nasp.lab.lab2.Kromosom;

import java.util.Random;

public class KrizanjeJednaTockaPrekida implements Krizanje{
	
	private Random r;
	private double pKrizanje;
	
	public KrizanjeJednaTockaPrekida(double pKrizanje, Random r){
		this.r = r;
		this.pKrizanje = pKrizanje;
	}

	@Override
	public Kromosom[] krizaj(Kromosom k1, Kromosom k2) {
		Kromosom[] retVal = new Kromosom[2];
		
		//do krizanja dolazi
		if(r.nextDouble() < this.pKrizanje){
			int duljina = k1.getDuljina();
			int prekidnaPozicija = (int)(r.nextDouble()*(duljina));
			byte[] noviNiz = new byte[duljina];
			byte[] noviNiz2 = new byte[duljina];
			
			for(int i = 0; i < prekidnaPozicija; ++i){
				noviNiz[i] = k1.bitoviKromosoma[i];
				noviNiz2[i] = k2.bitoviKromosoma[i];
			}
			for(int i = prekidnaPozicija; i < duljina; ++i){
				noviNiz[i] = k2.bitoviKromosoma[i];
				noviNiz2[i] = k1.bitoviKromosoma[i];
			}
			retVal[0] = new Kromosom(noviNiz);
			retVal[1] = new Kromosom(noviNiz2);
		} else { //do krizanja ne dolazi
			return null;
		}
		
		
		
		return retVal;
	}
	
	
}
