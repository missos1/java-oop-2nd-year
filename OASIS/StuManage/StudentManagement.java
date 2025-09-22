import java.util.LinkedHashSet;
import java.util.Set;

public class StudentManagement {
    private final Student[] students = new Student[100];
    private int currentarraysize = 0; 

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
     * @param newStudent the new student needed adding
     */
    public void addStudent(Student newStudent) {
        if (currentarraysize == 100) {
            return;
        }

        students[currentarraysize++] = newStudent;
    }

    /**
     * Get the full student list by groups.
     * @return the string of the list by groups
     */
    public String studentsByGroup() {
        Set<String> groupsInAppearenceOrder = new LinkedHashSet<>();
        String result = "";

        for (Student s : students) {
            if (s == null) {
                break;
            }

            groupsInAppearenceOrder.add(s.getGroup());
        }

        for (String group : groupsInAppearenceOrder) {
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

    /**
     * Remove a student by ids.
     * @param id the id of the student needed deleting;
     */
    public void removeStudent(String id) {
        int currIndex = 0;
        while (currIndex < currentarraysize) {
            if (students[currIndex].getId().equals(id)) {
                break;
            }
            currIndex++;
        }

        if (currIndex == currentarraysize) {
            return;
        }
        
        for (int i = currIndex; i < currentarraysize; i++) {
            students[i] = students[i + 1];
        }
        students[currentarraysize - 1] = null;
        currentarraysize--;
    }

    /**
     * Main function.
     * @param args takes in cmd
     */
    public static void main(String[] args) {
        
    }
}