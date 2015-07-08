package com.example.primedemo.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.component.panel.Panel;

import com.example.primedemo.util.JSFUtil;

@ManagedBean
@RequestScoped
public class DummyBean {

	private Panel panel;

	public void test() {
		/*
		 * Editor e = new Editor(); this.getPanel().getChildren().add(e);
		 */

		JSFUtil.includeCompositeComponent(this.getPanel(), "dummy", "dummy.xhtml", "myDummyComp");
	}

	public Panel getPanel() {
		return panel;
	}

	public void setPanel(Panel panel) {
		this.panel = panel;
	}

}
