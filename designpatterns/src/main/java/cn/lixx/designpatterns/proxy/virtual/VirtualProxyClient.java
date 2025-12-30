package cn.lixx.designpatterns.proxy.virtual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class VirtualProxyClient extends JFrame {
    private JPanel imagePanel;
    private JTextField urlField;

    public VirtualProxyClient() {
        setTitle("Virtual Proxy Image Viewer");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top Control Bar
        JPanel controlPanel = new JPanel();
        controlPanel.add(new JLabel("Web URL:"));
        urlField = new JTextField("http://example.com/gallery", 30);
        controlPanel.add(urlField);
        JButton loadButton = new JButton("Analyze & Download");
        controlPanel.add(loadButton);
        add(controlPanel, BorderLayout.NORTH);

        // Image Display Area
        imagePanel = new JPanel();
        imagePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        JScrollPane scrollPane = new JScrollPane(imagePanel);
        add(scrollPane, BorderLayout.CENTER);

        // Action
        loadButton.addActionListener(e -> analyzeUrlAndCreateProxies());
    }

    private void analyzeUrlAndCreateProxies() {
        imagePanel.removeAll();
        String url = urlField.getText();
        System.out.println("Analyzing URL: " + url);

        // SIMULATION: In a real app, we would parse the HTML at 'url' to find <img>
        // tags.
        // Here, we simulate finding 3 images.
        List<ImageProxy> foundImages = new ArrayList<>();

        // Using placeholder image service for demonstration
        foundImages.add(new ImageProxy("https://placeholder.im/300x300.png/Blue+Image/cccccc/000000", "image1.png"));
        foundImages.add(new ImageProxy("https://placeholder.im/300x300.png/Blue+Image/cccccc/000000", "photo.jpg"));
        foundImages.add(new ImageProxy("https://placeholder.im/300x300.png/Blue+Image/cccccc/000000", "nature.gif"));
        foundImages.add(new ImageProxy("https://placeholder.im/300x300.png/Blue+Image/cccccc/000000", "sunset.bmp"));

        for (ImageProxy proxy : foundImages) {
            JLabel label = new JLabel(proxy);
            label.setToolTipText("Click to download original image");
            label.setVerticalTextPosition(JLabel.BOTTOM);
            label.setHorizontalTextPosition(JLabel.CENTER);

            // Interaction: Click to load real image
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    proxy.loadRealImage();
                }
            });

            imagePanel.add(label);
        }

        imagePanel.revalidate();
        imagePanel.repaint();
        JOptionPane.showMessageDialog(this,
                "Found " + foundImages.size() + " images. Click an icon to download the full image.");
    }

    public static void main(String[] args) {
        // Run on Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            new VirtualProxyClient().setVisible(true);
        });
    }
}
