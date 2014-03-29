package hr.fer.zpr.nasp.lab.lab2.funkcija;

public class F6 implements Funkcija{

	@Override
	public double getValue(double[] x) {
		double sum = getSquaredAndSumedValue(x);
		double temp1 = Math.sin(Math.sqrt(sum));
		double brojnik = temp1 * temp1  - .5;
		
		double temp2 = (1 + .001 * sum);
		double nazivnik = temp2 * temp2;
		
		
		return .5 + (brojnik/nazivnik);
	}
	
	private double getSquaredAndSumedValue(double[] x){
		double temp = .0;
		for(int i = 0; i < x.length; ++i){
			temp += (x[i] * x[i]);
		}
		return temp;
	}

}
