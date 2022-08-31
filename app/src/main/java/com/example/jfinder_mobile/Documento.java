package com.example.jfinder_mobile;

public class Documento {


    //atributos
    private String numeroUnicoReferencia; //
    private String tipoDeDocumento; //
    private String interessado; //
    private String tipoDeArmazenamento;
    private String dataArquivamento;
    private String localCompletoDeArmazenamento;
    private String descriçãoDocumento; //
 //

    public Documento (){

    }

    //Construtor que inicializa o objeto Documento
    Documento(String NovoNumeroUnicoReferencia, String NovoTipoDeDocumento, String NovoInteressado, String NovoTipoDeArmazenamento, String NovoDataArquivamento,
              String NovoLocalCompletoDeArmazenamento, String NovoDescriçãoDocumento){
        this.setNumeroUnicoReferencia(NovoNumeroUnicoReferencia);
        this.setTipoDeDocumento(NovoTipoDeDocumento);
        this.setInteressado(NovoInteressado);
        this.setTipoDeArmazenamento(NovoTipoDeArmazenamento);
        this.setDataArquivamento(NovoDataArquivamento);
        this.setLocalCompletoDeArmazenamento(NovoLocalCompletoDeArmazenamento);
        this.setDescriçãoDocumento(NovoDescriçãoDocumento);

    }

    //Get Set dos atributos

    public String getNumeroUnicoReferencia() {

        return numeroUnicoReferencia;
    }
    public void setNumeroUnicoReferencia(String numeroUnicoReferencia) {
        this.numeroUnicoReferencia = numeroUnicoReferencia;
    }

    public String getDataArquivamento() {

        return dataArquivamento;
    }

    public void setDataArquivamento(String dataArquivamento) {

        this.dataArquivamento = dataArquivamento;
    }

    public String getInteressado() {
        return interessado;
    }

    public void setInteressado(String interessado) {

        this.interessado = interessado;
    }

    public String getTipoDeDocumento() {

        return tipoDeDocumento;
    }

    public void setTipoDeDocumento(String tipoDeDocumento) {

        this.tipoDeDocumento = tipoDeDocumento;
    }

    public String getDescriçãoDocumento() {

        return descriçãoDocumento;
    }

    public void setDescriçãoDocumento(String descriçãoDocumento) {

        this.descriçãoDocumento = descriçãoDocumento;
    }

    public String getTipoDeArmazenamento() {

        return tipoDeArmazenamento;
    }

    public void setTipoDeArmazenamento(String tipoDeArmazenamento) {

        this.tipoDeArmazenamento = tipoDeArmazenamento;
    }

    public String getLocalCompletoDeArmazenamento() {

        return localCompletoDeArmazenamento;
    }

    public void setLocalCompletoDeArmazenamento(String localCompletoDeArmazenamento) {
        this.localCompletoDeArmazenamento = localCompletoDeArmazenamento;
    }


    public String toString() {
        return "Nº Referência: " + numeroUnicoReferencia + "\nTipo de Documento: " + "\n" +tipoDeDocumento +"\nInteressado: " + interessado +
                "\nTipo de Armazenamento: " + tipoDeArmazenamento +"\nData de Arquivamento: " + dataArquivamento +"\nLocal de Armazenamento: " +"\n" +localCompletoDeArmazenamento +
                "\nDescrição: " + "\n"+ descriçãoDocumento;
    }

/*    public String toString() {
        return "Nº Referência: " + numeroUnicoReferencia + "\n" + "\nTipo de Documento: " +tipoDeDocumento + "\n" +"\nInteressado: " + interessado + "\n" +
                "\nTipo de Armazenamento: " + tipoDeArmazenamento + "\n" +"\nData de Arquivamento: " + dataArquivamento + "\n" +"\nLocal de Armazenamento: " + localCompletoDeArmazenamento + "\n" +
                "\nDescrição: " + descriçãoDocumento;
    }*/


}
