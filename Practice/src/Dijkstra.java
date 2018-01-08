import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Dijkstra {

	private static int vertex;
	private static int edges;
	// private static int moments;
	private static int[][] graph;
	// private static int[][] dissappear;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		vertex = Integer.parseInt(st.nextToken());
		edges = Integer.parseInt(st.nextToken());
		// moments = Integer.parseInt(st.nextToken());
		graph = new int[vertex][vertex]; // Adjacency matrix representation
		// dissappear = new int[moments][2]; //[0]-> time after which edge disappears
		// [1]-> edge number.
		int e1, e2, val;
		for (int i = 0; i < edges; ++i) {
			st = new StringTokenizer(br.readLine());
			e1 = Integer.parseInt(st.nextToken());
			e2 = Integer.parseInt(st.nextToken());
			val = Integer.parseInt(st.nextToken());
			graph[e1 - 1][e2 - 1] = val;
			graph[e2 - 1][e1 - 1] = val; // Undirected edges in graph
		}
		/*
		 * for (int i = 0; i < moments; ++i) { st = new StringTokenizer(br.readLine());
		 * e1 = Integer.parseInt(st.nextToken()); e2 = Integer.parseInt(st.nextToken());
		 * dissappear[i][0] = e1; dissappear[i][1] = e2; }
		 */
		dijkstra(5);
	}

	private static void dijkstra(int sourceIndex) {
		int[] minDist = new int[vertex];
		boolean[] included = new boolean[vertex];
		for (int i = 0; i < vertex; ++i) {
			if (i != sourceIndex && sourceIndex < vertex)
				minDist[i] = Integer.MAX_VALUE;
		}
		for (int count = 0; count < vertex - 1; ++count) {
			int minIndex = minDistanceVertex(minDist, included);
			included[minIndex] = true;
			for (int v = 0; v < vertex; v++) {
				if (!included[v] && graph[minIndex][v] != 0 && minDist[minIndex] != Integer.MAX_VALUE
						&& minDist[minIndex] + graph[minIndex][v] < minDist[v]) {
					minDist[v] = minDist[minIndex] + graph[minIndex][v];
				}
			}
		}
		printMinDist(minDist, sourceIndex);
	}

	private static int minDistanceVertex(int[] minDist, boolean[] included) {
		int minIndex = -1, min = Integer.MAX_VALUE;
		for (int i = 0; i < vertex; ++i) {
			if (!included[i] && minDist[i] <= min) {
				min = minDist[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

	private static void printMinDist(int[] minDist, int src) {
		System.out.println("Adjacency Matrix:");
		for (int[] row : graph) {
			for (int elem : row) {
				System.out.format("%3s", elem);
			}
			System.out.println();
		}
		System.out.println("Source: " + src);
		for (int i : minDist) {
			System.out.print(i + " ");
		}
	}
}