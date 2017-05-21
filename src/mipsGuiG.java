import java.awt.*;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.BadLocationException;

import MIPS.DataCache;
import MIPS.InstructionCache;
import MIPS.MIPSSim;
import MIPS.Registers;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;

public class mipsGuiG {
	private JFrame frame;
	private JTextField r16text;
	private JTextField r15text;
	private JTextField r14text;
	private JTextField r13text;
	private JTextField r12text;
	private JTextField r11text;
	private JTextField r10text;
	private JTextField r9text;
	private JTextField r8text;
	private JTextField r7text;
	private JTextField r6text;
	private JTextField r5text;
	private JTextField r4text;
	private JTextField r3text;
	private JTextField r2text;
	private JTextField r1text;
	private JTextField r0text;
	private JTextField R17TEXT;
	private JTextField r18text;
	private JTextField r19text;
	private JTextField r20text;
	private JTextField r21text;
	private JTextField r22text;
	private JTextField r23text;
	private JTextField r24text;
	private JTextField r25text;
	private JTextField r26text;
	private JTextField r27text;
	private JTextField r28text;
	private JTextField r29text;
	private JTextField r30text;
	private JTextField r31text;
	//JList  list;
	Registers registers;
	 ArrayList<String> listModel ;
	 JTextArea textArea;
	 ArrayList<String> memorija;
	 DataCache dataCache;
	 JTextPane textPane;
	 
	 
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mipsGuiG window = new mipsGuiG();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mipsGuiG() {	
		
		initialize();
		postaviMemoriju();
		for(int i = 0 ; i < 32; i++)
		textArea.append(memorija.get(i)+"\n");	
		
		
		
	}
	
	void postaviMemoriju() {
		memorija = new ArrayList<>();
		 for(int i = 0; i < 32; i++) {
			 memorija.add("MEM"+String.valueOf(i)+"=  0");
		 }
	}
	
	void prepraviMemoriju(DataCache vrijednost) {
		textArea.setText("");
		
		for(int i = 0; i < 32; i++) {
			textArea.append("MEM"+String.valueOf(i)+"=  "+vrijednost.read(i)+"\n");
		}
	}
	
	void resetMemoriju() {
		for(int i = 0; i < 32; i++ )
			dataCache.write(i, 0);
	}
	
	
	
	
	void postaviRegistre() {
		if(r0text.getText() != "0" ) registers.write(0, Integer.parseInt(r0text.getText()));
		if(r1text.getText() != "0" ) registers.write(1, Integer.parseInt(r1text.getText()));
		if(r2text.getText() != "0" ) registers.write(2, Integer.parseInt(r2text.getText()));
		if(r3text.getText() != "0" ) registers.write(3, Integer.parseInt(r3text.getText()));
		if(r4text.getText() != "0" ) registers.write(4, Integer.parseInt(r4text.getText()));
		if(r5text.getText() != "0" ) registers.write(5, Integer.parseInt(r5text.getText()));
		if(r6text.getText() != "0" ) registers.write(6, Integer.parseInt(r6text.getText()));
		if(r7text.getText() != "0" ) registers.write(7, Integer.parseInt(r7text.getText()));
		if(r8text.getText() != "0" ) registers.write(8, Integer.parseInt(r8text.getText()));
		if(r9text.getText() != "0" ) registers.write(9, Integer.parseInt(r9text.getText()));
		if(r10text.getText() != "0" ) registers.write(10, Integer.parseInt(r10text.getText()));
		if(r11text.getText() != "0" ) registers.write(11, Integer.parseInt(r11text.getText()));
		if(r12text.getText() != "0" ) registers.write(12, Integer.parseInt(r12text.getText()));
		if(r13text.getText() != "0" ) registers.write(13, Integer.parseInt(r13text.getText()));
		if(r14text.getText() != "0" ) registers.write(14, Integer.parseInt(r14text.getText()));
		if(r15text.getText() != "0" ) registers.write(15, Integer.parseInt(r15text.getText()));
		if(r16text.getText() != "0" ) registers.write(16, Integer.parseInt(r16text.getText()));
		if(R17TEXT.getText() != "0" ) registers.write(17, Integer.parseInt(R17TEXT.getText()));
		if(r18text.getText() != "0" ) registers.write(18, Integer.parseInt(r18text.getText()));
		if(r19text.getText() != "0" ) registers.write(19, Integer.parseInt(r18text.getText()));
		if(r20text.getText() != "0" ) registers.write(20, Integer.parseInt(r18text.getText()));
		if(r21text.getText() != "0" ) registers.write(21, Integer.parseInt(r18text.getText()));
		if(r22text.getText() != "0" ) registers.write(22, Integer.parseInt(r18text.getText()));
		if(r23text.getText() != "0" ) registers.write(23, Integer.parseInt(r18text.getText()));
		if(r24text.getText() != "0" ) registers.write(24, Integer.parseInt(r18text.getText()));
		if(r25text.getText() != "0" ) registers.write(25, Integer.parseInt(r18text.getText()));
		if(r26text.getText() != "0" ) registers.write(26, Integer.parseInt(r18text.getText()));
		if(r27text.getText() != "0" ) registers.write(27, Integer.parseInt(r18text.getText()));
		if(r28text.getText() != "0" ) registers.write(28, Integer.parseInt(r18text.getText()));
		if(r29text.getText() != "0" ) registers.write(29, Integer.parseInt(r18text.getText()));
		if(r30text.getText() != "0" ) registers.write(30, Integer.parseInt(r18text.getText()));
		if(r31text.getText() != "0" ) registers.write(31, Integer.parseInt(r18text.getText()));
		
	}
	
