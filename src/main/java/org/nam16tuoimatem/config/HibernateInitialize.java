package org.nam16tuoimatem.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.nam16tuoimatem.entity.Category;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class HibernateInitialize {
    private static List<Class> classes = List.of(Category.class);
    public static SessionFactory factory = build();

    private static SessionFactory build() {
        Configuration configuration = new Configuration().setProperties(properties());
        configuration.setProperty("hibernate.current_session_context_class", "thread");
        classes.forEach(clazz -> {
            configuration.addAnnotatedClass(clazz);
        });
        return configuration.buildSessionFactory();
    }

    private static Properties properties() {
        try (InputStream input = HibernateInitialize.class.getClassLoader().getResourceAsStream("hibernate.properties");) {
            Properties properties = new Properties();
            properties.load(input);
            return properties;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
