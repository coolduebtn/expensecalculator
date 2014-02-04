package com.expense.calc.view.login;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.VerticalLayout;

public class LoginView extends VerticalLayout implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5180953507685647434L;

	public LoginView() {
		removeAllComponents();
		LoginForm loginForm = new LoginForm();
		addComponent(loginForm);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

}
