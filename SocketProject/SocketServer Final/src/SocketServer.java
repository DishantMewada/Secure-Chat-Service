/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.*;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;

import java.io.*;
import java.net.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Map;

class SocketServer extends JFrame implements ActionListener {
	private static final String ALGORITHM = "AES";
	private JButton button, upload;
	private JTextField textField;
	private JLabel label = new JLabel("Text received over socket:");
	private JPanel panel, buttonPanel;
	private JTextArea textArea = new JTextArea(15, 30);
	private JScrollPane scrollPane;
	private ServerSocket server = null;
	private Socket client = null;
	private DataInputStream dis = null;
	private DataOutputStream dos = null;
	private FileOutputStream fos = null;
	private FileInputStream fis = null;
	private String path, line, filename;
	private int b;
	private String myName = null;
	private String name = null;
	private String pbkeyA = null;
	private String prikeyA = null;
	private String pbkeyB = null;
	private Encry en = null;
	private KeyPair kp = null;
	private String pkg = null;
	private Map<String, Object> keyPair = null;
	private String I = null;
	private String inner = null;
	private String Pa = null;
	private String Pb = null;
	private String outside = null;
	private String end = null;
	private String pkg2 = null;
	private String pkg3 = null;
	private String Kab = null;
	private File file = null;
	private File tempFile = null;

	public SocketServer(String myName) { // Begin Constructor
		this.myName = myName;
		scrollPane = new JScrollPane(textArea);
		textArea.setEditable(false);
		textField = new JTextField(20);
		button = new JButton("Send");
		upload = new JButton("Upload");
		upload.addActionListener(this);
		button.addActionListener(this);

		panel = new JPanel();
		buttonPanel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBackground(Color.white);
		getContentPane().add(panel);
		panel.add("North", scrollPane);
		panel.add("Center", textField);
		buttonPanel.add(button);
		buttonPanel.add(upload);
		panel.add("South", buttonPanel);

		this.setTitle("Chat-[S] Program");
		this.setSize(800, 400);
		WindowListener l = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		this.addWindowListener(l);
		this.pack();
		this.setVisible(true);
		try {
			this.listenSocket();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	} // End Constructor

	public void actionPerformed(ActionEvent event) {
		JFileChooser jFile = new JFileChooser();
		Object source = event.getSource();
		if (source == button) {
			b = 1;
			String text = textField.getText();
			if (!text.equals("")) {
				try {
					dos.writeInt(b);
					textArea.append(myName + " : " + text + "\n");
					text = en.AESEncrypt(text, Kab);
					dos.writeUTF(text);
				} catch (IOException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException
						| IllegalBlockSizeException | BadPaddingException e) {
					e.printStackTrace();
				}
				textField.setText(new String(""));
			}
		}
		if (source == upload) {
			b = 2;
			jFile.setDialogTitle("Plz select an image...");
			jFile.setApproveButtonText("OK");
			if (jFile.showOpenDialog(SocketServer.this) == JFileChooser.APPROVE_OPTION) {
				try {
					dos.writeInt(b);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				path = jFile.getSelectedFile().getAbsolutePath();
				path = path.replace("/", "\\");
				File temFile = new File(path.trim());
				filename = temFile.getName();
				File enFile = new File("Encrypted" + filename);
				// System.out.println(filename); //Rua.jpg
				try {
					dos.writeUTF(filename);
					// File file = new File(path);
					fis = new FileInputStream(en.encryptFile(temFile, enFile, Kab));
				} catch (IOException e) {
					e.printStackTrace();
				}

				byte[] bufImage = new byte[1024];
				int len = 0;
				try {
					while ((len = fis.read(bufImage, 0, bufImage.length)) > 0) {
						dos.write(bufImage, 0, len);
						dos.flush();
					}

					textArea.append("Transformed a file to " + name + "\n");
					// finalize();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void listenSocket() throws ClassNotFoundException {
		try {
			server = new ServerSocket(4444);
		} catch (IOException e) {
			System.out.println("Could not listen on port 4444");
			System.exit(-1);
		}

		try {
			client = server.accept();
		} catch (IOException e) {
			System.out.println("Accept failed: 4444");
			System.exit(-1);
		}

		try {
			dis = new DataInputStream(client.getInputStream());
			dos = new DataOutputStream(client.getOutputStream());
			dos.writeUTF(myName);
			while (true) {
				name = dis.readUTF();
				if (name != null) {
					break;
				}
			}
			en = new Encry();
			keyPair = en.genKeyPair();
			pbkeyA = en.getPublicKey(keyPair);
			prikeyA = en.getPrivateKey(keyPair);
			dos.writeUTF(pbkeyA);
			while (true) {
				pbkeyB = dis.readUTF();
				if (pbkeyB != null) {
					System.out.println("get public key");
					break;
				}
			}

			// step 1
			Pa = en.getRandomString(5);
			I = en.md5Encrypt(Pa);
			I = en.encryptByPrivateKey(I, prikeyA);
			inner = Pa + "," + I;
			inner = en.encryptByPublicKey(inner, pbkeyB);
			end = myName + "," + name + "," + inner;
			dos.writeUTF(end);
			System.out.println("Pa is " + Pa);
			System.out.println("step1 ends");
			// step 4
			while (true) {
				pkg2 = dis.readUTF();
				if (pkg2 != null)
					break;
			}
			String[] sep = pkg2.split(",");
			System.out.println(sep[0] + " replies to " + sep[1]);
			pkg3 = sep[2];
			pkg3 = en.decryptByPrivateKey(pkg3, prikeyA);
			String[] sep2 = pkg3.split(",");
			Pb = sep2[0];
			System.out.println("Pb is " + Pb);
			Kab = Pa + Pb;
			Kab = en.md5Encrypt(Kab);
			System.out.println("Kab is " + Kab);
			if (Pa.equals(en.AESDecrypt(sep2[1], Kab)))
				System.out.println("The response decrypted with AES is same to original Pa,which means step4 ends");
			// step5
			String s5 = myName + "," + name + "," + en.AESEncrypt(Pb, Kab);
			dos.writeUTF(s5);

		} catch (Exception e) {
			System.out.println("Accept failed: 4444");
			System.exit(-1);
		}
		while (true) {
			try {
				b = dis.readInt();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			try {
				if (b == 1) {
					line = dis.readUTF();
					line = en.AESDecrypt(line, Kab);
					textArea.append(name + "  : " + line + "\n");
				}

			} catch (IOException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException
					| IllegalBlockSizeException | BadPaddingException e1) {
				e1.printStackTrace();
			}

			if (b == 2) {

				try {
					filename = dis.readUTF();
					tempFile = new File("Encrypted" + filename);
					fos = new FileOutputStream(tempFile);
					file = new File("../FileS/"+filename);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				byte[] bufImage = new byte[1024];
				int len = 0;
				try {
					while ((len = dis.read(bufImage, 0, bufImage.length)) > 0) {
						fos.write(bufImage, 0, len);
						fos.flush();
						if (len != 1024) {
							fos.close();
							break;
						}
					}
					en.decryptFile(tempFile, file, Kab);
					textArea.append("Received a file from " + name + "\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void files(Socket socket) {
		try {
			dis = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] bufImage = new byte[1024];
		int len = 0;
		try {
			while ((len = dis.read(bufImage, 0, bufImage.length)) > 0) {
				fos.write(bufImage, 0, len);
				fos.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		textArea.append("Received a file from client : " + "\n");
	}

	protected void finalize() {
		if (fos != null)
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		if (dis != null)
			try {
				dis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		if (client != null)
			try {
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}