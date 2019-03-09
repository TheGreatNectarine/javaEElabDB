package workers;

import dao.StudentDao;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;

public class WorkWithStudent {

    @Autowired
    private StudentDao studentsDao;

    public void saveToDB(Student student) {
        if ((student != null) && (student.getPib() != null) && (!student.getPib().equals("")) && (student.getCourse() > 0)) {
            studentsDao.addStudent(student);
            System.out.println("Student have been saved " + student);
        }
    }
}