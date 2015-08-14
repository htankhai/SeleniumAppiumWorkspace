package coreJava;
/** prints the numbers from 1 to 100. But, multiples of 3 should be replaced with “Bud 3”,
 *  multiples of 5 should be replaced with “Bud 5” and multiples of both 3 and 5 
 *  should be replaced with “Bud 3 and 5”
 */
public class Bud3and5 {
	public static void main(String args[]) {
		for(int i = 1; i <= 200; i++) {
			if((i % (3*5)) == 0) {
				System.out.println("Bud 3 and 5");
			}
			else if ((i % 5) == 0) {
				System.out.println("Bud 5");
			}
			else if ((i % 3) == 0) {
				System.out.println("Bud 3");
			}
			else {
				System.out.println(i);
			}
		}
	}
}
