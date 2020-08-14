public class Factorial {
    /**
     * calculate factorial in regualr method
     * @param n
     * @return
     */
    public static long factorialIter(long n) {
        long i = (n-1);

        while(i>1) {
            n=n*i;
            i--;
        }
        return n;
    }

    /**
     * calculate factorial in recursive metohd
     * @param n
     * @return
     */
    public static long factorialRecursive(long n) {
        if(n==1) {
            return 1;
        }
        return n * factorialRecursive(n-1);
    }
    /*public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        System.out.println("recursive:" + factorialRecursive(n));
        System.out.println("iterative:" + factorialIter(n));

    }*/
}
