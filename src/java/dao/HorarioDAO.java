/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Horario;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.ConnectionFactory;

/**
 *
 * @author Kaique
 */
public class HorarioDAO {
    
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
    
    public List<Horario> list(){
        startSession();
        t = session.beginTransaction();
        List l = session.createQuery("From Horario").list();
        t.commit();
        closeSession();
        return l;
    }
    
    public boolean save(Horario h){
        try{
            startSession();
            t = session.beginTransaction();
            session.save(h);
            t.commit();
            closeSession();
            return true;
        }catch(Exception e){
            System.err.println(e.toString());
            return false;
        }
    }
    
    public Horario getNextHorario(String horario){
        startSession();
        t = session.beginTransaction();
        Query q = session.createQuery("From Horario WHERE horarioInicio >= :horario order by horarioInicio");
        q.setParameter("horario", horario);
        q.setMaxResults(1);
        Horario h = (Horario) q.uniqueResult();
        return h;
    }
    
}
