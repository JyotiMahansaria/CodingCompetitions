//You will be given an integer n. You need to return the count of prime numbers less than or equal to n.

public class Solution {
    public int solve(int A) {
        int countOfPrimeNumber = 0;
        for(int i = 1; i <=A; i++){
            if(isPrimeNumber(i)){
                countOfPrimeNumber++;
            }
        }
        return countOfPrimeNumber;
    }
// If A Number has exactly 2 factors then its a Prime Number. 1 is not a prime number as it has only 1 factor. 
    public boolean isPrimeNumber(int A) {
        int count = countFactors(A);
        if(count == 2){
            return true;
        }
        return false;
    }

    public int countFactors(int A){
        int count = 0;
        for(int i = 1; i <= Math.sqrt(A); i++){
            
            if(A%i == 0){ // check if i is a factor
                if(i == A/i){ // check if its a perfect square root
                    count++;
                }else{
                    count = count+2;
                }
            }
        }
        return count;
    }
}
