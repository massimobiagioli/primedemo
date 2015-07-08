package com.example.primedemo.util;

import java.io.IOException;

import javax.faces.FacesException;
import javax.faces.application.Application;
import javax.faces.application.Resource;
import javax.faces.component.UIComponent;
import javax.faces.component.UIPanel;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;

public class JSFUtil {
	public static void includeCompositeComponent(UIComponent parent, String libraryName, String resourceName, String id) {
	    // Prepare.
	    FacesContext context = FacesContext.getCurrentInstance();
	    Application application = context.getApplication();
	    FaceletContext faceletContext = (FaceletContext) context.getAttributes().get(FaceletContext.FACELET_CONTEXT_KEY);

	    // This basically creates <ui:component> based on <composite:interface>.
	    Resource resource = application.getResourceHandler().createResource(resourceName, libraryName);
	    UIComponent composite = application.createComponent(context, resource);
	    composite.setId(id); // Mandatory for the case composite is part of UIForm! Otherwise JSF can't find inputs.

	    // This basically creates <composite:implementation>.
	    UIComponent implementation = application.createComponent(UIPanel.COMPONENT_TYPE);
	    implementation.setRendererType("javax.faces.Group");
	    composite.getFacets().put(UIComponent.COMPOSITE_FACET_NAME, implementation);

	    // Now include the composite component file in the given parent.
	    parent.getChildren().add(composite);
	    parent.pushComponentToEL(context, composite); // This makes #{cc} available.
	    try {
	        faceletContext.includeFacelet(implementation, resource.getURL());
	    } catch (IOException e) {
	        throw new FacesException(e);
	    } finally {
	        parent.popComponentFromEL(context);
	    }
	}
}
