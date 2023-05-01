/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import Bank.Cconta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Admin
 */
public class Conta extends Dados {
   
    private String end;
    private String carta;
   
    Connection con;
    PreparedStatement pst;

    public Conta(String nome, int idade, String cell, String senha, String senha2) {
        super(nome, idade, cell, senha, senha2);
    }
    
  

    public Conta( String end, String carta,String nome, int idade, String cell,String senha,String senha2) {
       
        super(nome,idade,cell,senha,senha2);
        this.end = end;
        this.carta = carta;
        
    }

   

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getCarta() {
        return carta;
    }

    public void setCarta(String carta) {
        this.carta = carta;
    }

    
    
     
    
    public void registrar(String nome,int idade,String cell,String end,String carta,String senha,String senha2){
        
        
           try {
            // TODO add your handling code here:
            
           Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/consesionaria","root","");
            
            
            pst=con.prepareStatement("insert into conta (nome,idade,celular,endereco,carta,senha) values (?,?,?,?,?,?)");
           
          
            pst.setString(1,nome);
            pst.setInt(2,idade);
            pst.setString(3,cell);
            pst.setString(4,end);
            pst.setString(5,carta);
           pst.setString(6,senha);
            
            pst.executeUpdate();
            
            
             int conf=JOptionPane.showConfirmDialog(null, "Ja tem uma conta no nosso banco?","Importante",JOptionPane.YES_NO_OPTION);
             
             if(conf==JOptionPane.YES_OPTION){
                 
             
             
             
             
            JOptionPane.showMessageDialog(null, "Conta criada com sucesso");
            

             }
             else{
                 
                 JOptionPane.showMessageDialog(null,"Vc precisa criar uma conta para continuar");
                 
                 Cconta cc=new Cconta();
                 
                 cc.setVisible(true);
                 
             }
             
        } catch (ClassNotFoundException ex) {
           // Logger.getLogger(SingIn.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (SQLException ex) {
           // Logger.getLogger(SingIn.class.getName()).log(Level.SEVERE, null, ex
           JOptionPane.showInternalInputDialog(null,"Complete todos os espacos","Erro",JOptionPane.ERROR_MESSAGE);
        }
        
        
        
    }
    
    
    
    
    
}
