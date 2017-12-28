package com.yiban2017.demo.repositty;

import com.yiban2017.demo.model.Dalao;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by dalao on 17-12-26.
 */
public interface DalaoReposity extends CrudRepository<Dalao,Integer>{
    Iterable<Dalao> findBy姓名(String 姓名);

}
