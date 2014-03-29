package hr.fer.zemris.apr.dz.dz3;

import hr.fer.zpr.nasp.lab.lab2.GenetskiAlgoritam;
import hr.fer.zpr.nasp.lab.lab2.funkcija.F3;
import hr.fer.zpr.nasp.lab.lab2.funkcija.F4;
import hr.fer.zpr.nasp.lab.lab2.funkcija.F6;
import hr.fer.zpr.nasp.lab.lab2.funkcija.F7;
import hr.fer.zpr.nasp.lab.lab2.funkcija.Funkcija;
import hr.fer.zpr.nasp.lab.lab2.krizanje.Krizanje;
import hr.fer.zpr.nasp.lab.lab2.krizanje.KrizanjeUniformno;
import hr.fer.zpr.nasp.lab.lab2.mutacija.Mutacija;
import hr.fer.zpr.nasp.lab.lab2.mutacija.MutacijaJednolika;
import hr.fer.zpr.nasp.lab.lab2.odabir.Odabir;
import hr.fer.zpr.nasp.lab.lab2.odabir.OdabirTurnirski;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestDrive {
	public static void main(String[] args){
		List<Double> rezultati1 = new ArrayList<Double>();
		List<Double> rezultati2 = new ArrayList<Double>();
		List<Double> rezultati3 = new ArrayList<Double>();
		List<Double> rezultati4 = new ArrayList<Double>();
		
		String line = null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int velicinaPopulacije = 10;
		double pMutacija = 0, pKrizanje = 0;
		int brojIteracija = 1000;
		
		try {
			System.out.println("Velièina populacije: ");
			line = reader.readLine();
			velicinaPopulacije = Integer.parseInt(line);
			
			System.out.println("Vjerojatnost mutacije: ");
			line = reader.readLine();
			pMutacija = Double.parseDouble(line);
			
			System.out.println("Vjerojatnost križanja: ");
			line = reader.readLine();
			pKrizanje = Double.parseDouble(line);
			
			System.out.println("Broj iteracija: ");
			line = reader.readLine();
			brojIteracija = Integer.parseInt(line);

			reader.close();
		} catch (IOException ex) {
			line = null;
			System.exit(-1);
		}
		
		Random randomGenerator = new Random();
		Odabir odabir = new OdabirTurnirski(randomGenerator, 3);
		Krizanje uniformno = new KrizanjeUniformno(pKrizanje, randomGenerator);
		Mutacija jednolika = new MutacijaJednolika(pMutacija, randomGenerator);
		Funkcija f4 = new F4();
		Funkcija f6 = new F6();
		Funkcija f7 = new F7();
		
		double[] f3Params = new double[]{1,2,3,4,5};
		Funkcija f3 = new F3(f3Params);
		/*
		GenetskiAlgoritam ga = new GenetskiAlgoritam(f4, jednolika, uniformno, odabir);
		ga.brojIteracija = brojIteracija;
		ga.velicinaPopulacije = velicinaPopulacije;
		double min1 = .0;		
		for(int i = 0; i < 100; ++i){
			min1 = ga.execute();
			rezultati1.add(min1);
		}*/
		
		GenetskiAlgoritam ga = new GenetskiAlgoritam(f6, jednolika, uniformno, odabir);
		ga.brojIteracija = brojIteracija;
		ga.velicinaPopulacije = velicinaPopulacije;
		ga.brojVarijabli = 3;
		ga.duljinaKromosoma = 24;
		ga.duljinaVarijable = 8;
		double min2 = .0;		
		for(int i = 0; i < 100; ++i){
			min2 = ga.execute();
			rezultati2.add(min2);
		}
		/*
		ga = new GenetskiAlgoritam(f7, jednolika, uniformno, odabir);
		ga.brojIteracija = brojIteracija;
		ga.velicinaPopulacije = velicinaPopulacije;
		ga.brojVarijabli = 3;
		ga.duljinaKromosoma = 24;
		ga.duljinaVarijable = 8;
		double min3 = .0;		
		for(int i = 0; i < 100; ++i){
			min3 = ga.execute();
			rezultati3.add(min3);
		}
		
		ga = new GenetskiAlgoritam(f3, jednolika, uniformno, odabir);
		ga.brojIteracija = brojIteracija;
		ga.velicinaPopulacije = velicinaPopulacije;
		ga.brojVarijabli = 5;
		ga.duljinaKromosoma = 50;
		ga.duljinaVarijable = 10;
		double min4 = .0;		
		for(int i = 0; i < 100; ++i){
			min4 = ga.execute();
			rezultati4.add(min4);
		}*/
		
		
		
		BufferedWriter br = null;
		try {
			FileWriter fw = new FileWriter("F6.txt");
			br = new BufferedWriter(fw);
			double sum = .0;/*
			fw.write("FUNKCIJA F4");
			for(int i = 0; i < rezultati1.size(); ++i){
				sum += rezultati1.get(i);
				fw.write("Iteracija " + i + " Rezultat: " + String.valueOf(rezultati1.get(i)) + "\n");
			}
			fw.write("Prosjek: " + String.valueOf(sum/rezultati1.size()));
			fw.write("-----------------------------\n");*/
			
			sum = .0;
			fw.write("FUNKCIJA F6");
			for(int i = 0; i < rezultati2.size(); ++i){
				sum += rezultati2.get(i);
				fw.write("Iteracija " + i + " Rezultat: " + String.valueOf(rezultati2.get(i)) + "\n");
			}
			fw.write("Prosjek: " + String.valueOf(sum/rezultati2.size()));
			fw.write("-----------------------------\n");
			/*
			sum = .0;
			fw.write("FUNKCIJA F7");
			for(int i = 0; i < rezultati3.size(); ++i){
				sum += rezultati3.get(i);
				fw.write("Iteracija " + i + " Rezultat: " + String.valueOf(rezultati3.get(i)) + "\n");
			}
			fw.write("Prosjek: " + String.valueOf(sum/rezultati3.size()));
			fw.write("-----------------------------\n");
			
			sum = .0;
			fw.write("FUNKCIJA F3");
			for(int i = 0; i < rezultati4.size(); ++i){
				sum += rezultati4.get(i);
				fw.write("Iteracija " + i + " Rezultat: " + String.valueOf(rezultati4.get(i)) + "\n");
			}
			fw.write("Prosjek: " + String.valueOf(sum/rezultati4.size()));
			fw.write("-----------------------------\n");*/
			
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Bananaaaaaaaaa");
	}
}
