package hr.fer.zpr.nasp.lab.lab2.funkcija;

public class F3 implements Funkcija{
	
	private double[] p;
	
	public F3(double[] p){
		this.p = p;
	}

	@Override
	public double getValue(double[] x) {
		double temp1 = x[0] - p[0];
		double temp2 = x[1] - p[1];
		double temp3 = x[2] - p[2];
		double temp4 = x[3] - p[3];
		double temp5 = x[4] - p[4];
		
		return temp1 * temp1 + temp2 * temp2 + temp3 * temp3 + temp4 * temp4 + temp5 * temp5;
	}
	
	public int numVar(){
		return p.length;
	}
}
