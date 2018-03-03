import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Mobile {

	String os;
	byte ram;
	boolean memory;
	int price;
	int rating;

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public byte getRam() {
		return ram;
	}

	public void setRam(byte ram) {
		this.ram = ram;
	}

	public boolean isMemory() {
		return memory;
	}

	public void setMemory(boolean memory) {
		this.memory = memory;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (memory ? 1231 : 1237);
		result = prime * result + ((os == null) ? 0 : os.hashCode());
		result = prime * result + ram;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mobile other = (Mobile) obj;
		if (memory != other.memory)
			return false;
		if (os == null) {
			if (other.os != null)
				return false;
		} else if (!os.equals(other.os))
			return false;
		if (price > other.price)
			return false;
		if (ram != other.ram)
			return false;
		return true;
	}

}

public class MobilesNiYO {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Mobile[] mobiles = new Mobile[n];
		StringTokenizer st;
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			mobiles[i] = new Mobile();
			mobiles[i].setOs(st.nextToken());
			mobiles[i].setRam(Byte.parseByte(st.nextToken()));
			mobiles[i].setMemory((Byte.parseByte(st.nextToken()) == (byte) 64) ? true : false);
			mobiles[i].setPrice(Integer.parseInt(st.nextToken()));
			mobiles[i].setRating(Integer.parseInt(st.nextToken()));
		}
		int q = Integer.parseInt(br.readLine());
		Mobile query = new Mobile();
		for (int i = 0; i < q; ++i) {
			st = new StringTokenizer(br.readLine());
			query.setOs(st.nextToken());
			query.setRam(Byte.parseByte(st.nextToken()));
			query.setMemory((Byte.parseByte(st.nextToken()) == (byte) 64) ? true : false);
			query.setPrice(Integer.parseInt(st.nextToken()));
			int bestRating = -1;
			for (int j = 0; j < n; ++j) {
				if (mobiles[j].equals(query)) {
					if (mobiles[j].getRating() > bestRating) {
						bestRating = mobiles[j].getRating();
					}
				}
			}
			System.out.println(bestRating);
		}
	}

}
