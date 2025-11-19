/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho.a3.view;

/**
 *
 * @author mathe
 */
public class MainFrame extends javax.swing.JFrame {
      private String tipoUsuario; // "admin" ou "comum"

    public MainFrame(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
        initComponents();
        setLocationRelativeTo(null);
        configurarVisibilidade();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        panel = new javax.swing.JPanel();
        lblBemVindo = new javax.swing.JLabel();
        btnGerenciarUsuarios = new javax.swing.JButton();
        btnCadastrarRecurso = new javax.swing.JButton();
        btnListarRecursos = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Painel Principal");

        panel.setBackground(new java.awt.Color(250, 250, 250));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBemVindo.setFont(new java.awt.Font("Segoe UI", 1, 18));
        lblBemVindo.setText("Bem-vindo ao Sistema");
        panel.add(lblBemVindo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        btnGerenciarUsuarios.setText("Gerenciar Usuários");
        btnGerenciarUsuarios.addActionListener(evt -> new UserManagementFrame().setVisible(true));
        panel.add(btnGerenciarUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 200, 40));

        btnCadastrarRecurso.setText("Cadastrar Recurso");
        btnCadastrarRecurso.addActionListener(evt -> new ResourceCreateFrame().setVisible(true));
        panel.add(btnCadastrarRecurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 200, 40));

        btnListarRecursos.setText("Listar Recursos");
        btnListarRecursos.addActionListener(evt -> new ResourceListFrame().setVisible(true));
        panel.add(btnListarRecursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 200, 40));

        btnSair.setText("Sair");
        btnSair.addActionListener(evt -> {
            new LoginFrame().setVisible(true);
            dispose();
        });
        panel.add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 200, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
        );

        pack();
    }

    private void configurarVisibilidade() {
        btnGerenciarUsuarios.setVisible("admin".equalsIgnoreCase(tipoUsuario));
        btnCadastrarRecurso.setVisible("comum".equalsIgnoreCase(tipoUsuario));
        btnListarRecursos.setVisible("comum".equalsIgnoreCase(tipoUsuario));
    }

    // componentes
    private javax.swing.JButton btnCadastrarRecurso;
    private javax.swing.JButton btnGerenciarUsuarios;
    private javax.swing.JButton btnListarRecursos;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel lblBemVindo;
    private javax.swing.JPanel panel;

}
