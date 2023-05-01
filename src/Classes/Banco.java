/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import Bank.Cconta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class Banco extends Dados{
    
    private String bi;
    private int cartao;
    private double saldo;

     Connection con;
        PreparedStatement pst;
        ResultSet rs;
        
        
    

    public Banco(String nome, int idade, String cell, String senha, String senha2) {
        super(nome, idade, cell, senha, senha2);
    }
    
    public Banco(String bi, int cartao, double saldo, String nome, int idade, String cell, String senha, String senha2) {
        super(nome, idade, cell, senha, senha2);
        this.bi = bi;
        this.cartao = cartao;
        this.saldo = saldo;
    }

    public String getBi() {
        return bi;
    }

    public void setBi(String bi) {
        this.bi = bi;
    }

    public int getCartao() {
        return cartao;
    }

    public void setCartao(int cartao) {
        this.cartao = cartao;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    
    
    public void bank(String bi, int cartao, double saldo, String nome, int idade, String cell, String senha, String senha2){
        
        
          try {
            Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/consesionaria","root","");

            pst=con.prepareStatement("insert into cartao (nome,idade,cell,edentidade,cartao,senha,saldo) values (?,?,?,?,?,?,?)");

            pst.setString(1, nome);
            pst.setInt(2, idade);
            pst.setString(3, cell);
            pst.setString(4, bi);
            pst.setInt(5, cartao);
            pst.setString(6, senha);
            pst.setDouble(7, saldo);
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Conta criada com sucesso");
            
           
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cconta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Cconta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    
    
    
    
    
}
