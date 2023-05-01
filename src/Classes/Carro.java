/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;



import Adm.ImagemV;
import Adm.RegVeiculos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */


     
        
public class Carro {
    

    
    private String marca;
    private String modelo;
    private String tipo;
    private String tanque;
    private int pass;
    private double preco;
    private String disp;
    private String cor;
    private String ac;
    private String airbag;
    private String som;

    
        
   Connection con;
       PreparedStatement pst;
       ResultSet rs;
    
    
    public Carro() {
    }

   
    public Carro(String marca, String modelo, String tipo, String tanque, int pass, double preco,String disp, String cor, String ac, String airbag, String som) {
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
        this.tanque = tanque;
        this.pass = pass;
        this.preco = preco;
        this.disp = disp;
        this.cor = cor;
        this.ac = ac;
        this.airbag = airbag;
        this.som = som;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTanque() {
        return tanque;
    }

    public void setTanque(String tanque) {
        this.tanque = tanque;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    
    public String getDisp() {
        return disp;
    }

    public void setDisp(String disp) {
        this.disp = disp;
    }
    
    

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getAc() {
        return ac;
    }

    public void setAc(String ac) {
        this.ac = ac;
    }

    public String getAirbag() {
        return airbag;
    }

    public void setAirbag(String airbag) {
        this.airbag = airbag;
    }

    public String getSom() {
        return som;
    }

    public void setSom(String som) {
        this.som = som;
    }
    
   
    
    public void registrat(String marca1,String modelo1,String tipo,String tank,int pass1,double preco1
            ,String disp1,String cor1,String ac1,String airbag,String som){
        
        
        
        
          try {
            Class.forName("com.mysql.jdbc.Driver");
                    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/consesionaria","root","");

           pst=con.prepareStatement("insert into regveiculos (marca,modelo,tipo,tanque,pass,preco,disponivel,cor,ac,airbag,som) values (?,?,?,?,?,?,?,?,?,?,?)");
          
           pst.setString(1,marca1);   
           pst.setString(2,modelo1);   
           pst.setString(3,tipo);   
           pst.setString(4,tank);   
           pst.setInt(5,pass1);   
           pst.setDouble(6,preco1);   
           pst.setString(7,disp1);   
           pst.setString(8,cor1);   
           pst.setString(9,ac1);   
           pst.setString(10,airbag);   
           pst.setString(11,som);   
           
           pst.executeUpdate();
           
                
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegVeiculos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RegVeiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
          
          
    }
    
    

       public ArrayList<Integer>lista(int id1){
        
    ArrayList<Integer> imagem=new ArrayList<>();
    
    
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/consesionaria","root","");

            pst=con.prepareStatement("select * from imagem where id1 = "+id1);
            
                  ResultSet rs=pst.executeQuery();

              while(rs.next()){
                  
                  imagem.add(rs.getInt(1));
                  
              }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ImagemV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ImagemV.class.getName()).log(Level.SEVERE, null, ex);
        }

    
return imagem;    
     
       }
    
    
    
           
       }
    
    
    

