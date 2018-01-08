import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*(Incorrect Output)
 * You are watching a video on YouTube but you are on a slow, fluctuating network :( There are a total of N data packets each having
 * variable amount of data. The video you are watching streams a fixed 'd' amount of data per second. You want to watch the video
 * uninterrupted (without buffering delay) and you also want to start watching as soon as possible. Calculate the time(in seconds) for
 * which you need to let the video get buffered before you can start watching.(Hint: video should be let to get buffered until you 
 * have enough playback time that you can start watching and never run out of buffered data till the end.)
 * NOTE: Video will be played only when atleast 1 second worth of data(i.e 'd') is available in the buffer. 
 */
public class YouTubeZscalar {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		int sum = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
		}
		int playback = 0, remaining = sum / d, i = -1, buffer = 0, time = 0;
		while (playback < remaining) {
			++time;
			buffer += arr[++i];
			if (buffer >= d) {
				playback = buffer / d;
				remaining -= (buffer / d);
				buffer = 0;
			}
		}
		System.out.println(time);
	}

}
