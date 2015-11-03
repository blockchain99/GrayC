package edu.duke;

public class PrimeCheck {
	public boolean isPrime(int num){
		int div =2;
		System.out.println("sqrt("+num+") : " + Math.sqrt(num));
		if(num == 2){
			return true;
		}
		while(true){
			if( num % div == 0){
				System.out.println("It is divied by : "+ div);
				return false;
			}
			if(div > Math.sqrt(num)){
				System.out.println("Just before break, div value : " + div);
				break;
				
			}
			div += 1;
			System.out.println("divisor : " + div);
		}
		System.out.println("after break in while loop, start here ! ");
		return true;
	}
}
