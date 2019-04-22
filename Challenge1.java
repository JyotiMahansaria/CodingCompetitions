/*
 
Tiger Shah and Battleships

Tiger Shah has been hired to write a program to analyze strategic data for the Scandinavian Navy.His task is described below. 
There are L battleships represented as L points on the plane. The radius of a ship is defined to be the distance from that ship to the ship closest to it. The effective set for a ship is defined to be the set of all ships (excluding itself) which are at a distance from that ship of no more than twice its radius. The number of elements in the effective set of a ship is called the effective value of that ship.Tiger Shah needs to write a program to calculate the radius and the effective value of each battleship. This task is so tough that without your help, Tiger Shah could never finish it. Let's help him!

Input Format
The first line contains t, the number of test cases. Then t test cases follow.
Each test case has the following form:
The first line contains an integer L, the number of battleships.
Each of the next L lines contains two integers X, Y (space separately) which represents the coordinates of a battleship.

Note: There may be more than one ships located at the same place.

Constraints
1<= t <=5
1 <= L <= 30000
0 <= X, Y <= 10000

Output Format
For each test case, print L lines. Each line should contain two numbers which are the radius and the effective value of the corresponding battleship. The radius should be rounded to 2 decimal points.

Sample TestCase 1
Input
2
3
0 0
0 0
3 4
5
5 3
7 8
0 9
3 1
4 4
Output
0.00 1
0.00 1
5.00 2
1.41 2
5.00 4
6.40 4
2.83 2
1.41 1
 
*/

import java.io.*;
import java.util.*;
public class TecGig1 {
    public static void main(String args[] ) throws Exception {
     
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        for(int t = 1; t <= numberOfTests; t++){
            int numberOfShips = scanner.nextInt();
            int[][] co_ordinates = new int[numberOfShips][2];
            for(int s = 1; s<= numberOfShips ; s++){
                co_ordinates[s-1][0] = scanner.nextInt();
                co_ordinates[s-1][1] = scanner.nextInt();
            }
            for(int i = 0; i < co_ordinates.length ; i++){
                Double radius = null;
                double[] distances = new double[co_ordinates.length];
                for(int j = 0; j < co_ordinates.length ; j++){
                    if(i != j){
                        double distance = Math.sqrt(((co_ordinates[i][0]- co_ordinates[j][0]) * (co_ordinates[i][0]- co_ordinates[j][0])) 
                        										+ ((co_ordinates[i][1]- co_ordinates[j][1]) * (co_ordinates[i][1]- co_ordinates[j][1])));
                        distances[j] = distance;
                        if(radius == null || distance < radius){
                            radius = distance;
                        }
                    }else{
                       distances[j] = -1; 
                    }
                }
                int count = 0;
                for(int d = 0; d < distances.length ; d++){
                        if(distances[d] != -1 && distances[d] <= (2 * radius)){
                            count++;
                        }
                }
                System.out.printf("%.2f", radius); System.out.println(" " + (count));
            }
        }

   }
}
