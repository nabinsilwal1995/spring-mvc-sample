package com.igctech.firstspringproject.config;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.igctech.firstspringproject.HelloController;
public class WebApp implements  WebApplicationInitializer {
	
	public void onStartup(ServletContext container)throws ServletException {
      AnnotationConfigWebApplicationContext rootContext =  new AnnotationConfigWebApplicationContext();
      rootContext.register(HelloController.class);
      rootContext.setServletContext(container);
      
      AnnotationConfigWebApplicationContext dispatcherContext =   new AnnotationConfigWebApplicationContext();
      dispatcherContext.register(Config.class);

      ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
      dispatcher.setLoadOnStartup(1);
      dispatcher.addMapping("/");
    }
}
