package com.alok.tags;

import java.util.*;

import javax.management.RuntimeErrorException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class EmailTag extends TagSupport {
	private String value;

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		Tag tag = getParent();
		if (value.trim().length() != 0) {
			if (tag instanceof StudentTag) {
				StudentTag stag = (StudentTag) tag;
				Map<String, String> map = stag.getInfo();
				if (map.get("email") == null) {
					map.put("email", value);
				} else {
					String eml = map.get("email");
					map.put("email", eml + "<br />" + value);
				}
			} else {
				throw new RuntimeException(
						"Email must be used with STUDENT tag");
			}
		}
		return EVAL_PAGE;
	}

}
