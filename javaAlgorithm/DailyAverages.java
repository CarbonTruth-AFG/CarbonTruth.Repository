import java.util.ArrayList;

public class DailyAverages 
{
	private ArrayList<Double> pastFootprints;
	private String lastTime;
	
	private int maxSize;
	private int maxDaysNull;
	
	public DailyAverages(int givenMaxSize, int givenMaxDaysNull)
	{
		//simply initializes this database
		pastFootprints=new ArrayList<Double>();
		
		maxSize=givenMaxSize;
		maxDaysNull=givenMaxDaysNull;
	}
	
	public void updateDay(double footprintForDay)
	{
		//check and see when the last time user inputed data using the lastTime string. if it's been over the time limit, erase the current data.
		
		//-1 is the value that will be returned if the user hasn't inputted any data for the current day
		if (footprintForDay!=-1)
		{
			updatePastFootprints(footprintForDay);
		}
	}

	private void updatePastFootprints(double footprintForDay) 
	{
		if (pastFootprints.size()==maxSize) 
		{
			pastFootprints.remove(0);
			pastFootprints.add(footprintForDay);
		}
		else 
		{
			pastFootprints.add(footprintForDay);
		}
	}
}
