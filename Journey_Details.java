
package airline.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Journey_Details extends JFrame{  //Forth

   public JTable table;
    JLabel ReservationDetails,Pnrno,Ticketid,Fcode,Jnydate,Jnytime,Source,Destination,label,label1;
    JButton Show;

    public static void main(String[] args){
        new Journey_Details();
    }
    
    public Journey_Details(){
        
        setTitle("JOURNEY_DETAILS");
	getContentPane().setBackground(Color.lightGray);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	setLayout(null);
		
	Source = new JLabel("SOURCE");
	Source.setFont(new Font("Tahoma", Font.PLAIN, 19));
	Source.setBounds(60, 100, 150, 27);
	add(Source);
	
        Destination = new JLabel("DESTINATION");
	Destination.setFont(new Font("Tahoma", Font.PLAIN, 19));
	Destination.setBounds(350, 100, 150, 27);
	add(Destination);
		
	
		
	Show = new JButton("SHOW");
	Show.setBounds(680, 100, 100, 30);
	Show.setBackground(Color.orange);
	add(Show);

	setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
	ReservationDetails = new JLabel("JOURNEY DETAILS");
	ReservationDetails.setForeground(Color.red);
	ReservationDetails.setFont(new Font("Tahoma", Font.PLAIN, 31));
	ReservationDetails.setBounds(280, 27, 359, 31);
	add(ReservationDetails);
		
	Pnrno = new JLabel("PNR_NO");
	Pnrno.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Pnrno.setBounds(79, 270, 83, 20);
	add(Pnrno);
		
	Ticketid = new JLabel("TICKET_ID");
	Ticketid.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Ticketid.setBounds(172, 270, 71, 20);
	add(Ticketid);
		
	Fcode = new JLabel("F_CODE");
	Fcode.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Fcode.setBounds(297, 270, 103, 20);
	add(Fcode);
		
	Jnydate = new JLabel("JNY_DATE");
	Jnydate.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Jnydate.setBounds(390, 270, 94, 20);
	add(Jnydate);
		
	Jnytime = new JLabel("JNY_TIME");
	Jnytime.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Jnytime.setBounds(494, 270, 83, 20);
	add(Jnytime);
		
	Source = new JLabel("SOURCE");
	Source.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Source.setBounds(613, 270, 94, 20);
	add(Source);
		
	Destination = new JLabel("DESTINATION");
	Destination.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Destination.setBounds(717, 270, 94, 20);
	add(Destination);
        
	String[] items1 =  {"India","Philippines","Bangladesh","China", "Russia", "Brazil","Canada","Israel","United States","Australia","Saudi Arabia","United kingdom"};
	JComboBox comboBox = new JComboBox(items1);
	comboBox.setBounds(150, 100, 150, 27);
	comboBox.setBackground(Color.lightGray);
	add(comboBox);
		
		
	String[] items2 =  {"Philippines", "China", "Russia", "United States","Australia","Saudi Arabia","India","Bangladesh","Brazil","Canada","Israel"};
	JComboBox comboBox_1 = new JComboBox(items2);
	comboBox_1.setBounds(500, 100, 150, 27);
	comboBox_1.setBackground(Color.lightGray);
	add(comboBox_1);
        
        table = new JTable();
	table.setBounds(38, 310, 770, 130);
	add(table);
	
		
		
	Show.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
				String source  = (String) comboBox.getSelectedItem();
				String dest  = (String) comboBox_1.getSelectedItem();
		try{

                    
                    conn c = new conn();
                    
                    String str = "select pnr_no,ticket_id,f_code,jny_date,jny_time,src,dst from reservation where src = '"+source+"' and dst = '"+dest+"'";
                    ResultSet rs=c.s.executeQuery(str);
			        table.setModel(DbUtils.resultSetToTableModel(rs));
                /*    if(rs.next()){
                        table.setModel(DbUtils.resultSetToTableModel(rs));
                    }
					else{
                        JOptionPane.showMessageDialog(null,"No Flights between Source and Destination");
                        
                    }			*/
                    
					
		}catch(SQLException e){
			e.printStackTrace();
		}
            }
	});
		
	setSize(860,600);
        setLocation(200,50);
	setVisible(true);
		
    }
}
