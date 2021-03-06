import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Point {

	private int x;
	private int y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Point() {
		super();
	}

	public Point(int x, int y) {

		this.x = x;
		this.y = y;
	}

}

public class InsenceSticksCapillary {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Point p1 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(br.readLine());
		Point p2 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		int n = Integer.parseInt(br.readLine());
		Point[] locations = new Point[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i) {
			locations[i] = new Point();
			locations[i].setX(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i) {
			locations[i].setY(Integer.parseInt(st.nextToken()));
		}
		int q = Integer.parseInt(br.readLine());
		int[] t = new int[q];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < q; ++i) {
			t[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < q; ++i) {
			System.out.print(pointsCovered(locations, n, t[i], p1, p2) + " ");
		}
	}

	static int pointsCovered(Point[] loc, int n, int t, Point p1, Point p2) {
		int result = 0;
		for (int i = 0; i < n; ++i) {
			if (dis(p1, loc[i]) <= t && dis(p2, loc[i]) <= t) {
				++result;
			}
		}
		return result;
	}

	static int dis(Point p1, Point p2) {

		return (int) (Math.sqrt(
				(p1.getX() - p2.getX()) * (p1.getX() - p2.getX()) + (p1.getY() - p2.getY()) * (p1.getY() - p2.getY())));
	}
}
