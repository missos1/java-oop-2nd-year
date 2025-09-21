
public class Undergradmanage {
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
        

        StudentManagement t = new StudentManagement();
        t.addStudent(Student);
        t.addStudent(student1);
        t.addStudent(student2);
        t.addStudent(student3);

        System.out.print(t.studentsByGroup());
    }
}

class Student {
    private String name;
    private String id;
    private String group;
    private String email;

    public Student() {
        name = "Student";
        id = "000";
        group = "K62CB";
        email = "uet@vnu.edu.vn";
    }

    public Student(String name, String id, String email) {
        this.name = name;
        this.id = id;
        this.group = "K62CB";
        this.email = email;
    }

    public Student(Student s) {
        this.name = s.name;
        this.id = s.id;
        this.group = s.group;
        this.email = s.email;
    }

    public String getName() {
        return name;
    }


    public String getId() {
        return id;
    }

    public String getGroup() {
        return group;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInfo() {
        return name + " - " + id + " - " 
        + group + " - " + email;
    }

}

class StudentManagement {
    private Student[] students = new Student[100];
    private int curr_arraysize = 0; 
    

    public static boolean sameGroup(Student s1, Student s2) {
        return s1.getGroup().equals(s2.getGroup());
    }

    public void addStudent(Student newStudent) {
        if (curr_arraysize == 100) return;

        students[curr_arraysize++] = newStudent;
    }

    public String studentsByGroup() {
        String[] groups_inappearenceorder = new String[100];
        int groupsize = 0;
        String prev_group = "";
        String result = "";

        for (Student s : students) {
            if (s != null && !prev_group.equals(s.getGroup())) {
                prev_group = s.getGroup();
                groups_inappearenceorder[groupsize++] = prev_group;
            }
        }

        for (int i = 0; i < groupsize; i++) {
            result += groups_inappearenceorder[i] + "\n";
            for (Student s : students) {
                if (s != null && groups_inappearenceorder[i].equals(s.getGroup())) {
                    result += s.getInfo() + "\n"; 
                }
            }
        }

        return result;
    }
}