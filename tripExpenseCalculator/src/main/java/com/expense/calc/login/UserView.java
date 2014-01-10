package com.expense.calc.login;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class UserView extends VerticalLayout implements View {

	@Override
	public void enter(ViewChangeListener.ViewChangeEvent event) {
		removeAllComponents();
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		if (authentication != null && authentication.isAuthenticated()) {
			String name = authentication.getName();
			Label labelLogin = new Label("Username: " + name);
			addComponent(labelLogin);
			Collection<? extends GrantedAuthority> authorities = authentication
					.getAuthorities();
			for (GrantedAuthority ga : authorities) {
				String authority = ga.getAuthority();
				if ("ADMIN".equals(authority)) {
					Label lblAuthority = new Label(
							"You are the administrator. ");
					addComponent(lblAuthority);
				} else {
					Label lblAuthority = new Label("Granted Authority: "
							+ authority);
					addComponent(lblAuthority);
				}
			}

			Button logout = new Button("Logout");

			logout.addClickListener(createLogoutListerner());
			addComponent(logout);
		} else {
			Navigator navigator = UI.getCurrent().getNavigator();
			navigator.navigateTo("login");
		}

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
