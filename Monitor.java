class Monitor {
  public void run(Processo[] processos, int[] memoria) {
    while(true) {
      if (!temProcessosNaMemOuParados(processos)) {
        break;
      }

      varrerMemDecrementandoTempo(memoria, processos);

    }
    
  }


  private boolean temProcessosNaMemOuParados(Processo[] processos) {
    for(int i = 0; i < processos.length; i++) {
      if(processos[i].getStatus() != 'F') {
        return true;
      }
    }
    return false;
  }

  private void varrerMemDecrementandoTempo(int[] memoria, Processo[] processos) {

    for (int i = 0; i < processos.length; i++) {
      if (processos[i].getStatus() !=  'E') {
        continue;
      }

      processos[i].diminuirUnidadeDeTempo();

      if (processos[i].getQtUnidadesDeTempo() == 0) {
        processos[i].finalizar();
        desalocaDaMem(memoria, processos[i]);
      }
    }


  }

  private void desalocaDaMem(int[] memoria, Processo processo) {
    int enderecoFinal = processo.getEnderecoMem() + processo.getTamanho();
    int j = 0; 
    for (int i = processo.getEnderecoMem(); j < processo.getTamanho() ; i++) {
      memoria[i] = -1;
      j++;
    }
  }


}
