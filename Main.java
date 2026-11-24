import java.util.Scanner;
public class Main {
 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  System.out.print("Enter n, a, b and k: ");
  long n = sc.nextLong(); int a = sc.nextInt(), b = sc.nextInt(), k = sc.nextInt();
  if (n < 1 || a < 1 || b < 2 || k < 0) { System.out.println("Invalid input."); return; }
  long check = n;
  while (check > 1 && check % b == 0) check /= b;
  if (check != 1) { System.out.println("Enter n as a power of b."); return; }
  double total = 0, nodes = 1; long size = n; int level = 0;
  System.out.println("\nRecursion Tree:");
  while (size > 1) {
   double work = nodes * Math.pow(size, k);
   System.out.printf("Level %d: Nodes = %.0f, Size = %d, Work = %.2f%n", level, nodes, size, work);
   total += work; nodes *= a; size /= b; level++;
  }
  double leafWork = nodes;
  System.out.printf("Leaf level %d: Nodes = %.0f, Work = %.2f%n", level, nodes, leafWork);
  total += leafWork;
  System.out.printf("Total estimated cost = %.2f%n", total);
  System.out.println("Number of levels = " + level);
 }
}
