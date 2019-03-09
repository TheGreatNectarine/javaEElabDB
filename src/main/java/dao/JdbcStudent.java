package dao;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcStudent implements StudentDao {


    @Autowired
    private SimpleJdbcTemplate jdbcTemplate;

    public Student getStudentById(int id) {
        return jdbcTemplate.queryForObject("select id, pib, course from students where id = ?",
                (rs, row) -> new Student(rs.getInt(1), rs.getString(2), rs.getInt(3)), id);
    }

    public void addStudent(Student student) {
        jdbcTemplate.update("insert into students (pib, course) values (?,?)", student.getPib(), student.getCourse());
    }
}