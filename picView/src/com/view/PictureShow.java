package com.view;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.LineBorder;
import javax.swing.SwingUtilities;

import com.encrypt.DealData;
import com.view.BarThread;

public class PictureShow extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
    private static final String title = "图片数据加密工具";
	private JButton jButtonBrowse;
	private JButton jButtonLoad;
	private JButton jButtonEncrypt;
	private JLabel jLabelPicContent;
	private JButton jButtonNext;
	private JButton jButtonBefore;
	private JTextField jTextFieldPicPath;
	private JLabel jLabelOpen;
	private int count = 0;
	private int num = 0;
	private ArrayList<String> list = new ArrayList<String>();
	private DealData dealData;

	public static void main(String[] args) {
		// 获取当前工作路径
		System.out.println(System.getProperty("user.dir"));
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PictureShow inst = new PictureShow();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public PictureShow() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout(
					(JComponent) getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setTitle(title);
			{
				jLabelOpen = new JLabel();
				jLabelOpen.setText("打开");
			}
			{
				jTextFieldPicPath = new JTextField(
						System.getProperty("user.dir"));
			}
			{
				jButtonBrowse = new JButton();
				jButtonBrowse.setText("浏览");
				jButtonBrowse.addActionListener(this);
			}
			{
				jButtonLoad = new JButton();
				jButtonLoad.setText("载入");
				jButtonLoad.addActionListener(this);
			}
			
			{
				
				jButtonEncrypt = new JButton();
				jButtonEncrypt.setText("加密");
				jButtonEncrypt.addActionListener(this);
			}
			{
				jLabelPicContent = new JLabel();
				jLabelPicContent.setBorder(new LineBorder(new java.awt.Color(0,
						0, 0), 1, false));
				jLabelPicContent.setSize(600, 450);
			}
			{
				jButtonBefore = new JButton();
				jButtonBefore.setText("上一张");
				jButtonBefore.addActionListener(this);
			}
			{
				jButtonNext = new JButton();
				jButtonNext.setText("下一张");
				jButtonNext.addActionListener(this);
			}
			thisLayout
					.setVerticalGroup(thisLayout
							.createSequentialGroup()
							.addContainerGap()
							.addGroup(
									thisLayout
											.createParallelGroup(
													GroupLayout.Alignment.BASELINE)
											.addComponent(
													jLabelOpen,
													GroupLayout.Alignment.BASELINE,
													GroupLayout.PREFERRED_SIZE,
													20,
													GroupLayout.PREFERRED_SIZE)
											.addComponent(
													jTextFieldPicPath,
													GroupLayout.Alignment.BASELINE,
													GroupLayout.PREFERRED_SIZE,
													GroupLayout.PREFERRED_SIZE,
													GroupLayout.PREFERRED_SIZE)
											.addComponent(
													jButtonBrowse,
													GroupLayout.Alignment.BASELINE,
													GroupLayout.PREFERRED_SIZE,
													22,
													GroupLayout.PREFERRED_SIZE)
											.addComponent(
													jButtonLoad,
													GroupLayout.Alignment.BASELINE,
													GroupLayout.PREFERRED_SIZE,
													GroupLayout.PREFERRED_SIZE,
													GroupLayout.PREFERRED_SIZE)
											.addComponent(
													jButtonEncrypt,
													GroupLayout.Alignment.BASELINE,
													GroupLayout.PREFERRED_SIZE,
													GroupLayout.PREFERRED_SIZE,
													GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(
									LayoutStyle.ComponentPlacement.UNRELATED)

							.addGroup(
									thisLayout
											.createParallelGroup()
											.addComponent(
													jLabelPicContent,
													GroupLayout.Alignment.LEADING,
													0, 496, Short.MAX_VALUE)
											.addGroup(
													thisLayout
															.createSequentialGroup()
															.addGap(210)
															.addGroup(
																	thisLayout
																			.createParallelGroup()
																			.addGroup(
																					GroupLayout.Alignment.LEADING,
																					thisLayout
																							.createSequentialGroup()
																							.addComponent(
																									jButtonBefore,
																									GroupLayout.PREFERRED_SIZE,
																									GroupLayout.PREFERRED_SIZE,
																									GroupLayout.PREFERRED_SIZE)
																							.addGap(0,
																									11,
																									Short.MAX_VALUE))
																			.addGroup(
																					GroupLayout.Alignment.LEADING,
																					thisLayout
																							.createSequentialGroup()
																							.addGap(11)
																							.addComponent(
																									jButtonNext,
																									GroupLayout.PREFERRED_SIZE,
																									GroupLayout.PREFERRED_SIZE,
																									GroupLayout.PREFERRED_SIZE)
																							.addGap(0,
																									0,
																									Short.MAX_VALUE)))
															.addGap(253)))

							.addContainerGap(24, 24));
			thisLayout
					.setHorizontalGroup(thisLayout
							.createSequentialGroup()
							.addGroup(
									thisLayout
											.createParallelGroup()
											.addComponent(
													jButtonBefore,
													GroupLayout.Alignment.LEADING,
													GroupLayout.PREFERRED_SIZE,
													79,
													GroupLayout.PREFERRED_SIZE)
											.addGroup(
													GroupLayout.Alignment.LEADING,
													thisLayout
															.createSequentialGroup()
															.addGap(24)
															.addComponent(
																	jLabelOpen,
																	GroupLayout.PREFERRED_SIZE,
																	40,
																	GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(
									LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(
									thisLayout
											.createParallelGroup()
											.addGroup(
													GroupLayout.Alignment.LEADING,
													thisLayout
															.createSequentialGroup()
															
															.addComponent(
																	jLabelPicContent,
																	GroupLayout.PREFERRED_SIZE,
																	608,
																	GroupLayout.PREFERRED_SIZE)
															.addPreferredGap(
																	LayoutStyle.ComponentPlacement.RELATED)
															.addComponent(
																	jButtonNext,
																	GroupLayout.PREFERRED_SIZE,
																	82,
																	GroupLayout.PREFERRED_SIZE))
											.addGroup(
													GroupLayout.Alignment.LEADING,
													thisLayout
															.createSequentialGroup()
															.addGap(28)
															
															
															.addComponent(
																	jTextFieldPicPath,
																	GroupLayout.PREFERRED_SIZE,
																	400,
																	GroupLayout.PREFERRED_SIZE)
															.addGap(28)
															
															.addComponent(
																	jButtonBrowse,
																	GroupLayout.PREFERRED_SIZE,
																	70,
																	GroupLayout.PREFERRED_SIZE)
															.addGap(19)
															.addComponent(
																	jButtonLoad,
																	GroupLayout.PREFERRED_SIZE,
																	70,
																	GroupLayout.PREFERRED_SIZE)
															.addComponent(
																	jButtonEncrypt,
																	GroupLayout.PREFERRED_SIZE,
																	70,
																	GroupLayout.PREFERRED_SIZE)													
															.addGap(0,
																	20,
																	Short.MAX_VALUE))));
			
			pack();
			this.setSize(800, 600);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jButtonBrowse) {
			JFileChooser fc = new JFileChooser();
			int returnval = fc.showOpenDialog(this);
			if (returnval == JFileChooser.APPROVE_OPTION) {
				File f = fc.getSelectedFile();
				String fileName = f.getName();
				String filePath = fc.getSelectedFile().getAbsolutePath();
				jTextFieldPicPath.setText(filePath);
				// System.out.println(filePath);
				//this.setTitle(fileName + "图片数据加密工具");
				ImageIcon image = new ImageIcon(filePath);
				int width = image.getIconWidth();
				int height = image.getIconHeight();
				if (width > height) {
					Image scaledImage = image.getImage().getScaledInstance(600,
							450, Image.SCALE_DEFAULT);
					ImageIcon scaledIcon = new ImageIcon(scaledImage);
					jLabelPicContent.setIcon(scaledIcon);
					jLabelPicContent.setHorizontalAlignment(0);
					jLabelPicContent.setVerticalAlignment(0);
				} else {
					Image scaledImage = image.getImage().getScaledInstance(300,
							450, Image.SCALE_DEFAULT);
					ImageIcon scaledIcon = new ImageIcon(scaledImage);
					jLabelPicContent.setIcon(scaledIcon);
					jLabelPicContent.setHorizontalAlignment(0);
					jLabelPicContent.setVerticalAlignment(0);
				}
				File[] fileList = f.getParentFile().listFiles();
				// System.out.println(fileList.length);
				for (int i = 0; i < fileList.length; i++) {
					if (fileList[i].isFile()) {
						String[] part = fileList[i].getName().split("\\.");
						if (part[1].equals("jpg") || part[1].equals("JPG")
								|| part[1].equals("GIF")
								|| part[1].equals("gif")
								|| part[1].equals("png")
								|| part[1].equals("PNG")
								|| part[1].equals("bmp")
								|| part[1].equals("BMP")) {
							// System.out.println(part[1]);
							list.add(fileList[i].getAbsolutePath());
							num++;
							// System.out.println(fileList[i].getAbsoluteFile());
							if (fileList[i].getAbsolutePath().equals(filePath)) {
								count = num;
							}
						}
					}
				}
				// System.out.println(num+"\t"+count);
			}
		} else if (e.getSource() == jButtonBefore) {
			if (count >= 1) {
				String path = list.get(count - 1);
				// System.out.println(path);
				ImageIcon image = new ImageIcon(path);
				int width = image.getIconWidth();
				int height = image.getIconHeight();
				if (width > height) {
					Image scaledImage = image.getImage().getScaledInstance(600,
							450, Image.SCALE_DEFAULT);
					ImageIcon scaledIcon = new ImageIcon(scaledImage);
					jLabelPicContent.setIcon(scaledIcon);
					jLabelPicContent.setHorizontalAlignment(0);
					jLabelPicContent.setVerticalAlignment(0);

				} else {
					Image scaledImage = image.getImage().getScaledInstance(300,
							450, Image.SCALE_DEFAULT);
					ImageIcon scaledIcon = new ImageIcon(scaledImage);
					jLabelPicContent.setIcon(scaledIcon);
					jLabelPicContent.setHorizontalAlignment(0);
					jLabelPicContent.setVerticalAlignment(0);
				}
				jTextFieldPicPath.setText(path);
				File file = new File(path);
				//this.setTitle(file.getName() + "图片数据加密工具");
				count--;
				// System.out.println(path+"\t"+count);
			} else {
				JOptionPane.showMessageDialog(null, "已经是第一张图片！");
			}
		} else if (e.getSource() == jButtonNext) {
			if (count < list.size() - 1) {
				// System.out.println(list.get(0));
				String path = list.get(count + 1);
				ImageIcon image = new ImageIcon(path);
				int width = image.getIconWidth();
				int height = image.getIconHeight();
				if (width > height) {
					Image scaledImage = image.getImage().getScaledInstance(600,
							450, Image.SCALE_DEFAULT);
					ImageIcon scaledIcon = new ImageIcon(scaledImage);
					jLabelPicContent.setIcon(scaledIcon);
					jLabelPicContent.setHorizontalAlignment(0);
					jLabelPicContent.setVerticalAlignment(0);
				} else {
					Image scaledImage = image.getImage().getScaledInstance(300,
							450, Image.SCALE_DEFAULT);
					ImageIcon scaledIcon = new ImageIcon(scaledImage);
					jLabelPicContent.setIcon(scaledIcon);
					jLabelPicContent.setHorizontalAlignment(0);
					jLabelPicContent.setVerticalAlignment(0);
				}
				jTextFieldPicPath.setText(path);
				//File file = new File(path);
				//this.setTitle(file.getName() + "图片数据加密工具");
				count++;
				// System.out.println(path+"\t"+count);
			} else {
				JOptionPane.showMessageDialog(null, "已经是最后一张图片！");
			}
		} else if (e.getSource() == jButtonLoad) {
			if (jTextFieldPicPath.getText().equals("") ||
					jTextFieldPicPath.getText().split("\\.").length==1) {
				JOptionPane.showMessageDialog(null, "请先打开一张图片！");
			} else {
				try {
					FileInputStream fin = new FileInputStream(
							jTextFieldPicPath.getText());
					BufferedInputStream bin = new BufferedInputStream(fin);
					String filename = (new File(jTextFieldPicPath.getText()))
							.getName();
					
					String genPath= System.getProperty("user.dir")+"//mypath";
					//初始化工作空间，加载图片到相关工作空间路径中
					dealData = new DealData(genPath);
					FileOutputStream fou = new FileOutputStream(
							dealData.getWorkSrcPath()+"/"+filename);
					BufferedOutputStream bou = new BufferedOutputStream(fou);
					byte[] buff = new byte[1024 * 10];
					int len;
					while ((len = bin.read(buff)) != -1) {
						bou.write(buff, 0, len);
					}
					bou.flush();
					bou.close();
					bin.close();
					fou.close();
					fin.close();
					//(new File(jTextFieldPicPath.getText())).delete();
					//list.remove(count);
					JOptionPane.showMessageDialog(null, "已经将图片加载完毕！");
				} catch (IOException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "文件流读写错误！");
				}
				
				

			}
		}else if (e.getSource() == jButtonEncrypt){
			try {
				//Double a = Double.valueOf(str.toString());
				if(dealData==null){
					String genPath= System.getProperty("user.dir")+"//mypath";
					//初始化工作空间，加载图片到相关工作空间路径中
					dealData = new DealData(genPath);
				}
				File dir = new File(dealData.getWorkSrcPath());
				File files[]=dir.listFiles();
				if(files.length>0){
			    	System.out.println("dddddddddddddddd");
			    	JOptionPane.showInputDialog("请输入");
			    	Thread barThread = new BarThread();//新生成一个处理事务线程
			    	barThread.start();//启动事务线程
			    	(new ThreadDialog(this, barThread ,"正在执行，请等待......")).start();
			    	
					dealData.encryptData();
				 }else{
					 JOptionPane.showMessageDialog(null, "请先载入图片");
				 }
				
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "图片加密错误!");
				
			}
		}

	}
}
