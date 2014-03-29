package hr.fer.zpr.nasp.lab.lab2.funkcija;

public class F7 implements Funkcija{
	
	
	
	@Override
	public double getValue(double[] x) {
		double sum = getSquaredAndSumedValue(x);
		
		double prviClan = Math.pow(sum, .25);
		double tempDrugogClana = Math.sin(50 * Math.pow(sum, .1));
		double drugiClan = tempDrugogClana * tempDrugogClana + 1;
		
		return prviClan * drugiClan;
	}
	
	private double getSquaredAndSumedValue(double[] x){
		double temp = .0;
		for(int i = 0; i < x.length; ++i){
			temp += (x[i] * x[i]);
		}
		return temp;
	}

}
