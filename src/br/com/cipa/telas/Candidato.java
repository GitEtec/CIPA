/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cipa.telas;

import br.com.cipa.dal.conexao;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Aluno
 */
public class Candidato {
    
    
    
    
    public void insereCandidato(int num, String nome, String apelido, String setor, int idade, int tempo){
           
        Connection con = conexao.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
    
    
        try 
        {
           ps = con.prepareStatement("insert into cad_candidato"
                   + "(numero,nome,apelido,setor,idade,tempo) "
                   + "values(?,?,?,?,?,? )");
           ps.setInt(1, num);
           ps.setString(2, nome);
           ps.setString(3, apelido);
           ps.setString(4, setor);
           ps.setInt(5, idade);
           ps.setInt(6,tempo);
        } 
        catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(null,"Erro ao inserir" + ex);
        }
    
    
    
    }
   
    
    
 
        
        
    
}
