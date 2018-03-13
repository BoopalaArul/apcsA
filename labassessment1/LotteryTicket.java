package labassessment1;

public class LotteryTicket {

	private String nameOfBuyer;
	private int[] numberList;
	
	private boolean search(int toFind)
	{
		for(int i = 0; i < numberList.length; i++)
		{
			if(numberList[i] == toFind)
			{
				return true;
			}
		}
		return false;
	}
	
	public LotteryTicket(String name)
	{
		nameOfBuyer = name;
		numberList = new int[10];
		for(int i = 0; i < numberList.length; i++)
		{
			int j = (int) Math.random()*50+1;
			while(!this.search(j))
			{
				j = (int) Math.random()*50+1;
			}
			numberList[i] = j;
		}
	}
	
	public double getPercentThatMatch(int[] winningNumbers)
	{
		double count = 0;
		for(int i = 0; i < 10; i++)
		{
			if(search(winningNumbers[i]))
			{
				count++;
			}
		}
		return count/10;
	}
	
	public String getName()
	{
		return nameOfBuyer;
	}

	
}
