package cn.lixx.designpatterns.proxy.virtual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

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

        // SIMULATION: In a real app, we would parse the HTML at 'url' to find <img> tags.
        // Here, we simulate finding 3 images.
        List<ImageProxy> foundImages = new ArrayList<>();
        
        // Using placeholder image service for demonstration
        foundImages.add(new ImageProxy("https://via.placeholder.com/300/0000FF/808080?text=Blue+Image", "image1.png"));
        foundImages.add(new ImageProxy("https://via.placeholder.com/400/FF0000/FFFFFF?text=Red+Image", "photo.jpg"));
        foundImages.add(new ImageProxy("https://via.placeholder.com/350/008000/FFFFFF?text=Green+Nature", "nature.gif"));
        foundImages.add(new ImageProxy("https://via.placeholder.com/500/FFFF00/000000?text=Yellow+Sun", "sunset.bmp"));

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
        JOptionPane.showMessageDialog(this, "Found " + foundImages.size() + " images. Click an icon to download the full image.");
    }

    public static void main(String[] args) {
        // Run on Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            new VirtualProxyClient().setVisible(true);
        });
    }
}
