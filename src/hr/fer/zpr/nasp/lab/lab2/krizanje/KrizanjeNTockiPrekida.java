package hr.fer.zpr.nasp.lab.lab2.krizanje;

import java.util.Arrays;
import java.util.Random;

import hr.fer.zpr.nasp.lab.lab2.Kromosom;

public class KrizanjeNTockiPrekida implements Krizanje{

	private Random r;
	private double pKrizanje;
	private int numTockePrekida;
	
	public KrizanjeNTockiPrekida(double pKrizanje, Random r, int numTockePrekida){
		this.r = r;
		this.pKrizanje = pKrizanje;
		this.numTockePrekida = numTockePrekida;
	}

	@Override
	public Kromosom[] krizaj(Kromosom k1, Kromosom k2) {
		if(r.nextDouble() < this.pKrizanje)
			return null;
		
		int duljina = k1.getDuljina();
		int prekidnaPozicija = (int)(r.nextDouble()*(duljina));
		int prekidnaPozicija2 = 0;
		//prekidne pozicije se razlikuju za 1
		while(prekidnaPozicija2 == prekidnaPozicija){
			prekidnaPozicija2 = (int)(r.nextDouble()*(duljina));
		}
		
		if(prekidnaPozicija2 > prekidnaPozicija){
			int temp = prekidnaPozicija;
			prekidnaPozicija = prekidnaPozicija2;
			prekidnaPozicija2 = temp;
		}
		
		byte[] noviNiz = new byte[duljina];
		byte[] noviNiz2 = new byte[duljina];
		
		for(int i = 0; i < prekidnaPozicija; ++i){
			noviNiz[i] = k1.bitoviKromosoma[i];
			noviNiz2[i] = k2.bitoviKromosoma[i];
		}
		
		for(int i = prekidnaPozicija; i < prekidnaPozicija2; ++i){
			noviNiz[i] = k2.bitoviKromosoma[i];
			noviNiz2[i] = k1.bitoviKromosoma[i];
		}
		
		for(int i = prekidnaPozicija2; i < duljina; ++i){
			noviNiz[i] = k1.bitoviKromosoma[i];
			noviNiz2[i] = k2.bitoviKromosoma[i];
		}

		Kromosom[] retVal = new Kromosom[2];
		
		retVal[0] = new Kromosom(noviNiz);
		retVal[1] = new Kromosom(noviNiz2);
		
		return retVal;
	}

}
