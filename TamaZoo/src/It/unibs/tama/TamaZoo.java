package It.unibs.tama;
import java.util.ArrayList;
import MyClass.MyVarie;
/*
 * errore nel nominamento dei tamagochi numero sbagliato.
 */

public class TamaZoo {
	private final static int N_SPECIE = 3;;
	private ArrayList<Tamagochi> tamaZoo=new ArrayList<Tamagochi>();
	private final static int MAX_PREMIO=8, MIN_PREMIO=1;
	private int nEsemplari;
	
	public TamaZoo(int nTama){
		int nTamagochi=0, nTriste=0, nGordo=0;
		nEsemplari=nTama;
		
		for(int i=0; i<nTama; i++){
			int scelta=MyVarie.interoCasuale(N_SPECIE, 1);
			
			switch(scelta){
				//inserimento TamaBase
				case 1:
					Tamagochi tama= new Tamagochi();
					tamaZoo.add(tama);
					nTamagochi++;
					tama.setNome(nTamagochi);
					break;
				//inserimento TamaTriste
				case 2: 
					TamaTriste tamaT= new TamaTriste();
					tamaZoo.add(tamaT);
					nTriste++;
					tamaT.setNome(nTriste);
					break;
				//inserimento TamaGordo
				case 3:
					TamaGordo tamaG= new TamaGordo();
					tamaZoo.add(tamaG);
					nGordo++;
					tamaG.setNome(nGordo);
					break;
			}
		}
	}
	
	public void distribuisciBiscotti(){
		int biscotti=MyVarie.interoCasuale(MAX_PREMIO, MIN_PREMIO);
		
		for(int i=0; i<tamaZoo.size(); i++){
			tamaZoo.get(i).riceviBiscotti(biscotti);
		}
	}
	
	public void distribuisciCarezze(){
		int carezze=MyVarie.interoCasuale(MAX_PREMIO, MIN_PREMIO);
		
		for(int i=0; i<tamaZoo.size(); i++){
			tamaZoo.get(i).riceviCarezze(carezze);
		}
	}
	
	public String controllaVita(){
		String nMorti="";
		
		for(int i=0; i<tamaZoo.size(); i++){			
			if(!tamaZoo.get(i).isInVita()){
				nMorti= nMorti+ "\n\t -" + tamaZoo.get(i).getNome() + " è morto!";
				tamaZoo.remove(i);
				i--;
				nEsemplari--;
			}
		}
		
		return nMorti;
	}
	
	public int getNEsemplari(){
		return nEsemplari;
	}
	
	public String toString(){
		String str="\nCondizioni dei Tamagochi ospitati allo Zoo: " + this.controllaVita();
		for(int i=0; i<tamaZoo.size(); i++) str= str + "\n -" + tamaZoo.get(i).toString();
		return str;
	}
	
	public void setNomi(String ...nomi){
		for(int i=0; i<tamaZoo.size(); i++){
			tamaZoo.get(i).setNome(nomi[i]);
		}
	}
}
