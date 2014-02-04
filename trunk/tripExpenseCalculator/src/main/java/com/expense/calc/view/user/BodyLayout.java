package com.expense.calc.view.user;

import com.vaadin.ui.HorizontalSplitPanel;

public class BodyLayout extends HorizontalSplitPanel {

	private NavigationTree navigationTree;
	private ContentLayout contentLayout;

	public BodyLayout() {
		setHeight("500px");
		setSplitPosition(300, Unit.PIXELS);
		navigationTree = new NavigationTree();
		setFirstComponent(navigationTree);
		contentLayout = new ContentLayout();
		setSecondComponent(contentLayout);
	}

	public ContentLayout getContentLayout() {
		return contentLayout;
	}
}
