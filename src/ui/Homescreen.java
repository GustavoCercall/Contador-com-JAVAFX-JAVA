package ui;

import modelo.Contador;
import modelo.ContadorListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Homescreen extends JFrame implements ActionListener, ContadorListener {
    JButton btn = new JButton("BOTAO#1");
    JButton btn2 = new JButton("BOTAO#2");

    public Homescreen() {
        Contador.getInstance().setListener(this);
        setTitle("Atividade Contador");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initializeLayout();
    }

    private void initializeLayout() {
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        btn.setAlignmentX(CENTER_ALIGNMENT);
        btn2.setAlignmentX(CENTER_ALIGNMENT);
        add(btn);
        add(btn2);
        btn.setActionCommand("Botao1");
        btn2.setActionCommand("Botao2");
        btn.addActionListener(this);
        btn2.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getActionCommand().equalsIgnoreCase("Botao1")) {
                System.out.println("\nBotao 1 foi pressionado!\n");
                Contador.getInstance().incrementa();
            } else if (e.getActionCommand().equalsIgnoreCase("Botao2")) {
                System.out.println("\nBotão 2 foi pressionado!\n");
                 Contador.getInstance().decremento();
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    @Override
    public void oValorMudou(int novoValor) {
        System.out.println("Mudou Valor!");
        System.out.println("O novo valor eh:"+novoValor);
    }
}
