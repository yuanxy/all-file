package com.svse.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.svse.dao.WenDAO;
import com.svse.entity.WenEntity;

public class MyServlet extends HttpServlet
{

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		WenDAO dao = new WenDAO();
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("all"))
		{
			// 全查询
			List ar = dao.getAll();
			request.setAttribute("myall", ar);
			request.getRequestDispatcher("/all.jsp").forward(request, response);
		}
		else
		{
			// 增加
			String w_title = request.getParameter("w_title");
			String w_lj = request.getParameter("strfile");

			List ar=new ArrayList();
			String a[] = w_lj.split(",");
			for(int i=0;i<a.length;i++)
			{
				WenEntity w=new WenEntity();
				w.setW_title(w_title);
				w.setW_lj(a[i]);
				ar.add(w);
			}
			
			dao.addWen(ar);
			
			//全查询
			
			List arx = dao.getAll();
			request.setAttribute("myall", arx);
			request.getRequestDispatcher("/all.jsp").forward(request, response);
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		doPost(request, response);
	}

}
