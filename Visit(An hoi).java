import java.util.Scanner;

public class Solution {

	public static int[][] arr;
	public static float[][] arrp;
	public static float [][] gt;
	public static int [] a;
	public static Point1 [] Q;
	public static int  n, m, r, k, x, y, l, t, e;
	public static int z1,  z2;	
	public static float p1, p2;	


	public static void main(String[] args)  {
		

		Scanner in = new Scanner(System.in);
		int T = 10;
		
		for(int tc=1;tc<=T;tc++){	
			n = in.nextInt();
			k = in.nextInt();
			e = in.nextInt();
			t = in.nextInt();
			e = t - e;
			arr = new int[n+1][n+1];
			arrp = new float[n+1][n+1];
			a = new int[n+1];
			gt = new float[n+1][t/10+10];
			Q= new Point1[1000000];
			for (int i = 0; i < k; i++) {
				int x = in.nextInt();
				int y = in.nextInt();
				float z= in.nextFloat();
				
				arr[x][arr[x][n]] = y;
				arrp[x][arr[x][n]] = z;
				arr[x][n] = arr[x][n] +1;
			}
			z1= z2= 0;
			p1 = p2 = 0;
			Bfs(1);
			System.out.println("#"+ tc+" "+z1+ " "+String.format("%.6f", p1)+" "+ z2+ " "+String.format("%.6f", p2));
		}
	}
	
	static void Bfs(int h){
		
		gt[h][0]= 1;
		Q[l]= new Point1(1, 0);
		l++;
		a[h] = 0; 
		while (l!=r) {
			Point1 point1 = Q[r];
			r++;
			int ds = point1.x;
			
			if (t/10 == point1.z) {
				if (gt[point1.x][point1.z] > p1) {
					z1= point1.x;
					p1=gt[point1.x][point1.z];
				}
			}
			if (e/10 == point1.z) {
				if (gt[point1.x][point1.z]> p2) {
					z2= point1.x;
					p2= gt[point1.x][point1.z];
				}
			}
			
			if (point1.z <= t/10) {
				for (int i = 0; i < arr[ds][n]; i++) { // i la dinh ke
					if (a[arr[ds][i]] < point1.z+1		) {
							a[arr[ds][i]] = point1.z+1;
							gt[arr[ds][i]][a[arr[ds][i]]] =  gt[ds][point1.z]* arrp[ds][i];
							Q[l]= new Point1(arr[ds][i], a[arr[ds][i]]);
							l++;	
					}else if (a[arr[ds][i]] == point1.z+1) {
						gt[arr[ds][i]][a[arr[ds][i]]/1] =  gt[arr[ds][i]][a[arr[ds][i]]/1] + gt[ds][point1.z]* arrp[ds][i];		
				}
					      
			}	
		}
	  }
	}
}
class Point1{
	int x, z;
	public Point1(int x, int z) {
		super();
		this.x = x;
		this.z = z;
	
	}
}







