package com.alok.tags;

import java.io.*;
import java.util.*;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class StudentTag extends TagSupport {
	private String sid;
	private Map<String, String> info = null;

	public Map<String, String> getInfo() {
		return info;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		info = new HashMap<String, String>();
		return EVAL_BODY_INCLUDE;
	}

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		try {
			Writer out = pageContext.getOut();
			out.write("<table border='1' bordercolor='blue'>"
					+ "<tr bgcolor='lightblue'>"
					+ "<td colspan='3' align='center'>"
					+ "<h1>STUDENT INFORMATION" + "</h1></td></tr>");
			out.write("<tr bgcolor='lightgreen'>" + "<td align='center'>"
					+ "<h2>ID</td>");

			Object nm = info.get("sname");
			if (nm != null) {
				out.write("<td align='center'><h2>Name</td>");
			}
			Object eml = info.get("email");
			if (eml != null)
				out.write("<td align='center'><h2>Email</td>");
			out.write("</tr>");
			out.write("<tr><td align='center'><h2>" + sid + "</td>");
			if (nm != null)
				out.write("<td align='center'><h2>" + nm + "</td>");
			if (eml != null)
				out.write("<td align='center'><h2>" + eml + "</td>");
			out.write("</tr>");
			out.write("</table>");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}
}
