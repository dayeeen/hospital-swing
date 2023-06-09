import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import javax.swing.*;

public class Antrian implements ActionListener {
    public static void main(String[] args) {
        new Antrian();
    }
    Antrian () {
        initComponent();
    }
    private void initComponent() {
        JFrame antri = new JFrame("Menu Antrian");
        antri.setSize(500, 400);
        antri.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        antri.setLocationRelativeTo(null);
        antri.setLayout(null);
        //Membuat Label Judul
        JLabel labelJudul = new JLabel("Antrian Rumah Sakit SGD");
        labelJudul.setForeground(Color.BLACK);
        labelJudul.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
        labelJudul.setBounds(140, 30, 300, 30);
        
        antri.add(labelJudul);
        //Membuat Label Menu
        JLabel labelMenu = new JLabel(" ADT yang digunakan : LinkedList ");
        labelMenu.setBounds(135, 60, 300, 20);
        labelMenu.setForeground(Color.BLACK);
        labelMenu.setFont(new Font("Serif", Font.CENTER_BASELINE, 15));
        antri.add(labelMenu);
        //Membuat tombol menu
        JButton btn1 = new JButton("Tambah Antrian");
        btn1.setBounds(150, 90, 200, 25);
        antri.add(btn1);
        JButton btn2 = new JButton("Pemanggilan Pasien");
        btn2.setBounds(150, 120, 200, 25);
        antri.add(btn2);
        JButton btn3 = new JButton("Tampilkan Antrian");
        btn3.setBounds(150, 150, 200, 25);
        antri.add(btn3);
        JButton btn4 = new JButton("Kembali");
        btn4.setBounds(150, 180, 200, 25);
        antri.add(btn4);

        //set background biar kece
        JLabel background = new JLabel(new ImageIcon("image\\RS.png"));
        //background must be fit cover
        background.setBounds(0, 0, 500, 400);
        antri.add(background);

        antri.setVisible(true);
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
        //Membuat Queue
        Queue<String> antrian = new LinkedList<String>();
        //Membuat antrian rumah sakit
        switch(command) {
            case "Tambah Antrian":
                //show dialog
                String nomor = JOptionPane.showInputDialog("Masukkan Nomor Antrian : ");
                String nama = JOptionPane.showInputDialog("Masukkan Nama : ");                
                //add patients to DaftarPasien.txt
                //use queue method to add
                //write to DaftarPasien.txt
                if (nomor == null || nama == null) {
                    //do nothing
                    break;
                }
                try {
                    FileWriter fw = new FileWriter("data/DaftarPasien.txt", true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter pw = new PrintWriter(bw);
                    antrian.add(nomor + " " + nama);
                    pw.println(antrian);
                    //SHOW
                    JOptionPane.showMessageDialog(null, "Pasien dengan nomor antrian " + nomor + " telah ditambahkan");
                    pw.close();

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;
            case "Pemanggilan Pasien":               
                //read data from DaftarPasien.txt
                try {
                    List<String> lines = Files.readAllLines(new File("data/DaftarPasien.txt").toPath(), Charset.defaultCharset());
                    //cek apakah list nya ada atau tidak
                    if (lines.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Antrian Kosong");
                    }
                    else {
                        //show dialog
                        JOptionPane.showMessageDialog(null, "Masuk ke ruangan untuk antrian nomor : " + lines.get(0));
                        //remove data from DaftarPasien.txt
                        lines.remove(0);
                        //write to DaftarPasien.txt
                        try {
                            FileWriter fw = new FileWriter("data/DaftarPasien.txt");
                            BufferedWriter bw = new BufferedWriter(fw);
                            PrintWriter pw = new PrintWriter(bw);
                            for (String line : lines) {
                                pw.println(line);
                            }
                            pw.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
                catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;
            case "Tampilkan Antrian":
                //read data from DaftarPasien.txt
                //display horizontal
                try {
                    List<String> lines = Files.readAllLines(new File("data/DaftarPasien.txt").toPath(), Charset.defaultCharset());
                    //cek apakah list nya ada atau tidak
                    if (lines.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Antrian Kosong");
                    }
                    else {
                        //show dialog horizontal
                        //horizontal
                        String[] columnNames = {"Nomor Antrian", "Nama"};
                        String[][] data = new String[lines.size()][2];
                        for (int i = 0; i < lines.size(); i++) {
                            String[] line = lines.get(i).split(" ");
                            data[i][0] = line[0];
                            data[i][1] = line[1];
                        }
                        JTable table = new JTable(data, columnNames);
                        JScrollPane scrollPane = new JScrollPane(table);
                        JOptionPane.showMessageDialog(null, scrollPane, "Antrian Pasien", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;
            case "Kembali":
                TugasBesar.main(null);
                break;
        }
    }
}
 