package com.expense.calc;

import javax.servlet.annotation.WebServlet;

import com.expense.calc.view.login.LoginView;
import com.expense.calc.view.user.UserView;
import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
@SuppressWarnings("serial")
@PreserveOnRefresh
public class MyVaadinUI extends UI
{
	
    public static final String USER_VIEW = "user";
	public static final String LOGIN_VIEW = "login";

	@WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "com.expense.calc.AppWidgetSet")
    public static class Servlet extends VaadinServlet {
    }

	private UserView userView;
    
    @Override
    protected void init(VaadinRequest request) {
    	Navigator navigator = new Navigator(this, this);
    	navigator.addView(LOGIN_VIEW, LoginView.class);
    	userView=new UserView();
    	navigator.addView(USER_VIEW, userView);
    	navigator.navigateTo(LOGIN_VIEW);
    	setNavigator(navigator);
    }
    
    public UserView getUserView() {
		return userView;
	}
    
    public static MyVaadinUI getCurrent() {
    	return (MyVaadinUI) UI.getCurrent();
    }

}
