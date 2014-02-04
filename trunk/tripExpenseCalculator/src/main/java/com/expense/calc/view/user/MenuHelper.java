package com.expense.calc.view.user;

import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;

public class MenuHelper {
	
	public static final String PROJECTS_LABEL = "Projects";
	public static final String CREATE_NEW_LABEL = "Create New";
	public static final String MYPROJECTS_LABEL = "My Projects";
	
	public static Component getContentByUserClick(Object value) {
		Component content = new VerticalLayout();
		if (MenuHelper.CREATE_NEW_LABEL.equals(value)) {
			//TODO layout for creating new project
		} else if (MenuHelper.MYPROJECTS_LABEL.equals(value)) {
			//TODO layout for listing all projects
		}
		
		return content;
		
	}
}
