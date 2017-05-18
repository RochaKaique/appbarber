/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Kaique
 */
public class ConnectionFactory {
private static final SessionFactory sessionFactory;
    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();

    /* observe o que temos de importante 
     * nesse bloco static, o arquivo
     * que possui os dados de conexao com 
     * o banco de dados hibernateconfig.xml 
     */

    static {
        try {
            sessionFactory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();

        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    //retorna uma sessao de comunicacao com o BD
    public static Session getInstance() {
        Session session = threadLocal.get();
        session = sessionFactory.openSession();
        threadLocal.set(session);
        return session;
    }
}
