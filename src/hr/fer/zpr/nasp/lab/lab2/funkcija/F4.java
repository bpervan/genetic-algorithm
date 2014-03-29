package hr.fer.zpr.nasp.lab.lab2.funkcija;

public class F4 implements Funkcija{

	@Override
	public double getValue(double[] x) {
		double temp1 = x[0] - x[1];
		double temp2 = x[0] + x[1];
		
		return Math.abs(temp1 * temp2) + Math.sqrt((x[0] * x[0] + x[1] * x[1]));
	}
	
	public int numVar(){
		return 2;
	}

}
