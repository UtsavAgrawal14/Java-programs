import java.lang.reflect.InvocationTargetException;

/*
 * static methods are not overridden in the usual sense like instance methods. Rather,when we declare a static method with the
 * same name and signature in a child class, it just hides that method in CHILD class until forced to run. In the example below,
 * when we call calculateSalary() method from a reference of parent class, the JVM determines at runtime that the object pointed to
 * by that reference is actually of the child class and calls the child class' calculateSalary() which then forces it to call the child's
 * getBonusMultiplier() having 0.3f return value. However, if we just remove the calculateSalary() from child class, then parent's
 * getBonusMultiplier() will be called
 */
class RegularEmployee{
	public double salary;

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public static float getBonusMultiplier() {
		System.out.println("Parent static");
		return 0.2f;
	}
	
	public double calculateSalary() {
		return salary + salary*getBonusMultiplier();
	}
}

class SpecialEmployee extends RegularEmployee{
	
	
	//Comment out the method below to see how chlid's static method will be hidden.
	/*@Override
	public double calculateSalary() {
		System.out.println("Child's method called");
		return salary + salary*getBonusMultiplier();
	}*/
	
	public static float getBonusMultiplier() {
		System.out.println("Child static");
		return 0.3f;
	}
	
}
public class StaticInheritence {
	
	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		RegularEmployee e = new SpecialEmployee();
		e.setSalary(1000);
		System.out.println(SpecialEmployee.getBonusMultiplier()); // calls child's static method. 
		System.out.format("%8.4f",e.calculateSalary()); //calls parent's static method.
		Class<Object>[] c = null;
		Object[] o = null;
		System.out.println();
		e.getClass().getMethod("getBonusMultiplier", c).invoke(null, o); //calls child's static method.
	}
}
