import java.util.LinkedList;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * <p>
 * Created by Jiacheng on 2018/6/20.
 */
public class RangeOfRobot {

    /**
     * DFS
     *
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    public int movingCountDFS(int threshold, int rows, int cols) {
        if (threshold <= 0) {
            return 0;
        }
        boolean[][] visited = new boolean[rows][cols];
        return movingCount(threshold, 0, 0, rows, cols, visited);
    }

    //从（i,j）出发，能够达到多少格子
    public int movingCount(int threshold, int i, int j, int rows, int cols, boolean[][] visited) {
        //base case：当前节点便不可达，直接返回0
        if (i < 0 || i >= rows || j < 0 || j >= cols || visited[i][j] || countNum(i) + countNum(j) > threshold) {
            return 0;
        }
        //当前节点可达，将当前节点设置为已遍历
        visited[i][j] = true;
        //然后从当前节点的上下左右四个节点出发，统计可达数目，并加上当个格子数1，便是从（i,j）出发，能够达到多少格子
        return 1 + movingCount(threshold, i - 1, j, rows, cols, visited) + movingCount(threshold, i + 1, j, rows, cols, visited) +
                movingCount(threshold, i, j - 1, rows, cols, visited) + movingCount(threshold, i, j + 1, rows, cols, visited);
    }

    //统计target的每一位数字之和
    public int countNum(int target) {
        int count = 0;
        while (target != 0) {
            count += (target % 10);
            target = target / 10;
        }
        return count;
    }

    /**
     * BFS
     *
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    public int movingCountBFS(int threshold, int rows, int cols) {
        if (threshold <= 0) {
            return 0;
        }
        LinkedList<Point> queue = new LinkedList<>();
        //标志是否已经遍历
        boolean[][] visited = new boolean[rows][cols];
        //将（0,0）入队，并标志已遍历
        visited[0][0] = true;
        queue.add(new Point(0, 0));
        int count = 0;
        while (!queue.isEmpty()) {
            //出队便计数
            Point curPoint = queue.poll();
            count++;
            int x = curPoint.x;
            int y = curPoint.y;
            //将当前出队元素的上下左右四个节点（可达）入队，并设置相应标志
            if (isAvailable(x - 1, y, rows, cols, threshold, visited)) {
                queue.add(new Point(x - 1, y));
                visited[x - 1][y] = true;
            }
            if (isAvailable(x + 1, y, rows, cols, threshold, visited)) {
                queue.add(new Point(x + 1, y));
                visited[x + 1][y] = true;
            }
            if (isAvailable(x, y - 1, rows, cols, threshold, visited)) {
                queue.add(new Point(x, y - 1));
                visited[x][y - 1] = true;
            }
            if (isAvailable(x, y + 1, rows, cols, threshold, visited)) {
                queue.add(new Point(x, y + 1));
                visited[x][y + 1] = true;
            }
        }
        return count;
    }

    public class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    //（x,y）是否可达
    public boolean isAvailable(int x, int y, int rows, int cols, int threshold, boolean[][] visited) {
        return (x >= 0 && x < rows && y >= 0 && y < cols && !visited[x][y] && countNum(x) + countNum(y) <= threshold);
    }
}
