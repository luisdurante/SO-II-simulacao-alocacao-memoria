class Alocador {
  

  public void run(Processo[] processos, int[] memoria) {
    while(true) {
      int indexRecenteFila = getIndiceMaisRecenteDaFilaDeProcessos(processos);
      if (indexRecenteFila < 0) {
        break;
      }

      int espacoParaAlocar = getMelhorEspacoMemoria(processos[indexRecenteFila], memoria);

      if(espacoParaAlocar != -1) {
        processos[indexRecenteFila].executar(espacoParaAlocar);
        alocaProcessoMemoria(memoria, processos[indexRecenteFila], indexRecenteFila);
      }
    }
    
  }


  private int getIndiceMaisRecenteDaFilaDeProcessos(Processo[] processos) {
    for(int i = 0; i < processos.length; i++) {
      if(processos[i].getStatus() == 'P') {
        return i;
      }
    }
    return -1;
  }

  private int getMelhorEspacoMemoria(Processo processo, int[] memoria) {
   int indiceMelhorEspaco = 0;
    int tamanhoMelhorEspaco = memoria.length;
    int i;

    if (processo.getTamanho() > memoria.length) {
      return -1;
    }

    for (i = 0; i < memoria.length; i++) {
      if (memoria[i] < 0) {
        int j = 0;
        for (j = i; j < memoria.length; j++) {
          if (memoria[j] != -1) {
            break;
          }
        }
        int tamanhoAtual = j - i;
        if (processo.getTamanho() <= tamanhoAtual && tamanhoAtual < tamanhoMelhorEspaco) {
          tamanhoMelhorEspaco = tamanhoAtual;
          indiceMelhorEspaco = i;
        }
        i = j;
      }
    }


    if (indiceMelhorEspaco == 0) {
      for (int _i = 0; _i < processo.getTamanho(); _i++) {
        if (memoria[_i] != -1) {
          return -1;
        }
      }
    }

    return indiceMelhorEspaco;
  }

  private void alocaProcessoMemoria(int[] memoria, Processo processo, int indexFilaProcesso) {
    int indexInicial = processo.getEnderecoMem();
    for (int _i = 0; _i < processo.getTamanho(); _i++) {
      memoria[indexInicial++] = indexFilaProcesso;
    }
  }

}
