package tictactoe;
import java.io.*;
public class Game {
	
	private static String[] arr = {"-","-","-","-","-","-","-","-","-"};
	private static String p1;
	private static String p2;

	public static void main(String[] args) throws IOException {
		BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
		char c;
		while(true) {
		createTable();
		System.out.println("Table created");
		System.out.println("Enter First Player's Name:\n");
		p1=obj.readLine();
		System.out.println("Enter Second Player's Name:\n");
		p2=obj.readLine();
		
		letsPlay();
		System.out.println("Enter Y/y to play again");
		c=obj.readLine().charAt(0);
		if(c=='Y' || c=='y')
			continue;
		else {
			System.out.println("Thanks for playing");
			break;
		}
			
		}
		
	}
	
	public static void createTable() {	//display updated table at beginning and after each entry
		System.out.println("-------------");
		System.out.println("| "+arr[0]+" | "+arr[1]+" | "+arr[2]+" |");
		System.out.println("-------------");
		System.out.println("| "+arr[3]+" | "+arr[4]+" | "+arr[5]+" |");
		System.out.println("-------------");
		System.out.println("| "+arr[6]+" | "+arr[7]+" | "+arr[8]+" |");
		System.out.println("-------------");
		
	}
	
	public static void letsPlay() throws IOException {
		BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
		String cond1="XXX";
		String cond2="OOO";
		
		int count=1;
		String temp="";
		
		
		while(count>0)
		{
			
			
			if(count%2!=0)
			{
				System.out.println(p1+"\'s Turn:\n");
				int Xinp=Integer.parseInt(obj.readLine());
				
				if(temp.contains(Integer.toString(Xinp)))
				{
					System.out.println("Already marked");
					count-=1;
				}
				
				else {
					temp+=Integer.toString(Xinp);
					arr[Xinp-1]="X";
					
					if(((arr[0]+arr[1]+arr[2]).equals(cond1))||((arr[3]+arr[4]+arr[5]).equals(cond1))||
							((arr[6]+arr[7]+arr[8]).equals(cond1))||((arr[0]+arr[3]+arr[6]).equals(cond1))||
							((arr[1]+arr[4]+arr[7]).equals(cond1))||((arr[2]+arr[5]+arr[8]).equals(cond1))||
							((arr[0]+arr[4]+arr[8]).equals(cond1))||((arr[2]+arr[4]+arr[6]).equals(cond1)))
					{
						createTable();
						System.out.println(p1+" is Winner");
						count=-1;
						for(int i=0;i<9;i++)
						{
							arr[i]="-";
						}
					}
					
					else
						{
							createTable();
						}
				}
				
			
			}
			
			
			else if(count%2==0)
			{
				System.out.println(p2+"\'s Turn:\n");
				int Oinp=Integer.parseInt(obj.readLine());
				
				if(temp.contains(Integer.toString(Oinp)))
				{
					System.out.println("Already marked");
					count-=1;
				}
				
				else {
					temp+=Integer.toString(Oinp);
					arr[Oinp-1]="O";
					
					if(((arr[0]+arr[1]+arr[2]).equals(cond2))||((arr[3]+arr[4]+arr[5]).equals(cond2))||
							((arr[6]+arr[7]+arr[8]).equals(cond2))||((arr[0]+arr[3]+arr[6]).equals(cond2))||
							((arr[1]+arr[4]+arr[7]).equals(cond2))||((arr[2]+arr[5]+arr[8]).equals(cond2))||
							((arr[0]+arr[4]+arr[8]).equals(cond2))||((arr[2]+arr[4]+arr[6]).equals(cond2)))
					{
						createTable();
						System.out.println(p2+" is Winner");
						count=-1;
						for(int i=0;i<9;i++)
						{
							arr[i]="-";
						}
					}
					
					
					else {
						createTable();
					}
				}
				
			}
			
	
			count++;
			
		if(count>9) {
			System.out.println("No Winner");
			for(int i=0;i<9;i++)
			{
				arr[i]="-";
			}
			
			break;	
		}
		
		
	}
	

}
}
