package algorithm;


import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B14503_로봇청소기 {
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};
    static int N, M;
    static int map[][];
    static boolean v[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        v = new boolean[N][M];
        int dirCnt = 0;
        boolean flag = true;
        while (flag) {
            if (map[r][c] == 0) {
                map[r][c] = 2;
                ans++;
            }
            while (true) {
                if (dirCnt == 4) {
                    int nr = r - dr[d];
                    int nc = c - dc[d];
                    if (map[nr][nc] == 1) {
                        flag = false;
                        break;
                    } else {
                        r = nr;
                        c = nc;
                        dirCnt = 0;
                    }
                }
                d = (d + 3) % 4;
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (map[nr][nc] == 0) {
                    r = nr;
                    c = nc;
                    dirCnt = 0;
                    break;
                } else {
                    dirCnt++;
                }
            }

        }
        System.out.println(ans);
    }
}