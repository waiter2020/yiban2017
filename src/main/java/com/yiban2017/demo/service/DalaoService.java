package com.yiban2017.demo.service;

import com.yiban2017.demo.model.Dalao;
import com.yiban2017.demo.repositty.DalaoReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dalao on 17-12-26.
 */
@Service
public class DalaoService {
    @Autowired
    private DalaoReposity dalaoReposity;

    public Object createDalao(String 部门, String 职位, String 姓名, String 性别, String 专业班级, String 联系方式){
        Dalao dalao = new Dalao(部门, 职位, 姓名, 性别, 专业班级, 联系方式);
        return dalaoReposity.save(dalao);
    }

    public Object findByname(String 姓名){
        Iterable<Dalao> dalaoIterable= dalaoReposity.findBy姓名("%"+姓名+"%");
        return  dalaoIterable;
    }

    public Object findAll(){
        Iterable<Dalao> dalaoIterable=dalaoReposity.findAll();
        return dalaoIterable;
    }

    public Object count(){
        return dalaoReposity.count();
    }
}
