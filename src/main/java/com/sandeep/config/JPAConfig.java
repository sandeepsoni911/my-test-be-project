package com.sandeep.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

import com.zaxxer.hikari.HikariDataSource;

/**
 * Configuration class to setup 1. EnityManager 2. DataSource 3.
 * TransactionManager 4. flexibility to add additional properties
 *
 * @author sonisan
 * @version 1.0
 */
@Configuration
@EnableTransactionManagement
@ComponentScan( { "com.sandeep" } )
@EnableJpaRepositories( { "com.sandeep.repository" } )
@EnableWebMvc
public class JPAConfig {
	
	

	private static final Logger logger = LoggerFactory.getLogger(JPAConfig.class);

    @Value( "${jdbc.url}" )
    private String dbURL;
    
    @Value( "${jdbc.driver}") 
    private String driverClass;
    
    @Value( "${jdbc.username}" )
    private  String dbUser;
    
    @Value( "${jdbc.password}"  )
    private  String dbPassword;
    
    @Value( "10" ) 
    private Integer maxPoolSize;
    
    @Value( "org.hibernate.dialect.MySQL5Dialect" )
    private  String hibernateDialect;
    
    @Value( "true" )
    private  String showSql;
    
    @Value( "true" )
    private  String hbm2ddlStrategy;
    
    @Value( "10" )
    private  int restTemplateMaxConnection;
    
    @Value( "10" ) 
    private int restTemplateMaxConnectionPerRoute;

    /**
     * default constructor
     */
    public JPAConfig() {
        super();
    }

    /**
     * FactoryBean that creates a JPA EntityManagerFactory according to JPA's
     * standard container bootstrap contract. This is the most powerful way to
     * set up a shared JPA EntityManagerFactory in a Spring application context;
     * the EntityManagerFactory can then be passed to JPA-based DAOs via
     * dependency injection. Note that switching to a JNDI lookup or to a
     * LocalEntityManagerFactoryBean definition is just a matter of
     * configuration!
     *
     * @return LocalContainerEntityManagerFactoryBean entityManagerFactoryBean
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource( dataSource() );
        em.setPackagesToScan( new String[] { "com.sandeep.entity" } );

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter( vendorAdapter );
        em.setJpaProperties( additionalProperties() );

        return em;
    }

    
   
    /**
     * Provides a utility class for easy DataSource access, a
     * PlatformTransactionManager for a single DataSource, and various simple
     * DataSource implementations.
     *
     * @return DataSource dataSource
     */
    @Bean
    public DataSource dataSource() {
        final HikariDataSource dataSource = new HikariDataSource();
        //final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        logger.info( "driverClass : " + driverClass + " dbURL   : " + dbURL );
        dataSource.setDriverClassName( driverClass );
         dataSource.setJdbcUrl( dbURL );
         dataSource.setMaximumPoolSize( maxPoolSize );
       // dataSource.setUrl( dbURL );
        dataSource.setUsername( dbUser );
        dataSource.setPassword( dbPassword );
        return dataSource;
    }

    /**
     * This is the central interface in Spring's transaction infrastructure.
     * Applications can use this directly, but it is not primarily meant as API:
     * Typically, applications will work with either TransactionTemplate or
     * declarative transaction demarcation through AOP.
     *
     * @param emf
     *            - EntityManagerFactory.
     *
     * @return PlatformTransactionManager transactionManager
     */
    @Bean
    public PlatformTransactionManager transactionManager( final EntityManagerFactory emf ) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory( emf );

        return transactionManager;
    }

    /**
     * Bean post-processor that automatically applies persistence exception
     * translation to any bean marked with Spring's @Repository annotation,
     * adding a corresponding PersistenceExceptionTranslationAdvisor to the
     * exposed proxy (either an existing AOP proxy or a newly generated proxy
     * that implements all of the target's interfaces).
     *
     * @return PersistenceExceptionTranslationPostProcessor
     *         persistenceExceptionTranslationPostProcessor
     */
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    /**
     * The Properties class represents a persistent set of properties. The
     * Properties can be saved to a stream or loaded from a stream. Each key and
     * its corresponding value in the property list is a string.
     *
     * @return additionalProperties
     */
    final Properties additionalProperties() {
        final Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty( "hibernate.dialect", hibernateDialect );
        hibernateProperties.setProperty( "hibernate.show_sql", showSql );
        hibernateProperties.setProperty( "hibernate.hbm2ddl.auto", hbm2ddlStrategy );
        return hibernateProperties;
    }

   
    
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations(
				"/resources/");
	}
    
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        PropertySourcesPlaceholderConfigurer c = new PropertySourcesPlaceholderConfigurer();
        c.setLocation(new ClassPathResource("application.properties"));
        return c;
    }

	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions(new String[] { "/WEB-INF/tiles.xml" });
		tilesConfigurer.setCheckRefresh(true);
		return tilesConfigurer;
	}

	@Bean
	public UrlBasedViewResolver urlBasedViewResolver() {
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		viewResolver.setViewClass(TilesView.class);
		viewResolver.setOrder(2);
		return viewResolver;
	}

	@Bean
	public InternalResourceViewResolver jspViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/pages/*/");
		viewResolver.setSuffix(".*");
		viewResolver.setOrder(3);
		return viewResolver;
	}
	
	@Bean
	public InternalResourceViewResolver ftlViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/ftl/forms/");
		viewResolver.setSuffix(".ftl");
		viewResolver.setOrder(4);
		return viewResolver;
	}
    
    @Bean
	public FreeMarkerConfigurer freeMarkerConfigurer() {
		FreeMarkerConfigurer config = new FreeMarkerConfigurer();
		config.setTemplateLoaderPath("/ftl");
		return config;
	}

	@Bean
	public FreeMarkerViewResolver freeMarkerViewResolver() {
		FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
		viewResolver.setExposeSpringMacroHelpers(true);
		viewResolver.setPrefix("/");
		viewResolver.setSuffix(".ftl");
		viewResolver.setOrder(1);
		viewResolver.setContentType("text/html;charset=UTF-8");
		return viewResolver;
	}
	
//	 @Bean
//	    public WebMvcConfigurer corsConfigurer() {
//	        return new WebMvcConfigurerAdapter() {
//	            @Override
//	            public void addCorsMappings(CorsRegistry registry) {
//	                registry.addMapping("/greeting-javaconfig").allowedOrigins("http://localhost:9000");
//	            }
//	        };
//	    }
    
    
}
