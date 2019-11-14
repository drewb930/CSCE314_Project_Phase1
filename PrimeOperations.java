import java.util.ArrayList; 
import java.math.BigInteger;

/*
 *  Desc: This class generates primes, twin primes, and hexagon crosses using BigInteger data types.
 */
public class PrimeOperations {
	private BigInteger primes[] = new BigInteger[20000];
	private int numPrimes = 0;
	private int mids[] = new int[20000];
	private int numMids = 0;
	private int hex[] = new int[20000];
	private int numHex = 0;
	private int totalHex = 0;
	
	Pair p = new Pair();
	// Pair class implementation.
	private class Pair<T> {
		private int twins[] = new int[20000];
		private int numTwins = 0;
		private int totalTwins = 0;
		
		public void addPair(int x, int y) {
			twins[numTwins] = x;
			numTwins++;
			twins[numTwins] = y;
			numTwins++;
			totalTwins++;
			
		}
	}
	
	// Member variables for containing out lists of integers, twin primes, hexagon crosses, and the pairs of twin primes that make up the hex crosses.
	
	// Add a prime to the prime list if and only iff it is not already in the list. (ignore duplicates)
	public void addPrime(BigInteger x)
	{
		if(!inList(x)) {
			primes[numPrimes] = x;
			numPrimes++;
		}
	}
	public void addMid(int m){
		mids[numMids] = m;
		numMids++;
	}
	
	public void addHex(int x, int y) {
		hex[numHex] = x;
		numHex++;
		hex[numHex] = y;
		numHex++;
		totalHex++;
	}
	
	// Output the prime list. Each prime should be on a separate line and the total number of primes should be on the following line.
	public void printPrimes()
	{
		for(int i = 0; i < numPrimes; i++) {
			System.out.println(primes[i] ); 
		}
		System.out.println("Total Primes: " + numPrimes);
		
	}
		
	// Output the twin prime list. Each twin prime should be on a separate line with a comma separating them, and the total number of twin primes should be on the following line.
	public void printTwins()
	{
		for(int i = 0; i < p.numTwins - 1; i = i + 2) {
			System.out.println(p.twins[i] + ", " + p.twins[i+1]);
		}
		System.out.println("Total Twins: " + p.totalTwins);
	}
		
	// Output the hexagon cross list. Each should be on a separate line listing the two twin primes and the corresponding hexagon cross, with the total number on the following line.
	public void printHexes()
	{
		for(int i = 0; i < numHex; i = i + 2) {
			System.out.println("Prime Pairs: " + (hex[i]-1) + ", " + (hex[i]+1) + " and " + (hex[i+1]-1) + ", " + (hex[i+1]+1) + " seperated by " + hex[i] + ", " + hex[i+1]);
		}
		System.out.println("Total Hexes: " + totalHex);
	}
		
	// Generate and store a list of primes.
	public void generatePrimes(int count1)
	{
		for(int i = 1; i < count1; i++) {
			if(isPrime(i)) {
				BigInteger b1 = BigInteger.valueOf(i);
				addPrime(b1);
			}
		}
		
	}
	
	// Generate and store a list of twin primes.
	public void generateTwinPrimes()
	{
		for(int i = 0; i < numPrimes - 1; i++) {
			if((primes[i+1].intValue() - primes[i].intValue()) ==  2) {
				p.addPair(primes[i].intValue(),primes[i+1].intValue());
				addMid(primes[i].intValue() + 1);
			}
		}
	}
	
	// Generate and store the hexagon crosses, along with the two twin primes that generate the hexagon cross.
	public void generateHexPrimes()
	{
		
		for(int i = 0; i < numMids; i++) {
			for(int j = i; j < numMids; j++) {
				
				if( mids[i] * 2 == mids[j]) {
					addHex(mids[i], mids[j]);
				}
			}
		}
		
	}
	public boolean inList(BigInteger x) {
		for(int i = 0; i < numPrimes; i++) {
			if(primes[i] == x) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isPrime(int p) {
		if( p == 1) {
			return true;
		}
		else {
			for(int i = 2; i < p; i++) {
				if(p % i == 0) {
					return false;
				}
			}
		}
		return true;
	}
}
