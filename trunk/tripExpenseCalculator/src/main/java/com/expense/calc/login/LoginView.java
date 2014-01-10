package com.expense.calc.login;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.VerticalLayout;

public class LoginView extends VerticalLayout implements View {

	public LoginView() {
		LoginForm loginForm = new LoginForm();
		addComponent(loginForm);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

}
