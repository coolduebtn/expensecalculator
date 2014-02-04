package com.expense.calc.view.user;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.expense.calc.MyVaadinUI;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.VerticalLayout;

public class UserView extends VerticalLayout implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1577927242877113114L;

	private HeaderLayout headerLayout;
	private BodyLayout bodyLayout;
	private FooterLayout footerLayout;

	@Override
	public void enter(ViewChangeListener.ViewChangeEvent event) {
		removeAllComponents();
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		if (authentication != null && authentication.isAuthenticated()) {
			setMargin(true);
			headerLayout = new HeaderLayout(authentication.getName());
			addComponent(headerLayout);
			bodyLayout = new BodyLayout();
			addComponent(bodyLayout);
			footerLayout = new FooterLayout();
			addComponent(footerLayout);

		} else {
			Navigator navigator = MyVaadinUI.getCurrent().getNavigator();
			navigator.navigateTo(MyVaadinUI.LOGIN_VIEW);
		}

	}

	public HeaderLayout getHeaderLayout() {
		return headerLayout;
	}

	public BodyLayout getBodyLayout() {
		return bodyLayout;
	}

	public FooterLayout getFooterLayout() {
		return footerLayout;
	}

}