	void upisiuGUIreg() {
		for(int i = 0; i < 32; i++) {
			
				switch(i) {
				case 0: r0text.setText(String.valueOf(registers.read(i))); break;
				case 1: r1text.setText(String.valueOf(registers.read(i))); break;
				case 2: r2text.setText(String.valueOf(registers.read(i))); break;
				case 3: r3text.setText(String.valueOf(registers.read(i))); break;
				case 4: r4text.setText(String.valueOf(registers.read(i))); break;
				case 5: r5text.setText(String.valueOf(registers.read(i))); break;
				case 6: r6text.setText(String.valueOf(registers.read(i))); break;
				case 7: r7text.setText(String.valueOf(registers.read(i))); break;
				case 8: r8text.setText(String.valueOf(registers.read(i))); break;
				case 9: r9text.setText(String.valueOf(registers.read(i))); break;
				case 10: r10text.setText(String.valueOf(registers.read(i))); break;
				case 11: r11text.setText(String.valueOf(registers.read(i))); break;
				case 12: r12text.setText(String.valueOf(registers.read(i))); break;
				case 13: r13text.setText(String.valueOf(registers.read(i))); break;
				case 14: r14text.setText(String.valueOf(registers.read(i))); break;
				case 15: r15text.setText(String.valueOf(registers.read(i))); break;
				case 16: r16text.setText(String.valueOf(registers.read(i))); break;
				case 17: R17TEXT.setText(String.valueOf(registers.read(i))); break;
				case 18: r18text.setText(String.valueOf(registers.read(i))); break;
				case 19: r19text.setText(String.valueOf(registers.read(i))); break;
				case 20: r20text.setText(String.valueOf(registers.read(i))); break;
				case 21: r21text.setText(String.valueOf(registers.read(i))); break;
				case 22: r22text.setText(String.valueOf(registers.read(i))); break;
				case 23: r23text.setText(String.valueOf(registers.read(i))); break;
				case 24: r24text.setText(String.valueOf(registers.read(i))); break;
				case 25: r25text.setText(String.valueOf(registers.read(i))); break;
				case 26: r26text.setText(String.valueOf(registers.read(i))); break;
				case 27: r27text.setText(String.valueOf(registers.read(i))); break;
				case 28: r28text.setText(String.valueOf(registers.read(i))); break;
				case 29: r29text.setText(String.valueOf(registers.read(i))); break;
				case 30: r30text.setText(String.valueOf(registers.read(i))); break;
				case 31: r31text.setText(String.valueOf(registers.read(i))); break;
				
				
				
				
			}
		}
	}
	
