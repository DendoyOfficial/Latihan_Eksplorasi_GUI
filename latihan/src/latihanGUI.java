import java.awt.*;
import javax.swing.*;

public class latihanGUI extends JFrame {

    private GridLayout layoutUtama;
    private FlowLayout layoutTeks;
    private FlowLayout layoutHitung;

    private JPanel panelAtas;
    private JPanel panelBawah;

    private JLabel labelNama;
    private JLabel labelHasil;
    private JLabel labelHitung;

    private JTextField inputNama;

    private JButton tombolSapa;
    private JButton tombolReset;

    private int counter;

    public latihanGUI() {
        layoutUtama = new GridLayout(3, 1, 8, 8);
        layoutTeks = new FlowLayout();
        layoutHitung = new FlowLayout();

        panelAtas = new JPanel();
        panelBawah = new JPanel();

        labelNama = new JLabel("Nama:");
        labelHasil = new JLabel("Halo, silakan masukkan nama!", SwingConstants.CENTER);
        labelHitung = new JLabel("Jumlah klik: 0");

        inputNama = new JTextField(15);

        tombolSapa = new JButton("Sapa");
        tombolReset = new JButton("Reset");

        counter = 0;

        setTitle("Contoh Java GUI (Swing)");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // tampil di tengah layar

        setLayout(layoutUtama);

        panelAtas.setLayout(layoutTeks);
        panelBawah.setLayout(layoutHitung);

        panelAtas.add(labelNama);
        panelAtas.add(inputNama);
        panelAtas.add(tombolSapa);

        labelHasil.setFont(new Font("Arial", Font.BOLD, 16));

        panelBawah.add(labelHitung);
        panelBawah.add(tombolReset);

        add(panelAtas);
        add(labelHasil);
        add(panelBawah);

        tombolSapa.addActionListener(e -> {
            String nama = inputNama.getText().trim();
            if (nama.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong!",
                        "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }
            labelHasil.setText("Halo, " + nama + "!");
            counter++;
            labelHitung.setText("Jumlah klik: " + counter);
        });

        tombolReset.addActionListener(e -> {
            inputNama.setText("");
            labelHasil.setText("Halo, silakan masukkan nama!");
            counter = 0;
            labelHitung.setText("Jumlah klik: 0");
        });
    }

    public static void main(String[] args) {
        latihanGUI n = new latihanGUI();
        n.setVisible(true);
    }
}