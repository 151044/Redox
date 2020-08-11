package com.colin.games.redox.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;

public class WelcomeFrame extends JFrame {
    private BufferedImage read;
    public WelcomeFrame(){
        super("Welcome!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try{
            read = ImageIO.read(Path.of("data/Starry Nebula 219.png").toFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        JPanel paint = new JPanel(){
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponents(g);
                g.drawImage(read,0,0,getWidth(), getHeight(),0,0,read.getWidth(),read.getHeight(),this);
            }
        };
        paint.setLayout(new BorderLayout());
        JButton button = new JButton("sudo pacman -Rns systemd");
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.addActionListener(ae -> System.exit(0));
        paint.add(button,BorderLayout.CENTER);
        add(paint);
        setSize(getMaximumSize());
        setVisible(true);
    }
}
