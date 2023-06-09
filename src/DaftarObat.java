import java.util.Stack;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import javax.swing.*;

public class DaftarObat implements ActionListener {
    public static void main(String[] args) {
        new DaftarObat();
    }
    DaftarObat () {
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
        JLabel labelMenu = new JLabel(" Menggunakan Konsep Stack ");
        labelMenu.setBounds(155, 60, 300, 20);
        labelMenu.setForeground(Color.BLACK);
        labelMenu.setFont(new Font("Serif", Font.CENTER_BASELINE, 15));
        obat.add(labelMenu);
        //Membuat tombol menu
        JButton btn1 = new JButton("Tambah Obat");
        btn1.setBounds(150, 90, 200, 25);
        obat.add(btn1);
        JButton btn2 = new JButton("Hapus Obat");
        btn2.setBounds(150, 120, 200, 25);
        obat.add(btn2);
        JButton btn3 = new JButton("Tampilkan Daftar Obat");
        btn3.setBounds(150, 150, 200, 25);
        obat.add(btn3);
        JButton btn4 = new JButton("Kembali");
        btn4.setBounds(150, 180, 200, 25);
        obat.add(btn4);

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
        btn4.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String command = e.getActionCommand();
        //STACK
        Stack<String> obat = new Stack<String>();
        //Membuat obatan rumah sakit
        switch(command) {
            case "Tambah Obat":
                //show dialog
                String kode = JOptionPane.showInputDialog("Masukkan Kode Obat : ");
                String nama = JOptionPane.showInputDialog("Masukkan Nama Obat : ");
                String exp = JOptionPane.showInputDialog("Masukkan Tanggal Expired : ");
                //add patients to DaftarPasien.txt
                if (kode == null || nama == null || exp == null) {
                    //do nothing
                    break;
                }
                try { 
                    List<String> lines = Files.readAllLines(new File("data/DaftarObat.txt").toPath(), Charset.defaultCharset());
                    //create stack
                    obat.push(kode + "  " + nama + "  " + exp);
                    //add to stack
                    for (String line : lines) {
                        obat.push(line);
                    }
                    //write to file
                    Files.write(new File("data/DaftarObat.txt").toPath(), obat, Charset.defaultCharset());
                    JOptionPane.showMessageDialog(null, "Obat telah ditambahkan");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;
            case "Hapus Obat":
                //read data from DaftarObat.txt
                try {
                    List<String> lines = Files.readAllLines(new File("data/DaftarObat.txt").toPath(), Charset.defaultCharset());
                    //if obat is empty
                    if (lines.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Daftar Obat Kosong...");
                        break;
                    } else {
                        //delete the first line of the txt biar last in first out
                        lines.remove(0);
                        //write to file
                        Files.write(new File("data/DaftarObat.txt").toPath(), lines, Charset.defaultCharset());
                        JOptionPane.showMessageDialog(null, "Obat telah dihapus");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;
            case "Tampilkan Daftar Obat":
                //read data from DaftarObat.txt
                try {
                    List<String> lines = Files.readAllLines(new File("data/DaftarObat.txt").toPath(), Charset.defaultCharset());
                    //if obat is empty
                    if (lines.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Daftar Obat Kosong...");
                        break;
                    } else {
                        //tables
                        String[] columnNames = {"Kode Obat", "Nama Obat", "Tanggal Expired"};
                        String[][] data = new String[lines.size()][3];
                        //add data to tables
                        for (int i = 0; i < lines.size(); i++) {
                            String[] line = lines.get(i).split("  ");
                            data[i][0] = line[0];
                            data[i][1] = line[1];
                            data[i][2] = line[2];
                        }
                        //show tables
                        JTable table = new JTable(data, columnNames);
                        JOptionPane.showMessageDialog(null, new JScrollPane(table));
                        
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;
            case "Kembali":
                TugasBesar.main(null);
                break;
        }
    }
}
 