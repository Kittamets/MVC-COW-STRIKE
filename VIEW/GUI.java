package VIEW;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import CONTROLLER.InputController;
import CONTROLLER.ReadController;

import java.awt.*;  
import java.awt.event.*;  

public class GUI {
    public GUI() {
        JFrame frame1 = new JFrame();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(500, 500);

        JFrame frame2 = new JFrame();
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(500, 500);

        JFrame frame3 = new JFrame();
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setSize(500, 500);

        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());

        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());

        JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout());

        JTextField textField = new JTextField(15);
        JButton button = new JButton("Click Meh!");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame1.setVisible(false);
                frame2.setVisible(true);
                String text_input = textField.getText();
                String[] tmp = ReadController.findCow(text_input);

                panel2.removeAll();

                if ((tmp != null) && InputController.isZeroFirst(tmp[0]) && InputController.isDigitAnd8Digits(text_input) && InputController.isCowBlue(tmp[1])) {
                    JOptionPane.showMessageDialog(frame2, String.format("Cow ID: %s, Color: %s, Age: %s, Month: %s", tmp[0], tmp[1], tmp[2], tmp[3]));

                    final boolean[] isLime = {false};
                    String old_color = InputController.getCowColor(tmp[1]);

                    if (old_color.equals("BROWN")) {
                        JButton btn = new JButton("Milking");
                        panel2.add(btn);
                        btn.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                double prob = 0.01 * Integer.parseInt(tmp[2]);
                                if (Math.random() == prob) {
                                    int count = Integer.parseInt(tmp[4]) + 1;
                                    tmp[4] = Integer.toString(count);
                                    tmp[1] = "BLUE";
                                    JOptionPane.showMessageDialog(frame2, "BSOD");
                                }
                                else {
                                    int count = Integer.parseInt(tmp[4]) + 1;
                                    tmp[4] = Integer.toString(count);
                                    count = Integer.parseInt(tmp[5]) + 1;
                                    tmp[5] = Integer.toString(count);
                                }
                                ReadController.writeCSV(text_input, tmp);
                                JOptionPane.showMessageDialog(frame2, String.format("All milk produced: %s, Good milk: %s", tmp[4], tmp[5]));

                                frame2.setVisible(false);
                                frame3.setVisible(true);
                                JButton reset_btn = new JButton("RESET");
                                JButton home_btn = new JButton("HOME");
                                reset_btn.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        tmp[1] = old_color;
                                        ReadController.writeCSV(text_input, tmp);
                                    };
                                });
                                home_btn.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        frame3.setVisible(false);
                                        frame1.setVisible(true);
                                    };
                                });
                                panel3.removeAll();
                                panel3.add(home_btn);
                                panel3.add(reset_btn);

                                frame3.add(panel3);
                                frame3.revalidate();
                                frame3.repaint();
                            }
                        });
                    }
                    else {
                        JButton btn = new JButton("Milking");
                        JButton btn2 = new JButton("Feed lime");
                        
                        btn.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                if (!isLime[0]) {
                                    double prob = 0.005 * Integer.parseInt(tmp[3]);
                                    if (Math.random() == prob) {
                                        int count = Integer.parseInt(tmp[4]) + 1;
                                        tmp[4] = Integer.toString(count);
                                        tmp[1] = "BLUE";
                                        JOptionPane.showMessageDialog(frame2, "BSOD");
                                    }
                                    else {
                                        int count = Integer.parseInt(tmp[4]) + 1;
                                        tmp[4] = Integer.toString(count);
                                        count = Integer.parseInt(tmp[5]) + 1;
                                        tmp[5] = Integer.toString(count);
                                    }
                                    ReadController.writeCSV(text_input, tmp);
                                }
                                else {
                                    int count = Integer.parseInt(tmp[4]) + 1;
                                    tmp[4] = Integer.toString(count);
                                    count = Integer.parseInt(tmp[5]) + 1;
                                    tmp[5] = Integer.toString(count);
                                    ReadController.writeCSV(text_input, tmp);
                                }
                                JOptionPane.showMessageDialog(frame2, String.format("All milk produced: %s, Good milk: %s", tmp[4], tmp[5]));

                                frame2.setVisible(false);
                                frame3.setVisible(true);
                                JButton reset_btn = new JButton("RESET");
                                JButton home_btn = new JButton("HOME");
                                reset_btn.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        tmp[1] = old_color;
                                        ReadController.writeCSV(text_input, tmp);
                                    };
                                });
                                home_btn.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        frame3.setVisible(false);
                                        frame1.setVisible(true);
                                    };
                                });
                                panel3.removeAll();
                                panel3.add(home_btn);
                                panel3.add(reset_btn);

                                frame3.add(panel3);
                                frame3.revalidate();
                                frame3.repaint();
                            }

                        });
                        btn2.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                isLime[0] = true;
                            }
                        });
                        panel2.add(btn);
                        panel2.add(btn2);
                    }
                    frame2.add(panel2);
                    frame2.revalidate();
                    frame2.repaint();
                }
                else if  ((tmp != null) && (InputController.isZeroFirst(tmp[0]) == false) && InputController.isDigitAnd8Digits(text_input) && InputController.isCowBlue(tmp[1])){
                    JOptionPane.showMessageDialog(frame1, "ZERO FIRST");
                }
                else if  ((tmp != null) && InputController.isZeroFirst(tmp[0])  && (InputController.isDigitAnd8Digits(text_input) == false) && InputController.isCowBlue(tmp[1])){
                    JOptionPane.showMessageDialog(frame1, "contain more or less than 8 digits");
                }
                else if  ((tmp != null) && InputController.isZeroFirst(tmp[0])  && InputController.isDigitAnd8Digits(text_input) && (InputController.isCowBlue(tmp[1]) == false)){
                    JOptionPane.showMessageDialog(frame1, "BSOD");
                }
                else {
                    JOptionPane.showMessageDialog(frame1, "Multiple error occured");
                }
            }
        });

        panel1.add(textField);
        panel1.add(button);
        frame1.add(panel1);

        frame1.setVisible(true);
        frame1.setLocationRelativeTo(null);
        frame1.setResizable(false);
    }
}
