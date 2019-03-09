import model.Student;
import model.Teacher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import workers.WorkWithStudent;
import workers.WorkWithTeacher;

import java.util.Date;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
        WorkWithStudent worker = (WorkWithStudent) context.getBean("worker");
        Student testStudent = new Student("Nikondr", 3);
        worker.saveToDB(testStudent);

        WorkWithTeacher workWithTeacher = (WorkWithTeacher) context.getBean("teachersWorker");
        Teacher teacher = new Teacher("Artem", "Karpovich", new Date(), "+380675097865");
        teacher = workWithTeacher.addTeacher(teacher);
        teacher.setCellphone("+XXXXXXXXXXX");
        workWithTeacher.saveTeacher(teacher);
    }
}
