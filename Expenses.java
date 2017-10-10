import java.util.*;
import java.io.*;
import java.util.Arrays.*;
/**
* @author Abhishek
* @version 0.1
*/

public class Expenses{

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		System.out.println("Hello! Enter number of people (max 26) whose expenses need to be managed.");
		int n = in.nextInt();
		startApp(n);
		System.out.println("Hope to see you soon! Bye.");
	}

	public static void startApp(int n) throws Exception{		
		int data[][] = new int[n][n];
		for (int[] row : data)
		    Arrays.fill(row, 0);
		while(true){
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("\nMain menu");
			System.out.println("1. Add an expense");
			System.out.println("2. Show expenses");
			System.out.println("3. Exit application");
			int choice = Integer.parseInt(br.readLine());

			if(choice == 3){
				break;
			}

			else if(choice == 2){
				int check = 0;
				for (int i=-1; i<n; i++) {
					if (i==0)	check = 0;
					for (int j=-1; j<n; j++) {
						if (i==-1 || j==-1){
							if (j!=i)	System.out.print((char)(check++ + 'A')); /****/
						}
						else
							System.out.print(data[i][j]);
						System.out.print("\t");
					}
					System.out.println();
				}
			}

			else if(choice == 1){
				System.out.println("\nEnter in this format \"<person> <expense>\"");
				String inp = br.readLine();
				String[] input = inp.split("\\s+");
				char person = input[0].charAt(0);
				int amount = Integer.parseInt(input[1])/n;
				int j = person - 'A';
				for (int i=0; i<n; i++) {
					if(i!=j){
						if (data[j][i] > 0){ 
							data[i][j] = data[i][j] + amount - data[j][i];
							if(data[j][i]-amount <0)
								data[j][i]=0;							
						}
						else
							data[i][j] += amount;
					}
				}
			}
		}
	}
}