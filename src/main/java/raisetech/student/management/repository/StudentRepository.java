package raisetech.student.management.repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import raisetech.student.management.data.Student;
import raisetech.student.management.data.StudentCourses;

@Mapper
public interface StudentRepository {

  @Select("SELECT * FROM students")
  List<Student> search();

  @Select("SELECT * FROM students WHERE age BETWEEN 30 AND 39")
  List<Student> search30();

  @Select("SELECT * FROM student_courses")
  List<StudentCourses> searchStudentCourse();

  @Select("SELECT * FROM student_courses WHERE course_name = 'Java'")
  List<StudentCourses> searchStudentCourseJava();
}
