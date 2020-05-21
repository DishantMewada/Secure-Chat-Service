package securechat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jitender
 */
public class SecondUser extends javax.swing.JFrame implements Runnable {

        public static  Socket s;
        static DataInputStream din;      // DataInputstream Object
        static DataOutputStream dout;
        static String dfileStr;
         static File encryptFile;
        String  ip="";
        static String nameFirst = "";
      static Socket s4;                // Socket Object
    static DataInputStream din4;     // DataInputstream Object 
    static DataOutputStream dout4;   // DataOutputstream Object
    static Socket s5;                // Socket Object
    static DataInputStream din5;     // DataInputstream Object 
    static DataOutputStream dout5;   // DataOutputstream Object
    static FileInputStream aa;       // FileInputStream Object
    static ObjectOutputStream aas;   // ObjectOutputStream
    static boolean flag = false;
    static String ipstr;
   
        
        public SecondUser() 
        {
            initComponents();
            setTitle("Second User");
           
            
        }
        public void clear() // Clear() - it clears msg text area every time after send button is pressed 
        {
          tf.setText(""); // sets textfield to null
        }
        public void process()
        {
            Thread t= new Thread(this);
            //t.start();
        }
        public void run() 
          {
             while(true)
               {
                 try
                   {
                       
                    // ta.append("Server:"+br.readLine()+"\n");
                   }
                 catch(Exception e)
                   {}
               }
          }
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta = new javax.swing.JTextArea();
        tf = new javax.swing.JTextField();
        sendButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        tfIpAddress = new javax.swing.JTextField();
        tfIpAddress.setVisible(false);
        connectButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        browseButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        encrypt = new javax.swing.JToggleButton();
        decrypt = new javax.swing.JToggleButton();
        clearButton = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SecondUser");
        setResizable(false);

        jPanel1.setMaximumSize(new java.awt.Dimension(409, 518));

        ta.setEditable(false);
        ta.setBackground(new java.awt.Color(225, 225, 245));
        ta.setColumns(20);
        ta.setRows(5);
        jScrollPane1.setViewportView(ta);

        tf.setEditable(false);
        tf.setBackground(new java.awt.Color(225, 225, 245));
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

        sendButton.setBackground(new java.awt.Color(228, 223, 239));
        sendButton.setForeground(new java.awt.Color(0, 0, 102));
        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Name");

        jLabel2.setBackground(new java.awt.Color(153, 102, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));

