import java.lang.reflect.Array;
import java.util.Arrays;

public class DescribeNumbers {
    public static int[] stringsToInts(String[] numbers) {
        int[] arr2 = new int[numbers.length]; //instantiate array of type int in the size of command line arguments.
        for (int i = 0; i < numbers.length; i++) {
            arr2[i] = Integer.parseInt(numbers[i]);
        }
        return arr2;
    }
    public static int min(int[] numbers) {
        int min = numbers[0];
        for (int i=1; i<numbers.length;i++) {
            if(min>numbers[i]) {
                min = numbers[i];
            }
        }
        return min;
    }
    public static int max(int[] numbers) {
        int max = numbers[0];
        for (int i=1; i<numbers.length;i++) {
            if(max<numbers[i]) {
                max = numbers[i];
            }
        }
        return max;
    }
    public static float avg(int[] numbers) {
        int i = 0;
        int avg = 0;
        for(;i<numbers.length;i++) {
            avg+=numbers[i];
        }
        return avg/numbers.length;
    }
    public static void main(String[] args) {
        int[] arr = stringsToInts(args);
        System.out.println("min:" + min(arr)+"\nmax:" +max(arr) +"\navg: "+avg(arr));
    }
}