	ArrayList<String> uString() {
		ArrayList<String> lista = new ArrayList<>();
		String txt = textPane.getText();
		String [] arrayOfLines = txt.split("\n");
		for(String line: arrayOfLines) {
			StringBuilder s = new StringBuilder(line);
			for(int i = 0; i < s.length(); i++) if(s.charAt(i) != '0' && s.charAt(i) != '1') s.deleteCharAt(i);
		    lista.add(s.toString());
			
		}
		
		return lista;
		
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1445, 730);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//JScrollPane scroll;
		 listModel = new ArrayList<>();
		 GroupLayout groupLayout;
			
			 registers = new Registers();

		
		JPanel panel = new JPanel();
		
		JLabel lblRegistri = new JLabel("REGISTRI");
		
		JLabel lblInstrukcije = new JLabel("INSTRUKCIJE");
		
		 textPane = new JTextPane();
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		
		JScrollPane scroll = new JScrollPane (textPane);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		

		frame.getContentPane().add(scroll);	
		
		
		
		JScrollPane scrollPane = new JScrollPane(textPane_1);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	

		frame.getContentPane().add(scroll);	
		
		JButton btnRun = new JButton("Run");
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String txt = textPane.getText();
				
			
				//String [] arrayOfLines = txt.split("\n");
				ArrayList<String> lines;// = new ArrayList<String>();
				lines = uString();
			//	for(String line: arrayOfLines)
				//    lines.add(line);
				//String instruction = "00000000010000110000100000100000"; //add r1 r2 r3
				//String inst = "00000000100000100000000000100101";
				String ins = "00000000011000100010000000100100";
				
				
				InstructionCache instCache = new InstructionCache(lines.size());
				for(int i = 0 ; i < lines.size(); i++)
				instCache.setInstruction(i, lines.get(i));
				
				
				dataCache = new DataCache(32);
				
				MIPSSim simulator = new MIPSSim(instCache, dataCache);
				
				postaviRegistre();
				
				
				simulator.setRegisters(registers);
				
				simulator.start();
				
				listModel = simulator.vratiListu();
				
			
				textPane_1.update(textPane_1.getGraphics());
				for(int i = 0; i < listModel.size(); i++) 
					textPane_1.setText(textPane_1.getText()+listModel.get(i)+"\n");
				
		
			 
				registers = simulator.getRegisters();
				upisiuGUIreg();
				
				//prepravit memoriju
				 dataCache = simulator.getData();
				 
