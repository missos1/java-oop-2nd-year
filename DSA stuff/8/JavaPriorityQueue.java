import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class JavaPriorityQueue {
    class Student {
        private int id;
        private String name;
        private double cgpa;
        
        Student(int id, String name, double cgpa) {
            this.id = id;
            this.name = name;
            this.cgpa = cgpa;
        }
        
        public int getId() {
            return id;
        }
        
        public String getName() {
            return name;
        }
        
        public double getCGPA() {
            return cgpa;
        }
    }

    class Priorities {
        List<Student> getStudents(List<String> events) {
            StudentComparator comparator = new StudentComparator();
            Queue<Student> serveQ = new PriorityQueue<>(comparator);
            
            for (String s : events) {
                if (s.equals("SERVED")) {
                    serveQ.poll();
                } else {
                    String[] parts = s.split(" ");
                    String name = parts[1];
                    double cgpa = Double.parseDouble(parts[2]);
                    int id = Integer.parseInt(parts[3]);
                    serveQ.add(new Student(id, name, cgpa));
                }
            }
            
            List<Student> res = new ArrayList<>();
            
            while (!serveQ.isEmpty()) {
                res.add(serveQ.poll());
            }
            return res;
        }
    }

    class StudentComparator implements Comparator<Student> {
        @Override
        public int compare(Student x, Student y) {
            if (x.getCGPA() != y.getCGPA()) {
                return -Double.compare(x.getCGPA(), y.getCGPA());
            }
            if (!x.getName().equals(y.getName())) {
                return x.getName().compareTo(y.getName());
            }
            return Integer.compare(x.getId(), y.getId());
        }
    }
}
