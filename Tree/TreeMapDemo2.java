package Tree;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapDemo2 {
    public static void main(String[] args) {
        TreeMapDemo2 t = new TreeMapDemo2();
        t.demo();
    }

    private void demo() {
        TreeMap<Student,String> tm = new TreeMap<>(new Comparator<Student>(){
            public int compare(Student s1, Student s2){
                int num = s2.age - s1.age;
                return num == 0 ? s1.name.compareTo(s2.name):num;
            }
        });

        tm.put(new Student("Ke", 13), "Atlanta");
        tm.put(new Student("Youngkey", 33), "Shanghai");
        tm.put(new Student("YY", 23), "Beijing");
        tm.put(new Student("ZZ", 23), "Xian");
        tm.put(new Student("ZZ", 18), "Seattle");
        System.out.println(tm);
    }


    public class Student {
        String name;
        int age;

        Student(String n, int a) {
            this.name = n;
            this.age = a;
        }

        public String toString() {
            return "name: " + this.name + " age: " + this.age;
        }
    }
}
