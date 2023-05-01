/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Adm;

import Classes.Carro;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class ImagemV extends javax.swing.JFrame {

    /**
     * Creates new form ImagemV
     */
    Carro carro=new Carro();
    
  
    
    public ImagemV() {
        initComponents();
        RegistroM();
    }
    
    Connection con;
     PreparedStatement pst;
    
 public void regI(int id1){
     
       ArrayList<Integer>lista=carro.lista(id1);
     
     
     String[] columnsName={"Imagens"};
     
     Object[][] rows=new Object[lista.size()][columnsName.length];
     
     for(int i=0;i<lista.size();i++){
         
         rows[i][0]=lista.get(i);
     }
     DefaultTableModel mod=new DefaultTableModel(rows,columnsName );
     Imagens.setModel(mod);
     
     
     
 }
     
    public void RegistroM(){
        
              
int y;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/consesionaria","root","");
            
            
            pst=con.prepareStatement("select * from regveiculos");
             ResultSet rs=pst.executeQuery();
             
              ResultSetMetaData yr= rs.getMetaData();
             
              
              y=yr.getColumnCount();
              
             DefaultTableModel df=(DefaultTableModel)table.getModel();
             df.setRowCount(0);
             
           while(rs.next()){
            Vector v1=new Vector();
            
            for (int i=1;i<=y;i++){
                
               v1.add(rs.getString("id"));
               v1.add(rs.getString("marca"));
               v1.add(rs.getString("modelo"));
               
               
        }
        df.addRow(v1);

             
              }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VerClientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VerClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
          
    public String imag(){
         
         JFileChooser file=new JFileChooser();
         file.setDialogTitle("Selecione uma imagem");
         
         file.setCurrentDirectory(new File("C:\\Users\\Admin\\Pictures\\Logo dos carros"));
         FileNameExtensionFilter filtro =new FileNameExtensionFilter("image",".png",".jpg");
         file.addChoosableFileFilter(filtro);
         
         int st=file.showSaveDialog(null);
         String path="";


         if(st==JFileChooser.APPROVE_OPTION){
             
             path = file.getSelectedFile().getAbsolutePath();
               
         }
         
         
         return path;
     }
     
   public void mostrat2(int width,int height,byte[] image_byte, JLabel label){
        
//pegar a imagem

ImageIcon imc=new ImageIcon(image_byte);

//tamanho
Image image= imc.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);

label.setIcon(new ImageIcon(image));
         
    }
    
   
  
    public void mostrat(int width,int height,String image_path, JLabel label){
        
//pegar a imagem

ImageIcon imc=new ImageIcon(image_path);

//tamanho
Image image= imc.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);

label.setIcon(new ImageIcon(image));
         
    }
    
    
     public ArrayList<Integer> listaV(int id1){
            
        
        ArrayList<Integer> imagem=new ArrayList<>();
        
    String c=id.getText();
           
           try{
               
        pst=con.prepareStatement("select id,id1,logo from imagem where id1= "+ id1);

               
               pst.setString(1,c);
          ResultSet rs1=pst.executeQuery();
               
               while(rs1.next()){
                   
                   imagem.add(rs1.getInt(2));

                   
               }
           
             }       catch (SQLException ex) {     
            Logger.getLogger(ImagemV.class.getName()).log(Level.SEVERE, null, ex);
        }
           return imagem;

        //Segunda parte
        }

     public void lista(int id1){
         
         
         ArrayList<Integer> imagem1 = listaV(ERROR); 
         
         String[] nomec={"ID do veiculo"};
         
         Object[][] linhas =new Object[imagem1.size()][nomec.length];
         
         
         for (int i=0;i<imagem1.size();i++){
             
             linhas[i][0]=imagem1.get(i);
         }
     }

  
     
     
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        im1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        id = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Imagens = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Marca", "Modelo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table.setRowHeight(30);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        im1.setBackground(new java.awt.Color(204, 204, 255));
        im1.setOpaque(true);

        jButton1.setText("Remover");

        jButton2.setText("Adicionar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Pesquisar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        id.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N

        Imagens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Imagens"
            }
        ));
        Imagens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImagensMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Imagens);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 264, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(im1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(im1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(id, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        
        try {
            // TODO add your handling code here:


         String id1=id.getText();
         
                   
               byte [] logo= Files.readAllBytes(Paths.get(jLabel1.getText()));
               
            Class.forName("com.mysql.jdbc.Driver");
          con=DriverManager.getConnection("jdbc:mysql://localhost:3306/consesionaria","root","");

          
            pst=con.prepareStatement("insert into imagem (id1,logo) values (?,?)");
            
            
            
            pst.setString(1, id1);
            pst.setBytes(2, logo);
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(this,"Imagem adicionada com sucesso");
            
           
           im1.setIcon(null);
           
            int pos=table.getSelectedRow();
        int i=Integer.valueOf(table.getValueAt(pos,0).toString());
        
           regI(i);
           regI(i);
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "A imagem e muito grande","Erro",JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,"Adicione uma imagem do veiculo");
        }
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
          String imagepath= imag();
        
        mostrat(im1.getWidth(), im1.getHeight(), imagepath, im1);
        
       //Para mostrar o caminho da imagem
        
       jLabel1.setText(imagepath);
        
        
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        
               
         DefaultTableModel m=(DefaultTableModel )table.getModel();
        
        int sel=table.getSelectedRow();
      
        id.setText(m.getValueAt(sel,0).toString());
        
    String c=id.getText();
    
    int id2=Integer.valueOf(m.getValueAt(sel, 0).toString());
        
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/consesionaria","root","");

         
            pst=con.prepareStatement("select * from regveiculos where id=?");
            
           pst.setString(1,c);
            
             ResultSet rs=pst.executeQuery();
            
             
             while(rs.next()){
        
                 
              byte [] im=(rs.getBytes(3));
              
                 
         
            
        mostrat2(im1.getWidth(), im1.getHeight(), im, im1);
        
             }
                    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Marca.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Marca.class.getName ()).log(Level.SEVERE, null, ex);
        }
        
        int pos=table.getSelectedRow();
        int i=Integer.valueOf(table.getValueAt(pos,0).toString());
        
           regI(i);
         
    }//GEN-LAST:event_tableMouseClicked

    private void ImagensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImagensMouseClicked
        // TODO add your handling code here:
        
   DefaultTableModel m=(DefaultTableModel )Imagens.getModel();
        
        int sel=Imagens.getSelectedRow();
      
        id.setText(m.getValueAt(sel,0).toString());
        
    String c=id.getText();
        
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/consesionaria","root","");

         
            pst=con.prepareStatement("select * from marca where id=?");
            
           pst.setString(1,c);
            
             ResultSet rs=pst.executeQuery();
            
             
             while(rs.next()){
        
                 
              byte [] im=(rs.getBytes(3));
                 
         
            
        mostrat2(im1.getWidth(), im1.getHeight(), im, im1);
}
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Marca.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Marca.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }//GEN-LAST:event_ImagensMouseClicked

      
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ImagemV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImagemV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImagemV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImagemV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImagemV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Imagens;
    private javax.swing.JTextField id;
    private javax.swing.JLabel im1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
