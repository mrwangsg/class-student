package com.sgwang.repository;

import com.sgwang.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @创建人 sgwang
 * @name StudentRepository
 * @user 91119
 * @创建时间 2019/6/14
 * @描述
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findStudentByStudentNum(String studentNum);

    @Query(value = "SELECT stu.* FROM student stu where stu.alias_class_id =:aliasClassId ", nativeQuery = true)
    List<Student> findStudentByaliasClassId(@Param("aliasClassId") Integer aliasClassId);

    @Query(value = "SELECT stu.* FROM student stu where stu.alias_class_id in (:aliasClassIds) ", nativeQuery = true)
    List<Student> findStudentByaliasClassIds(@Param("aliasClassIds") List<Integer> aliasClassIds);
}
