package com.lxisoft.mockexamjavaconfig.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class FrontController extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class[]
				{
					 AppContext.class,SecurityConfig.class 
				};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[] { WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		
		return new String[] {"/"};
	}

}
