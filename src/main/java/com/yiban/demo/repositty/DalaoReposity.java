package com.yiban.demo.repositty;

import com.yiban.demo.model.Dalao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by dalao on 17-12-26.
 */
public interface DalaoReposity extends CrudRepository<Dalao,Integer>{
    List<Dalao> findBy姓名(String 姓名);
    Dalao findBy序号(int 序号);
    List<Dalao> findBy姓名Like(String name);
    Page<Dalao> findAll(Pageable pageable);
    long count();
}
