public class StudentList {
    private List<Student> students;

    public StudentList() {
        students = new List<Student>();
    }

    public boolean isEmpty() {
        return students.isEmpty();
    }

    public Student first() {
        return students.first();
    }

    public Student next() {
        return students.next();
    }


    //add a new student to the list
    public void addRecord(Student s) {
        students.add(s);
    }

    //delete a student record according to the id number;
    public void deleteRecord(int ID) {
        Student stu = students.first();
        int id;
        while (stu != null) {
            id = stu.getStudentID();
            if (id == ID) {
                students.remove(stu);
            }
            stu = students.next();
        }
    }

    //display records of all the students taking a specified major
    public void displayMajors(String major) {
        Student stu = students.first();
        String maj;
        while (stu != null) {
            maj = stu.getMajor();
            if (maj.equals(major)) {
                System.out.println(stu);
            }
            stu = students.next();
        }
    }

    public void displayFaculty(String faculty) {
        Student stu = students.first();
        String fac;
        while (stu != null) {
            fac = stu.getFaculty();
            if (fac.equals(faculty)) {
                System.out.println(stu);
            }
            stu = students.next();
        }
    }
    public void displayName(String name) {
        Student stu = students.first();
        String nam;
        while (stu != null) {
            nam = stu.getLastName();
            if (nam.equals(name)) {
                System.out.println(stu);
            }
            stu = students.next();
        }
    }
    public Student searchID(int ID){
        Student stu = students.first();
        int id;
        while (stu != null) {
            id = stu.getStudentID();
            if (id == ID) {
                return stu;
            }
            stu = students.next();
        }
        return null;
    }
}