				prepraviMemoriju(dataCache);
				
				
			}
		});
		
		 
		
		JLabel lblIzlaz = new JLabel("IZLAZ");
		
		JLabel lblMemorija = new JLabel("MEMORIJA");
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int i = 0; i < 32; i++) 
					if(registers.read(i) != 0) registers.write(i,0);
				
				upisiuGUIreg();
				textPane_1.setText("");
				textPane.setText("");
				resetMemoriju();
				prepraviMemoriju(dataCache);
				
				
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		
		
		
		
		groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(23)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 447, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(47)
							.addComponent(lblRegistri)))
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 287, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMemorija))
					.addGap(196)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblInstrukcije)
							.addContainerGap())
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
									.addComponent(btnReset, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
									.addComponent(btnRun, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
									.addComponent(scroll, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 348, GroupLayout.PREFERRED_SIZE))
								.addGap(130))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblIzlaz)
								.addContainerGap()))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(23)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblRegistri)
								.addComponent(lblMemorija)
								.addComponent(lblInstrukcije))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(panel, GroupLayout.PREFERRED_SIZE, 611, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(255)
											.addComponent(btnRun)
											.addGap(3)
											.addComponent(btnReset)
											.addGap(18)
											.addComponent(lblIzlaz, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(34)
									.addComponent(scroll, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(73)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 518, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		
		
	
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane_1.setViewportView(textArea);
		textArea.setWrapStyleWord(true);
		
		
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		

		
		
		scrollPane.setViewportView(textPane_1);
		
		JLabel lblR = new JLabel("R0");
		
		JLabel lblR_1 = new JLabel("R1");
		
		JLabel lblR_2 = new JLabel("R2");
		
		JLabel lblR_3 = new JLabel("R3");
		
		JLabel lblR_4 = new JLabel("R4");
		
		JLabel lblR_5 = new JLabel("R5");
		
		JLabel lblR_6 = new JLabel("R6");
		
		JLabel lblR_7 = new JLabel("R7");
		
		JLabel lblR_8 = new JLabel("R8");
		
		JLabel lblR_9 = new JLabel("R9");
		
		JLabel lblR_10 = new JLabel("R10");
		
		JLabel lblR_11 = new JLabel("R11");
		
		JLabel lblR_12 = new JLabel("R12");
		
		JLabel lblR_13 = new JLabel("R13");
		
		JLabel lblR_14 = new JLabel("R14");
		
		JLabel lblR_15 = new JLabel("R15");
		
		JLabel lblR_16 = new JLabel("R16");
		
		r16text = new JTextField();
		r16text.setText("0");
		r16text.setColumns(10);
		
		r15text = new JTextField();
		r15text.setText("0");
		r15text.setColumns(10);
		
		r14text = new JTextField();
		r14text.setText("0");
		r14text.setColumns(10);
		
		r13text = new JTextField();
		r13text.setText("0");
		r13text.setColumns(10);
		
		r12text = new JTextField();
		r12text.setText("0");
		r12text.setColumns(10);
		
		r11text = new JTextField();
		r11text.setText("0");
		r11text.setColumns(10);
		
		r10text = new JTextField();
		r10text.setText("0");
		r10text.setColumns(10);
		
		r9text = new JTextField();
		r9text.setText("0");
		r9text.setColumns(10);
		
		r8text = new JTextField();
		r8text.setText("0");
		r8text.setColumns(10);
		
		r7text = new JTextField();
		r7text.setText("0");
		r7text.setColumns(10);
		
		r6text = new JTextField();
		r6text.setText("0");
		r6text.setColumns(10);
		
		r5text = new JTextField();
		r5text.setText("0");
		r5text.setColumns(10);
		
		r4text = new JTextField();
		r4text.setText("0");
		r4text.setColumns(10);
		
		r3text = new JTextField();
		r3text.setText("0");
		r3text.setColumns(10);
		
		r2text = new JTextField();
		r2text.setText("0");
		r2text.setColumns(10);
		
		r1text = new JTextField();
		r1text.setText("0");
		r1text.setColumns(10);
		
		r0text = new JTextField();
		r0text.setText("0");
		r0text.setColumns(10);
		
		JLabel r17text = new JLabel("R17");
		
		JLabel lblR_17 = new JLabel("R18");
		
		JLabel lblR_18 = new JLabel("R19");
		
		JLabel lblR_19 = new JLabel("R20");
		
		JLabel lblR_20 = new JLabel("R21");
		
		JLabel lblR_21 = new JLabel("R22");
		
		JLabel lblR_22 = new JLabel("R23");
		
		JLabel lblR_23 = new JLabel("R24");
		
		JLabel lblR_24 = new JLabel("R25");
		
		JLabel lblR_25 = new JLabel("R26");
		
		JLabel lblR_26 = new JLabel("R27");
		
		JLabel lblR_27 = new JLabel("R28");
		
		JLabel lblR_28 = new JLabel("R29");
		
		JLabel lblR_29 = new JLabel("R30");
		
		JLabel lblR_30 = new JLabel("R31");
		
		R17TEXT = new JTextField();
		R17TEXT.setText("0");
		R17TEXT.setColumns(10);
		
		r18text = new JTextField();
		r18text.setText("0");
		r18text.setColumns(10);
		
		r19text = new JTextField();
		r19text.setText("0");
		r19text.setColumns(10);
		
		r20text = new JTextField();
		r20text.setText("0");
		r20text.setColumns(10);
		
		r21text = new JTextField();
		r21text.setText("0");
		r21text.setColumns(10);
		
		r22text = new JTextField();
		r22text.setText("0");
		r22text.setColumns(10);
		
		r23text = new JTextField();
		r23text.setText("0");
		r23text.setColumns(10);
		
		r24text = new JTextField();
		r24text.setText("0");
		r24text.setColumns(10);
		
		r25text = new JTextField();
		r25text.setText("0");
		r25text.setColumns(10);
		
		r26text = new JTextField();
		r26text.setText("0");
		r26text.setColumns(10);
		
		r27text = new JTextField();
		r27text.setText("0");
		r27text.setColumns(10);
		
		r28text = new JTextField();
		r28text.setText("0");
		r28text.setColumns(10);
		
		r29text = new JTextField();
		r29text.setText("0");
		r29text.setColumns(10);
		
		r30text = new JTextField();
		r30text.setText("0");
		r30text.setColumns(10);
		
		r31text = new JTextField();
		r31text.setText("0");
		r31text.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblR_15)
							.addGap(18)
							.addComponent(r15text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblR_10)
										.addComponent(lblR_9)
										.addComponent(lblR_8)
										.addComponent(lblR_7)
										.addComponent(lblR_6)
										.addComponent(lblR_5)
										.addComponent(lblR_4)
										.addComponent(lblR_3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblR_2)
										.addComponent(lblR_1)
										.addComponent(lblR))
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(r0text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(r1text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(r2text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(r3text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(r4text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(r5text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(r6text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(r7text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(r8text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(r9text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(r10text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblR_11)
									.addGap(18)
									.addComponent(r11text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblR_12)
									.addGap(18)
									.addComponent(r12text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblR_13)
									.addGap(18)
									.addComponent(r13text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblR_14)
									.addGap(18)
									.addComponent(r14text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(40)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblR_27)
									.addGap(18)
									.addComponent(r28text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblR_28)
									.addGap(18)
									.addComponent(r29text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblR_29)
									.addGap(18)
									.addComponent(r30text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblR_30)
									.addGap(18)
									.addComponent(r31text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblR_16)
										.addComponent(r17text)
										.addComponent(lblR_17)
										.addComponent(lblR_18)
										.addComponent(lblR_19)
										.addComponent(lblR_20)
										.addComponent(lblR_21)
										.addComponent(lblR_22)
										.addComponent(lblR_23)
										.addComponent(lblR_25)
										.addComponent(lblR_26)
										.addComponent(lblR_24))
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(r25text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(r26text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(r27text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(r24text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(r23text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(r22text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(r21text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(r19text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(r18text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(R17TEXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(r20text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(r16text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addPreferredGap(ComponentPlacement.RELATED, 123, Short.MAX_VALUE)))
					.addGap(71))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblR)
							.addComponent(r0text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(r16text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblR_16)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblR_1)
								.addComponent(r1text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblR_2)
								.addComponent(r2text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblR_3))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(R17TEXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(r17text))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(r18text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblR_17))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(r3text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(r19text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblR_18))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblR_4)
						.addComponent(r4text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(r20text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblR_19))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblR_5)
						.addComponent(r5text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(r21text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblR_20))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblR_6)
						.addComponent(r6text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(r22text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblR_21))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblR_7)
						.addComponent(r7text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(r23text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblR_22))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblR_8)
						.addComponent(r8text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(r24text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblR_23))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblR_9)
						.addComponent(r9text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblR_24)
						.addComponent(r25text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblR_10)
						.addComponent(r10text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(r26text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblR_25))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblR_11)
						.addComponent(r11text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblR_26)
						.addComponent(r27text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblR_12)
						.addComponent(r12text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblR_27)
						.addComponent(r28text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblR_13)
						.addComponent(r13text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblR_28)
						.addComponent(r29text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblR_14)
						.addComponent(r14text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblR_29)
						.addComponent(r30text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblR_15)
						.addComponent(r15text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(r31text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblR_30))
					.addContainerGap(43, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmUpute = new JMenuItem("Upute");
		mntmUpute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String upute = "Instrukcije se unose u binarnom zapisu!";
				JOptionPane.showMessageDialog(null, upute,"Protoèna struktura", JOptionPane.PLAIN_MESSAGE);
			}
		});
		mnHelp.add(mntmUpute);
		
		JMenuItem mntmAutori = new JMenuItem("Autori");
		mntmAutori.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Haliloviæ Irhad\nKariæ Zlata","Autori", JOptionPane.PLAIN_MESSAGE);
			}
		});
		mnHelp.add(mntmAutori);
	}
}

