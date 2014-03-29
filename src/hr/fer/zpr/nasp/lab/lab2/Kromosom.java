package hr.fer.zpr.nasp.lab.lab2;

import hr.fer.zpr.nasp.lab.lab2.funkcija.Funkcija;

import java.util.Arrays;
import java.util.Random;

public class Kromosom implements Comparable<Kromosom>{
	
	//Binarni i realni prikaz kromosoma
	public byte[] bitoviKromosoma;
	public double vrijednost;
	
	public double dobrota;
	public int duljinaKromosoma;
	
	
	
	public Kromosom(byte[] bitoviKromosoma){
		this.bitoviKromosoma = bitoviKromosoma;
		this.duljinaKromosoma = bitoviKromosoma.length;
	}
	/**
	 *
	 * @param r - Generator pseudosluèajnih brojeva
	 * @param duljinaKromosoma - Broj bitova kromosoma
	 * 
	 * Ovaj konstruktor koristi se samo za generiranje sluèajnog kromosoma kod Uniformnog(binarnog) križanja
	 */
	public Kromosom(Random r, int duljinaKromosoma){
		this.bitoviKromosoma = new byte[duljinaKromosoma];
		boolean temp;
		for(int i = 0; i < duljinaKromosoma; ++i){
			temp = r.nextBoolean();
			if(true == temp){
				this.bitoviKromosoma[i] = (byte)1;
			}else{
				this.bitoviKromosoma[i] = (byte)0;
			}
		}
		this.duljinaKromosoma = duljinaKromosoma;
	}
	
	public Kromosom(Random r, int duljinaKromosoma, Konverter k, Funkcija f){
		this.bitoviKromosoma = new byte[duljinaKromosoma];
		boolean temp;
		for(int i = 0; i < duljinaKromosoma; ++i){
			temp = r.nextBoolean();
			if(true == temp){
				this.bitoviKromosoma[i] = (byte)1;
			}else{
				this.bitoviKromosoma[i] = (byte)0;
			}
		}
		
		this.vrijednost = f.getValue(k.decodeBinary(this));
		this.duljinaKromosoma = duljinaKromosoma;
	}
	
	public double getDobrota(){
		return this.dobrota;
	}
	
	public int getDuljina(){
		return this.duljinaKromosoma;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < this.duljinaKromosoma; ++i){
			sb.append(bitoviKromosoma[i]);
		}
		return sb.toString();
	}
	
	@Override
	public int compareTo(Kromosom arg0) {
		if(this.vrijednost > arg0.vrijednost)
			return -1;
		else
			return 1;
	}
}
