package com.expense.calc.view.user;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

public class FooterLayout extends HorizontalLayout {
	
	public FooterLayout() {
		Label label = new Label("Created by me.");
		addComponent(label);
		}

}
