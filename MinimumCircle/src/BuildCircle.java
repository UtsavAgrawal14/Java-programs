import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/*
 * Finds the minimum radius and center of the circle passing through or enclosing a given set of points. 
 * 
 * Input Format:
 * 1. An integer N, denoting the number of points.
 * For each point:
 * x-coordinate of the point <space> y-coordinate of the point.
 * 
 * Output format:
 * x and y coordinates of the center.
 * Max. distance points.
 */
class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BuildCircle {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println("Enter number of points:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Point> points = new ArrayList<>();
		System.out.println("Enter " + n + " points:");
		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			points.add(new Point(x, y));
		}
		double[][] dist = new double[n][n];
		double maxDist = Double.MIN_VALUE;
		Point a = null, b = null;
		for (int i = 0; i < n; ++i) {
			Point firstPoint = points.get(i);
			for (int j = i + 1; j < n; ++j) {
				dist[i][j] = findDistance(firstPoint, points.get(j));
				if (dist[i][j] > maxDist) {
					maxDist = dist[i][j];
					a = firstPoint;
					b = points.get(j);
				}
			}
		}
		double centreX = (double) (a.x + b.x) / 2;
		double centreY = (double) (a.y + b.y) / 2;
		System.out.println("Radius: " + (maxDist / 2) + " Centre:" + centreX + " " + centreY);
		System.out.println("Max dist points:" + a.x + " " + a.y + " & " + b.x + " " + b.y);
	}

	public static double findDistance(Point a, Point b) {
		return Math.sqrt((b.x - a.x) * (b.x - a.x) + (b.y - a.y) * (b.y - a.y));
	}

}
