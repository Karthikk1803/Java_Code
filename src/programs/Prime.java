package programs;

public class Prime {
    public static String isPrime(int a) {
        boolean flag = true;
        for (int i = 2; i < Math.sqrt(a); i++) {
            if (a % i == 1) {
                flag = false;
                break;
            }
        }
        return flag ? "Prime" : "NotPrime";
    }
}
