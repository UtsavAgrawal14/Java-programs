class GeneralMulti<T, U> {

	T obj1;
	U obj2;

	GeneralMulti(T obj1, U obj2) {

		this.obj1 = obj1;
		this.obj2 = obj2;
	}

	void print() {

		System.out.println(obj1 + " " + obj2);
	}
}

public class MultiTypeParameters {

	public static void main(String[] args) {

		GeneralMulti<Integer, String> student = new GeneralMulti<>(1, "Ares");
		student.print();
		GeneralMulti<String, Double> account = new GeneralMulti<>("1245135651313", 50254.22);
		account.print();
	}

}
