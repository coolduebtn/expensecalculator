package com.expense.calc.view.user;

import org.springframework.security.core.context.SecurityContextHolder;

import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

@SuppressWarnings("serial")
public class HeaderLayout extends HorizontalLayout {
	
	public HeaderLayout(String username) {
		Label labelLogin = new Label("Username: " + username);
		addComponent(labelLogin);
		
		Button logout = new Button("Logout");

		logout.addClickListener(createLogoutListerner());
		addComponent(logout);
		}
	
	private ClickListener createLogoutListerner() {

		return new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				SecurityContextHolder.clearContext();
				UI.getCurrent().close();
				Navigator navigator = UI.getCurrent().getNavigator();
				navigator.navigateTo("login");

			}
		};
	}

}
