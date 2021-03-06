package griffio.config;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import griffio.order.repository.OrderRepository;
import griffio.product.repository.ProductRepository;
import net.ttddyy.dsproxy.listener.SLF4JQueryLoggingListener;
import net.ttddyy.dsproxy.support.ProxyDataSource;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "griffio")
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = {OrderRepository.class, ProductRepository.class},
    repositoryImplementationPostfix = "Extension")
public class ApplicationConfiguration {

  @Autowired
  private Environment env;

  private EmbeddedDatabase buildDataSource() {
    return new EmbeddedDatabaseBuilder()
        .addScripts("example-schema.sql", "example-data.sql")
        .setName("datasource1")
        .build();
  }

  @Bean
  public DataSource dataSource() {
    ProxyDataSource proxyDataSource = new ProxyDataSource();
    proxyDataSource.setDataSource(buildDataSource());
    proxyDataSource.setListener(new SLF4JQueryLoggingListener());
    return proxyDataSource;
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
    entityManagerFactoryBean.setDataSource(dataSource);
    entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
    entityManagerFactoryBean.setPackagesToScan("griffio");
    return entityManagerFactoryBean;
  }

  @Bean
  public PersistenceExceptionTranslationPostProcessor repositoryExceptionTranslation() {
    return new PersistenceExceptionTranslationPostProcessor();
  }

  @Bean
  public JpaVendorAdapter jpaVendorAdapter() {
    HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
    jpaVendorAdapter.setDatabase(Database.HSQL);
    jpaVendorAdapter.setGenerateDdl(false);
    jpaVendorAdapter.setShowSql(true);
    return jpaVendorAdapter;
  }

  @Bean
  public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
    return new JpaTransactionManager(entityManagerFactory);
  }

  @Bean
  public Supplier<LocalDateTime> systemTime() {
    return Suppliers.ofInstance(new LocalDateTime());
  }

}