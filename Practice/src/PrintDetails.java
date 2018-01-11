import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Utsav
 * Prints the details of each teacher with teachers sorted lexicographically. Each teacher teaches one or several students, but each each 
 * student is taught by exactly one teacher.
 * 
 * Input:
 * 1. No. of teachers, t <space> No. of students, s
 * 2. Next t lines will have the names of each teacher
 * 3. Next s lines will have, Teacher's name <space> Student's name <space> Student's age
 * 
 * Output:
 * 
 * Print each teacher's name
 * Each student taught by that teacher <space> Age of student
 * 
 * Note:
 * Sort teachers lexicographically, and students by age.
 * No spaces in the names of teachers or students. 
 */

class Student {
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Student(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name + " " + age;
	}

}

class Teacher {

	private String name;
	private List<Student> list;

	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Teacher(String name, List<Student> list) {
		this.name = name;
		this.list = list;
	}

	public Teacher(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder print = new StringBuilder();
		print.append(this.name);
		print.append(":\n");
		List<Student> list = this.getList();
		for (int i = 0; i < list.size(); ++i) {
			print.append(list.get(i).toString());
			if(i < list.size() - 1)
				print.append(" , ");
		}
		return print.toString();
	}
}

public class PrintDetails {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		List<Teacher> teachers = new ArrayList<>();
		Teacher temp;
		List<Student> students;
		Student stud;
		int index;
		for (int i = 0; i < t; ++i) {
			temp = new Teacher(br.readLine(), new ArrayList<>());
			teachers.add(temp);
		}
		sortTeachers(teachers);
		for (int i = 0; i < s; ++i) {
			st = new StringTokenizer(br.readLine());
			index = findIndexOf(teachers, st.nextToken());
			if (index != -1) {
				temp = teachers.get(index);
				students = temp.getList();
				stud = new Student(st.nextToken(), Integer.parseInt(st.nextToken()));
				students.add(stud);
			}
		}
		for (int i = 0; i < t; ++i) {
			temp = teachers.get(i);
			students = temp.getList();
			if (students.size() > 1) {
				sortStudents(students);
			}
			System.out.println(temp);
		}
	}

	private static void sortTeachers(List<Teacher> l) {
		int size = l.size();
		Teacher j1, j2, temp;
		for (int i = 0; i < size - 1; ++i) {
			for (int j = 0; j < size - 1 - i; ++j) {
				j1 = l.get(j);
				j2 = l.get(j + 1);
				if (j1.getName().compareToIgnoreCase(j2.getName()) > 0) {
					temp = j1;
					l.set(j, j2);
					l.set(j + 1, temp);
				}
			}
		}
	}

	private static int findIndexOf(List<Teacher> list, String teachersName) {

		for (int i = 0; i < list.size(); ++i) {
			if (teachersName.equals(list.get(i).getName()))
				return i;
		}
		return -1;
	}

	private static void sortStudents(List<Student> list) {

		int size = list.size();
		Student j1, j2, temp;
		for (int i = 0; i < size - 1; ++i) {
			for (int j = 0; j < size - 1 - i; ++j) {
				j1 = list.get(j);
				j2 = list.get(j + 1);
				if (j1.getAge() > j2.getAge()) {
					temp = j1;
					list.set(j, j2);
					list.set(j + 1, temp);
				}
			}
		}
	}

}
