package practiceWorld;

public class primitiveTypes {
	
	public static void main(String[] args) {
		
		int myValue = 10000;
		
		int myMinIntValue = Integer.MIN_VALUE;
		int myMaxIntValue = Integer.MAX_VALUE;
		System.out.println("Integer Minimum Value = " + myMinIntValue);
		System.out.println("Integer Maximum Value = " + myMaxIntValue);
		System.out.println("Busted Max Value = " + (myMaxIntValue +1));
		System.out.println("Busted MIN Value = " +( myMinIntValue - 1));
	}
	
}
