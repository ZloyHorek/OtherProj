import java.util.*;

public class PrimesGenerator {
        public static ArrayList<Integer> generatePrimes(int n) {

            ArrayList<Integer> primes = new ArrayList<>();
            for (int i = 2; i <= n; i++) {
                boolean isPrime = true;
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    primes.add(i);
                }
            }
            return primes;
        }
        public static void Reverse(ArrayList<Integer>primes) {
            ListIterator<Integer> iterator = primes.listIterator(primes.size());
            while (iterator.hasPrevious()) {
                Integer element = iterator.previous();
                System.out.print(element+" ");
            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n2=sc.nextInt();
            ArrayList<Integer> primes = generatePrimes(n2);
//            primes.sort(Comparator.reverseOrder());
            System.out.println(primes);
            Reverse(primes);
        }
    }

