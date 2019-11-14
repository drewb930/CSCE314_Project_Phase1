public class Project1 {
	public static void main(String[] args) 
	{
		// Instantiate Primes Class
		PrimeOperations testOne = new PrimeOperations();


		//generate Primes and test.
		testOne.generatePrimes(72);
		testOne.printPrimes();
		
		// Generate and test Twin Primes
		PrimeOperations testTwo = new PrimeOperations();
		testTwo.generatePrimes(550);
		testTwo.generateTwinPrimes();
		testTwo.printTwins();
		
		
		// Generate and test Hexagonal crosses
		PrimeOperations testThree = new PrimeOperations();
		testThree.generatePrimes(15000);
		testThree.generateTwinPrimes();
		testThree.generateHexPrimes();
		testThree.printHexes();
	}
}
