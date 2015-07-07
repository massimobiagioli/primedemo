package com.example.primedemo.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.component.editor.Editor;
import org.primefaces.component.panel.Panel;

@ManagedBean
@RequestScoped
public class DummyBean {
	
	private Panel panel;
	
	public void test() {
		Editor e = new Editor();
		this.getPanel().getChildren().add(e);
	}

	public Panel getPanel() {
		return panel;
	}

	public void setPanel(Panel panel) {
		this.panel = panel;
	}
	
}
