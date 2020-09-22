import java.util.Random;

class Main {

  public static void main(String[] args) {
    Random rand = new Random();
    Processo[] processos = new Processo[200];
    int i;
    for (i = 0; i < processos.length; i++ ){
        processos[i] = new Processo(i, rand.nextInt(100), rand.nextInt(20));
        
    }
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
