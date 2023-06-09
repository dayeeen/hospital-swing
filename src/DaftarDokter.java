import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
public class DaftarDokter implements ActionListener {
    public static void main(String[] args) {
        new DaftarDokter();
    }
    DaftarDokter () {
        initComponent();
    }
    private void initComponent() {
        JFrame antri = new JFrame("Menu Daftar Dokter");
        antri.setSize(500, 400);
        antri.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        antri.setLocationRelativeTo(null);
        antri.setLayout(null);
        //Membuat Label Judul
        JLabel labelJudul = new JLabel("Daftar Dokter di RS SGD");
        labelJudul.setForeground(Color.BLACK);
        labelJudul.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
        labelJudul.setBounds(140, 30, 300, 30);
        antri.add(labelJudul);
        //Membuat Label Menu
        JLabel labelMenu = new JLabel("ADT yang digunakan : Hashtable");
        labelMenu.setForeground(Color.BLACK);
        labelMenu.setFont(new Font("Serif", Font.CENTER_BASELINE, 15));
        labelMenu.setBounds(140, 60, 300, 20);
        antri.add(labelMenu);
        //Membuat tombol menu
        JButton btn1 = new JButton("Cari Dokter Spesialis");
        btn1.setBounds(150, 90, 200, 25);
        btn1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        antri.add(btn1);

        JButton btn2 = new JButton("Tampilkan Daftar Dokter");
        btn2.setBounds(150, 120, 200, 25);
        btn2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        antri.add(btn2);

        JButton btn3 = new JButton("Kembali");
        btn3.setBounds(150, 150, 200, 25);
        btn3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        antri.add(btn3);

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
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Hashtable<String, String> dr = new Hashtable<String, String>();
        dr.put("Mata", "Dr. Dayen");
        dr.put("THT", "Dr. Tatang H. Tjahya");
        dr.put("Gigi", "Dr. Armand Maulana");
        dr.put("Umum", "Dr. Luhut");
        dr.put("Kandungan", "Dr. Lia Dahlia");
        dr.put("Kulit", "Dr. Richard");
        dr.put("Jantung", "Dr. Binsar Pandjaitan");
        dr.put("Paru", "Dr. Dre");
        
        // TODO Auto-generated method stub
        String command = e.getActionCommand();
        //Membuat antrian rumah sakit
        switch(command) {
            case "Cari Dokter Spesialis":
                //show dialog
                String find = JOptionPane.showInputDialog("Masukkan spesialisasi dokter: ");
                //show message
                JOptionPane.showMessageDialog(null, "Dokter " + find + " adalah " + dr.get(find));
                break;
            case "Tampilkan Daftar Dokter":
                //show doctor in spesial way
                //tables
                String[] columnNames = {"Spesialisasi", "Nama Dokter"};
                Object[][] data = {
                    {"Mata", dr.get("Mata")},
                    {"THT", dr.get("THT")},
                    {"Gigi", dr.get("Gigi")},
                    {"Umum", dr.get("Umum")},
                    {"Kandungan", dr.get("Kandungan")},
                    {"Kulit", dr.get("Kulit")},
                    {"Jantung", dr.get("Jantung")},
                    {"Paru", dr.get("Paru")}
                };
                //create table
                JTable table = new JTable(data, columnNames);
                //create scrollpane
                JScrollPane scrollPane = new JScrollPane(table);
                //show table
                JOptionPane.showMessageDialog(null, scrollPane, "Daftar Dokter", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "Kembali":
                //show message
                TugasBesar.main(null);
                break;
        }
    }
}
 