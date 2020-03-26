import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public class Student implements Comparable<Student> {
        private String name;
        private int score;

        public Student(String name2, int score2) {
            this.name = name2;
            this.score = score2;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getScore() {
            return this.score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        @Override
        public int compareTo(Student o) {
            return (this.score - o.getScore());
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 人数
        int count = in.nextInt();
        // 0表示顺序，从大到小
        int order = in.nextInt();
        LinkedList<Student> students = new LinkedList<Student>();

        String name;
        int score = -1;
        for (int i = 0; i < count; i++) {
            name = in.next();
            score = in.nextInt();
            // Check valid
            Student s = new Main().new Student(name, score);
            students.add(s);
        }

        // 排序
        Collections.sort(students);

        // 顺序输出
        if (order == 1) {
            for (int i = 0; i < students.size(); i++) {
                System.out.println(students.get(i).getName() + " " + students.get(i).getScore());
            }
        } else {
            for (int i = students.size() - 1; i > -1; i--) {
                System.out.println(students.get(i).getName() + " " + students.get(i).getScore());
            }
        }

        in.close();
    }

}