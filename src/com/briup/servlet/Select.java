package com.briup.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Select
 */
@WebServlet("/Select")
public class Select extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String[][] citys = {
    		{"东莞","广州","深圳"},
    		{"苏州","南京","昆山"}
    };
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Select() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("测试-------------------------");
		//设置编码
		System.out.println("设置编码");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//接受province的id
		System.out.println("接受province的id");
		String id = request.getParameter("id");
		System.out.println(id);
		//设置响应类型
		System.out.println("设置响应类型");
		response.setContentType("text/xml;charset=utf-8");
		//设置响应头部
		System.out.println("设置响应头部");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		//获取对应省份的city
		System.out.println("获取对应省份的city");
		String[] city = citys[Integer.parseInt(id)];
		//获取字符输出流
		System.out.println("获取字符输出流");
		PrintWriter pw = response.getWriter();
		pw.write("<citys>");
		for(String c:city){
			System.out.println("进入for");
			pw.write("<city>");
			pw.write(c);
			pw.write("</city>");
		}
		pw.write("</citys>");
		pw.flush();
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
