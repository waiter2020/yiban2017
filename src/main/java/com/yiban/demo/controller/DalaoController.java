package com.yiban.demo.controller;

import com.yiban.demo.model.Dalao;
import com.yiban.demo.service.DalaoService;
import com.yiban.demo.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by dalao on 17-12-26.
 */
@Controller
@RequestMapping("/")
public class DalaoController extends HttpServlet{
    @Autowired
    private DalaoService dalaoService;
    private String uri;

    @RequestMapping("/")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //获取“当前页”参数；  (第一次访问当前页为null)
            String currPage = req.getParameter("currentPage");

            // 判断
            if (currPage == null || "".equals(currPage.trim())){
                currPage = "1";  	// 第一次访问，设置当前页为1;
            }
            currPage = currPage.trim();
            // 转换
            int currentPage = Integer.parseInt(currPage);

            // 创建PageBean对象，设置当前页参数； 传入service方法参数
            PageBean<Dalao> pageBean = new PageBean<Dalao>();
            pageBean.setCurrentPage(currentPage);

            //调用service
            dalaoService.findAll(pageBean);    // 【pageBean已经被dao填充了数据】

            //保存pageBean对象，到request域中
            req.setAttribute("pageBean", pageBean);

            // 跳转
            uri = "/list.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            // 出现错误，跳转到错误页面；给用户友好提示
            uri = "/error.jsp";
        }
        req.getRequestDispatcher(uri).forward(req, resp);

    }
    @RequestMapping("/change")
    public void change(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String ids =req.getParameter("id");
        ids=ids.trim();
        resp.setCharacterEncoding("UTF-8");
        if(ids==null||ids.equals("")){
            resp.setContentType("text/html");
            PrintWriter writer = resp.getWriter();
            writer.println("<!doctype html>");
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<meta charset=\"UTF-8\">\n" +
                    "  <meta name=\"Generator\" content=\"EditPlus®\">\n" +
                    "  <meta name=\"Author\" content=\"\">\n" +
                    "  <meta name=\"Keywords\" content=\"\">\n" +
                    "  <meta name=\"Description\" content=\"\">");
            writer.println("<title>出错啦!</title></head>");
            writer.println("<body>");
            writer.println("叫你别乱动你不听！");
            writer.println("</body>");
            writer.println("</html>");
        }else {
            Dalao dalao =dalaoService.findById(Integer.valueOf(ids));
            resp.setContentType("text/html");

            PrintWriter writer = resp.getWriter();
            writer.println("<!doctype html>");
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<meta charset=\"UTF-8\">\n" +
                    "  <meta name=\"Generator\" content=\"EditPlus®\">\n" +
                    "  <meta name=\"Author\" content=\"\">\n" +
                    "  <meta name=\"Keywords\" content=\"\">\n" +
                    "  <meta name=\"Description\" content=\"\">");
            writer.println("<title>修改信息</title></head>");
            writer.println("<body>");
            writer.println("<form action=\"/changeend\" align=\"center\">\n" +
                    "序号:<br>\n" +
                    "<input type=\"text\" name=\"id\" value=\""+Integer.valueOf(ids)+"\" readonly=\"readonly\">\n" +
                    "<br>\n" +
                    "部门:<br>\n" +
                    "<input type=\"text\" name=\"department\" value=\""+dalao.get部门()+"\">\n" +
                    "<br>\n" +
                    "职位:<br>\n" +
                    "<input type=\"text\" name=\"position\" value=\""+dalao.get职位()+"\">\n" +
                    "<br>\n" +
                    "姓名:<br>\n" +
                    "<input type=\"text\" name=\"name\" value=\""+dalao.get姓名()+"\">\n" +
                    "<br>\n" +
                    "性别:<br>\n" +
                    "<input type=\"text\" name=\"Gender\" value=\""+dalao.get性别()+"\">\n" +
                    "<br>\n" +
                    "专业班级:<br>\n" +
                    "<input type=\"text\" name=\"class\" value=\""+dalao.get专业班级()+"\">\n" +
                    "<br>\n" +
                    "联系方式:<br>\n" +
                    "<input type=\"text\" name=\"Telephone\" value=\""+dalao.get联系方式()+"\">\n" +
                    "<br>\n" +
                    "<br><br>\n" +
                    "<input type=\"submit\" value=\"提交\">\n" +
                    "</form>");
            writer.println("</body>");
            writer.println("</html>");
        }
    }
    @RequestMapping("/changeend")
    public String changeEnd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String ids =req.getParameter("id").trim();
        Dalao dalao = new Dalao(Integer.valueOf(ids),req.getParameter("department"), req.getParameter("position"), req.getParameter("name"),req.getParameter("Gender"),req.getParameter("class"), req.getParameter("Telephone"));
        dalaoService.Change(dalao);
        return "success";
    }
    @RequestMapping("/add")
    public void addDalao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<!doctype html>");
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<meta charset=\"UTF-8\">\n" +
                "  <meta name=\"Generator\" content=\"EditPlus®\">\n" +
                "  <meta name=\"Author\" content=\"\">\n" +
                "  <meta name=\"Keywords\" content=\"\">\n" +
                "  <meta name=\"Description\" content=\"\">");
        writer.println("<title>添加信息</title></head>");
        writer.println("<body>");
        writer.println("<form action=\"/addend\"align=\"center\">\n" +

                "部门:<br>\n" +
                "<input type=\"text\" name=\"department\">\n" +
                "<br>\n" +
                "职位:<br>\n" +
                "<input type=\"text\" name=\"position\">\n" +
                "<br>\n" +
                "姓名:<br>\n" +
                "<input type=\"text\" name=\"name\">\n" +
                "<br>\n" +
                "性别:<br>\n" +
                "<input type=\"text\" name=\"Gender\" >\n" +
                "<br>\n" +
                "专业班级:<br>\n" +
                "<input type=\"text\" name=\"class\">\n" +
                "<br>\n" +
                "联系方式:<br>\n" +
                "<input type=\"text\" name=\"Telephone\">\n" +
                "<br>\n" +
                "<br><br>\n" +
                "<input type=\"submit\" value=\"提交\">\n" +
                "</form>");
        writer.println("</body>");
        writer.println("</html>");
    }
    @RequestMapping("/addend")
    public String addEnd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        Dalao dalao = new Dalao(req.getParameter("department").trim(), req.getParameter("position").trim(), req.getParameter("name").trim(),req.getParameter("Gender").trim(),req.getParameter("class").trim(), req.getParameter("Telephone").trim());
        dalaoService.Change(dalao);
        return "success";
    }
    @RequestMapping("/delete")
    public String delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String ids =req.getParameter("id").trim();
        dalaoService.delete(Integer.valueOf(ids));
        return "success";
    }
    @RequestMapping("/search")
    public void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String name = req.getParameter("name").trim();
        PageBean<Dalao> pageBean = new PageBean<Dalao>();
        pageBean.setCurrentPage(1);
        dalaoService.findByname(name,pageBean);
        req.setAttribute("pageBean", pageBean);
        req.getRequestDispatcher("/list.jsp").forward(req, resp);
    }
}
