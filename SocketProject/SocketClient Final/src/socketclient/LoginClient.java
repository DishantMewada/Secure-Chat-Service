package socketclient;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginClient extends javax.swing.JFrame {

	private String Myname = null;

	public LoginClient() {
		this.setTitle("Client-[C]");
		jLabel1 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setText("Nickname");

		jButton1.setText("Submit");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(48, 48, 48)
						.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101,
								javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(46, 46, 46)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 153,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 113,
								javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(52, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(89, 89, 89)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(61, 61, 61).addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(77, Short.MAX_VALUE)));

		pack();
		this.setVisible(true);
	}

	public static void main(String args[]) {
		LoginClient lo = new LoginClient();
	}

	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JTextField jTextField1;

	public void jButton1ActionPerformed(ActionEvent e) {
		try {
			if (!(jTextField1.getText().equals(""))) {
				this.Myname = jTextField1.getText();
				Thread thread = new Thread(new socketThread(Myname));
				thread.start();
				this.dispose();
			}

		} catch (Exception e1) {

		}
	}

}
