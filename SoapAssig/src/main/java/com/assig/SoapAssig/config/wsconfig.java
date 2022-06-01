//package com.assig.soapassig.config;
//
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.ws.config.annotation.EnableWs;
//import org.springframework.ws.config.annotation.WsConfigurerAdapter;
//import org.springframework.ws.transport.http.MessageDispatcherServlet;
//import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
//import org.springframework.xml.xsd.SimpleXsdSchema;
//import org.springframework.xml.xsd.XsdSchema;
//
//@EnableWs
//@Configuration
//public class wsconfig extends WsConfigurerAdapter {
//
//	
//	//during startup to register our application
//	@Bean
//	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
//		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
//		servlet.setApplicationContext(applicationContext);
//		servlet.setTransformWsdlLocations(true);
//		return new ServletRegistrationBean(servlet, "/soapEmp/*");
//	}
//	@Bean(name = "employees")
//	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema employeeSchema) {
//		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
//		wsdl11Definition.setPortTypeName("employeeServiceEmp");
//		wsdl11Definition.setLocationUri("/soapEmp");
//		wsdl11Definition.setTargetNamespace("http://SoapAssig.assig.com/interfaces");
//		wsdl11Definition.setSchema(employeeSchema);
//		return wsdl11Definition;
//	}
//	
//	
//	
//	@Bean
//	public XsdSchema employeeSchema() {
//		return new SimpleXsdSchema(new ClassPathResource("employee.xsd"));
//	}
//	
//}
