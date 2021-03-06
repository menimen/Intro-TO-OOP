import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] str = DescribeNumbers.stringsToInts(args);
        bubbleSort1(str);
        sortASC(str);
        sortDESC(str);
    }
    public static void sortASC(int[] str) {
        int i = 0;
        while(i<str.length) {
            System.out.print(str[i]+" ");
            i++;
        }
        System.out.println();
    }
    public static void sortDESC(int[] str) {
        int i = str.length-1;
        while(i >= 0 ) {
            System.out.print(str[i] + " ");
            i--;
        }
    }
    public static void swap(int i , int j, int arr[]){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void bubbleSort1(int arr[]) {
        for(int i =0;i<arr.length;i++) {
            for(int j=0;j<arr.length-i-1;j++) {
                if(arr[j]>arr[j+1]) {
                    swap(j,j+1,arr);
                }
            }
        }
    }
    public static void bubbleSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j <= n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    // swap arr[j+1] and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }
}
