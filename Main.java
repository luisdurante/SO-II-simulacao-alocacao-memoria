class Main {

  public static void main(String[] args) {
    Processo[] processos = new Processo[2];
    int[] memoria = new int[20];
    processos[0] = new Processo("Firefox", 10, 3);
    processos[1] = new Processo("Chrome", 15, 6);
    int indiceProcessoDaFila = 0;
    while(indiceProcessoDaFila >= 0) {

      indiceProcessoDaFila = getIndiceMaisRecenteDaFilaDeProcessos(processos);
      System.out.println(indiceProcessoDaFila);
      break;
    }
   
  }

  public static int getIndiceMaisRecenteDaFilaDeProcessos(Processo[] processos) {
    boolean processoExecutando = false;
    for(int i = 0; i < processos.length; i++) {
      if(processos[i].getStatus() == 'P') {
        return i;
      }

      if(processos[i].getStatus() == 'E') {
        processoExecutando = true;
      }
    }

    if (processoExecutando) {
      return -1;
    }

    return -2;
  }

}
