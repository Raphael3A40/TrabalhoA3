/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho.a3.view;

import trabalho.a3.model.Usuario;
import trabalho.a3.dao.UsuarioDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author mathe
 */
public class UserManagementFrame extends javax.swing.JFrame  {
      private DefaultTableModel tableModel;

    public UserManagementFrame() {
        initComponents();
        setLocationRelativeTo(null);
        montarTabela();
        carregarUsuarios();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        panel = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblIdade = new javax.swing.JLabel();
        txtIdade = new javax.swing.JTextField();
        lblTipo = new javax.swing.JLabel();
        comboTipo = new javax.swing.JComboBox<>(new String[]{"admin", "comum"});
        chkIA = new javax.swing.JCheckBox("IA Responsável");
        chkCiber = new javax.swing.JCheckBox("Cibersegurança");
        chkPriv = new javax.swing.JCheckBox("Privacidade & Ética Digital");
        btnSalvar = new javax.swing.JButton("Salvar");
        btnEditar = new javax.swing.JButton("Editar");
        btnInativar = new javax.swing.JButton("Inativar");
        tabela = new javax.swing.JTable();

        setTitle("Gestão de Usuários");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNome.setText("Nome:");
        panel.add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        panel.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 220, 28));

        lblIdade.setText("Idade:");
        panel.add(lblIdade, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));
        panel.add(txtIdade, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 60, 28));

        lblTipo.setText("Tipo:");
        panel.add(lblTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, -1));
        panel.add(comboTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 120, 28));

        panel.add(chkIA, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));
        panel.add(chkCiber, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, -1, -1));
        panel.add(chkPriv, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, -1, -1));

        btnSalvar.addActionListener(evt -> onSalvar());
        panel.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));

        btnEditar.addActionListener(evt -> onEditar());
        panel.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 90, 30));

        btnInativar.addActionListener(evt -> onInativar());
        panel.add(btnInativar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 110, 30));

        tabela.setModel(new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Nome", "Idade", "Tipo", "Ativo"}));
        panel.add(new JScrollPane(tabela), new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 440, 200));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
        );

        pack();
    }

    private void montarTabela() {
        tableModel = (DefaultTableModel) tabela.getModel();
    }

    private void carregarUsuarios() {
        try {
            UsuarioDAO dao = new UsuarioDAO();
            List<Usuario> lista = dao.listarTodos();
            tableModel.setRowCount(0);
            for (Usuario u : lista) {
                tableModel.addRow(new Object[]{u.getId(), u.getNome(), u.getIdade(), u.getTipo(), u.isAtivo()});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar usuários: " + ex.getMessage());
        }
    }

    private void onSalvar() {
        try {
            Usuario u = new Usuario();
            u.setNome(txtNome.getText());
            u.setIdade(Integer.parseInt(txtIdade.getText()));
            u.setTipo((String) comboTipo.getSelectedItem());
            u.setInteresseIA(chkIA.isSelected());
            u.setInteresseCiber(chkCiber.isSelected());
            u.setInteressePrivacidade(chkPriv.isSelected());
            u.setAtivo(true);

            UsuarioDAO dao = new UsuarioDAO();
            dao.criar(u);
            carregarUsuarios();
            JOptionPane.showMessageDialog(this, "Usuário salvo.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Idade inválida.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro BD: " + e.getMessage());
        }
    }

    private void onEditar() {
        int sel = tabela.getSelectedRow();
        if (sel < 0) { JOptionPane.showMessageDialog(this, "Selecione um usuário."); return; }
        int id = (int) tableModel.getValueAt(sel, 0);
        String nome = (String) tableModel.getValueAt(sel, 1);
        int idade = (int) tableModel.getValueAt(sel, 2);
        String tipo = (String) tableModel.getValueAt(sel, 3);
        txtNome.setText(nome);
        txtIdade.setText(String.valueOf(idade));
        comboTipo.setSelectedItem(tipo);
        // para simplificar a edição completa use botão Salvar após alterar
    }

    private void onInativar() {
        int sel = tabela.getSelectedRow();
        if (sel < 0) { JOptionPane.showMessageDialog(this, "Selecione um usuário."); return; }
        int id = (int) tableModel.getValueAt(sel, 0);
        try {
            UsuarioDAO dao = new UsuarioDAO();
            // pega, marca inativo e atualiza (simplificação)
            List<Usuario> lista = dao.listarTodos();
            for (Usuario u : lista) {
                if (u.getId() == id) {
                    u.setAtivo(false);
                    dao.atualizar(u);
                    break;
                }
            }
            carregarUsuarios();
            JOptionPane.showMessageDialog(this, "Usuário inativado.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro BD: " + ex.getMessage());
        }
    }

    // componentes
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnInativar;
    private javax.swing.JCheckBox chkIA;
    private javax.swing.JCheckBox chkCiber;
    private javax.swing.JCheckBox chkPriv;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblIdade;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtIdade;
}
