package hr.fer.zpr.nasp.lab.lab2.funkcija;

public class F6Predavanja implements Funkcija{

	@Override
	public double getValue(double[] x) {
		double temp1 = x[0] * x[0] + x[1] * x[1];
		double podSinusom = Math.sqrt(temp1);
		double megaSinus = Math.sin(podSinusom);
		
		double brojnik = megaSinus * megaSinus - .5;
		
		double nazivnik = 1 + .001 * (temp1);
		
		return .5 - (brojnik / (nazivnik * nazivnik));
		}

}
