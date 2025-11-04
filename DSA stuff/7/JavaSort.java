import java.util.Comparator;

public class JavaSort {
    class StudentComparator implements Comparator<Student> {
        @Override
        public int compare(Student a, Student b) {
            if (a.getCgpa() != b.getCgpa()) {
                return -Double.compare(a.getCgpa(), b.getCgpa());
            }
            
            if (!a.getFname().equals(b.getFname())) {
                return a.getFname().compareTo(b.getFname());
            }
            
            return Integer.compare(a.getId(), b.getId());
        }
    }
}
