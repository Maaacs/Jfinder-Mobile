package com.example.jfinder_mobile;

import java.io.Serializable;

public class Usuario implements Serializable {

    //atributos
    private String primeiroNome;
    private String ultimoNome;
    private String CPF;
    private String cargo;


    public Usuario(String NovoPrimeiroNome, String NovoUltimoNome, String novoCPF, String NovoCargo) {
        this.setPrimeiroNome(NovoPrimeiroNome);
        this.setUltimoNome(NovoUltimoNome);
        this.setCPF(novoCPF);
        this.setCargo(NovoCargo);
    }

    //Get Set dos atributos
    public String getPrimeiroNome() {

        return this.primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {

        this.primeiroNome = primeiroNome;
    }

    public String getUltimoNome() {

        return this.ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {

        this.ultimoNome = ultimoNome;
    }

    public String getCPF() {
        return this.CPF;
    }

    public void setCPF(String CPF) {

        this.CPF = CPF;
    }

    public String getCargo() {

        return this.cargo;
    }

    public void setCargo(String cargo) {

        this.cargo = cargo;
    }

    public String toString() {
        return "Nome: " + primeiroNome + "\nSobrenome: " + ultimoNome + "\nCPF: " + CPF +
                "\nCargo: " + cargo;
    }


}
