package com.expense.calc;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextHolder implements ApplicationContextAware {

	private static ApplicationContext context = null;

	public void setApplicationContext(ApplicationContext context) throws BeansException {
		changeContext(context);
	}

	private static void changeContext(ApplicationContext ctx) {
		context = ctx;
	}

	public static ApplicationContext getContext() {
		return context;
	}

}
