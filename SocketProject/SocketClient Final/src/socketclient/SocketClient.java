/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package socketclient;

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
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Map;

class SocketClient extends JFrame implements ActionListener {
	private static final String ALGORITHM = "AES";
	private JLabel clicked;
	private JButton button, upload;
	private JPanel panel, buttonPanel;
	private JTextField textField;
	private JTextArea textArea = new JTextArea(15, 30);
	private JScrollPane scrollPane;
	private Socket socket = null;
	private Socket socketImage = null;
	private DataOutputStream dos = null;
	private DataInputStream dis = null;
	private FileInputStream fis = null;
	private FileOutputStream fos = null;
	CipherOutputStream cipherOutputStream = null;
	// private PrintWriter out = null;
	// private BufferedReader in = null;
	private String path, line, filename;
	private int b;
	private String myName, name;
	private String pbkeyB = null;
	private String prikeyB = null;
	private String pbkeyA = null;
	private Encry en = null;
	private Map<String, Object> keyPair = null;
	private String pkg = null;
	private String Kab = null;
	private String I = null;
	private String resp = null;
	private String pkg2 = null;
	private String Pa = null;
	private String Pb = null;
	private String inner = null;
	private String out = null;
	private File file = null;
	private File tempFile = null;

	public SocketClient(String myName) { // Begin Constructor
		this.myName = myName;
		scrollPane = new JScrollPane(textArea);
		textArea.setEditable(false);
		textField = new JTextField(20);
		button = new JButton("Send");
		upload = new JButton("Upload");
		button.addActionListener(this);
		upload.addActionListener(this);

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

		this.setTitle("Chat-[C] Program");
		WindowListener l = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};

		this.addWindowListener(l);
		this.pack();
		this.setVisible(true);
		this.listenSocket();
	} // End Constructor

	public void actionPerformed(ActionEvent event) {
		JFileChooser jFile = new JFileChooser();
		Object source = event.getSource();
		if (source == button) {
			// Send data over socket
			try {
				dos = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			b = 1;
			String text = textField.getText();
			if (!text.equals("")) {
				try {
					dos.writeInt(b);
				} catch (IOException e) {
					e.printStackTrace();
				}
				textArea.append(myName + " : " + text + "\n");
				try {
					text = en.AESEncrypt(text, Kab);
					dos.writeUTF(text);
				} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException
						| IllegalBlockSizeException | BadPaddingException | IOException e) {
					e.printStackTrace();
				}
				textField.setText(new String(""));
			}
			// Receive text from Client 1
		}
		if (source == upload) {
			b = 2;
			jFile.setDialogTitle("Plz select an image...");
			jFile.setApproveButtonText("OK");
			if (jFile.showOpenDialog(SocketClient.this) == JFileChooser.APPROVE_OPTION) {
				try {
					dos.writeInt(b);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				path = jFile.getSelectedFile().getAbsolutePath();
				path = path.replace("/", "\\");
				File temFile = new File(path.trim());
				filename = temFile.getName();
				File enFile = new File("Encrypted " + filename);
				en.encryptFile(temFile, enFile, Kab);
				try {
					dos.writeUTF(filename);
					// File file = new File(path);
					fis = new FileInputStream(enFile);
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

	public void listenSocket() {
		// Create socket connection
		try {
			socket = new Socket("127.0.0.1", 4444);
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(myName);
			while (true) {
				name = dis.readUTF();
				if (name != null) {
					break;
				}
			}
		} catch (UnknownHostException e) {
			System.out.println("Unknown host: 127.0.0.1.eng");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("No I/O");
			System.exit(1);
		}

		en = new Encry();
		Pb = en.getRandomString(5);
		System.out.println("Pb is " + Pb);
		try {
			keyPair = en.genKeyPair();
			pbkeyB = en.getPublicKey(keyPair);
			prikeyB = en.getPrivateKey(keyPair);
			dos.writeUTF(pbkeyB);
			while (true) {
				pbkeyA = dis.readUTF();
				if (pbkeyA != null)
					break;
			}
			while (true) {
				pkg = dis.readUTF();
				if (pkg != null)
					break;
			}
			String sep[] = pkg.split(",");
			System.out.println(sep[0] + " wanna talk to " + sep[1]);
			String outside = sep[2];
			outside = en.decryptByPrivateKey(outside, prikeyB);
			String[] sep2 = outside.split(",");
			Pa = sep2[0];
			// step 2,Kab
			Kab = Pa + Pb;
			Kab = en.md5Encrypt(Kab);
			System.out.println("Kab is " + Kab);
			System.out.println("step2 ends");
			// step 3
			resp = en.AESEncrypt(Pa, Kab);
			System.out.println("Pa is " + Pa);
			resp = Pb + "," + resp;
			I = en.md5Encrypt(resp);
			inner = en.encryptByPrivateKey(I, prikeyB);
			resp = resp + "," + inner;
			resp = en.encryptByPublicKey(resp, pbkeyA);
			out = myName + "," + name + "," + resp;
			dos.writeUTF(out);
			System.out.println("step 3 ends");

			while (true) {
				String s5 = dis.readUTF();
				if (s5 != null) {
					String sep1[] = s5.split(",");
					String response = sep1[2];
					if (Pb.equals(en.AESDecrypt(response, Kab))) {
						System.out.println(sep1[0] + " replies to " + sep1[1] + ",step5 ends");
						System.out.println(
								"Channel establishment success !Because the response decrypted with AES is same to original Pb!");
					}

					break;
				}

			}
		} catch (Exception e3) {
			e3.printStackTrace();
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
					textArea.append(name + " : " + line + "\n");
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
//					file = new File("D:\\SocketProject\\FileC\\"+filename);
					file = new File("../FileC/"+filename);
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

	protected void finalize() {
		// Clean up
		try {
			if (dos != null)
				dos.close();
			if (fis != null)
				fis.close();
			if (socket != null)
				socket.close();
		} catch (IOException e) {
			System.out.println("Could not close.");
			System.exit(-1);
		}
	}
}