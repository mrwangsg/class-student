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
 * @name AliasClassService
 * @user 91119
 * @创建时间 2019/6/14
 * @描述
 */
@Service
@Transactional
public class AliasClassService {

    @Autowired
    private AliasClassRepository aliasClassRepository;
    @Autowired
    private StudentRepository studentRepository;

    /**
     * @描述 返回所有班级
     * @参数 null
     * @返回值 List<AliasClass> | null
     */
    public List<AliasClass> listAliasClass() {
        return aliasClassRepository.findAll();
    }

    /**
     * @描述 根据id返回班级
     * @参数 Integer uuid
     * @返回值 AliasClass | null
     */
    public AliasClass getAliasClassById(Integer uuid) {
        Optional<AliasClass> opt = aliasClassRepository.findById(uuid);
        if (opt.isPresent()) {
            return opt.get();
        }
        return null;
    }

    /**
     * @描述 插入班级
     * @参数 AliasClass aliasClass
     * @返回值 AliasClass | null
     */
    public AliasClass createAliasClass(AliasClass aliasClass) {

        AliasClass result = aliasClassRepository.findAliasClassByClassName(aliasClass.getClassName());
        // 如果已经存在，则停止插入
        if (result != null) {
            return null;
        }

        return aliasClassRepository.saveAndFlush(aliasClass);
    }

    /**
     * @描述 单个删除
     * @参数 String id
     * @返回值 AliasClass | null
     */
    public AliasClass deleteAliasClassById(Integer uuid) {
        AliasClass result = getAliasClassById(uuid);

        if (result == null) {
            return null;
        }

        // 逻辑外键删除
        List<Student> stuList = studentRepository.findStudentByaliasClassId(uuid);
        if (stuList != null && !stuList.isEmpty()) {
            studentRepository.deleteAll(stuList);
        }

        aliasClassRepository.delete(result);
        return result;
    }

    /**
     * @描述 批量删除
     * @参数 List<Integer> uuids
     * @返回值 List<AliasClass> | null
     */
    public List<AliasClass> deleteAliasClassBatch(List<Integer> uuids) {
        List<AliasClass> result = aliasClassRepository.findAllById(uuids);

        if (result != null && !result.isEmpty()) {
            // 逻辑外键删除
            List<Student> stuList = studentRepository.findStudentByaliasClassIds(uuids);

            if (!stuList.isEmpty()) {
                studentRepository.deleteAll(stuList);
            }

            aliasClassRepository.deleteAll(result);
        }

        return result;
    }

    /**
     * @描述 更新字段
     * @参数 AliasClass aliasClass
     * @返回值 AliasClass | null
     */
    public AliasClass updateAliasClass(AliasClass aliasClass) {
        Optional<AliasClass> opt = aliasClassRepository.findById(aliasClass.getUuid());
        if (opt != null && opt.isPresent()) {
            AliasClass oldAliasClass = opt.get();
            updateAliasClassAttribute(oldAliasClass, aliasClass);

            return aliasClassRepository.saveAndFlush(oldAliasClass);
        }
        return null;
    }

    /**
     * @描述 如果有字段更新，则更新字段
     * @参数 数据库AliasClass oldAliasClass, 前端传来AliasClass newAliasClass
     * @返回值 void
     */
    private void updateAliasClassAttribute(AliasClass oldAliasClass, AliasClass newAliasClass) {

        // 如果前端传来不为空，说明该字段需要更新
//        if (newAliasClass.getClassName() != null) {
//            oldAliasClass.setClassName(newAliasClass.getClassName());
//        }
        if (newAliasClass.getClassTeacher() != null) {
            oldAliasClass.setClassTeacher(newAliasClass.getClassTeacher());
        }
    }
}
