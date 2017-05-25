/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Horario;
import bean.Servico;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kaique
 */
public class teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Horario> l = new ArrayList<>();
        l = new HorarioDAO().list();
        System.out.println(new Gson().toJson(l));
    }
    
}
