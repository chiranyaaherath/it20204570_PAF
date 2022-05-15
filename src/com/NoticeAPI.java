package com;

import model.Notice;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@WebServlet("/NoticeAPI")
public class NoticeAPI extends HttpServlet {
	private static final long serialVersionNID = 1L;
	//private Object userObj;
	
	 Notice noticeObj = new Notice();
   
    public NoticeAPI() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String output = Obj.insertNotice(
				request.getParameter("Notice_Title"),
				request.getParameter("Notice_Time"),
				request.getParameter("Notice_Date"),
				request.getParameter("Area")
				request.getParameter("Description"));
		
				response.getWriter().write(output);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map paras = getParasMap(request);
		String output = noticeObj.updateNotice(paras.get("hidNoticeSave").toString(),
				 paras.get("Notice_Title").toString(),
				paras.get("Notice_Time").toString(),
				paras.get("Notice_Date").toString(),
				paras.get("Area").toString()
				paras.get("Description").toString());
		
		response.getWriter().write(output);
	} 
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Map paras = getParasMap(request);
		String output = noticeObj.deleteNotice(paras.get("Notice_ID").toString());
		response.getWriter().write(output);
	}

	private static Map getParasMap(HttpServletRequest request)
	{
		Map<String, String> map = new HashMap<String, String>();
	try
	 {
		 Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
		 String queryString = scanner.hasNext() ?
		 scanner.useDelimiter("\\A").next() : "";
		 scanner.close();
		 String[] params = queryString.split("&");
		 for (String param : params)
	 { 
		 String[] p = param.split("=");
		 map.put(p[0], p[1]);
		 }
	}
		catch (Exception e)
			 {
			 }
		return map;
			}
}
