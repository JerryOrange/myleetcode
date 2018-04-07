import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * POJ 2431. Expedition (hard)
 * http://poj.org/problem?id=2431
 *
 * A group of cows grabbed a truck and ventured on an expedition deep into the jungle. Being rather poor drivers,
 * the cows unfortunately managed to run over a rock and puncture the truck's fuel tank.
 * The truck now leaks one unit of fuel every unit of distance it travels.
 *
 * To repair the truck, the cows need to drive to the nearest town (no more than 1,000,000 units distant) down a long, winding road.
 * On this road, between the town and the current location of the truck, there are N (1 <= N <= 10,000) fuel stops where the cows can stop to acquire additional fuel (1..100 units at each stop).
 *
 * The jungle is a dangerous place for humans and is especially dangerous for cows.
 * Therefore, the cows want to make the minimum possible number of stops for fuel on the way to the town. Fortunately,
 * the capacity of the fuel tank on their truck is so large that there is effectively no limit to the amount of fuel it can hold.
 * The truck is currently L units away from the town and has P units of fuel (1 <= P <= 1,000,000).
 *
 * Determine the minimum number of stops needed to reach the town, or if the cows cannot reach the town at all.
 *
 * Created by Jiacheng on 2018/4/7.
 */
public class Expediton_poj {

    public static int get_minimum_stop(int L, int P, int[][] stop) {
        //存储油量
        Stack gas = new Stack<Integer>();
        int result = 0;
        //起点至终点
        stop[stop.length - 1][0] = L;
        stop[stop.length - 1][1] = 0;
        //以停靠点至终点的距离，从大到小排列
        Arrays.sort(stop, (a, b) -> b[0] - a[0]);
        for (int i = 0; i < stop.length; i++) {
            int dis = L - stop[i][0];
            while (!gas.isEmpty() && dis > P) {
                P += (int) gas.peek();
                gas.pop();
                result++;
            }
            //无法到达
            if (gas.isEmpty() && dis > P) {
                return -1;
            }
            P = P - dis;
            //更新L为当前停靠加油站的距离
            L = stop[i][0];
            //添加当前停靠点的汽油
            gas.push(stop[i][1]);
        }
        return result;
    }

    public static void main(String[] args) {
        int N, L, P;
        /*
        Input
        Line 1: A single integer, N
        Lines 2..N+1: Each line contains two space-separated integers describing a fuel stop:
        The first integer is the distance from the town to the stop; the second is the amount of fuel available at that stop.
        Line N+2: Two space-separated integers, L and P
        */
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[][] stop = new int[N + 1][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                stop[i][j] = sc.nextInt();
            }
        }
        L = sc.nextInt();
        P = sc.nextInt();
        int solution = get_minimum_stop(L, P, stop);
        System.out.println("solution is " + solution);
    }
}
