package org.nam16tuoimatem.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.nam16tuoimatem.entity.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class HibernateInitialize {
    /**
     * Add entity to session factory of hibernate
     */
    private static final List<Class> classes = List.of(
        Category.class, Customers.class, Order.class, OrderDetail.class, Vegetable.class
    );
    public static SessionFactory factory = build();
    private static SessionFactory build() {
        Configuration configuration = new Configuration().setProperties(properties());
        /**
         * Make session factory get current session
         */
        configuration.setProperty("hibernate.current_session_context_class", "thread");
        classes.forEach(configuration::addAnnotatedClass);
        return configuration.buildSessionFactory();
    }
    private static Properties properties() {
        try (InputStream input = HibernateInitialize.class.getClassLoader().getResourceAsStream("hibernate.properties")) {
            Properties properties = new Properties();
            properties.load(input);
            return properties;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
