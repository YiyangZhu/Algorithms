package Tree;

import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMapDemo t = new TreeMapDemo();
        t.demo();
    }

    private void demo() {
        TreeMap<Student, String> tm = new TreeMap<>();
        tm.put(new Student("Ke", 13), "Atlanta");
        tm.put(new Student("Youngkey", 33), "Shanghai");
        tm.put(new Student("YY", 23), "Beijing");
        tm.put(new Student("ZZ", 23), "Xian");
        tm.put(new Student("ZZ", 18), "Seattle");
        System.out.println(tm);
    }

    public class Student implements Comparable<Student> {
        String name;
        int age;

        Student(String n, int a) {
            this.name = n;
            this.age = a;
        }

        public int compareTo(Student o) {
            int num = this.age - o.age;
            return num == 0 ? this.name.compareTo(o.name) : num;
        }

        public String toString() {
            return "name: " + this.name + " age: " + this.age;
        }
    }
}
