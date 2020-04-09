import java.util.HashMap;
public class Calculations 
{
	//footprint==tons of carbon per year
	double footprint;
	HashMap<String, Double> foods;
	HashMap<String, Double> cars;
	
	
	//input variables
	public Calculations(String givenMeat, String givenDairy, String givenFat, String givenGrain, double unitsMeat, double unitsVegFruit, double unitsDairy, double unitsFats, double unitsGrain, double givenMiles, String vehicleType)
	{
		initializeHashmaps();
		double foodFootprint = foodCalculations(givenMeat, givenDairy, givenFat, givenGrain, unitsMeat, unitsVegFruit, unitsDairy, unitsFats, unitsGrain);
		double transportationFootprint=transportationCalculations(givenMiles, vehicleType);
		footprint=foodFootprint+transportationFootprint;
	}
	
	private void initializeHashmaps() 
	{
		// TODO Auto-generated method stub
		
	}

	//do calculations
	public double transportationCalculations(double givenMiles, String vehicleType)
	{
		//get mpg based on cartype.
		double mpg=25.0;
		for (String vehicle:cars.keySet())
		{
			if (vehicleType.equals(vehicle))
			{
				mpg=cars.get(vehicle);
			}
		}
		
		//lbs of CO2 per gallon
		int lbpg=20;
		
		double totalPounds=givenMiles*(1/mpg)*lbpg;
		
		//pounds to ton
		int lbpt=2000;
		
		double totalTonsperYear=totalPounds*365/lbpt;
		return totalTonsperYear;
	}
	
	public double foodCalculations(String givenMeat, String givenDairy, String givenFat, String givenGrain, double kilosMeat, double kilosVegFruit, double kilosDairy, double kilosFats, double kilosGrain)
	{
		//kilos of c02 released from one kilo of given food, with data from (https://www.greeneatz.com/foods-carbon-footprint.html)
		double meat = 20.0;
		double dairy = 1.9;
		double fat = 2.3;
		double grain = 2.7;
		double vegetables = 2.0;
		
		double totalKilos=(kilosMeat*meat)+(kilosDairy*dairy)+(kilosFats*fat)+(kilosGrain*grain)+(kilosVegFruit*vegetables);
		
		//kilos to ton
		int kpt=907;
		
		double totalTonsperYear=totalKilos*365/kpt;
		return totalTonsperYear;
	}
	
	//output the variables
	public double getFootprint()
	{
		return footprint;
	}
}
