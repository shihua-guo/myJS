package com.briup.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test.do")
public class CheckNameServlet extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = req.getParameter("username");
		System.out.println("name:"+name);
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plian;charset=UTF-8");
		PrintWriter pw = resp.getWriter();
		if("zhangsan".equals(name)){
			pw.println("验证通过！");
		}else{
			pw.println("验证失败！用户名不正确！");
		}
		pw.flush();
		pw.close();
	}
}
