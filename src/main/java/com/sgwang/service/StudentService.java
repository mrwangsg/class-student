package com.sgwang.service;

import com.sgwang.model.AliasClass;
import com.sgwang.model.Student;
import com.sgwang.repository.AliasClassRepository;
import com.sgwang.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @创建人 sgwang
 * @name StudentService
 * @user 91119
 * @创建时间 2019/6/15
 * @描述
 */
@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private AliasClassRepository aliasClassRepository;

    /**
     * @描述 返回所有学生
     * @参数 null
     * @返回值 List<Student> | null
     */
    public List<Student> listStudent() {
        return studentRepository.findAll();
    }

    /**
     * @描述 根据id返回学生
     * @参数 Integer uuid
     * @返回值 Student | null
     */
    public Student getStudentById(Integer uuid) {
        Optional<Student> opt = studentRepository.findById(uuid);
        if (opt != null && opt.isPresent()) {
            return opt.get();
        }
        return null;
    }

    /**
     * @描述 插入学生
     * @参数 Student student
     * @返回值 Student | null
     */
    public Student createStudent(Student student) {
        // 如果要插入的班级不存在，则返回null
        Optional<AliasClass> opt = aliasClassRepository.findById(student.getAliasClass().getUuid());

        if (!opt.isPresent()) {
            return null;
        }

        // 判断逻辑上 唯一键
        Student result = studentRepository.findStudentByStudentNum(student.getStudentNum());

        // 如果已经存在，则停止插入
        if (result != null) {
            return null;
        }

        return studentRepository.saveAndFlush(student);
    }

    /**
     * @描述 单个删除
     * @参数 String id
     * @返回值 Student | null
     */
    public Student deleteStudentById(Integer uuid) {
        Student result = getStudentById(uuid);

        if (result == null) {
            return null;
        }

        studentRepository.delete(result);
        return result;
    }

    /**
     * @描述 批量删除
     * @参数 List<Integer> uuids
     * @返回值 List<Student> | []
     */
    public List<Student> deleteStudentBatch(List<Integer> uuids) {
        List<Student> result = studentRepository.findAllById(uuids);

        if (!result.isEmpty()) {
            studentRepository.deleteAll(result);
        }

        return result;
    }

    /**
     * @描述 更新学生字段
     * @参数 Student student
     * @返回值 Student | null
     */
    public Student updateStudent(Student student) {
        Optional<Student> opt = studentRepository.findById(student.getUuid());
        if (opt != null && opt.isPresent()) {
            Student oldStudent = opt.get();
            updateStudentAttribute(oldStudent, student);

            return studentRepository.saveAndFlush(oldStudent);
        }
        return null;
    }

    /**
     * @描述 如果有字段更新，则更新字段
     * @参数 数据库 Student oldStudent, 前端传来 Student newStudent
     * @返回值 void
     */
    private void updateStudentAttribute(Student oldStudent, Student newStudent) {

        // 如果前端传来不为空，说明该字段需要更新
//        if (newStudent.getStudentNum() != null) {
//            oldStudent.setStudentNum(newStudent.getStudentNum());
//        }
        if (newStudent.getStudentName() != null) {
            oldStudent.setStudentName(newStudent.getStudentName());
        }
        if (newStudent.getSex() != null) {
            oldStudent.setSex(newStudent.getSex());
        }
        if (newStudent.getBirthDate() != null) {
            oldStudent.setBirthDate(newStudent.getBirthDate());
        }
        if (newStudent.getAddress() != null) {
            oldStudent.setAddress(newStudent.getAddress());
        }

        // 针对外键特殊更新
        if (newStudent.getAliasClass() != null && newStudent.getAliasClass().getUuid() != null) {

            Optional<AliasClass> opt = aliasClassRepository.findById(newStudent.getAliasClass().getUuid());
            if (opt != null && opt.isPresent()) {
                oldStudent.setAliasClass(opt.get());
            }
        }
    }

}
