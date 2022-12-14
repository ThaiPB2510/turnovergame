import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ladyrinth {
    static int n, m, l = -1, r = -1, max_p, max_x, max_y;
    static char maze[][] = new char[1001][1001];
    static int visited[][] = new int[1001][1001];
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static Pair q[] = new Pair[1000000];

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("input"));
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());
        for (int tc = 1; tc <= 2; tc++) {
            m = sc.nextInt();
            n = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < n; i++) {
                String s = sc.nextLine();
                for (int j = 0; j < s.length(); j++) {
                    maze[i][j] = s.charAt(j);
                }
            }
            max_p = 1;
            max_x = -1;
            max_y = -1;
            for (int i = 0; i < n; i++) {
                if (max_x != -1) break;
                for (int j = 0; j < m; j++) {
                    if (maze[i][j] == '.') {
                        bfs(i, j);
                        break;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    visited[i][j] = 0;
                }
            }
            if (max_x != -1) bfs(max_x, max_y);
            System.out.printf("Maximum rope length is %d.", max_p - 1);
            System.out.println();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    visited[i][j] = 0;
                }
            }
        }
    }

    private static void bfs(int x, int y) {
        visited[x][y] = 1;
        q[++l] = new Pair(x, y);
        while (l != r) {
            Pair pair = q[++r];
            int a = pair.x;
            int b = pair.y;
            if (visited[a][b] > max_p) {
                max_p = visited[a][b];
                max_x = a;
                max_y = b;
            }
            for (int i = 0; i < 4; i++) {
                int aa = a + dx[i];
                int bb = b + dy[i];
                if (aa >= 0 && aa < n && bb >= 0 && bb < m && visited[aa][bb] == 0 && maze[aa][bb] == '.') {
                    visited[aa][bb] = visited[a][b] + 1;
                    q[++l] = new Pair(aa, bb);
                }
            }
        }

    }
}

class Pair {
    int x, y;

    public Pair(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }
}
