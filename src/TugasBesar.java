import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
public class TugasBesar implements ActionListener {
    public static void main(String[] args) {
        new TugasBesar();
    }
    TugasBesar () {
        initComponent();
    }
    private void initComponent() {
        JFrame fr = new JFrame("Tugas Besar Kelompok 4");
        fr.setSize(500, 400);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLocationRelativeTo(null);
        fr.setLayout(null);
        
        

        //Membuat Label Judul
        //Menu rumah sakit
        JLabel labelJudul = new JLabel(" RS Sagede Bandung ");
        //set font color
        labelJudul.setForeground(Color.BLACK);
        //set bounds in the middle
        labelJudul.setBounds(165, 30, 300, 25);
        labelJudul.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
        
        //add to frame
        fr.add(labelJudul);

        //Membuat Label Menu
        JLabel labelMenu = new JLabel("Silahkan pilih menu di bawah ini : ");
        labelMenu.setBounds(145, 60, 300, 20);
        labelMenu.setFont(new Font("Serif", Font.CENTER_BASELINE, 15));
        labelMenu.setForeground(Color.BLACK);
        fr.add(labelMenu);
        //Membuat tombol menu

        JButton btn1 = new JButton("Daftar Obat");
        btn1.setBounds(150, 120, 200, 25);
        //set cursor
        btn1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        fr.add(btn1);

        JButton btn2 = new JButton("Antrian Pasien");
        btn2.setBounds(150, 90, 200, 25);
        btn2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        fr.add(btn2);

        JButton btn3 = new JButton("Daftar Dokter");
        btn3.setBounds(150, 150, 200, 25);
        btn3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        fr.add(btn3);

        JButton btn4 = new JButton("Estimasi Biaya");
        btn4.setBounds(150, 180, 200, 25);
        btn4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        fr.add(btn4);


        JButton btn5 = new JButton("Keluar");
        btn5.setBounds(150, 210, 200, 25);
        btn5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        fr.add(btn5);

        //set background biar kece
        JLabel background = new JLabel(new ImageIcon("image\\RS.png"));
        //background must be fit cover
        background.setBounds(0, 0, 500, 400);
        fr.add(background);

        //Aktifin setVisiblenya biar muncul framenya
        fr.setVisible(true);

        //Block event
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String command = e.getActionCommand();
        switch(command) {
            case "Antrian Pasien":
                Antrian.main(null);
                break;
            case "Daftar Obat":
                DaftarObat.main(null);
                break;
            case "Daftar Dokter":
                DaftarDokter.main(null);
                break;
            case "Estimasi Biaya":
                Biaya.main(null);
                break;
            case "Keluar":
                //show dialog
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog (null, "Apakah anda yakin ingin keluar?","Warning",dialogButton);
                if(dialogResult == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
                break;
        }
    }
}
