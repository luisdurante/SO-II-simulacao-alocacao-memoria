import java.util.Arrays;

public class RegistradorLogger {
	public int vezesQueFragmentou = 0;
	private boolean isBusy = false;
	private int[] nivelDeMultiprog = new int[1024];
	private int[] nivelDeFrag = new int[1024];
	
	public void turnOn() {
		this.isBusy = true;
	}
	
	public void turnOff() {
		this.isBusy = false;
	}
	
	public boolean isBusy() {
		return this.isBusy;
	}
	
	private void addNivelDeMultiprogEfrag(Processo[] processos) {
		int qtMultiprog = 0;
		int qtFrag = 0;
		for (int i = 0; i < processos.length; i++) {
			if(processos[i].getStatus() == 'E') {
				qtMultiprog++;
				qtFrag += processos[i].getTamanho();
			}
		}
		this.nivelDeMultiprog[this.vezesQueFragmentou] = qtMultiprog;
		this.nivelDeFrag[this.vezesQueFragmentou] = 1024 - qtFrag;
	}
	
	public void work(int[] memoria, Processo processo, Processo[] processos) {
		this.turnOn();
		addNivelDeMultiprogEfrag(processos);
		this.vezesQueFragmentou++;
		printaMem(memoria, processo);
		this.turnOff();
	}
	
	public void printaMem(int[] memoria, Processo processo) {
	  int index = 0;
      System.out.println("Fragmentação! nº do processo: " + processo.getNome() + " Tamanho: " + processo.getTamanho());
	  System.out.print('+');
	  for (int x = 0; x < 162 ; x++) {
		  System.out.print('-');		  
	  }
	  System.out.print('+');
	  System.out.println("");
	  for (int i = 0; i < 32; i++) {
		  System.out.print("| ");
		  for (int j = 0; j < 32; j++) {
			  System.out.format("[%3d]", memoria[index]);
			  index++;
		  }
		  System.out.print(" |");
		  System.out.println("");
	  }
	  System.out.print('+');
	  for (int x = 0; x < 162 ; x++) {
		  System.out.print('-');		  
	  }
	  System.out.print("+\n");
	}

	public void gerarLogFinal() {
		int menorFrag = this.nivelDeFrag[0];
		int maiorFrag = this.nivelDeFrag[0];
		int menorMulti = this.nivelDeMultiprog[0];
		int maiorMulti = this.nivelDeMultiprog[0];
		int[] _frag = new  int[this.vezesQueFragmentou];
		int[] _multi = new  int[this.vezesQueFragmentou];
		
		preencherFragEMulti(_frag, _multi);
		
		Arrays.sort(_frag);
		Arrays.sort(_multi);
		int medMulti;
		int medFrag;
		if(this.vezesQueFragmentou == 0 || this.vezesQueFragmentou == 1) {
			medMulti = _multi[0];
			medFrag = _frag[0];
		} else if (this.vezesQueFragmentou % 2 == 0) {
			medMulti = _multi[this.vezesQueFragmentou / 2 - 1];
			medFrag = _frag[this.vezesQueFragmentou / 2 - 1];
		} else {
			int med = (int)this.vezesQueFragmentou / 2;
			medMulti = _multi[med];
			medFrag = _frag[med];
		}
		
		System.out.println("Número de fragmentações: " + this.vezesQueFragmentou);
		for(int i=0; i < this.vezesQueFragmentou; i++) {
			if (this.nivelDeFrag[i] < menorFrag) {
				menorFrag = this.nivelDeFrag[i];
			}
			
			if (this.nivelDeFrag[i] > maiorFrag) {
				maiorFrag = this.nivelDeFrag[i];
			}
			
			if (this.nivelDeMultiprog[i] < menorMulti) {
				menorMulti = this.nivelDeMultiprog[i];
			}
			
			if (this.nivelDeMultiprog[i] > maiorMulti) {
				maiorMulti = this.nivelDeMultiprog[i];
			}
		}
		
		System.out.print('+');
		for(int i = 0; i < 41; i++) {
			System.out.print('-');
		}
		System.out.println('+');
		
		System.out.format("|      | Fragmentação | Multi Programação |\n");
		for (int i = 0; i < 3; i++) {
			if (i == 0) {
				System.out.format("| Min  |%13d | %17d |\n", menorFrag, menorMulti);				
			}
			
			if (i == 1) {
				System.out.format("| Med  |%13d | %17d |\n", medFrag, medMulti);				
			}
			
			if (i == 2) {
				System.out.format("| Max  |%13d | %17d |\n", maiorFrag, maiorMulti);				
			}
			
		}
		
		System.out.print('+');
		for(int i = 0; i < 41; i++) {
			System.out.print('-');
		}
		System.out.println('+');
	}
	
	private void preencherFragEMulti(int[] _frag, int[] _multi) {
		
		for (int i = 0; i < this.vezesQueFragmentou; i++) {
			_frag[i] = this.nivelDeFrag[i];
			_multi[i] = this.nivelDeMultiprog[i];
		}
	}

}
