class Processo {
  private String nome;
  private int tamanho;
  private int qtUnidadesDeTempo;
  //P = Parado, E = Executando, F = Finalizado
  private char status = 'P';
  private int enderecoMem;

  public Processo(String nome, int tamanho, int qtUnidadesDeTempo) {
    this.nome = nome;
    this.tamanho = tamanho;
    this.qtUnidadesDeTempo = qtUnidadesDeTempo;
  }


  public void diminuirUnidadeDeTempo(){
    this.qtUnidadesDeTempo = this.qtUnidadesDeTempo-- > 0 ? this.qtUnidadesDeTempo-- : 0;
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

  public int getEnderecoMemX() {
    return this.enderecoMem;
  }

  public char getStatus() {
    return this.status;
  }

  public void teste(){
    System.out.println(this.nome + " " + this.tamanho + " " + this.qtUnidadesDeTempo + " "  + this.status + " " + this.enderecoMem);
  }
}
