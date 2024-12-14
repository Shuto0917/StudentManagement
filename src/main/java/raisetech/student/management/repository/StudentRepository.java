package raisetech.student.management.repository;

import java.util.List;

import org.apache.ibatis.annotations.*;
import raisetech.student.management.data.Student;
import raisetech.student.management.data.StudentCourses;

@Mapper
public interface StudentRepository {
    
    @Select("SELECT * FROM students WHERE isDeleted = false")
    List<Student> search();

    @Select("SELECT * FROM students WHERE isDeleted = true")
    List<Student> searchCanceledStudents();

    @Select("SELECT * FROM students WHERE id = #{id}")
    Student searchStudent(int id);

    @Select("SELECT * FROM student_courses")
    List<StudentCourses> searchStudentsCoursesList();

    @Select("SELECT * FROM student_courses WHERE student_id = #{studentId}")
    List<StudentCourses> searchStudentsCourses(int id);

    @Insert("INSERT INTO students(full_Name, furigana, nickname, email, region, age, gender, remark, is_deleted)"
            + "VALUES(#{fullName}, #{furigana}, #{nickname}, #{email}, #{region}, #{age}, #{gender}, #{remark}, false)")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void registerStudent(Student student);

    @Insert("INSERT INTO student_courses(student_id, course_name, course_start_at, course_end_at) "
            + "VALUES(#{studentId}, #{courseName}, #{courseStartAt}, #{courseEndAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void registerStudentCourses(StudentCourses studentCourses);


    @Update("UPDATE students SET full_name = #{fullName}, furigana = #{furigana}, nickname = #{nickname}, "
            + "email = #{email}, region = #{region}, age = #{age}, gender = #{gender}, remark = #{remark}, isDeleted = #{isDeleted} WHERE id = #{id}")
    void updateStudent(Student student);

    @Update("UPDATE student_courses SET course_name = #{courseName} WHERE id = #{id}")
    void updateStudentCourses(StudentCourses studentCourses);
}
