package br.unesp.poo.grupo03.modelo;

public class Nutricionista extends Pessoa{
    private String RegistroProfissional;
    private String senha;
    private Especialidade especialidade;

    public String getRegistroProfissional() {
        return RegistroProfissional;
    }

    public void setRegistroProfissional(String RegistroProfissional) {
        this.RegistroProfissional = RegistroProfissional;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
   
}
