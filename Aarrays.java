// public class Aarrays {
//     public static void main(String[] args) {
//         int[] arr = {4, 7, 8, 2, 10, 13};

//         int min = arr[0];
//         int max = arr[0];

//         for (int i = 1; i < arr.length; i++) {
//             if (arr[i] < min) {
//                 min = arr[i];
//             }
//             if (arr[i] > max) {
//                 max = arr[i];
//             }
//         }

//         System.out.println("Smallest Number = " + min);
//         System.out.println("Largest Number = " + max);
//     }
// }



// import java.util.Arrays;

// public class Aarrays {
//     public static void main(String[] args) {
//         String[] input = {"java", "python", "html"};
//         String[] output = new String[input.length];

//         for (int i = 0; i < input.length; i++) {
//             char[] chars = input[i].toCharArray();
//             Arrays.sort(chars);   // sort characters
//             output[i] = new String(chars);
//         }

//         System.out.println(Arrays.toString(output));
//     }
// }


// FibonacciTriangle

// import java.util.Scanner;

// public class Aarrays {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter number of rows: ");
//         int rows = sc.nextInt();

//         int a = 0, b = 1;

//         for (int i = 1; i <= rows; i++) {
//             for (int j = 1; j <= i; j++) {
//                 System.out.print(a + " ");
//                 int c = a + b;
//                 a = b;
//                 b = c;
//             }
//             System.out.println(); // new line after each row
//         }

//         sc.close();
//     }
// }



// TwoSum


// public class Aarrays {
//     public static void main(String[] args) {
//         int[] arr = {1, 2, 7, 8, 9, 12};
//         int target = 9;

//         for (int i = 0; i < arr.length; i++) {
//             for (int j = i + 1; j < arr.length; j++) {
//                 if (arr[i] + arr[j] == target) {
//                     System.out.println("Indexes: " + i + " and " + j);
//                     return; // exit after finding the pair
//                 }
//             }
//         }
//         System.out.println("No pair found!");
//     }
// }


// public class Aarrays {
//     public static void main(String[] args) {
//         int[] arr = {1, 2, 7, 8, 9, 12};
//         int target = 9;
//         boolean found = false;

//         for (int i = 0; i < arr.length; i++) {
//             for (int j = i + 1; j < arr.length; j++) {
//                 if (arr[i] + arr[j] == target) {
//                     System.out.println("{" + i + ", " + j + "}");
//                     found = true;
//                 }
//             }
//         }

//         if (!found) {
//             System.out.println("No pairs found!");
//         }
   
   
//     }
// }


// SimpleFibonacciInArray



// public class Aarrays {
//     public static void main(String[] args) {
//         int[] arr = {5, 1, 4, 9, 8};
//         int count = 0;

//         System.out.print("Fibonacci numbers in array: ");
//         for (int n : arr) {
//             int a = 0, b = 1;
//             while (b < n) { 
//                 int c = a + b; 
//                 a = b; 
//                 b = c; 
//             }
//             if (n == a || n == b) {
//                 System.out.print(n + " ");
//                 count++;
//             }
//         }
//         System.out.println("\nCount = " + count);
//     }
// }
























