/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho.a3.view;

import trabalho.a3.dao.RecursoDAO;
import trabalho.a3.model.Recurso;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author mathe
 */
public class ResourceListFrame extends javax.swing.JFrame{
     private DefaultTableModel tableModel;

    public ResourceListFrame() {
        initComponents();
        setLocationRelativeTo(null);
        tableModel = (DefaultTableModel) tabela.getModel();
        carregar(1); // usuário de teste id=1
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        panel = new javax.swing.JPanel();
        tabela = new javax.swing.JTable();

        setTitle("Recursos Cadastrados");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tabela.setModel(new DefaultTableModel(new Object[][]{}, new String[]{"Título", "Autor", "Categoria"}));
        panel.add(new JScrollPane(tabela), new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 460, 300));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE));

        pack();
    }

    private void carregar(int usuarioId) {
        try {
            RecursoDAO dao = new RecursoDAO();
            List<Recurso> lista = dao.listarPorUsuario(usuarioId);
            tableModel.setRowCount(0);
            for (Recurso r : lista) {
                tableModel.addRow(new Object[]{r.getTitulo(), r.getAutor(), r.getCategoria()});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro BD: " + ex.getMessage());
        }
    }

    // componentes
    private javax.swing.JPanel panel;
    private javax.swing.JTable tabela;
}
