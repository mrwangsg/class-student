package com.sgwang.controller;

import com.sgwang.aop.annotation.LogAnnotation;
import com.sgwang.model.AliasClass;
import com.sgwang.service.AliasClassService;
import com.sgwang.tool.Payload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @创建人 sgwang
 * @name AliasClassController
 * @user 91119
 * @创建时间 2019/6/14
 * @描述
 */
@RestController
@RequestMapping("/class")
public class AliasClassController {
    private static final Logger logger = LoggerFactory.getLogger(AliasClassController.class);

    @Autowired
    AliasClassService aliasClassService;

    @LogAnnotation
    @GetMapping
    public Payload getAliasClassList() {
        List<AliasClass> result = aliasClassService.listAliasClass();
        return new Payload(result);
    }

    @GetMapping("/{uuid:[0-9]+}")
    public Payload getAliasClassById(@PathVariable("uuid") Integer uuid) {
        AliasClass result = aliasClassService.getAliasClassById(uuid);
        return new Payload(result);
    }

    @PostMapping
    public Payload createAliasClass(@Valid @RequestBody AliasClass aliasClass, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String code = "404";
            String msg = "插入AliasClass失败！";

            return new Payload(null, code, msg);
        }

        AliasClass result = aliasClassService.createAliasClass(aliasClass);
        if (result == null) {
            String code = "404";
            String msg = "插入AliasClass失败！" + "  className: " + aliasClass.getClassName() + " 已经存在！";
            return new Payload(null, code, msg);
        }

        return new Payload(result);
    }

    @DeleteMapping("/{uuid:[0-9]+}")
    public Payload deleteAliasClassById(@PathVariable("uuid") Integer uuid) {
        AliasClass result = aliasClassService.deleteAliasClassById(uuid);

        if (result == null){
            String code = "404";
            String msg = "删除AliasClass失败！有可能不存在该班级";
            return new Payload(null, code, msg);
        }
        return new Payload(result);
    }

    @DeleteMapping("/batch")
    public Payload getAliasClassById(@RequestBody List<Integer> uuids) {
        List<AliasClass> result = aliasClassService.deleteAliasClassBatch(uuids);

        if (result.isEmpty()){
            String code = "404";
            String msg = "删除AliasClass失败！";
            return new Payload(new ArrayList<>(), code, msg);
        }
        return new Payload(result);
    }

    @PutMapping
    public Payload updateAliasClassById(@RequestBody AliasClass aliasClass) {
        AliasClass result = aliasClassService.updateAliasClass(aliasClass);
        if (result == null) {
            return new Payload(null, "404", "更新失败！");
        }
        return new Payload(result);
    }

}
