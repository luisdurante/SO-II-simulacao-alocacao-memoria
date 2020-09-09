class Processo {
  private String nome;
  private int tamanho;
  private int qtUnidadesDeTempo;
  //P = Parado, E = Executando, F = Finalizado
  private char status = 'P';
  private int enderecoMemX;
  private int enderecoMemY;

  public Processo(String nome, int tamanho, int qtUnidadesDeTempo) {
    this.nome = nome;
    this.tamanho = tamanho;
    this.qtUnidadesDeTempo = qtUnidadesDeTempo;
  }


  public void diminuirUnidadeDeTempo(){
    this.qtUnidadesDeTempo = this.qtUnidadesDeTempo-- > 0 ? this.qtUnidadesDeTempo-- : 0;
  }

  public void executar(int enderecoX, int enderecoY) {
    this.status = 'E';
    this.anexarEnderecoDeMemoria(enderecoX, enderecoY);
  }

  private void anexarEnderecoDeMemoria(int enderecoX, int enderecoY) {
    this.enderecoMemX = enderecoX;
    this.enderecoMemY = enderecoY;
  }

  public void finalizar() {
    this.status = 'F';
  }

  public int getEnderecoMemX() {
    return this.enderecoMemX;
  }

  public int getEnderecoMemY() {
    return this.enderecoMemY;
  }

  public char getStatus() {
    return this.status;
  }

  public void teste(){
    System.out.println(this.nome + " " + this.tamanho + " " + this.qtUnidadesDeTempo + " "  + this.status + " " + this.enderecoMemX);
  }
}

class Escalonador {

}

class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    Processo p = new Processo("Firefox", 10, 3);
    p.teste();
    p.diminuirUnidadeDeTempo();
    p.teste();
    p.executar(10,12);
    p.diminuirUnidadeDeTempo();
    p.teste();
    p.diminuirUnidadeDeTempo();
    p.teste();
    p.diminuirUnidadeDeTempo();
    p.teste();
    p.diminuirUnidadeDeTempo();
  }
}

