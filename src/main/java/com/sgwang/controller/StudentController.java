package com.sgwang.controller;

import com.sgwang.aop.annotation.LogAnnotation;
import com.sgwang.model.Student;
import com.sgwang.service.StudentService;
import com.sgwang.tool.Payload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @创建人 sgwang
 * @name StudentController
 * @user 91119
 * @创建时间 2019/6/15
 * @描述
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    StudentService studentService;

    @LogAnnotation
    @GetMapping
    public Payload getStudentServiceList() {
        List<Student> studentList = studentService.listStudent();

        return new Payload(studentList);
    }

    @GetMapping("/{uuid:[0-9]+}")
    public Payload getStudentById(@PathVariable("uuid") Integer uuid) {
        Student result = studentService.getStudentById(uuid);

        return new Payload(result);
    }

    @PostMapping
    public Payload createStudent(@Valid @RequestBody Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String code = "404";
            String msg = "插入Student失败！";

            return new Payload(null, code, msg);
        }

        Student result = studentService.createStudent(student);
        if (result == null) {
            String code = "404";
            String msg = "插入Student失败！";
            return new Payload(null, code, msg);
        }

        return new Payload(result);
    }

    @DeleteMapping("/{uuid:[0-9]+}")
    public Payload deleteStudentById(@PathVariable("uuid") Integer uuid) {
        return new Payload(studentService.deleteStudentById(uuid));
    }

    @DeleteMapping("/batch")
    public Payload deleteStudentBatch(@RequestBody List<Integer> uuids) {
        return new Payload(studentService.deleteStudentBatch(uuids));
    }

    @PutMapping
    public Payload updateStudentById(@RequestBody Student student) {
        Student result = studentService.updateStudent(student);
        if (result == null) {
            return new Payload(null, "404", "更新失败！");
        }
        return new Payload(result);
    }


}
