package com.expense.calc.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.expense.calc.MyVaadinUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.*;

import org.springframework.security.authentication.
UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.
AuthenticationException;
import org.springframework.security.core.context.
SecurityContextHolder;

@Component
public class LoginForm extends VerticalLayout {
	
	@Autowired
	private AuthManager authManager;

	private TextField txtLogin = new TextField("Login: ");
	private PasswordField txtPassword = new PasswordField("Password: ");
	private Button btnLogin = new Button("Login");

	public LoginForm() {
		addComponent(txtLogin);
		addComponent(txtPassword);
		addComponent(btnLogin);
		btnLogin.addClickListener(createLoginFormListener());
	}

	private ClickListener createLoginFormListener() {
		return new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				try {
					Button source = event.getButton();
					LoginForm parent = (LoginForm) source.getParent();
					String username = parent.getTxtLogin().getValue();
					String password = parent.getTxtPassword().getValue();
					UsernamePasswordAuthenticationToken request = new UsernamePasswordAuthenticationToken(
							username, password);
					Authentication result = authManager.authenticate(request);
					SecurityContextHolder.getContext()
							.setAuthentication(result);
					MyVaadinUI current = (MyVaadinUI) UI.getCurrent();
					Navigator navigator = current.getNavigator();
					navigator.navigateTo("user");
				} catch (AuthenticationException e) {
					Notification.show("Authentication failed: "
							+ e.getMessage());
				}

			}
		};
	}

	public TextField getTxtLogin() {
		return txtLogin;
	}

	public PasswordField getTxtPassword() {
		return txtPassword;
	}

}
