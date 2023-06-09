import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Biaya implements ActionListener {
    public static void main(String[] args) {
        new Biaya();
    }
    Biaya() {
        initComponent();
    }
    private void initComponent() {
        JFrame obat = new JFrame("Menu Daftar Obat");
        obat.setSize(500, 400);
        obat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obat.setLocationRelativeTo(null);
        obat.setLayout(null);
        //Membuat Label Judul
        JLabel labelJudul = new JLabel("Daftar Obat Rumah Sakit SGD");
        labelJudul.setForeground(Color.BLACK);
        labelJudul.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
        labelJudul.setBounds(115, 30, 300, 30);
        
        obat.add(labelJudul);
        //Membuat Label Menu
        JLabel labelMenu = new JLabel(" ADT yang digunakan : Sorting ");
        labelMenu.setBounds(155, 60, 300, 20);
        labelMenu.setForeground(Color.BLACK);
        labelMenu.setFont(new Font("Serif", Font.CENTER_BASELINE, 15));
        obat.add(labelMenu);
        //Membuat tombol menu
        JButton btn1 = new JButton("Tampilkan Sorting Daftar Pasien");
        btn1.setBounds(150, 90, 200, 25);
        obat.add(btn1);
        JButton btn2 = new JButton("Tampilkan Sorting Daftar Obat");
        btn2.setBounds(150, 120, 200, 25);
        obat.add(btn2);
        JButton btn3 = new JButton("Kembali");
        btn3.setBounds(150, 150, 200, 25);
        obat.add(btn3);

        //set background biar kece
        JLabel background = new JLabel(new ImageIcon("image\\RS.png"));
        //background must be fit cover
        background.setBounds(0, 0, 500, 400);
        obat.add(background);

        obat.setVisible(true);
        //Block event
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch(command) {
            case "Tampilkan Sorting Daftar Pasien":
                //tampilkan sorting pasien
                
                break;
            case "Tampilkan Sorting Daftar Obat":
                //tampilkan sorting obat
                break;
            case "Kembali":
                //kembali ke menu utama
                TugasBesar.main(null);
                break;
        }
    }
}