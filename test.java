import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Frame {
    JFrame f;
    Frame(String name) {
        this.f = new JFrame(name);
        JButton b = this.addButton("Exit", 250, 300, 100, 30);
        b.addActionListener(e -> {
            f.dispose();
        });
        f.setSize(450, 400);
        f.setLayout(null);
        f.setVisible(true);
    }
    public JButton addButton(String bname, int x, int y, int w, int h) {
        JButton b = new JButton(bname);
        b.setBounds(x, y, w, h);
        f.add(b);
        return b;
    }
    public JTextField addTextField(int x, int y, int w, int h) {
        JTextField t = new JTextField(20);
        t.setBounds(x, y, w, h);
        f.add(t);
        return t;
    }
    public void addLabel(String lname, int x, int y, int w, int h) {
        JLabel l = new JLabel(lname);
        l.setBounds(x, y, w, h);
        f.add(l);
    }
    public JPasswordField addPasswordField(int x, int y, int w, int h) {
        JPasswordField v = new JPasswordField();
        v.setBounds(x, y, w, h);
        v.setEchoChar('*');
        f.add(v);
        return v;
    }
    public void addCheckBox(String name, int x, int y, int w, int h, JPasswordField v) {
        JCheckBox c = new JCheckBox(name);
        c.setBounds(x, y, w, h);
        c.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (c.isSelected())
                    v.setEchoChar((char) 0);
                else
                    v.setEchoChar('*');
            }
        });
        f.add(c);
    }
    public void showImageIcon() {
        JLabel lbl1 = new JLabel(new ImageIcon("sr.png"));
        lbl1.setBounds(100, 50, 150, 150);
        f.add(lbl1);
    }
}

public class test {
    public static void main(String[] args) {
        Frame o = new Frame("PaySlip Generator");
        o.showImageIcon();
        JButton b1 = o.addButton("...WELCOME...", 100, 230, 150, 30);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                Frame o = new Frame("PaySlip Generator");
                o.addLabel("Name:", 50, 50, 130, 30);
                JTextField nameTextField = o.addTextField(150, 50, 130, 30);
                o.addLabel("ID:", 50, 100, 130, 30);
                JTextField idTextField = o.addTextField(150, 100, 130, 30);
                o.addLabel("Password:", 50, 150, 130, 30);
                JPasswordField pwdField = o.addPasswordField(150, 150, 130, 30);
                o.addCheckBox("Show password", 300, 150, 130, 50, pwdField);
                JTextField pwd = pwdField;
                JButton b2 = o.addButton("Submit", 150, 200, 100, 30);
                b2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                    	String a1=nameTextField.getText();
                        String b1=idTextField.getText();
                        String c1=pwd.getText();
                        if(!a1.equals("") && !b1.equals("")&&!c1.equals("")) 
                        {    

                        	Frame o = new Frame("PaySlip Generator");
                           o.addLabel("No. of hours worked:", 50, 50, 130, 30);
                           JTextField dayTextField = o.addTextField(200, 50, 130, 30);
                           o.addLabel("Pay per hour:", 50, 100, 130, 30);
                           JTextField paypdTextField = o.addTextField(200, 100, 130, 30);
                           o.addLabel("Additional working hours:", 50, 150, 150, 30);
                           JTextField adworkdayTextField = o.addTextField(200, 150, 130, 30);
                           JButton b3 = o.addButton("Generate", 150, 200, 100, 30);
                          
                       		b3.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent ae) {
                            	   String a=dayTextField.getText();
                                   String b=paypdTextField.getText();
                               		String c=adworkdayTextField.getText();
                                   if(a.equals("") && b.equals("") && c.equals("")) 
                                   { 
                                	   
                                	   Frame newm = new Frame("Error!");
                                	   newm.addLabel("PLEASE ENTER YOUR DETAILS", 100, 150, 230, 30);
                                    
                                   }
                                   else
                                   {
                                	   Frame o = new Frame("Salary");
                                	   String name = nameTextField.getText();
                                       o.addLabel("Name: " + name, 50, 50, 130, 30);
                                       String id = idTextField.getText();
                                       o.addLabel("ID: " + id, 50, 100, 130, 30);
                                       float day = Float.parseFloat(dayTextField.getText());
                                       float pay = Float.parseFloat(paypdTextField.getText());
                                       float wday = Float.parseFloat(adworkdayTextField.getText());
                                       float sal = day * pay + (wday * pay);
                                       o.addLabel("Number of hours worked: " + (day + wday), 50, 150, 200, 30);
                                       o.addLabel("Salary: " + sal, 50, 200, 130, 30);
                                   }
                                   
                               }
                           });
                        }
                        else
                        {
                        	 Frame newf = new Frame("Error!");
                      	   newf.addLabel("PLEASE ENTER PROPER DETAILS", 100, 150, 230, 30);
                        }
                    }
                });
            }
        });
    }
}
