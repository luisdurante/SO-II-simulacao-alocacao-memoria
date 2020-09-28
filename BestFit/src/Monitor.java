

class Monitor extends Thread{
  private Processo[] processos;
  private int[] memoria;
  private RegistradorLogger logger;
  
  public Monitor(Processo[] processos, int[] memoria, RegistradorLogger logger) {
	  this.memoria = memoria;
	  this.processos = processos;
	  this.logger = logger;
  }
  
  @Override
  public void run() {
    while(true) {
      System.out.print("");
      if (this.logger.isBusy()) {
    	  continue;
      }
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
        //System.out.println("Desalocando processo " + i);
        processos[i].finalizar();
        desalocaDaMem(memoria, processos[i]);
      }
    }


  }

  private void desalocaDaMem(int[] memoria, Processo processo) {
    int j = 0; 
    for (int i = processo.getEnderecoMem(); j < processo.getTamanho() ; i++) {
      memoria[i] = -1;
      j++;
    }
  }


}