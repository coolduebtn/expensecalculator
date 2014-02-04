package com.expense.calc.view.user;

import com.expense.calc.MyVaadinUI;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.Tree;

public class NavigationTree extends Tree {

	public NavigationTree() {
		setCaption("Navigation");
		addItem(MenuHelper.PROJECTS_LABEL);
		setChildrenAllowed(MenuHelper.PROJECTS_LABEL, true);
		addChild(MenuHelper.CREATE_NEW_LABEL, MenuHelper.PROJECTS_LABEL);

		addChild(MenuHelper.MYPROJECTS_LABEL, MenuHelper.PROJECTS_LABEL);

		expandItemsRecursively(MenuHelper.PROJECTS_LABEL);
		setNullSelectionAllowed(false);

		addItemClickListener(createItemClickListener());
	}

	private void addChild(String child, String parent) {
		addItem(child);
		setParent(child, parent);
		setChildrenAllowed(child, false);
	}

	private ItemClickListener createItemClickListener() {
		return new ItemClickListener() {

			@Override
			public void itemClick(ItemClickEvent event) {
				Object value = event.getItemId();
				MyVaadinUI current = MyVaadinUI.getCurrent();
				ContentLayout contentLayout = current.getUserView()
						.getBodyLayout().getContentLayout();
				contentLayout.removeAllComponents();
				contentLayout.addComponent(MenuHelper.getContentByUserClick(value));
			}

		};
	}

}
