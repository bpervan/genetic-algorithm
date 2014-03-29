package hr.fer.zpr.nasp.lab.lab2;

import hr.fer.zpr.nasp.lab.lab2.funkcija.F6Predavanja;
import hr.fer.zpr.nasp.lab.lab2.funkcija.Funkcija;
import hr.fer.zpr.nasp.lab.lab2.krizanje.Krizanje;
import hr.fer.zpr.nasp.lab.lab2.krizanje.KrizanjeJednaTockaPrekida;
import hr.fer.zpr.nasp.lab.lab2.krizanje.KrizanjeNTockiPrekida;
import hr.fer.zpr.nasp.lab.lab2.krizanje.KrizanjeUniformno;
import hr.fer.zpr.nasp.lab.lab2.mutacija.Mutacija;
import hr.fer.zpr.nasp.lab.lab2.mutacija.MutacijaJednolika;
import hr.fer.zpr.nasp.lab.lab2.mutacija.MutacijaJednostavna;
import hr.fer.zpr.nasp.lab.lab2.mutacija.MutacijaNiziBitovi;
import hr.fer.zpr.nasp.lab.lab2.odabir.Odabir;
import hr.fer.zpr.nasp.lab.lab2.odabir.OdabirEliminacijskiJednostavni;
import hr.fer.zpr.nasp.lab.lab2.odabir.OdabirGeneracijskiJednostavni;
import hr.fer.zpr.nasp.lab.lab2.odabir.OdabirTurnirski;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class TestDrive {
	
	public static void main(String[] args){
		
		List<Double> rezultati1 = new ArrayList<Double>();
		List<Double> rezultati2 = new ArrayList<Double>();
		List<Double> rezultati3 = new ArrayList<Double>();
		List<Double> rezultati4 = new ArrayList<Double>();
		List<Double> rezultati5 = new ArrayList<Double>();
		List<Double> rezultati6 = new ArrayList<Double>();
		List<Double> rezultati7 = new ArrayList<Double>();
		List<Double> rezultati8 = new ArrayList<Double>();
		
		Random randomGenerator = new Random();
		
		//Funkcija funkcijaCilja = new F4();
		Funkcija funkcijaCilja = new F6Predavanja();
		Odabir odabir = new OdabirTurnirski(randomGenerator, 3);
		Odabir generacijskiJednostavni = new OdabirGeneracijskiJednostavni(randomGenerator);
		Odabir eliminacijskiJednostavni = new OdabirEliminacijskiJednostavni(randomGenerator, 3);
		
		Krizanje jednaTockaPrekida = new KrizanjeJednaTockaPrekida(0.9, randomGenerator);
		Krizanje uniformno = new KrizanjeUniformno(0.9, randomGenerator);
		Krizanje nTocakaPrekida = new KrizanjeNTockiPrekida(0.9, randomGenerator, 2);
		
		Mutacija jednostavna = new MutacijaJednostavna(0.05, randomGenerator);
		Mutacija jednolika = new MutacijaJednolika(0.05, randomGenerator);
		Mutacija niziBitovi = new MutacijaNiziBitovi(0.05, randomGenerator, 5);
		
		double min1 = .0;
		// F4, Jedna prekidna toèka, jednostavna mutacija, turnir
		GenetskiAlgoritam ga = new GenetskiAlgoritam(funkcijaCilja, jednostavna, jednaTockaPrekida, odabir);
		for(int i = 0; i < 100; ++i){
			min1 = ga.execute();
			rezultati1.add(min1);
		}
		
		
		// F4, Jedna prekidna toèka, jednolika mutacija, turnir
		ga = new GenetskiAlgoritam(funkcijaCilja, jednolika, jednaTockaPrekida, odabir);
		double min2 = .0;
		for(int i = 0; i < 100; ++i){
			min2 = ga.execute();
			rezultati2.add(min2);
		}
		
		
		
		// F4, Jedna prekidna toèka,  mutacija nižih bitova, turnir
		ga = new GenetskiAlgoritam(funkcijaCilja, niziBitovi, jednaTockaPrekida, odabir);
		double min3 = .0;
		for(int i = 0; i < 100; ++i){
			min3 = ga.execute();
			rezultati3.add(min3);
		}
		
		ga = new GenetskiAlgoritam(funkcijaCilja, jednolika, uniformno, odabir);
		double min4 = .0;
		for(int i = 0; i < 100; ++i){
			min4 = ga.execute();
			rezultati4.add(min4);
		}
		
		ga = new GenetskiAlgoritam(funkcijaCilja, niziBitovi, uniformno, odabir);
		double min5 = .0;
		for(int i = 0; i < 100; ++i){
			min5 = ga.execute();
			rezultati5.add(min5);
		}
		
		ga = new GenetskiAlgoritam(funkcijaCilja, jednolika, uniformno, generacijskiJednostavni);
		double min6 = .0;
		for(int i = 0; i < 100; ++i){
			min6 = ga.execute();
			rezultati6.add(min6);
		}
		
		ga = new GenetskiAlgoritam(funkcijaCilja, jednolika, uniformno, eliminacijskiJednostavni);
		double min7 = .0;
		for(int i = 0; i < 100; ++i){
			min7 = ga.execute();
			rezultati7.add(min7);
		}
		
		ga = new GenetskiAlgoritam(funkcijaCilja, jednolika, nTocakaPrekida, eliminacijskiJednostavni);
		double min8 = .0;
		for(int i = 0; i < 100; ++i){
			min8 = ga.execute();
			rezultati8.add(min8);
		}
		
		BufferedWriter br = null;
		try {
			FileWriter fw = new FileWriter("stat.txt");
			br = new BufferedWriter(fw);
			double sum = .0;
			fw.write("Jedna prekidna tocka, jednostavna mutacija, 3 - turnirski odabir:\n");
			for(int i = 0; i < rezultati1.size(); ++i){
				sum += rezultati1.get(i);
				fw.write("Iteracija " + i + " Rezultat: " + String.valueOf(rezultati1.get(i)) + "\n");
			}
			fw.write("Prosjek: " + String.valueOf(sum/rezultati1.size()));
			fw.write("-----------------------------\n");
			
			fw.write("Jedna prekidna tocka, jednolika mutacija, 3 - turnirski odabir:\n");
			sum = .0;
			for(int i = 0; i < rezultati2.size(); ++i){
				sum += rezultati2.get(i);
				fw.write("Iteracija " + i + " Rezultat: " + String.valueOf(rezultati2.get(i)) + "\n");
			}
			fw.write("Prosjek: " + String.valueOf(sum/rezultati2.size()));		
			fw.write("-----------------------------\n");
			
			fw.write("Jedna prekidna tocka, mutacija nizih bitova, 3 - turnirski odabir:\n");
			sum = .0;
			for(int i = 0; i < rezultati3.size(); ++i){
				sum += rezultati3.get(i);
				fw.write("Iteracija " + i + " Rezultat: " + String.valueOf(rezultati3.get(i)) + "\n");
			}
			fw.write("Prosjek: " + String.valueOf(sum/rezultati3.size()));	
			fw.write("-----------------------------\n");
			
			fw.write("Uniformno, jednolika mutacija, 3 - turnirski odabir:\n");
			sum = .0;
			for(int i = 0; i < rezultati4.size(); ++i){
				sum += rezultati4.get(i);
				fw.write("Iteracija " + i + " Rezultat: " + String.valueOf(rezultati4.get(i)) + "\n");
			}
			fw.write("Prosjek: " + String.valueOf(sum/rezultati4.size()));		
			fw.write("-----------------------------\n");
			
			fw.write("Uniformno, mutacija nizih bitova, 3 - turnirski odabir:\n");
			sum = .0;
			for(int i = 0; i < rezultati5.size(); ++i){
				sum += rezultati5.get(i);
				fw.write("Iteracija " + i + " Rezultat: " + String.valueOf(rezultati5.get(i)) + "\n");
			}
			fw.write("Prosjek: " + String.valueOf(sum/rezultati5.size()));
			fw.write("-----------------------------\n");
			
			fw.write("Uniformno, jednolika mutacija, generacijski jednostavni odabir:\n");
			sum = .0;
			for(int i = 0; i < rezultati6.size(); ++i){
				sum += rezultati6.get(i);
				fw.write("Iteracija " + i + " Rezultat: " + String.valueOf(rezultati6.get(i)) + "\n");
			}
			fw.write("Prosjek: " + String.valueOf(sum/rezultati6.size()));
			fw.write("-----------------------------\n");
			
			fw.write("Uniformno, jednolika mutacija, eliminacijski jednostavni odabir:\n");
			sum = .0;
			for(int i = 0; i < rezultati7.size(); ++i){
				sum += rezultati7.get(i);
				fw.write("Iteracija " + i + " Rezultat: " + String.valueOf(rezultati7.get(i)) + "\n");
			}
			fw.write("Prosjek: " + String.valueOf(sum/rezultati7.size()));
			fw.write("-----------------------------\n");
			
			fw.write("2 tocke prekida, jednolika mutacija, eliminacijski jednostavni odabir:\n");
			sum = .0;
			for(int i = 0; i < rezultati8.size(); ++i){
				sum += rezultati8.get(i);
				fw.write("Iteracija " + i + " Rezultat: " + String.valueOf(rezultati8.get(i)) + "\n");
			}
			fw.write("Prosjek: " + String.valueOf(sum/rezultati8.size()));
			fw.write("-----------------------------\n");
			
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		/*
		System.out.println("Krizanje s jednom tockom prekida: "  + min1);
		System.out.println("Uniformno krizanje: " + min2);
		System.out.println("Jednolika mutacija: " + min3);
		System.out.println("Jednolika mutacija: " + min4);*/
	}
}
