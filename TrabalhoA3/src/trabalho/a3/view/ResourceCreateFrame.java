/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho.a3.view;

import trabalho.a3.model.Recurso;
import trabalho.a3.dao.RecursoDAO;

import javax.swing.*;
import java.sql.SQLException;

/**
 *
 * @author mathe
 */
public class ResourceCreateFrame extends javax.swing.JFrame {
     public ResourceCreateFrame() {
        initComponents();
        setLocationRelativeTo(null);
}
 @SuppressWarnings("unchecked")
    private void initComponents() {

        panel = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        lblAutor = new javax.swing.JLabel();
        txtAutor = new javax.swing.JTextField();
        lblCategoria = new javax.swing.JLabel();
        comboCategoria = new javax.swing.JComboBox<>(new String[]{"IA Responsável", "Cibersegurança", "Privacidade & Ética Digital"});
        btnSalvar = new javax.swing.JButton("Salvar");

        setTitle("Cadastrar Recurso");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setText("Título:");
        panel.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        panel.add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 360, 28));

        lblAutor.setText("Autor:");
        panel.add(lblAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));
        panel.add(txtAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 360, 28));

        lblCategoria.setText("Categoria:");
        panel.add(lblCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));
        panel.add(comboCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 240, 28));

        btnSalvar.addActionListener(evt -> onSalvar());
        panel.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 100, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE));

        pack();
    }

    private void onSalvar() {
        String titulo = txtTitulo.getText().trim();
        String autor = txtAutor.getText().trim();
        String categoria = (String) comboCategoria.getSelectedItem();

        if (titulo.isEmpty() || autor.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha título e autor.");
            return;
        }

        // Para testes: usuárioId temporário = 1
        Recurso r = new Recurso();
        r.setTitulo(titulo);
        r.setAutor(autor);
        r.setCategoria(categoria);
        r.setUsuarioId(1);

        try {
            RecursoDAO dao = new RecursoDAO();
            dao.criar(r);
            JOptionPane.showMessageDialog(this, "Recurso salvo.");
            dispose();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro BD: " + ex.getMessage());
        }
    }

    // componentes
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JButton btnSalvar;
}