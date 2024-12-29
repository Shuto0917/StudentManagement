package raisetech.student.management.repository;

import java.util.List;

import org.apache.ibatis.annotations.*;
import raisetech.student.management.data.Student;
import raisetech.student.management.data.StudentCourses;

/**
 * 受講生テーブルと受講生コース情報テーブルと紐づくRepositoryです。
 */
@Mapper
public interface StudentRepository {
    /**
     * 受講生の全件検索を行います。
     *
     * @return 受講生一覧(全件)
     */
    @Select("SELECT * FROM students WHERE isDeleted = false")
    List<Student> search();

    /**
     * 受講生の検索を行います。
     *
     * @param id 受講生ID
     * @return 受講生
     */
    @Select("SELECT * FROM students WHERE isDeleted = true")
    List<Student> searchCanceledStudents();

    @Select("SELECT * FROM students WHERE id = #{id}")
    Student searchStudent(int id);

    /**
     * 受講生コース情報の全件検索を行います。
     *
     * @return 受講生のコース情報(全件)
     */
    @Select("SELECT * FROM student_courses")
    List<StudentCourses> searchStudentsCoursesList();

    /**
     * 受講生IDに紐づく受講生コース情報を検索します。
     *
     * @param studentId 受講生ID
     * @return 受講生IDに紐づく受講生コース情報
     */
    @Select("SELECT * FROM student_courses WHERE student_id = #{studentId}")
    List<StudentCourses> searchStudentsCourses(int id);

    @Insert("INSERT INTO students(full_Name, furigana, nickname, email, region, age, gender, remark, isDeleted)"
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
