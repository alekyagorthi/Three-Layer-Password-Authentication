import java.util.*;
class examp
{
	public static void main(String args[])
	{
		double amount=10600;
		double intrest=10.25;
		int Years=25;
		for(int i=0;i<Years;i++)
		{
			amount=amount+((intrest*amount)/100);
		}
		System.out.println(amount);
	}
}
