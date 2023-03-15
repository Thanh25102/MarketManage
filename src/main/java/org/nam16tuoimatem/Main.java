package org.nam16tuoimatem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.nam16tuoimatem.config.HibernateInitialize;
import org.nam16tuoimatem.dao.CategoryDao;
import org.nam16tuoimatem.entity.CategoryEntity;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Main {
    public static void main(String[] args) throws IOException {
        CategoryDao categoryDao = new CategoryDao();
        System.out.println(categoryDao.findOne(1).toString());
    }
}