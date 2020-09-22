class Processo {
  private int id;
  private int tamanho;
  private int qtUnidadesDeTempo;
  //P = Parado, E = Executando, F = Finalizado
  private char status = 'P';
  private int enderecoMem;

  public Processo(int id, int tamanho, int qtUnidadesDeTempo) {
    this.id = id;
    this.tamanho = tamanho;
    this.qtUnidadesDeTempo = qtUnidadesDeTempo;
  }


  public void diminuirUnidadeDeTempo(){
    this.qtUnidadesDeTempo = this.qtUnidadesDeTempo - 1 > 0 ? this.qtUnidadesDeTempo - 1 : 0;
  }

  public void executar(int endereco) {
    this.status = 'E';
    this.anexarEnderecoDeMemoria(endereco);
  }

  private void anexarEnderecoDeMemoria(int endereco) {
    this.enderecoMem = endereco;
  }

  public void finalizar() {
    this.status = 'F';
  }

  public int getQtUnidadesDeTempo() {
    return this.qtUnidadesDeTempo;
  }

  public int getEnderecoMem() {
    return this.enderecoMem;
  }

   public int getTamanho() {
    return this.tamanho;
  }

  public char getStatus() {
    return this.status;
  }

  public void teste(){
    System.out.println(this.nome + " " + this.tamanho + " " + this.qtUnidadesDeTempo + " "  + this.status + " " + this.enderecoMem);
  }
}
