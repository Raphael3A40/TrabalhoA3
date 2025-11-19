/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho.a3.dao;

import trabalho.a3.db.Conexao;
import trabalho.a3.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author mathe
 */
public class UsuarioDAO {
    public void criar(Usuario u) throws SQLException {
        String sql = "INSERT INTO usuarios (nome, idade, tipo, interesse_ia, interesse_ciber, interesse_privacidade, ativo) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection c = Conexao.conectar();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, u.getNome());
            ps.setInt(2, u.getIdade());
            ps.setString(3, u.getTipo());
            ps.setBoolean(4, u.isInteresseIA());
            ps.setBoolean(5, u.isInteresseCiber());
            ps.setBoolean(6, u.isInteressePrivacidade());
            ps.setBoolean(7, u.isAtivo());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) u.setId(rs.getInt(1));
            }
        }
    }

    public void atualizar(Usuario u) throws SQLException {
        String sql = "UPDATE usuarios SET nome=?, idade=?, tipo=?, interesse_ia=?, interesse_ciber=?, interesse_privacidade=?, ativo=? WHERE id=?";
        try (Connection c = Conexao.conectar();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, u.getNome());
            ps.setInt(2, u.getIdade());
            ps.setString(3, u.getTipo());
            ps.setBoolean(4, u.isInteresseIA());
            ps.setBoolean(5, u.isInteresseCiber());
            ps.setBoolean(6, u.isInteressePrivacidade());
            ps.setBoolean(7, u.isAtivo());
            ps.setInt(8, u.getId());
            ps.executeUpdate();
        }
    }

   public List<Usuario> listar() throws SQLException {
    String sql = "SELECT * FROM usuarios";
    List<Usuario> lista = new ArrayList<>();
    try (Connection conn = Conexao.conectar();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            Usuario u = new Usuario();
            u.setId(rs.getInt("id"));
            u.setNome(rs.getString("nome"));
            // ... outros setters
            lista.add(u);
        }
    }
    return lista;
}

    }

