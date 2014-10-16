package br.unicesumar.escoladeti.entity;

import javax.persistence.Entity;
import static liquibase.util.MD5Util.computeMD5;

@Entity
public class Usuario extends Entidade {
    
    private static final long serialVersionUID = 1L;

    private String nome;
    private String login;
    private String senha;
    private String email;
    private boolean ativo;
    
    public Usuario() {
    }

    public Usuario(String nome, String senha, String login, String email) {
        this.login = login;
        this.nome = nome.toUpperCase();
        this.email = email.toUpperCase();
        setSenha(senha);
    }

    private Usuario(Long id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = computeMD5(senha);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.toUpperCase();
    }

    public boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    public static Usuario of(Long id) {
        return new Usuario(id);
    }
}
