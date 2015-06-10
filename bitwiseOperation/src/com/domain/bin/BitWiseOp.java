package com.domain.bin;


public class BitWiseOp {

	/**
	 * this is a simple bit operations execise.
	 * can be run in an ide or other tool.
	 * 
	 * The java class can be compiled and run and the exercise will print out what you need to do to get to next step.
	 * your solution should be written in the switch case and for corresponding case. e.g. step 1, should be written in switch case 1 and so on.
	 * the result of the operation should be stored in the aByte variable.
	 * 
	 * Here is some bit operations available, some will be used in the exercise.
	 * Operator		Name			Example		Result	Description
	 *	a & b		and				3 & 5		1		1 if both bits are 1.
	 *	a | b		or 				3 | 5 		7		1 if either bit is 1.
	 *	a ^ b		xor 			3 ^ 5 		6		1 if both bits are different.
	 *	~a			not 			~3 			-4		Inverts the bits.
	 *  n << p		left shift		3 <<< 2		12		Shifts the bits of n left p positions. Zero bits are shifted into the low-order positions.
	 *	n >> p		right shift		5 >> 2		1		Shifts the bits of n right p positions. If n is a 2's complement signed number, the sign bit is shifted into the high-order positions.
	 * 
	 * reference: 
	 *   http://www.fredosaurus.com/notes-java/data/expressions/bitops.html
	 *   http://www.vipan.com/htdocs/bitwisehelp.html
	 * 
	 */
	
	// using binary literals since java 0111
	static byte aByte = 0b00000000;

	public static void main(String[] args){
		int step = 0;
		
		while(workingStepOk(step)){
			step++;
			switch(step){
				case 1:
					// do your bit operations, to pass step 1 here:
					
//					aByte = 
					
					// end
					break;
				case 2:
					// do your bit operations  to pass step 2 here:
					
//					aByte = 
					
					// end
					break;
				case 3:
					// do your bit operations  to pass step 3 here:
					
//					aByte = 
					
					// end
					break;
				case 4:
					// do your bit operations  to pass step 4 here:
					
//					aByte = 
					
					// end
					break;	
				
			}
			
			System.out.println("aByte is now: "+ aByte);
		}
	}
	
	
	public static boolean workingStepOk(int step){
		boolean result = false;
		if(step == 0){
			System.out.println("use the or operator '|' to turn on bits in the aByte variable, so it matches: "+ step1);
			return true;
		}
		if(aByte == step1 && step == 1){
			printLines(3);
			System.out.println("good :)");
			System.out.println("use the shift operators '<<' or '>>' on the aByte variable,so it matches: "+ step2);
			return true;
		}
		
		if(aByte == step2 && step == 2){
			printLines(3);
			System.out.println("good :)");
			System.out.println("use the invert operator '~' on the aByte variable, so it matches: "+ step3);
			return true;
		}
		
		if(aByte == step3 && step == 3){
			printLines(3);
			System.out.println("good, this is fun :)");
			System.out.println("lets check a proper case, logging. other cases could be access rights for users");
			System.out.println("if logging uses the binary pattern, one can use levels that can be easily checked.");
			System.out.println("check the doLog() function.");
			System.out.println("setting the aByte to log nothing");
			aByte = NOTHING;
			System.out.println("use the or operator '|' to get logging for info and error: ");
			return true;
		}


		if(doLog(aByte, INFO) && step == 4){
			System.out.println("loggin info");
		}
		
		if(doLog(aByte, ERROR) && step == 4){
			System.out.println("loggin error");
		}

		if(doLog(aByte, DEBUG) && step == 4){
			System.out.println("loggin debug");
		}
		
		return result;
	}
	
	public static void printLines(int lines){
		int did = 0;
		while(lines > did++){
			System.out.println("");
		}
	}
	
	static byte step1 = 0b00000010;
	static byte step2 = 0b00000100;
	static byte step3 = (byte)0b11111011;
	static byte debug = (byte)0b00100000;
	
	
	public static final int NOTHING = 0;
	public static final int INFO = 4;
    public static final int ERROR = 16;
    public static final int DEBUG = 32;

    
    public static boolean doLog( int currentLogLevel, int logLevel) {
            return ((currentLogLevel & logLevel) == logLevel);
        }
}




































// solution below











































//switch(step){
//case 1:
//	// do your bit operations here:
//	aByte = (byte) (aByte | 0b00000010);
//	// end
//	break;
//case 2:
//	// do your bit operations here:
//	aByte = (byte) (aByte << 1);
//	// end
//	break;
//case 3:
//	// do your bit operations here:
//	aByte = (byte) ~aByte;
//	// end
//	break;
//case 4:
//	// do your bit operations here:
//	aByte = INFO | ERROR;
//	// end
//	break;	
//}
