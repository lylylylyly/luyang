package com.luyang.config;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.ContextResource;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiObjectFactoryBean;
import javax.naming.NamingException;
import javax.sql.DataSource;
 
@Configuration
public class TomcatConfigs {
 
    @Bean
    public TomcatServletWebServerFactory tomcatFactory() {
 
        return new TomcatServletWebServerFactory() {
            @Override
            protected TomcatWebServer getTomcatWebServer(Tomcat tomcat) {
                tomcat.enableNaming();
                return super.getTomcatWebServer(tomcat);
            }
 
            @Override
            protected void postProcessContext(Context context) {
                ContextResource resource = new ContextResource();
                resource.setType(DataSource.class.getName());
                resource.setName("jdbc/mydb");
                resource.setProperty("factory", "org.apache.commons.dbcp2.BasicDataSourceFactory");
                resource.setProperty("driverClassName", "com.mysql.jdbc.Driver");
                resource.setProperty("url", "jdbc:mysql://localhost:3306/luyang?useUnicode=true&characterEncoding=UTF-8&useSSL=false");
                resource.setProperty("username", "root");
                resource.setProperty("password", "123456");
 
                context.getNamingResources().addResource(resource);
            }
        };
    }
 
    @Bean
    public DataSource jndiDataSource() throws IllegalArgumentException, NamingException {
        JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
        bean.setJndiName("java:/comp/env/jdbc/mydb");
        bean.setProxyInterface(DataSource.class);
        bean.setLookupOnStartup(false);
        bean.afterPropertiesSet();
        return (DataSource) bean.getObject();
    }
}
