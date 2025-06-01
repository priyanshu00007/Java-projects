import java.util.*;
public class New 
{
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        String name  = scanner.nextLine();
        System.out.println("Hello " + name + "!");
        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();
        System.out.println("this is a number " + n);
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
}