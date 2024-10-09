package raisetech.student.management.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.student.management.data.Student;
import raisetech.student.management.data.StudentCourses;
import raisetech.student.management.service.StudentService;

@RestController
public class StudentController {

  private StudentService service;

@Autowired
  public StudentController(StudentService service) {
    this.service = service;
  }


  @GetMapping("/search30")
  public List<Student> search30() {
    return service.search30();
  }



  @GetMapping("/searchStudentCourseJava")
  public List<StudentCourses> searchStudentCourseJava() {
    return service.searchStudentCourseJava();
  }
}
