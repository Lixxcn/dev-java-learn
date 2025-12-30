package cn.lixx.designpatterns.proxy.virtual;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * ImageProxy acts as a Virtual Proxy.
 * It displays a placeholder icon initially and loads the real image in the background
 * only when requested (or automatically, depending on implementation).
 * 
 * In this specific requirement: "Display icon first... Click to view original".
 */
public class ImageProxy implements Icon {
    private String imageUrl;
    private String fileName;
    private ImageIcon realIcon;
    private boolean retrieving = false;
    private Component currentComponent;

    public ImageProxy(String imageUrl, String fileName) {
        this.imageUrl = imageUrl;
        this.fileName = fileName;
    }

    @Override
    public int getIconWidth() {
        if (realIcon != null) {
            return realIcon.getIconWidth();
        }
        return 100; // Default placeholder width
    }

    @Override
    public int getIconHeight() {
        if (realIcon != null) {
            return realIcon.getIconHeight();
        }
        return 120; // Default placeholder height (including text space)
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        this.currentComponent = c;
        if (realIcon != null) {
            // Real image is loaded, display it
            realIcon.paintIcon(c, g, x, y);
        } else {
            // Draw Placeholder / Icon
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(x, y, 100, 100);
            
            g.setColor(Color.BLACK);
            g.drawRect(x, y, 100, 100);
            
            // Draw File Type Text (simulating different icons)
            String ext = fileName.contains(".") ? fileName.substring(fileName.lastIndexOf(".") + 1) : "IMG";
            g.drawString(ext.toUpperCase(), x + 35, y + 50);
            
            // Draw Filename below
            g.drawString(fileName, x, y + 115);

            if (retrieving) {
                g.setColor(Color.RED);
                g.drawString("Loading...", x + 20, y + 20);
            }
        }
    }

    /**
     * Triggers the background loading of the real image.
     */
    public void loadRealImage() {
        if (realIcon == null && !retrieving) {
            retrieving = true;
            if (currentComponent != null) {
                currentComponent.repaint();
            }
            
            // Using a thread to load image in background
            new Thread(() -> {
                try {
                    System.out.println("Downloading: " + imageUrl);
                    // Simulate network delay for demonstration
                    Thread.sleep(2000); 
                    URL url = new URL(imageUrl);
                    realIcon = new ImageIcon(url);
                    System.out.println("Loaded: " + fileName);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println("Failed to load: " + fileName);
                } finally {
                    retrieving = false;
                    if (currentComponent != null) {
                        currentComponent.repaint();
                    }
                }
            }).start();
        }
    }
    
    public String getFileName() {
        return fileName;
    }
}