        tfName.setBackground(new java.awt.Color(225, 225, 245));
        tfName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNameActionPerformed(evt);
            }
        });

        tfIpAddress.setBackground(new java.awt.Color(225, 225, 245));
        tfIpAddress.setText("localhost");

        connectButton.setBackground(new java.awt.Color(228, 223, 239));
        connectButton.setForeground(new java.awt.Color(0, 0, 102));
        connectButton.setText("Connect");
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });

        jList1.setBackground(new java.awt.Color(225, 225, 245));
        jScrollPane2.setViewportView(jList1);

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setText("online");

        jLabel5.setFont(new java.awt.Font("Monotype Corsiva", 3, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 0, 153));
        jLabel5.setText("Chat Messenger");

        browseButton.setForeground(new java.awt.Color(0, 0, 102));
        browseButton.setText("Browse File");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("Message Box");

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

        clearButton.setText("Clear ");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(browseButton, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                            .addComponent(sendButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfIpAddress)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfName))
                        .addGap(18, 18, 18)
                        .addComponent(connectButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(encrypt))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(decrypt, javax.swing.GroupLayout.Alignment.LEADING))))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(20, 20, 20)
                                        .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfIpAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(connectButton)))
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(encrypt)
                        .addGap(36, 36, 36)
                        .addComponent(decrypt)
                        .addGap(38, 38, 38)
                        .addComponent(clearButton)))
                .addGap(35, 35, 35)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(browseButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sendButton)
                        .addGap(0, 11, Short.MAX_VALUE))
                    .addComponent(tf))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(8, 8, 8))
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
        JFileChooser fileChooser = new JFileChooser(); //Create a file chooser
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));//setting Directory
        int result = fileChooser.showOpenDialog(this); //In response to a button click:

        
        try
        {   
            if(dout != null || dout4 != null){
            if(result == JFileChooser.APPROVE_OPTION){
            File selectedFile = fileChooser.getSelectedFile();//returns an instance of File
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());// path of the choosen file is printed

            String pathtopic = selectedFile.getAbsolutePath();// path of the selected file is stored in pathtopic
        
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
                        System.out.println("s.length:"+s.length);
                        msgout = msgout+"."+efilename;
                    }
            dout5.writeUTF(msgout);//send "pic" string
            dout5.writeInt(size);//send size
            dout5.write(bytesArray);// file sent
            efile.delete();
            ta.append("\n"+jList1.getModel().getElementAt(0)+" "+"Encrypted File Sent");
            
            }
            
            else{
                
            System.out.println("button 1 pressed");
            File file = new File(pathtopic);

            //initializing array with file length
            byte[] bytesArray = new byte[(int) file.length()];

            FileInputStream fis = new FileInputStream(file);// creating new file input stream

            fis.read(bytesArray); //read file into bytes[]
            fis.close();// closing the stream

            int size = (int) file.length();// file size is stored
            String filename = file.getName();
                    System.out.println("file.getName();"+filename);
                    String s[]=filename.split("\\.");
                    String msgout="File Received";
                    System.out.println("s: "+s[0]+s[1]);
                    if(s.length == 2){
                        System.err.println("s.length:"+s.length);
                        msgout = msgout+"."+filename;
                    }
                    
                System.out.println("msgout"+msgout);
            dout.writeUTF(msgout);//send "pic" string
            System.out.println("size"+size);
            dout.writeInt(size);//send size
            System.out.println("bytesArray"+bytesArray);
            dout.write(bytesArray);// file sent
            ta.append("\n"+jList1.getModel().getElementAt(0)+" "+"File Sent: "+filename);
            }
            }else if(result == JFileChooser.CANCEL_OPTION){
            JOptionPane.showMessageDialog(browseButton,"Nothing is selected");
            }
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(browseButton,"Error in browsing file");
            e.printStackTrace();
        }
    }//GEN-LAST:event_browseButtonActionPerformed

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
        String msgin="";
        Thread worker = new Thread() // Creating new thread

        {

            @Override
            public void run() //we are using to perform action for a thread.
            {
                String msgin="";
                int port = 6000;
                    ip=tfIpAddress.getText();
                try{
                    if(ip.equalsIgnoreCase("localhost") && !tfName.getText().equalsIgnoreCase("")){
                    //port= Integer.parseInt(tfPort.getText());
                    tf.setEditable(true);
                    s=new Socket(ip,port);
                    s4=new Socket("127.0.0.1",6004);
                    s5=new Socket("127.0.0.1",6005);
                    din = new DataInputStream(s.getInputStream());      // creating new input stream for socket s
                    dout = new DataOutputStream(s.getOutputStream());   // creating new outpur stream for socket s
                    din4 = new DataInputStream(s4.getInputStream());    // creating new input stream for socket s3 
                    dout4 = new DataOutputStream(s4.getOutputStream()); // creating new output stream for socket s3
                    din5 = new DataInputStream(s5.getInputStream());    // creating new input stream for socket s3 
                    dout5 = new DataOutputStream(s5.getOutputStream()); // creating new output stream for socket s3
                    
                    //System.out.println("strArray[0]"+strArray[0]);
                    
                    String[] s={tfName.getText().trim()+":",din.readUTF()+":"};
                    jList1.removeAll();
                    jList1.setListData(s);
                    dout.writeUTF(tfName.getText().trim()+":"+"username");
                    ta.setText(ta.getText().trim()+"Connected to the User A");
                     BigInteger bigInt = null;
                     String str="";
                 dout.writeUTF(DH.str);
                 if(din.available() != -1){
                 str = din.readUTF();
                 }
                bigInt = new BigInteger(str.getBytes()); 
                 DH.secretB = bigInt; 
                     DH.secretB = bigInt;
                     DH.DHEncrypt();
                    while(!msgin.equals("exit")) // checks if the msg is exit or not
                    {
                        if (din.available() > 0)// checks if there is any msg available in the input stream
                        {
                            final String out;
                            msgin = din.readUTF(); // reading data from the input stream
                            
                            //if(msgin.equals("File Received"))
                            out=(ta.getText().trim()+"\n"+msgin);
                            System.out.println("msg received: " +msgin);// prints on o/p screen 
                            
                            
                            SwingUtilities.invokeLater(new Runnable() { //thread is invoked
                                public void run() {
                                    ta.setText(out);//updates the GUI
                                }
                            });

                            if(msgin.contains("File Received"))//checks if we are receiving any image file
                            {
                                String ext[] = msgin.split("\\.");
                                System.out.println("pic received!");
                                System.out.println("file received!");//prints on o/p screen
                                // create buffer
                                int size = din.readInt(); //reading the size of the file
                                System.out.println("the size :" + size); // prints the size on o/p screen
                                byte[] picbytes = new byte[size]; //initializing array of file size
                                din.readFully(picbytes);// reading the complete image
                                /*FileOutputStream is meant for writing streams of raw bytes such as image data*/
                                FileOutputStream fos ;// creating fileoutputstream
                                if(ext.length == 3){
                                    System.out.println("ext.length == 2"+ext[1]);
                                fos = new FileOutputStream(ext[1]+"."+ext[2]);
                                }else{
                                    System.out.println("else ext none");
                                fos = new FileOutputStream(ext[1]);
                                }
                                fos.write(picbytes);//writing the image file
                                fos.close();//closing fileoutputstream
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
                fos = new FileOutputStream(ext[1]+".");
                }
                         fos.write(picbytes);
                         fos.close();
                         ta.append("\nEncrypted File Received");
                        }

                    }
                }
                }else{
                        JOptionPane.showMessageDialog(connectButton,"Enter your name");
                        }    
                    
                }catch(Exception e)
                {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(connectButton,"Server not found");
                    
                }

            }
        };
        worker.start();
    }//GEN-LAST:event_connectButtonActionPerformed

    private void tfNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNameActionPerformed

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        // TODO add your handling code here:
        if(tf.getText().length() > 0){
         if(encrypt.isSelected()){
                try{
                    String name;
            name=tfName.getText();
            String msgout = ""; // String variable is created
            //new DH();
            msgout = tf.getText().trim(); // getText()- returns string, trim() - omits whitespaces and unicodes
            String digSign = SHA.getSHA256Hash(msgout);
            String digSign_Encrypt=AES.encrypt(digSign);
            String aes_encrypt=AES.encrypt(msgout);// Calling Encrypt function
            dout4 = new DataOutputStream(s4.getOutputStream());//Creating new output stream
            dout4.writeUTF(digSign_Encrypt); // Writes an encrypted message digest using SHA-256
            dout4.writeUTF(aes_encrypt); //Writes an encrypted data to the output stream using modified UTF-8 encoding.
            dout.writeUTF("Encrypted message received press decrypt...");
            String msgout1 = "Nothing here";
            dout5.writeUTF(msgout1);//send "pic" string
            ta.setText(ta.getText().trim()+"\n"+name+": "+msgout); //Prints msg on the chat area
            System.out.println("This is the Encrypted Msg: "+aes_encrypt); //prints encrypted data on to the output screen
            // msgarea.setText(msgarea.getText().trim()+"\n Client: This is the Encrypted Msg ("+aes_encrypt+")");
            }catch(Exception e){
            } 
         }else{ // following steps are performed if none of the buttons are pressed
        try{
            String name;
            name=tfName.getText();
            ta.append("\n"+name+" :"+tf.getText());
            //ta.append("\n");
            System.out.println("client msg"+tf.getText());
            try {
                dout.writeUTF(name+": "+tf.getText().trim());
            } catch (IOException ex) {
                Logger.getLogger(SecondUser.class.getName()).log(Level.SEVERE, null, ex);
            }
            tf.setText("");
            tf.requestFocus();
        }
        catch(Exception e){
            
        }}
        clear();
        
    }else{
            JOptionPane.showMessageDialog(sendButton,"Enter something to send");
        }
    }//GEN-LAST:event_sendButtonActionPerformed

    private void tfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfKeyTyped
        if(ip.matches(""))
        {
            JOptionPane.showMessageDialog(this,"Server Is Offline");
            tf.setText("");
        }

    }//GEN-LAST:event_tfKeyTyped

    private void tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfActionPerformed
        // TODO add your handling code here:
        if(!ip.matches("")&& !tf.getText().matches(""))
        {   String name;
            name=tfName.getText();
            ta.append(name+" :"+tf.getText());
            ta.append("\n");
            //pw.println(name+" :"+tf.getText());
            tf.setText("");
            tf.requestFocus();
        }
    }//GEN-LAST:event_tfActionPerformed

    private void encryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encryptActionPerformed
        // TODO add your handling code here:
        if(encrypt.isSelected())// checks if the button is selected or not
         {
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
             
              if(dfileStr.equalsIgnoreCase("Nothing here")){
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
                   
                //File f = new File("EncryptedFile.jpg");
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

   
    public static void main(String args[]) throws Exception {
       //nameFirst = args[0];
        nameFirst = "my1";
        final SecondUser c = new SecondUser() ;
       new DH();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               c.setVisible(true);
               
            }
        });
        
        
    
   }
     
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseButton;
    private javax.swing.JToggleButton clearButton;
    private javax.swing.JButton connectButton;
    private javax.swing.JToggleButton decrypt;
    private javax.swing.JToggleButton encrypt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton sendButton;
    private javax.swing.JTextArea ta;
    private javax.swing.JTextField tf;
    private javax.swing.JTextField tfIpAddress;
    private javax.swing.JTextField tfName;
    // End of variables declaration//GEN-END:variables
}
