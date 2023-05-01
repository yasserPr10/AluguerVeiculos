/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author Admin
 */
public abstract class Dados {
    
    private String nome;
    private int idade;
    private String cell;
    private String senha;
    private String senha2;

    public Dados(String nome, int idade, String cell,String senha,String senha2) {
        this.nome = nome;
        this.idade = idade;
        this.cell = cell;
        this.senha=senha;
        this.senha2=senha2;
    }
    
     public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha2() {
        return senha2;
    }

    public void setSenha2(String senha2) {
        this.senha2 = senha2;
    }
    
    
    
    
    
}
