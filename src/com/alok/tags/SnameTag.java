package com.alok.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.*;

import java.util.*;
import java.io.*;

public class SnameTag extends TagSupport {
	private String value;

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		if (value == null || value.trim().length() == 0) {
			throw new RuntimeException("SNAME value is not defined");
		} else {
			Tag tag = getParent();
			if (tag instanceof StudentTag) {
				StudentTag stag = (StudentTag) tag;
				Map<String, String> map = stag.getInfo();
				if (map.get("sname") == null) {
					map.put("sname", value);
				} else {
					throw new RuntimeException(
							"Only one SNAME tag should be used");
				}
			} else {
				throw new RuntimeException(
						"SNAME must be used with STUDENT tag");
			}
		}
		return EVAL_PAGE;
	}
}
