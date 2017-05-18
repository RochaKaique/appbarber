/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Servico;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.ConnectionFactory;

/**
 *
 * @author Kaique
 */
public class ServicoDAO {
    
    private static Session session;
    private static Transaction t = null;
    public static final void startSession() {
        session = ConnectionFactory.getInstance();
    }

    public static void closeSession() {
        if (session.isOpen()) {
            session.flush();
            session.close();
        }
    }
    
    public List<Servico> list(){
        startSession();
        t = session.beginTransaction();
        List l = session.createQuery("From Servico").list();
        t.commit();
        closeSession();
        return l;
    }
    
}
