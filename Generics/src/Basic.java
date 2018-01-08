class General<T> {

	T obj;

	General(T obj) {
		this.obj = obj;
	}

	public T getObj() {
		return this.obj;
	}

}

public class Basic {

	public static void main(String[] args) {
		
		General<Integer> intRef = new General<>(15);
		System.out.println("Integer value from generic class: "+intRef.getObj());
		Integer i = Integer.valueOf(15);
		System.out.println("Integer class: "+i);
		General<String> strRef = new General<>("Merry Christmas");
		System.out.println("String value from generic class: "+strRef.getObj());
		
	}

}
