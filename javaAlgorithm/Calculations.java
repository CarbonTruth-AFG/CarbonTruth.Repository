import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
public class Calculations 
{
	//footprint==tons of carbon per year
	private double footprint;
	private HashMap<String, Double> foodLibrary;
	private HashMap<String, Double> vehicleLibrary;
	
	//input variables
	public Calculations(String givenMeat, String givenDairy, String givenFat, String givenGrain, double unitsMeat, double unitsVegFruit, double unitsDairy, double unitsFats, double unitsGrain, double givenMiles, String vehicleType)
	{
		initializeHashmaps();
		double foodFootprint = foodCalculations(givenMeat, givenDairy, givenFat, givenGrain, unitsMeat, unitsVegFruit, unitsDairy, unitsFats, unitsGrain);
		double transportationFootprint=transportationCalculations(givenMiles, vehicleType);
		footprint=foodFootprint+transportationFootprint;
	}

	//do calculations
	public double transportationCalculations(double givenMiles, String vehicleType)
	{
		//get mpg based on cartype.
		double mpg=25.0;
		for (String vehicle:vehicleLibrary.keySet())
		{
			if (vehicleType.equals(vehicle))
			{
				mpg=vehicleLibrary.get(vehicle);
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
		//change from tons per year to lbs per day
		return footprint;
	}
	
	private void initializeHashmaps()
	{
		readAndInitializeHashmapData("file name for cars", vehicleLibrary);
		readAndInitializeHashmapData("file name for food", foodLibrary);
	}
	
	//code from TriviaGame where CSV file is read.
	 private void readAndInitializeHashmapData(String fileName, HashMap<String, Double> hashmap)
	    {
		 	//getResources() is an Android Studio command, looking for resources in the project.
	        InputStream is = getResources().openRawResource(R.raw.fileName);

	        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

	        String line = "";
	        try
	        {
	            while ((line = reader.readLine())!=null)
	            {
	                String[] fields = line.split(",");

	                hashmap.put(fields[0], Double.parseDouble(fields[1]));

	                //this is for decoding purposes only
	                //Log.v("MainActivity", fields[0] + " " + fields[1]);
	            }
	        }
	        catch(IOException e)
	        {
	            //again, only for decoding purposes
	        	//Log.wtf("MainActivity", "Error reading data on line: "+line);
	        }
	    }
}
