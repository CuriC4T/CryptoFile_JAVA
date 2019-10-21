package project02;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class MainFrame extends JFrame {

	FileManagenet filemanagemet;
	AES aes;
	DES des;
	BlowFish BF;
	TwoFish TF;
	MD5 md5;
	SHA sha;
	JLabel nameProjectLabel;
	JLabel filenameLabel;
	JLabel outputLabel;
	JLabel passwordLabel;

	JTextField filenameField;
	JTextField outputField;
	JTextField passwordField;

	JButton bt1;
	JButton bt2;
	JButton encrytButton;
	JButton decryptButton;

	JRadioButton AES;
	JRadioButton DES;
	JRadioButton BlowFish;
	JRadioButton TwoFish;
	ButtonGroup groupRd;

	String inputFileName;
	String outputFileName;

	public MainFrame() {
		init();
		setEvent();
	}

	public void init() {
		filemanagemet = new FileManagenet();
		try {
			sha = new SHA();
			aes = new AES();
			des = new DES();
			BF = new BlowFish();
			TF = new TwoFish();
			md5 = new MD5();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		nameProjectLabel = new JLabel("14035064 HYUN JAE WOOK");
		filenameLabel = new JLabel("Filename");
		outputLabel = new JLabel("Output File");
		passwordLabel = new JLabel("Password Key");

		filenameField = new JTextField(10);
		outputField = new JTextField(10);
		passwordField = new JTextField(10);

		bt1 = new JButton("...");
		bt2 = new JButton("...");
		encrytButton = new JButton("Encrypt");
		decryptButton = new JButton("Decrtpt");

		AES = new JRadioButton("AES");
		DES = new JRadioButton("DES");
		BlowFish = new JRadioButton("BlowFish");
		TwoFish = new JRadioButton("MD5");
		groupRd = new ButtonGroup();

		Border border = BorderFactory.createLineBorder(Color.BLACK);

		// --------------------------------------------------------------//

		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout(5, 5));
		// setBackground(new Color(0, 0, 0, 0));
		setSize(350, 425);

		filenameField.setSize(400, 20);
		filenameField.setFont(new Font("고딕", Font.PLAIN, (int) 20));
		// filenameField.setHorizontalAlignment(filenameField.EAST);
		outputField.setSize(400, 20);
		outputField.setFont(new Font("고딕", Font.PLAIN, (int) 20));
		// outputField.setHorizontalAlignment(outputField.CENTER);
		passwordField.setSize(400, 20);
		passwordField.setFont(new Font("고딕", Font.PLAIN, (int) 20));
		// passwordField.setHorizontalAlignment(passwordField.CENTER);

		nameProjectLabel.setBorder(border);
		filenameField.setBorder(border);
		outputField.setBorder(border);
		passwordField.setBorder(border);

		AES.setSelected(true);
		AES.setSize(50, 50);
		DES.setSize(50, 50);
		BlowFish.setSize(50, 50);
		TwoFish.setSize(50, 50);

		groupRd.add(AES);
		groupRd.add(DES);
		groupRd.add(BlowFish);
		groupRd.add(TwoFish);

		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(5, 1, 0, 0));

		JPanel p1_1 = new JPanel();
		p1_1.setLayout(new FlowLayout());

		JPanel p1_2 = new JPanel();
		p1_2.setLayout(new FlowLayout());

		p1_1.add(filenameField);
		p1_1.add(bt1);
		p1_2.add(outputField);
		p1_2.add(bt2);

		p1.add(nameProjectLabel);
		p1.add(filenameLabel);
		p1.add(p1_1);
		p1.add(outputLabel);
		p1.add(p1_2);

		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout(5));
		p2.add(AES);
		p2.add(DES);
		p2.add(BlowFish);
		p2.add(TwoFish);

		JPanel p3 = new JPanel();
		p3.setLayout(new GridLayout(3, 1, 0, 0));
		JPanel p3_1 = new JPanel();
		p3_1.setLayout(new FlowLayout());
		p3_1.add(passwordField);
		p3_1.add(new JLabel("             "));

		JPanel p3_2 = new JPanel();
		p3_2.setLayout(new FlowLayout(200));
		p3_2.add(encrytButton);
		p3_2.add(decryptButton);
		p3.add(passwordLabel);
		p3.add(p3_1);
		p3.add(p3_2);

		this.add(p1, BorderLayout.NORTH);
		this.add(p2, BorderLayout.CENTER);
		this.add(p3, BorderLayout.SOUTH);

		// pack();

	}

	public void setEvent() {
		bt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				/*
				 * int a = fc.showSaveDialog(Memo.this);//SaveDialog이다. if(a==1)return;
				 */
				if (fc.showSaveDialog(MainFrame.this) == JFileChooser.CANCEL_OPTION)
					return;
				File f = fc.getSelectedFile();
				inputFileName = f.getPath();
				System.out.println("가져온 파일 " + inputFileName);
				filenameField.setText(f.getPath());
				// String
				// temp=filemanagemet.readAllBytes("C:\\Users\\hjwja\\asd.jar");

			}

		});
		bt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				/*
				 * int a = fc.showSaveDialog(Memo.this);//SaveDialog이다. if(a==1)return;
				 */
				if (fc.showSaveDialog(MainFrame.this) == JFileChooser.CANCEL_OPTION)
					return;
				File f = fc.getSelectedFile();
				outputFileName = f.getPath();
				System.out.println("저장 파일 " + outputFileName);
				outputField.setText(f.getPath());

			}

		});
		encrytButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String password = passwordField.getText();
				if(password.getBytes().length<16) {
					sha = new SHA();
					try {
						
						System.out.println(sha.sha256(password.getBytes()).length);
						try {
							password=new String(sha.sha256(password.getBytes()),"UTF-8");
						} catch (UnsupportedEncodingException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} catch (NoSuchAlgorithmException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				byte[] temp = null;
				byte[] encryptedByte = null;
				if (new File(filenameField.getText()).exists() && outputFileName != null && password != null) {
					if (AES.isSelected()) {
						System.out.println("AES Encrypt");
						try {
							temp = filemanagemet.loadFile(new File(filenameField.getText()));

							encryptedByte = aes.Encrypt(password, temp);
							filemanagemet.saveFile(new File(outputField.getText()), encryptedByte);

						} catch (NoSuchAlgorithmException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (UnsupportedEncodingException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (GeneralSecurityException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						// System.out.println(temp);
					} else if (DES.isSelected()) {
						System.out.println("DES Encrypt");

						temp = filemanagemet.loadFile(new File(filenameField.getText()));
						encryptedByte = des.Encrypt(password, temp);
						filemanagemet.saveFile(new File(outputField.getText()), encryptedByte);

					} else if (BlowFish.isSelected()) {
						System.out.println("BlowFish Encrypt");
						temp = filemanagemet.loadFile(new File(filenameField.getText()));
						encryptedByte = BF.Encrypt(password, temp);
						filemanagemet.saveFile(new File(outputField.getText()), encryptedByte);
					} else {
						System.out.println("MD5 Encrypt");
						temp = filemanagemet.loadFile(new File(filenameField.getText()));
						encryptedByte = md5.Encrypt(password, temp);
						filemanagemet.saveFile(new File(outputField.getText()), encryptedByte);
					}
				}

			}

		});
		decryptButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String password = passwordField.getText();
				if(password.getBytes().length<16) {
					sha = new SHA();
					try {
						
						System.out.println(sha.sha256(password.getBytes()).length);
						try {
							password=new String(sha.sha256(password.getBytes()),"UTF-8");
						} catch (UnsupportedEncodingException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} catch (NoSuchAlgorithmException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				byte[] temp = null;
				byte[] encryptedByte = null;
				if (new File(filenameField.getText()).exists() && outputFileName != null && password != null) {
					if (AES.isSelected()) {
						System.out.println("AES Decrypt");
						try {
							temp = filemanagemet.loadFile(new File(filenameField.getText()));

							encryptedByte = aes.Decrypt(password, temp);
							filemanagemet.saveFile(new File(outputField.getText()), encryptedByte);

						} catch (NoSuchAlgorithmException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (UnsupportedEncodingException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (GeneralSecurityException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (DES.isSelected()) {
						System.out.println("DES Decrypt");
						temp = filemanagemet.loadFile(new File(filenameField.getText()));
						encryptedByte = des.Decrypt(password, temp);
						filemanagemet.saveFile(new File(outputField.getText()), encryptedByte);
					} else if (BlowFish.isSelected()) {
						System.out.println("BlowFish Decrypt");
						temp = filemanagemet.loadFile(new File(filenameField.getText()));
						encryptedByte = BF.Decrypt(password, temp);
						filemanagemet.saveFile(new File(outputField.getText()), encryptedByte);
					} else {

					}
				}

			}

		});

	}

}
