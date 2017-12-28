package com.yiban.demo.service;

import com.yiban.demo.model.Dalao;
import com.yiban.demo.repositty.DalaoReposity;
import com.yiban.demo.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * Created by dalao on 17-12-26.
 */
@Service
public class DalaoService {
    @Autowired
    private DalaoReposity dalaoReposity;

    public Object createDalao(int 序号,String 部门, String 职位, String 姓名, String 性别, String 专业班级, String 联系方式){
        Dalao dalao = new Dalao(序号,部门, 职位, 姓名, 性别, 专业班级, 联系方式);
        return dalaoReposity.save(dalao);
    }

    public void findByname(String 姓名,PageBean<Dalao> pb){
        List<Dalao> dalaoIterable= dalaoReposity.findBy姓名Like(姓名);
        pb.setPageData(dalaoIterable);
        pb.setTotalCount(dalaoIterable.size());

    }

    public Dalao findById(int id){
        return dalaoReposity.findBy序号(id);
    }

    public void Change(Dalao dalao){
        dalaoReposity.save(dalao);
    }

    public void findAll(PageBean<Dalao> pb){

        pb.setTotalCount(count());
        if (pb.getCurrentPage()<=0) {
            pb.setCurrentPage(1);					    // 把当前页设置为1
        } else if (pb.getCurrentPage() > pb.getTotalPage()){
            pb.setCurrentPage(pb.getTotalPage());		// 把当前页设置为最大页数
        }

        //1. 获取当前页： 计算查询的起始行、返回的行数
        int currentPage = pb.getCurrentPage();
        int index = (currentPage -1 ) * pb.getPageCount();		// 查询的起始行
        int count = pb.getPageCount();
        Pageable pageable = new PageRequest(currentPage-1,count, Sort.Direction.ASC,"序号");
        Page<Dalao> page = dalaoReposity.findAll(pageable);
        pb.setPageData(page.getContent());

    }
    public void delete(int id){
        dalaoReposity.delete(id);
    }
    public int count(){
        return new Long(dalaoReposity.count()).intValue();
    }

    public void addDalao(Dalao dalao){
        dalaoReposity.save(dalao);
    }
}
