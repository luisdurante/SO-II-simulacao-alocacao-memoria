class Main {

  public static void main(String[] args) {
    Processo[] processos = new Processo[2];
    processos[0] = new Processo("Firefox", 2, 3);
    processos[1] = new Processo("Chrome", 2, 6);
    int[] memoria = new int[10];
    preencheMemoria(memoria);
    printMem(memoria);
    System.out.println("\n\n\n\n");
    memoria[1] = 80;
    memoria[5] = 80;
    memoria[8] = 80;
    memoria[9] = 80;

    Alocador a = new Alocador();
    a.run(processos, memoria);
    printMem(memoria);
    System.out.println("\n\n\n\n");
    Monitor m = new Monitor();
    m.run(processos, memoria);

    printMem(memoria);
    
  }

  public static void preencheMemoria(int[] memoria){
    for(int i = 0; i < memoria.length ; i++) {
      memoria[i] = -1;
    }
  }

  public static void printMem(int[] memoria){
    for (int i = 0; i < memoria.length ; i++) {
      System.out.println(memoria[i]);
    }
  }
 
}
