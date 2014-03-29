package hr.fer.zpr.nasp.lab.lab2;

import hr.fer.zpr.nasp.lab.lab2.funkcija.Funkcija;
import hr.fer.zpr.nasp.lab.lab2.krizanje.Krizanje;
import hr.fer.zpr.nasp.lab.lab2.mutacija.Mutacija;
import hr.fer.zpr.nasp.lab.lab2.odabir.Odabir;
import hr.fer.zpr.nasp.lab.lab2.odabir.OdabirEliminacijskiJednostavni;
import hr.fer.zpr.nasp.lab.lab2.odabir.OdabirGeneracijskiJednostavni;
import hr.fer.zpr.nasp.lab.lab2.odabir.OdabirTurnirski;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenetskiAlgoritam {
	
	private Funkcija funkcijaCilja;
	private Mutacija mutacija;
	private Krizanje krizanje;
	private Odabir odabir;
	
	public int velicinaPopulacije = 10;
	private int donjaGranica = 0;
	private int gornjaGranica = 100;
	
	public int duljinaKromosoma = 24;
	public int brojVarijabli = 2;
	public int duljinaVarijable = duljinaKromosoma / brojVarijabli;
	
	public int brojIteracija = 1000;
	
	private Random randomGenerator;
	
	/**
	 * 
	 * @param f - Funkcija cilja
	 * @param m - Naèin mutacije kromosoma
	 * @param k - Metoda križanja
	 * @param o - Metoda odabira jedinki za križanje
	 * 
	 */
	public GenetskiAlgoritam(Funkcija f, Mutacija m, Krizanje k, Odabir o){
		this.setFunkcijaCilja(f);
		this.mutacija = m;
		this.krizanje = k;
		this.odabir = o;
		randomGenerator = new Random();
	}
	
	public double execute(){
		Konverter binaryToReal = new Konverter(donjaGranica, gornjaGranica, duljinaVarijable, brojVarijabli);
		
		List<Kromosom> populacija = stvoriPopulaciju(randomGenerator, binaryToReal, funkcijaCilja);
		evaluirajPopulaciju(populacija);
		
		for(Kromosom k : populacija){
			System.out.println("Binarno: " + k + ", Realno: " + k.vrijednost + ", Dobrota: " + k.dobrota);
		}
		
		Konverter dekoderVarijable = new Konverter(donjaGranica, gornjaGranica, 8, 1);
		
		int brojacIteracija = 0;
		double minValue;
		do{
			if(odabir instanceof OdabirTurnirski){
				//Odaberi roditelje za križanje
				Kromosom[] odabrani = odabir.odaberi(populacija);
				
				//Križaj roditelje
				Kromosom[] djeca = krizanje.krizaj(odabrani[1], odabrani[2]);
				
				//došlo je do križanja
				if(djeca != null){
					//Mutiraj djecu
					for(Kromosom dijete : djeca){
						mutacija.mutiraj(dijete);
					}
					//mutacija.mutiraj(djeca[0]);
					
					//Evaluiraj djecu
					for(Kromosom dijete : djeca){
						dijete.vrijednost = funkcijaCilja.getValue(binaryToReal.decodeBinary(dijete));
					}
					//djeca[0].vrijednost = funkcijaCilja.getValue(binaryToReal.decodeBinary(djeca[0]));
					
					populacija.remove(odabrani[0]);
					
					//Dodaj novo dijete u populaciju
					populacija.add(djeca[0]);
				}
			} else if (odabir instanceof OdabirGeneracijskiJednostavni){
				Kromosom[] odabrani = odabir.odaberi(populacija);
				
				populacija = new ArrayList<Kromosom>();
				
				for(Kromosom k : odabrani){
					populacija.add(k);
				}
				
				int randomInt = randomGenerator.nextInt(populacija.size() - 1);
				int randomInt2 = randomGenerator.nextInt(populacija.size() - 1);
				Kromosom[] djeca = krizanje.krizaj(populacija.get(randomInt), populacija.get(randomInt2));
				
				//došlo je do križanja
				if(djeca != null){
					//Mutiraj djecu
					for(Kromosom dijete : djeca){
						mutacija.mutiraj(dijete);
					}
					//mutacija.mutiraj(djeca[0]);
					
					//Evaluiraj djecu
					for(Kromosom dijete : djeca){
						dijete.vrijednost = funkcijaCilja.getValue(binaryToReal.decodeBinary(dijete));
					}
					//djeca[0].vrijednost = funkcijaCilja.getValue(binaryToReal.decodeBinary(djeca[0]));
					
					populacija.remove(randomInt);
					
					//Dodaj novo dijete u populaciju
					populacija.add(djeca[0]);
				}
				
				
			} else if(odabir instanceof OdabirEliminacijskiJednostavni){
				odabir.odaberi(populacija);
				while(populacija.size() < velicinaPopulacije){
					int randomInt = randomGenerator.nextInt(populacija.size());
					int randomInt2 = randomGenerator.nextInt(populacija.size());
					Kromosom[] djeca = krizanje.krizaj(populacija.get(randomInt), populacija.get(randomInt2));
					//došlo je do križanja
					if(djeca != null){
						//Mutiraj djecu
						for(Kromosom dijete : djeca){
							mutacija.mutiraj(dijete);
						}
						//mutacija.mutiraj(djeca[0]);
						
						//Evaluiraj djecu
						for(Kromosom dijete : djeca){
							dijete.vrijednost = funkcijaCilja.getValue(binaryToReal.decodeBinary(dijete));
						}
						//djeca[0].vrijednost = funkcijaCilja.getValue(binaryToReal.decodeBinary(djeca[0]));
						
						//Dodaj novo dijete u populaciju
						populacija.add(djeca[0]);
					}
				}
			}
			
			
			minValue = 1000000000;
			Kromosom temp = null;
			for(Kromosom k1 : populacija){
				if(k1.vrijednost < minValue){
					minValue = k1.vrijednost;
					temp = k1;
				}	
			}
			
			System.out.println(" Trenutna minimala: " + minValue);
			for(double var : binaryToReal.decodeBinary(temp)){
				System.out.print(" " + var);
			}
			brojacIteracija++;
		} while(brojacIteracija < brojIteracija);
		
		return minValue;
	}
	
	private List<Kromosom> stvoriPopulaciju(Random r, Konverter k, Funkcija f){
		List<Kromosom> novaPopulacija = new ArrayList<Kromosom>();
		
		for(int i = 0; i < velicinaPopulacije; ++i){
			novaPopulacija.add(new Kromosom(r, duljinaKromosoma, k, f));
		}
		
		return novaPopulacija;
	}
	
	private void evaluirajPopulaciju(List<Kromosom> populacija){
		double maxVrijednost = .0;
		for(int i = 0; i < populacija.size(); ++i){
			if(populacija.get(i).vrijednost > maxVrijednost)
				maxVrijednost = populacija.get(i).vrijednost;
		}
		
		for(int i = 0; i < populacija.size(); ++i){
			populacija.get(i).dobrota = maxVrijednost - populacija.get(i).vrijednost;
		}
	}
	
	public void setFunkcijaCilja(Funkcija funkcijaCilja) {
		this.funkcijaCilja = funkcijaCilja;
	}
	
	public void setMutacija(Mutacija mutacija) {
		this.mutacija = mutacija;
	}
	
	public void setKrizanje(Krizanje krizanje) {
		this.krizanje = krizanje;
	}
	
	public void setOdabir(Odabir odabir) {
		this.odabir = odabir;
	}

	public int getVelicinaPopulacije() {
		return velicinaPopulacije;
	}

	public void setVelicinaPopulacije(int velicinaPopulacije) {
		this.velicinaPopulacije = velicinaPopulacije;
	}

	public int getDonjaGranica() {
		return donjaGranica;
	}

	public void setDonjaGranica(int donjaGranica) {
		this.donjaGranica = donjaGranica;
	}

	public int getGornjaGranica() {
		return gornjaGranica;
	}

	public void setGornjaGranica(int gornjaGranica) {
		this.gornjaGranica = gornjaGranica;
	}
	
	public int getBrojVarijabli(){
		return brojVarijabli;
	}
	
	public void setBrojVarijabli(int brojVarijabli){
		this.brojVarijabli = brojVarijabli;
		this.duljinaVarijable = duljinaKromosoma / brojVarijabli;
	}
	
	public int duljinaKromosoma(){
		return duljinaKromosoma;
	}
	
	public void duljinaKromosoma(int duljinaKromosoma){
		this.duljinaKromosoma = duljinaKromosoma;
		this.duljinaVarijable = duljinaKromosoma / brojVarijabli;
	}
}
