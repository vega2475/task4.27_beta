//Input - Index of monotonic number
//Output - monotonic number
import java.util.Scanner;

public class Main {

    static int readNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write index: ");
        return scanner.nextInt();
    }


    public static boolean isMonotonic(int num) {
       int n = num;
       int b = n % 10 - (n/10)%10;
       n/=10;
       if(n < 10) return true;
       while(n > 0 && n > b){
           if(n % 10 - (n/10)%10 != b){
               return false;
           }
           n/=10;
       }
       return true;
    }








    static int functionForCountNumbers(){
        int index = readNumber();
        while (index < 0) {
                 System.out.println("number shouldn't be negative");
                 index = readNumber();
        }
        if (index < 100) return index;
        int count = 100;
        int candidate = 123; // the first monotonic number, which should correspond to n = 100

        while (count < index) {
            if (isMonotonic(candidate)) {
                count++;
            }
            candidate++;

        }

        return candidate;
    }



    public static void main(String[] args){
        System.out.println(functionForCountNumbers());
    }

}