package securechat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
/**
 *
 * @author Jitender
 */

public class MainUser extends javax.swing.JFrame
{
    
        Thread t;
       int port=6000;
       static String dfileStr;
       //private String name;
       static String userName="X";
       static File encryptFile;
       public static  Socket s;
       public static ServerSocket ss;
       static DataInputStream din;
       static DataOutputStream dout;
    
    static ServerSocket ss4;
    static Socket s4;                // Socket Object
    static DataInputStream din4;     // DataInputstream Object 
    static DataOutputStream dout4;   // DataOutputstream Object
    
    static ServerSocket ss5;
    static Socket s5;                // Socket Object
    static DataInputStream din5;     // DataInputstream Object 
    static DataOutputStream dout5;   // DataOutputstream Object
    
    static ServerSocket ss3;
   
    public MainUser() 
     {
       initComponents();  
       setTitle("Main User");
        
     }
     public void clear()
    {
        tf.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta = new javax.swing.JTextArea();
        tf = new javax.swing.JTextField();
        sendButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        browseButton = new javax.swing.JButton();
        encrypt = new javax.swing.JToggleButton();
        decrypt = new javax.swing.JToggleButton();
        clearButton = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        nameTF = new javax.swing.JTextField();
        connectButton = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MainUser");
        setMaximizedBounds(getMaximizedBounds());
        setResizable(false);

        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        ta.setEditable(false);
        ta.setBackground(new java.awt.Color(228, 228, 243));
        ta.setColumns(20);
        ta.setRows(5);
        jScrollPane1.setViewportView(ta);

        tf.setEditable(false);
        tf.setBackground(new java.awt.Color(228, 228, 243));
        tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfActionPerformed(evt);
            }
        });
        tf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfKeyTyped(evt);
            }
        });

        sendButton.setBackground(new java.awt.Color(227, 225, 237));
        sendButton.setForeground(new java.awt.Color(0, 0, 102));
        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        jList1.setBackground(new java.awt.Color(228, 228, 243));
        jScrollPane2.setViewportView(jList1);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("online");

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Monotype Corsiva", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 0, 153));
        jLabel3.setText("Chat Messenger");

        jLabel4.setText("Message Box");

        browseButton.setForeground(new java.awt.Color(0, 0, 153));
        browseButton.setText("Browse");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        encrypt.setText("Encrypt");
        encrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encryptActionPerformed(evt);
            }
        });

        decrypt.setText("Decrypt");
        decrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decryptActionPerformed(evt);
            }
        });

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Name");

        nameTF.setBackground(new java.awt.Color(225, 225, 245));
        nameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTFActionPerformed(evt);
            }
        });

        connectButton.setText("Connect");
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(22, 22, 22))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 22, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(sendButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(browseButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addContainerGap())))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(clearButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(decrypt)
                                        .addComponent(encrypt))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(68, 68, 68)
                .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(connectButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(connectButton))
                .addGap(3, 3, 3)
                .addComponent(jLabel2)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(encrypt)
                        .addGap(31, 31, 31)
                        .addComponent(decrypt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clearButton)))
                .addGap(11, 11, 11)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(browseButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sendButton))
                    .addComponent(tf, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        // TODO add your handling code here:
        System.out.println("button 1 pressed");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(this);

        
        try{
            if(dout != null || dout4 != null){
            if(result == JFileChooser.APPROVE_OPTION){
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());

             String pathtopic = selectedFile.getAbsolutePath();
            if(encrypt.isSelected()){
            System.out.println("button 1 pressed in encryption mode");
            File file = new File(pathtopic);
            File efile = FileEncryptDecrypt.encryptFile(file);
            byte[] bytesArray = new byte[(int) efile.length()];

            FileInputStream fis = new FileInputStream(efile);// creating new file input stream

            fis.read(bytesArray); //read file into bytes[]
            fis.close();// closing the stream

            int size = (int) efile.length();// file size is stored
            //String msgout = "Encrypted File Received";
            String efilename = efile.getName();
                    System.out.println("efile.getName();"+efilename);
                    String s[]=efilename.split("\\.");
                    String msgout="Encrypted File Received";
                    if(s.length == 2){
                        System.err.println("s.length:"+s.length);
                        msgout = msgout+"."+efilename;
                    }
            dout5.writeUTF(msgout);//send "pic" string
            dout5.writeInt(size);//send size
            dout5.write(bytesArray);// file sent
            efile.delete();
            ta.append("\n"+jList1.getModel().getElementAt(0)+" "+"Encrypted File Sent");
            
            
            }else{
            
            System.out.println("button 1 pressed");
            File file = new File(pathtopic);

            //init array with file length
            byte[] bytesArray = new byte[(int) file.length()];

            FileInputStream fis = new FileInputStream(file);

            fis.read(bytesArray); //read file into bytes[]
            fis.close();

            int size = (int) file.length();
            //String msgout = "File Received";
            String filename = file.getName();
                    System.out.println("file.getName();"+filename);
                    String s[]=filename.split("\\.");
                    String msgout="File Received";
                    System.out.println("s: "+s[0]+s[1]);
                    if(s.length == 2){
                        System.err.println("s.length:"+s.length);
                        msgout = msgout+"."+filename;
                    }
            
            dout.writeUTF(msgout);
            dout.writeInt(size);
            dout.write(bytesArray);
                System.err.println("file sent");
            ta.append("\n"+jList1.getModel().getElementAt(0)+" "+"File Sent: "+filename);
            }
            }else if(result == JFileChooser.CANCEL_OPTION){
            JOptionPane.showMessageDialog(browseButton,"Nothing is selected");
            }
            }else{
            JOptionPane.showMessageDialog(browseButton,"Not connected to server");
            }
        }
        catch(Exception e){
               JOptionPane.showMessageDialog(browseButton,"Error in browsing file");
            e.printStackTrace();
        }

    }//GEN-LAST:event_browseButtonActionPerformed

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
       if(tf.getText().length() > 0){
        if(encrypt.isSelected()){
            try{
                String msgout = "";
                //new DH();
                msgout = tf.getText().trim();
                String digSign = SHA.getSHA256Hash(msgout); // getText()- returns string, trim() - omits whitespaces and unicodes
                String digSign_Encrypt=AES.encrypt(digSign); // Calling Encrypt function
                String aes_encrypt=AES.encrypt(msgout); // Calling Encrypt function
                dout4 = new DataOutputStream(s4.getOutputStream());//Creating new output stream
                dout4.writeUTF(digSign_Encrypt);// Writes an encrypted message digest using SHA-256
                dout4.writeUTF(aes_encrypt); //Writes an encrypted data to the output stream using modified UTF-8 encoding.
                dout.writeUTF("Encrypted message received press decrypt...");
                String msgout1 = "Nothing here";
                dout5.writeUTF(msgout1);//send "pic" string
           
                System.out.println("The Encrypted msg is :"+aes_encrypt );
                ta.setText(ta.getText().trim()+"\n"+jList1.getModel().getElementAt(0)+" "+msgout);
                // msgarea.setText(msgarea.getText().trim()+"\n Server: This is the Encrypted Msg ("+aes_encrypt+")");
            }catch(Exception e){
            }
        }else{
            try{

                ta.append("\n"+jList1.getModel().getElementAt(0)+" "+tf.getText().trim());
                try {
                    dout.writeUTF(jList1.getModel().getElementAt(0)+" "+tf.getText().trim());
                } catch (IOException ex) {
                    Logger.getLogger(MainUser.class.getName()).log(Level.SEVERE, null, ex);
                }
                tf.setText("");
                tf.requestFocus();
            }catch(Exception e){
            }
        }
        clear();
       }else{
            JOptionPane.showMessageDialog(sendButton,"Enter something to send");
       }
    }//GEN-LAST:event_sendButtonActionPerformed

    private void tfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfKeyTyped

        if(port==0)
        {
            JOptionPane.showMessageDialog(this,"Client Is Offline");
        }

    }//GEN-LAST:event_tfKeyTyped

    private void tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfActionPerformed
        // TODO add your handling code here:
        if(!tf.getText().matches("")&& port!=0)
        {
            tf.setText("");
            tf.requestFocus();
        }
    }//GEN-LAST:event_tfActionPerformed

    private void encryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encryptActionPerformed
        // TODO add your handling code here:
         if(encrypt.isSelected()){
             ta.setText(ta.getText().trim()+"\n"+"Encryption Enabled");
        }
        else{
        ta.setText(ta.getText().trim()+"\n"+"Encryption Disabled");
        }
        
    }//GEN-LAST:event_encryptActionPerformed

    private void decryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decryptActionPerformed
        // TODO add your handling code here:
         try{
                
             if(din4 != null){
             if(dfileStr.contains("Nothing here")){
                String dig_Sign = din4.readUTF();
                String dig_Sign_Decrypt=AES.decrypt(dig_Sign);
                String msgin = din4.readUTF();
               
                String aes_decrypt=AES.decrypt(msgin);
                String current_Dig_Sign = SHA.getSHA256Hash(aes_decrypt);
                if(current_Dig_Sign.equals(dig_Sign_Decrypt)){
                final String out=(ta.getText().trim()+"\n"+jList1.getModel().getElementAt(1)+" "+aes_decrypt);
                SwingUtilities.invokeLater(new Runnable() {
                             public void run() {
                                 ta.setText(out);
                             }
                         });
                 System.out.println(msgin);
               }else{
                    ta.setText("Error... the message is modified");
               }
               decrypt.setSelected(false);
             }else if(dfileStr.contains("Encrypted File Received")){
                     System.out.println("pic received!");
                     System.out.println("encryptFile: "+encryptFile);
                    FileEncryptDecrypt.decryptFile(encryptFile);
                    ta.append("\nFile decrypted");
                    System.out.println("File decrypted");
                    decrypt.setSelected(false);
             }
             }else{
                JOptionPane.showMessageDialog(decrypt,"Nothing to decrypt");
                 decrypt.setSelected(false);
             
             }
                
        }catch (Exception e) {
                e.printStackTrace();
            }
    }//GEN-LAST:event_decryptActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        if(clearButton.isSelected())// checks if the button is selected or not
        {
             ta.setText("");
             clearButton.setSelected(false);
        }
    }//GEN-LAST:event_clearButtonActionPerformed

    private void nameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTFActionPerformed

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
        // TODO add your handling code here:
        if(!nameTF.getText().equalsIgnoreCase("")){
        userName = nameTF.getText().trim();
        nameTF.setEditable(false);
        connectButton.setSelected(false);

        }else{
        JOptionPane.showMessageDialog(connectButton,"Enter something in name");
        connectButton.setSelected(false);
        }
    }//GEN-LAST:event_connectButtonActionPerformed

      
       
    public static void main(String args[]) throws Exception {
        String msgin = "";
        
        new DH();
       Thread t = new Thread();
     java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() 
            {
                try
                {
                new MainUser().setVisible(true);
                }
                catch(Exception e)
                {
                    System.out.println(e.getMessage());
                }
                }
        });
        try{
           ss = new ServerSocket (6000);
           s = ss.accept();
           ss4 = new ServerSocket (6004);
           s4 = ss4.accept();
           ss5 = new ServerSocket (6005);
           s5 = ss5.accept();
           tf.setEditable(true);
           ta.setText(ta.getText().trim()+"New User is connected");
           System.out.println("connection accepted");
           din = new DataInputStream(s.getInputStream());
           dout = new DataOutputStream(s.getOutputStream());
           din4 = new DataInputStream(s4.getInputStream());
           dout4 = new DataOutputStream(s4.getOutputStream());
            din5 = new DataInputStream(s5.getInputStream());
           dout5 = new DataOutputStream(s5.getOutputStream());
           
           dout.writeUTF(userName);        
           String strArray[] = din.readUTF().split(":");
           System.out.println("strArray[0]"+strArray[0]);
             String[] s={userName+":",strArray[0]+":"};
                jList1.removeAll();
                 jList1.setListData(s);
                 System.out.println("list updated");
                 BigInteger bigInt = null;
                  String str="";
                 dout.writeUTF(DH.str);
                 if(din.available() != -1){
                 str = din.readUTF();
                 }
                bigInt = new BigInteger(str.getBytes()); 
                 DH.secretA = bigInt;
                 //new DH();
                 DH.DHEncrypt();
           while(!msgin.equals("exit")){
               if (din.available() > 0){
               final String out;
               msgin = din.readUTF();
               out=(ta.getText().trim()+"\n"+msgin);
               SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
                                ta.setText(out);
                            }
                        });
               
               System.out.println("msg received: " +msgin);
               if(msgin.contains("File Received")){
                   String ext[] = msgin.split("\\.");
                   System.out.println("pic received!");
                   // create buffer
                   int size = din.readInt();
                   System.out.println("the size :" + size);
                byte[] picbytes = new byte[size];
                din.readFully(picbytes);
                FileOutputStream fos;
                if(ext.length == 3){
                    System.out.println("ext.length == 2"+ext[1]);
                fos = new FileOutputStream(ext[1]+"."+ext[2]);
                }else{
                    System.out.println("else ext none");
                fos = new FileOutputStream(ext[1]);
                }
                fos.write(picbytes);
                fos.close();
               }
               }
               if(din5.available() > 0){
                   String str1 = din5.readUTF();
                   dfileStr = str1;
               if(str1.contains("Encrypted File Received")){
                   String ext[] = str1.split("\\.");  
                   System.out.println("pic received!");
                   // create buffer
                   int size = din5.readInt();
                   System.out.println("the size :" + size);
                byte[] picbytes = new byte[size];
                din5.readFully(picbytes);
                FileOutputStream fos;
                if(ext.length == 3){
                    encryptFile=new File(ext[1]+"."+ext[2]);
                fos = new FileOutputStream(ext[1]+"."+ext[2]);
                }else{
                    encryptFile=new File(ext[1]);
                fos = new FileOutputStream(ext[1]);
                }
                fos.write(picbytes);
                fos.close();
                ta.append("\nEncrypted File Received");
               }
             
               }
           }
    }catch(Exception e){
            }
  
 }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseButton;
    private javax.swing.JToggleButton clearButton;
    private javax.swing.JToggleButton connectButton;
    private javax.swing.JToggleButton decrypt;
    private javax.swing.JToggleButton encrypt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private static javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JTextField nameTF;
    private javax.swing.JButton sendButton;
    private static javax.swing.JTextArea ta;
    private static javax.swing.JTextField tf;
    // End of variables declaration//GEN-END:variables

   
}
