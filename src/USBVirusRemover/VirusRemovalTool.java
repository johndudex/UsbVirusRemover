package USBVirusRemover;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.ImageIcon;

public class VirusRemovalTool extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model = new DefaultTableModel();
	private JTextField DriveLetter;
	static VirusRemovalTool Frm=new VirusRemovalTool();
	boolean tableToggle=true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		        	
		        	UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");


		        	//UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VirusRemovalTool frame = new VirusRemovalTool();
					frame.setVisible(true);
					Frm=frame;
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VirusRemovalTool() {
		addWindowStateListener(new WindowStateListener() {
			
			@Override
			public void windowStateChanged(WindowEvent arg0) {
				// TODO Auto-generated method stub
				setBounds(500, 200, 410, 400);
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 410, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.cyan);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		
		
		JButton RefreshBtn = new JButton("Refresh");
	    RefreshBtn.setBounds(10, 311, 122, 23);
	    contentPane.add(RefreshBtn);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 175, 122, 125);
		contentPane.add(scrollPane);
		
		
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {
	                {},
	                {},
	                {},
	                {}
	            },
	            new String [] {

	            }
	        ));
		
		
		 
		 	String[] Column={"Choose Drive"};
		    model.setColumnIdentifiers(Column);
		    table.setModel(model);
		    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		    table.setFillsViewportHeight(true);
		    
		    JLabel lblDrive = new JLabel("Drive:");
		    lblDrive.setBounds(154, 240, 64, 14);
		    contentPane.add(lblDrive);
		    
		    DriveLetter = new JTextField();
		    DriveLetter.setBounds(194, 237, 86, 20);
		    contentPane.add(DriveLetter);
		    DriveLetter.setColumns(10);
		    DriveLetter.setEditable(false);
		    
		    JButton Restorebtn = new JButton("Restore");
		    Restorebtn.setBounds(291, 236, 89, 23);
		    contentPane.add(Restorebtn);
		    
		    JLabel lblNewLabel = new JLabel("");
		    lblNewLabel.setIcon(new ImageIcon("C:\\Users\\john\\Desktop\\Final_project\\USBVirusRemover\\Logo.png"));
		    lblNewLabel.setBounds(26, 50, 354, 52);
		    contentPane.add(lblNewLabel);
		    Restorebtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
				if(DriveLetter.getText().isEmpty()){
					JOptionPane.showMessageDialog(Frm, "No Drive Selected!!!");
					return;}
				String attr="attrib -h -r -s /s /d "+DriveLetter.getText()+"*.*";
				
				java.lang.Runtime rt = java.lang.Runtime.getRuntime();
		    	try {
		    		
					java.lang.Process p = rt.exec(attr);
					JOptionPane.showMessageDialog(Frm, "Congratulations Yours Files have been Restored \n \n \n  \t Developed by Johndudex");
					//p = rt.exec(DriveLetter.getText());
					//p = rt.exec("Del *.Ink");
					System.out.println("del "+DriveLetter.getText()+"*.Inf");
					p = rt.exec("Explorer.exe "+DriveLetter.getText());
				} catch (IOException e) {
					
				}
					
				}
			});
		    
		    
		    
		    updateTable();
		    RefreshBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					updateTable();
					
					
					
				}
			});
		    
		    
		    
		    table.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					try{
					int selectedRow = table.getSelectedRow();
					
					DriveLetter.setText(table.getValueAt(selectedRow, 0).toString());
					
					}catch(ArrayIndexOutOfBoundsException e){}
					
				}
			});
		  
		    
		    
		
		
	}

	protected void updateTable() {
		if (model.getRowCount() > 0) {
            for (int i = model.getRowCount() - 1; i > -1; i--) {
                model.removeRow(i);
            }
        }
		
		
		File[] paths;
    	FileSystemView fsv = FileSystemView.getFileSystemView();

    	// returns pathnames for files and directory
    	paths = File.listRoots();

    	// for each pathname in pathname array
    	for(File path:paths)
    	{
    	    // prints file and directory paths
    		String Drive="",Desc="";
    		Drive=Drive+path;
    	    //System.out.println("Drive Name: "+path);
    		Desc+=""+fsv.getSystemTypeDescription(path);
    		if(Desc.equals("Removable Disk"))
    	    model.addRow(new Object[]{Drive});
    	}
		
	}
}
