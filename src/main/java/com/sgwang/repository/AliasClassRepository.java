package com.sgwang.repository;

import com.sgwang.model.AliasClass;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @创建人 sgwang
 * @name AliasClassRepository
 * @user 91119
 * @创建时间 2019/6/14
 * @描述
 */
public interface AliasClassRepository extends JpaRepository<AliasClass, Integer> {
     AliasClass findAliasClassByClassName(String className);
}
