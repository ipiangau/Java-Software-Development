package demo;
import java.util.*;

public class Car {
    public static int fleet(int target, int[] position, int[] speed) {
        int n=position.length;

        int[][] cars = new int[n][2];
        for (int i=0; i<n;i++) {
            cars[i][0]=position[i]; 
            cars[i][1]=speed[i]; 
        }

        //farthest to closest
        Arrays.sort(cars,(a, b)->Integer.compare(b[0],a[0]));

        double[] time = new double[n];
        for (int i=0; i < n;i++) {
            time[i] = (double)(target-cars[i][0])/cars[i][1];
            //System.out.println("time "+i+": "+time[i]);
        }

        int count = 0;
        double last = 0;
        for (int i = 0; i < n; i++) {
            if (time[i] > last) {
                count++; //New fleet
                last = time[i];
                //System.out.println("last "+i); 
            }
            //System.out.print(": "+last);

        }return count;
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int casenum=1;
        while(in.hasNextLine()){
        int target =in.nextInt();
        in.nextLine();
        int[] position = Arrays.stream(in.nextLine().split(" ")) //split string by space
                              .mapToInt(Integer::parseInt) //str into int
                              .toArray();
        int[] speed = Arrays.stream(in.nextLine().split(" "))
                           .mapToInt(Integer::parseInt)
                           .toArray();
        System.out.println("Case "+casenum+": "+  fleet(target,position,speed)+".");
		casenum++;
        }
    }
}
