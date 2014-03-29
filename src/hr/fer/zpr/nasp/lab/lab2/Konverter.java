package hr.fer.zpr.nasp.lab.lab2;

import java.util.ArrayList;
import java.util.List;

public class Konverter {
	
	private int donjaGranica;
	private int gornjaGranica;
	private int duljinaVarijable;
	private int brojVarijabliUnutarKromosoma;
	
	public Konverter(int donjaGranica, int gornjaGranica, int duljinaVarijable, int brojVarijabliUnutarKromosoma){
		this.donjaGranica = donjaGranica;
		this.gornjaGranica = gornjaGranica;
		this.duljinaVarijable = duljinaVarijable;
		this.brojVarijabliUnutarKromosoma = brojVarijabliUnutarKromosoma;
	}
	
	private List<byte[]> splitVars(Kromosom k){
		List<byte[]> varijable = new ArrayList<byte[]>();
		byte[] tempKromosom;
		for(int i = 0; i < brojVarijabliUnutarKromosoma; ++i){
			tempKromosom = new byte[duljinaVarijable];
			for(int j = 0; j < duljinaVarijable; ++j){
				tempKromosom[j] = k.bitoviKromosoma[duljinaVarijable * i + j];
			}
			varijable.add(tempKromosom);
		}
		return varijable;
	}
	
	public double[] decodeBinary(Kromosom k){
		List<byte[]> binarneVarijable = splitVars(k);
		double[] realneVarijable = new double[binarneVarijable.size()];
		for(int i = 0; i < binarneVarijable.size(); ++i){
			int intValue = 0;
			byte[] temp = binarneVarijable.get(i);
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < temp.length; ++j){
				sb.append(temp[j]);
			}
			intValue = Integer.parseInt(sb.toString(),2);
			realneVarijable[i] = donjaGranica + ((intValue)/(Math.pow(2, duljinaVarijable) - 1)) * (gornjaGranica - donjaGranica);
		}
		return realneVarijable;
	}
}
