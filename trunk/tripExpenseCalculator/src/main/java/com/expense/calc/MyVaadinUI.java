package com.expense.calc;

import javax.servlet.annotation.WebServlet;

import com.expense.calc.login.LoginView;
import com.expense.calc.login.UserView;
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

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "com.expense.calc.AppWidgetSet")
    public static class Servlet extends VaadinServlet {
    }

    
    @Override
    protected void init(VaadinRequest request) {
    	Navigator navigator = new Navigator(this, this);
    	navigator.addView("login", LoginView.class);
    	navigator.addView("user", UserView.class);
    	navigator.navigateTo("login");
    	setNavigator(navigator);
    }

}
