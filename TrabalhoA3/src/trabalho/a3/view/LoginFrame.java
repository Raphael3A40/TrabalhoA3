/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package trabalho.a3.view;

/**
 *
 * @author mathe
 */
public class LoginFrame extends javax.swing.JFrame {
   public LoginFrame() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        panel = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        btnEntrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login - Sistema de Curadoria");

        panel.setBackground(new java.awt.Color(242, 242, 242));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 20));
        lblTitulo.setText("Acesso ao Sistema");
        panel.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        lblUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lblUsuario.setText("Usuário:");
        panel.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        txtUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14));
        panel.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 105, 260, 30));

        lblSenha.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lblSenha.setText("Senha:");
        panel.add(lblSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        txtSenha.setFont(new java.awt.Font("Segoe UI", 0, 14));
        panel.add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 175, 260, 30));

        btnEntrar.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnEntrar.setText("Entrar");
        btnEntrar.addActionListener(evt -> onEntrar());
        panel.add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 120, 35));

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

    private void onEntrar() {
        String usuario = txtUsuario.getText().trim();
        String senha = new String(txtSenha.getPassword()).trim();

        if (usuario.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
            return;
        }

        // Temporário: login falso
        // Se usuario == "admin" login admin, caso contrário comum
        if (usuario.equalsIgnoreCase("admin")) {
            new MainFrame("admin").setVisible(true);
            dispose();
        } else {
            // aqui idealmente você buscaria no DB e receberia o userId / tipo real
            new MainFrame("comum").setVisible(true);
            dispose();
        }
    }

 // componentes
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JPanel panel;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel1)
                .addContainerGap(339, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel1)
                .addContainerGap(224, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
