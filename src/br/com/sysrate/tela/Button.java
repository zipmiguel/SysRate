/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sysrate.tela;

import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author franc
 */
public class Button extends JButton{

    public Button(int x, int y, int l, int a, String nome, Color cor, Color fontColor) {
        setBounds(x, y, l, a);
        setText(nome);
        setBackground(cor);
        setForeground(fontColor);
    }
    
}
