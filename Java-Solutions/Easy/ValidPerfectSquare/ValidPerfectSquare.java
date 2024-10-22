/*Question: Given a positive integer num, return true if num is a perfect square or false otherwise.*/
// without using "sqrt" function.
import java.util.Scanner;

public class ValidPerfectSquare {
      static boolean validPerfectSquare(int num) {
            if(num == 1) {
                  return true;
            }
            long start = 2;
            long end = num / 2;

            while(start <= end) {
                  long mid = (start + (end - start)) / 2;
                  long currentSquare = (mid * mid);

                  if(currentSquare == num) {
                        return true;
                  }
                  else if(currentSquare > num) {
                        end = mid - 1;
                  }
                  else {
                        start = mid + 1;
                  }
            }
            return false;
      }
      public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            System.out.print("Value of number(num): ");
            int num = input.nextInt();
            System.out.println("The given number "+num+" is valid perfect square: "+validPerfectSquare(num));
      }
}