/* You are given an integer array prices where prices[i] is the price of a given stock on the ith day... On each day, you may decide to buy and/or sell the stock... You can only hold at most one share of the stock at any time... However, you can buy it then immediately sell it on the same day... Find and return the maximum profit you can achieve...
 * Eg 1: Prices = [7, 1, 5, 3, 6, 4]      Output = (5-1) + (6-3) = 4 + 3 = 7
 * Eg 2: Prices = [1, 2, 3, 4, 5]         Output = (5-1) = 4
 * Eg 3: Prices = [4, 1, 2, 5, 3, 8, 2]   Output = (5-1) + (8-3) = 4 + 5 = 9
*/
import java.util.*;
public class Stocks
{
    public int MaximumProfit(Vector<Integer> vec)    // Using Dynamic Programming...
    {
        int x = vec.get(0);     // Initializing variables... 
        int profit = 0;
        for(int i = 0; i < vec.size()-1; i++)
        {
            if(vec.get(i) < x || x == 0)     // If next values is less or x is zero...
                x = vec.get(i);
            else if(vec.get(i) > x && vec.get(i+1) < vec.get(i))
            {   // If next value is less than the current... but current value is greater than x...
                profit = profit + (vec.get(i) - x);    // Evaluating profit...
                System.out.println("The profit : "+vec.get(i)+" - "+x+" = "+profit);
                x = 0;      // Setting x to satisfy base condition...
            }
            if(i+1 == vec.size()-1 && x < vec.get(i) && profit == 0)
                profit = profit + (vec.get(i+1) - x);    // Evaluating profit...
        }
        return profit;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int x, a;
        System.out.print("Enter the size of the list : ");
        x = sc.nextInt();
        Vector<Integer> prices = new Vector<Integer>(x);    // Vector list created...
        for(int i = 0; i < x; i++)
        {
            System.out.print("Enter data : ");
            a = sc.nextInt();
            prices.add(i, a);    // Vector add method...
        }
        Stocks stocks = new Stocks();    // Object creation and function calling...
        System.out.println("The Maximum profit achieved : "+stocks.MaximumProfit(prices));
        sc.close();
    }
}

// Time Complexity -    O(n) time...
// Space Complexity -   0(1) space...