//Chapter4 - Exercise P4.11
public class CashRegisterGiveChange
{
	public static final double DOLLAR = 1;
	public static final double QUARTER = 0.25;
	public static final double DIME = 0.1;
	public static final double NICKEL = 0.05;
	public static final double PENNY = 0.01;
	
	private double purchase;
	private double change;
	private double dollar;
	private double quarter;
	private double dime;
	private double nickel;
	private double penny;
	
	public CashRegisterGiveChange()
	{
	purchase = 0;
	change = 0;
	dollar = 0;
	quarter = 0;
	dime = 0;
	nickel = 0;
	penny = 0;
	}
	
	public void addPurchase (double amount)
	{
	this.purchase = this.purchase + amount; //value = 8.37
	}
	
	public void addPayment (double Dollar, double Quarter, double Dime, double Nickel, double Penny)
	{
	this.dollar = this.dollar + Dollar; //value = 10
	this.quarter = this.quarter + Quarter; //value = 0
	this.dime = this.dime + Dime; //value = 0
	this.nickel = this.nickel + Nickel; //value = 0
	this.penny = this.penny + Penny; //value = 0
		
	}
	
	public double getChange()
	{
	this.change = dollar + quarter + dime + nickel + penny - purchase; //value = (10+0+0+0+0) - 8.37
	return this.change;
	}
	
	public int returnDollar()
	{
	int Doll = (int)(change/DOLLAR); //value = 1.63/1 = 1
	return Doll;
	}
	
	public int returnQuarter()
	{
	int Quar = (int)(change/DOLLAR); //value = 1.63/1 = 1
	double Qua = (double)(change-Quar); //value = 1.63-1 = 0.63
	int Q = (int)(Qua/QUARTER); //value = 0.63/0.25 = 2
	return Q;
	}
	
	public int returnDime()
	{
	int Dim = (int)(change/DOLLAR); //value = 1.63/1 = 1
	double Di = (double)(change-Dim); //value = 1.63-1 = 0.63
	int D = (int)(Di/QUARTER); //value = 0.63/0.25 = 2
	double D2 = (double)(D*QUARTER); //value = 2*0.25 = 0.5
	double D3 = (double)(change-(Dim+D2)); //value = 1.63-(1+0.5) = 0.13
	int D4 = (int)(D3/DIME); //value = 0.13/0.1 = 1
	return D4;
	}
	
	public int returnNickel()
	{
	int Nick = (int)(change/DOLLAR); //value = 1.63/1 = 1
	double Nic = (double)(change-Nick); //value = 1.63-1 = 0.63
	int Ni = (int)(Nic/QUARTER); //value = 0.63/0.25 = 2
	double N = (double)(Ni*QUARTER); //value = 2*0.25 = 0.5
	double N2 = (double)(change-(Nick+N)); //value = 1.63-(1+0.5) = 0.13
	int N3 = (int)(N2/DIME); //value = 0.13/0.1 = 1
	double N4 = (double)(N3*DIME); //value = 1*0.1 = 0.1
	double N5 = (double)(change-(Nick+N+N4)); //value = 1.63-(1+0.5+0.1) = 0.03
	int N6 = (int)(N5/NICKEL); //value = 0.03/0.05 = 0
	return N6;
	}
	
	public int returnPenny()
	{
	int Penn = (int)(change/DOLLAR); //value = 1.63/1 = 1
	double Pen = (double)(change-Penn); //value = 1.63-1 = 0.63
	int Pe = (int)(Pen/QUARTER); //value = 0.63/0.25 = 2
	double P = (double)(Pe*QUARTER); //value = 2*0.25 = 0.5
	double P2 = (double)(change-(Penn+P)); //value = 1.63-(1+0.5) = 0.13
	int P3 = (int)(P2/DIME); //value = 0.13/0.1 = 1
	double P4 = (double)(P3*DIME); //value = 1*0.1 = 0.1
	double P5 = (double)(change-(Penn+P+P4)); //value = 1.63-(1+0.5+0.1) = 0.03
	int P6 = (int)(P5/NICKEL); //value = 0.03/0.05 = 0
	double P7 = (double)(P6*NICKEL); //value = 0*0.05 = 0
	double P8 = (double)(change-(Penn+P+P4+P7)); //value = 1.63-(1+0.5+0.1+0) = 0.03
	int P9 = (int)(P8/PENNY); //value = 0.03/0.01 = 3
	return P9;
	}
}
	
	
	
	
	
	
	