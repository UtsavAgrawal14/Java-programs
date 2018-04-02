import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Waiting {

	Employee[] list;

	public Employee[] getList() {
		return list;
	}

	public void setList(Employee[] list) {
		this.list = list;
	}

}

class Employee {

	byte destination;
	byte weight;

	public byte getDestination() {
		return destination;
	}

	public void setDestination(byte destination) {
		this.destination = destination;
	}

	public byte getWeight() {
		return weight;
	}

	public void setWeight(byte weight) {
		this.weight = weight;
	}
}

public class Elevator {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		byte t = Byte.parseByte(br.readLine());
		StringTokenizer st;
		for (byte i = 0; i < t; ++i) {
			short floors = Short.parseShort(br.readLine());
			st = new StringTokenizer(br.readLine());
			byte maxPeople = Byte.parseByte(st.nextToken());
			short maxWeight = Short.parseShort(st.nextToken());
			Waiting[] waiting = new Waiting[floors - 1];
			st = new StringTokenizer(br.readLine());
			for (short j = 0; j < floors - 1; ++j) {
				waiting[j] = new Waiting();
				waiting[j].setList(new Employee[Byte.parseByte(st.nextToken())]);
			}
			for (short j = 0; j < floors - 1; ++j) {
				st = new StringTokenizer(br.readLine());
				Employee[] employees = waiting[j].getList();
				for(short k = 0; k < employees.length; ++k) {
					employees[k] = new Employee();
					employees[k].setDestination(Byte.parseByte(st.nextToken()));
				}
			}
			for (short j = 0; j < floors - 1; ++j) {
				st = new StringTokenizer(br.readLine());
				Employee[] employees = waiting[j].getList();
				for(short k = 0; k < employees.length; ++k) {
					employees[k].setWeight(Byte.parseByte(st.nextToken()));
				}
			}
			System.out.println("Data stored");
		}
	}

}
