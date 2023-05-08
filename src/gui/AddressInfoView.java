package gui;

import apiGoogleMaps.SiteDetails;
import com.google.maps.errors.ApiException;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.IOException;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class AddressInfoView extends JFrame {

    private JPanel contentPane;
    private JTextField txtAddress;
    private JPanel pnlSearch;
    private JLabel lblCiudad;
    private JLabel lblCiudad2;
    private JLabel lblPais;
    private JLabel lblPais2;
    private JLabel lblCodigoPostal;
    private JLabel lblCodigoPostal2;
    private JLabel lblLatitud;
    private JLabel lblLatitud2;
    private JPanel pnlResults;
    private JLabel lblApiGoogleMaps;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddressInfoView frame = new AddressInfoView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public AddressInfoView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 600);
        contentPane = new JPanel();
        contentPane.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        pnlSearch = new JPanel();
        pnlSearch.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
        pnlSearch.setBounds(194, 181, 589, 49);
        contentPane.add(pnlSearch);
        pnlSearch.setLayout(null);

        txtAddress = new JTextField();
        txtAddress.setHorizontalAlignment(SwingConstants.CENTER);
        txtAddress.setFont(new Font("Calibri", Font.PLAIN, 20));
        txtAddress.setBounds(0, 0, 477, 49);
        pnlSearch.add(txtAddress);
        txtAddress.setColumns(10);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setFont(new Font("Calibri", Font.PLAIN, 20));
        btnBuscar.setBounds(492, 0, 97, 49);
        pnlSearch.add(btnBuscar);

        pnlResults = new JPanel();
        pnlResults.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
        pnlResults.setBounds(270, 290, 421, 180);
        contentPane.add(pnlResults);
        pnlResults.setLayout(null);
        pnlResults.setVisible(false);

        lblCiudad = new JLabel("Ciudad");
        lblCiudad.setBounds(0, 0, 129, 34);
        pnlResults.add(lblCiudad);
        lblCiudad.setFont(new Font("Calibri", Font.BOLD, 20));

        lblCiudad2 = new JLabel("");
        lblCiudad2.setHorizontalAlignment(SwingConstants.CENTER);
        lblCiudad2.setFont(new Font("Calibri", Font.PLAIN, 20));
        lblCiudad2.setBounds(146, 0, 275, 34);
        pnlResults.add(lblCiudad2);

        lblPais = new JLabel("Pais");
        lblPais.setBounds(0, 46, 129, 34);
        pnlResults.add(lblPais);
        lblPais.setFont(new Font("Calibri", Font.BOLD, 20));

        lblPais2 = new JLabel("");
        lblPais2.setHorizontalAlignment(SwingConstants.CENTER);
        lblPais2.setFont(new Font("Calibri", Font.PLAIN, 20));
        lblPais2.setBounds(146, 46, 275, 34);
        pnlResults.add(lblPais2);

        lblCodigoPostal = new JLabel("Codigo postal");
        lblCodigoPostal.setBounds(0, 96, 129, 34);
        pnlResults.add(lblCodigoPostal);
        lblCodigoPostal.setFont(new Font("Calibri", Font.BOLD, 20));

        lblCodigoPostal2 = new JLabel("");
        lblCodigoPostal2.setHorizontalAlignment(SwingConstants.CENTER);
        lblCodigoPostal2.setFont(new Font("Calibri", Font.PLAIN, 20));
        lblCodigoPostal2.setBounds(146, 96, 275, 34);
        pnlResults.add(lblCodigoPostal2);

        lblLatitud = new JLabel("Latitud");
        lblLatitud.setBounds(0, 146, 129, 34);
        pnlResults.add(lblLatitud);
        lblLatitud.setFont(new Font("Calibri", Font.BOLD, 20));

        lblLatitud2 = new JLabel("");
        lblLatitud2.setHorizontalAlignment(SwingConstants.CENTER);
        lblLatitud2.setFont(new Font("Calibri", Font.PLAIN, 20));
        lblLatitud2.setBounds(146, 146, 275, 34);
        pnlResults.add(lblLatitud2);

        lblApiGoogleMaps = new JLabel("API GOOGLE MAPS");
        lblApiGoogleMaps.setHorizontalAlignment(SwingConstants.CENTER);
        lblApiGoogleMaps.setFont(new Font("Calibri", Font.BOLD, 45));
        lblApiGoogleMaps.setBounds(194, 67, 589, 49);
        contentPane.add(lblApiGoogleMaps);
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if(!txtAddress.equals("")) {
                    try {
                        String[] details = SiteDetails.getDetails(txtAddress.getText());
                        lblCiudad2.setText(details[0]);
                        lblPais2.setText(details[1]);
                        lblCodigoPostal2.setText(details[2]);
                        lblLatitud2.setText(details[3]);
                        pnlResults.setVisible(true);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }

            }
        });
    }
}

