/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho.a3.model;

/**
 *
 * @author mathe
 */
public class Usuario {
     private int id;
    private String nome;
    private int idade;
    private String tipo; // "admin" ou "comum"
    private boolean interesseIA;
    private boolean interesseCiber;
    private boolean interessePrivacidade;
    private boolean ativo = true;

    public Usuario() {}

    public Usuario(int id, String nome, int idade, String tipo) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.tipo = tipo;
    }

    // getters e setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public boolean isInteresseIA() { return interesseIA; }
    public void setInteresseIA(boolean interesseIA) { this.interesseIA = interesseIA; }

    public boolean isInteresseCiber() { return interesseCiber; }
    public void setInteresseCiber(boolean interesseCiber) { this.interesseCiber = interesseCiber; }

    public boolean isInteressePrivacidade() { return interessePrivacidade; }
    public void setInteressePrivacidade(boolean interessePrivacidade) { this.interessePrivacidade = interessePrivacidade; }

    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }
}
