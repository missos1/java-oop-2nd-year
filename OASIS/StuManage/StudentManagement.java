import java.util.LinkedHashSet;
import java.util.Set;

public class StudentManagement {
    private final Student[] students = new Student[100];
    private int curr_arraysize = 0; 

    /**
     * Check if two students are in the same group.
     * @param s1 1st student
     * @param s2 2nd student
     * @return the boolean value of whether the students are in the same group
     */
    public static boolean sameGroup(Student s1, Student s2) {
        return s1.getGroup().equals(s2.getGroup());
    }

    /**
     * Add student to the students list.
     * @param newStudent the new student needed to be added
     */
    public void addStudent(Student newStudent) {
        if (curr_arraysize == 100) return;

        students[curr_arraysize++] = newStudent;
    }
    /**
     * Get the full student list by groups.
     * @return the string of the list by groups
     */
    public String studentsByGroup() {
        Set<String> groups_inappearenceorder = new LinkedHashSet<>();
        String result = "";

        for (Student s : students) {
            if (s == null) {
                break;
            }

            groups_inappearenceorder.add(s.getGroup());
        }

        for (String group : groups_inappearenceorder) {
            result += group + "\n";
            for (Student s : students) {
                if (s == null) {
                    break;
                }

                if (group.equals(s.getGroup())) {
                    result += s.getInfo() + "\n"; 
                }
            }
        }

        return result;
    }

    public void removeStudent(String id) {
        int curr_index = 0;
        for (int i = 0; i < curr_arraysize; i++) {
            curr_index = i;
        }

        if (curr_index == curr_arraysize) {
            return;
        }
        
        for (int i = curr_index; i < curr_arraysize - 1; i++) {
            students[i] = students[i + 1];
        }
        students[curr_arraysize - 1] = null;
        curr_arraysize--;
    }

    public static void main(String[] args) {
        Student Student = new Student();

        Student.setName("Nguyen Van An");
        Student.setId("17020001"); 
        Student.setGroup("K62CC"); 
        Student.setEmail("17020001@vnu.edu.vn");

        Student student1 = new Student();
        student1.setName("Nguyen Van B");
        student1.setId("17020002");
        student1.setGroup("K62CC");
        student1.setEmail("17020002@vnu.edu.vn");

        Student student2 = new Student("Nguyen Van C", "17020003", "17020003@vnu.edu.vn");
        Student student3 = new Student("Nguyen Van D", "17020004", "17020004@vnu.edu.vn");
        Student student4 = new Student();
        
        StudentManagement t = new StudentManagement();
        t.addStudent(Student);
        t.addStudent(student1);
        t.addStudent(student2);
        t.addStudent(student3);
        t.addStudent(student4);

        System.out.print(t.studentsByGroup());

        t.removeStudent("000");

        System.out.print(t.studentsByGroup());

        
    }
}