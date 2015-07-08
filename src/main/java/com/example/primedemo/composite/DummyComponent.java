package com.example.primedemo.composite;

import javax.faces.component.FacesComponent;
import javax.faces.component.UINamingContainer;
import javax.faces.component.UIOutput;

@FacesComponent("dummyComponent")
public class DummyComponent extends UIOutput {
	public final static String COMPONENT_TYPE = "test.ComponentCCC";

	public String getFamily() {
		return UINamingContainer.COMPONENT_FAMILY;
	}
	
	public void test() {
		System.out.println("*** Inside the component ***");
	}
}
