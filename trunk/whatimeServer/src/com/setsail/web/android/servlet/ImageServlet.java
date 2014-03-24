package com.setsail.web.android.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.alibaba.fastjson.JSON;
import com.setsail.entity.response.StateEnum;
import com.setsail.entity.response.SystemState;

@WebServlet
public class ImageServlet extends HttpServlet {

	private static final long serialVersionUID = -5363002601681374598L;

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		super.service(request, response);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 获取文件上传域
		Part part = request.getPart("file");
		// 每个Part对象对应于一个文件上传域，该对象提供的大量方法来访问上传文件的文件类型，大小，输入流等。并提供一个write（String
		// file）将上传文件写入服务器磁盘。
		part.write(getServletContext().getRealPath("/uploadFiles")
				+ "/filename");
		out.write(JSON.toJSONString(new SystemState(
				StateEnum.STATE_SUCCESS
				)));
	}

}
