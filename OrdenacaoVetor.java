package packegeOrdenação;



/**
 *
 * @author renat
 */
import java.util.Arrays;
import javax.swing.JOptionPane;

public class OrdenacaoVetor {

    public static void main(String[] args) {
       
        int opcao = exibirMenu();
        int[]ordenacao = tamVetor();
        long  tempoInicial, tempoFinal;
         int[] original = ordenacao;
      
    
        switch(opcao){
        
            case 1:
                ordenacaoInsercao(ordenacao);
             
                exibirResultados(ordenacao,"Ordenação por Seleção",original);
                   
          
                break;
            case 2: 
                
                ordenacaoSelecao(ordenacao);
                exibirResultados(ordenacao,"Ordenação por Inserção",original);
          
               
          
              
              
            case 3:
              
                ordenacaoBolha(ordenacao);
                exibirResultados(ordenacao,"Ordenação Bolha",original);
              
               
          
              
            
                break;

            default:
                JOptionPane.showMessageDialog(null,"Opção invalida !");
                break;
        }
    }
    public static int exibirMenu(){
    
        String[]opcoes = {"Ordenação por Inserção","Ordenação por Seleção","Ordenação Bolha"};
        int opcao = JOptionPane.showOptionDialog(null,"Selecione um modelo de Ordenação:","Menu",JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,opcoes, opcoes[0]);
        return opcao + 1;
    
    }
    public static int[] tamVetor(){

    int n =  Integer.parseInt(JOptionPane.showInputDialog("Informe o tamanho do vetor:"));
    int[] ordenacao = new int[n];
    
    for(int i = 0; i < n; i++) {
        ordenacao[i] = Integer.parseInt(JOptionPane.showInputDialog("Informe o "+(i + 1)+"º elemento do vetor: "));
        
    }
    return ordenacao;
    }
    public static void ordenacaoInsercao(int[] ordenacao) {
        long tempoInicial1 = System.nanoTime();
               
      
        for(int i=1; i<ordenacao.length; i++) {
            int aux = ordenacao[i];
            int j = i - 1;
            while(j>=0 && ordenacao[j]>aux) {
                ordenacao[j+1] = ordenacao[j];
                j--;
            }
            ordenacao[j+1] = aux;
            
        }
        long tempoFinal1 = System.nanoTime();
         long temp1 = tempoInicial1 - tempoFinal1;
           JOptionPane.showMessageDialog(null,"Tempo De Execução: "+ temp1);
    }
    
    public static void ordenacaoSelecao(int[] ordenacao) {
        long tempoInicial2 = System.nanoTime();
               
   
        for(int i=0; i<ordenacao.length-1; i++) {
            int minIndex = i;
            for(int j=i+1; j<ordenacao.length; j++) {
                if(ordenacao[j] < ordenacao[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = ordenacao[minIndex];
            ordenacao[minIndex] = ordenacao[i];
            ordenacao[i] = temp;
        }
        
               
        long tempoFinal2 = System.nanoTime();
       long temp2 = tempoInicial2 - tempoFinal2;
       JOptionPane.showMessageDialog(null, temp2);
    }
    
    public static void ordenacaoBolha(int[] ordenacao) {
        long tempoInicial3 = System.nanoTime();
               
   
        for(int i=0; i<ordenacao.length-1; i++) {
            for(int j=0; j<ordenacao.length-i-1; j++) {
                if(ordenacao[j] > ordenacao[j+1]) {
                    int temp = ordenacao[j];
                    ordenacao[j] = ordenacao[j+1];
                    ordenacao[j+1] = temp;
                }
            }
        }

               
     long  tempoFinal3 = System.nanoTime();
       long temp3 = tempoInicial3 - tempoFinal3;
         JOptionPane.showMessageDialog(null,"Tempo De Execução: "+ temp3);
         
    }
    
  
   
public static void compararResultados(int[] ordenacao, int[] OrdenadoInsercao, int[] OrdenadoSelecao, int[] OrdenadoBolha) {
    String compara = "Vetor Original: " +Arrays.toString(ordenacao) +
                      "\n\nVetor Ordenado por Inserção:   " + Arrays.toString(OrdenadoInsercao) +
                      "\nVetor Ordenado por Seleção:    " + Arrays.toString(OrdenadoSelecao) +
                      "\nVetor Ordenado por Bolha:      " + Arrays.toString(OrdenadoBolha);
    JOptionPane.showMessageDialog(null, compara, "Comparação de Resultados", JOptionPane.INFORMATION_MESSAGE);
     
}
public static void exibirResultados(int[] ordenacao, String metodo,int[] original) {
    String mensagem = "Método utilizado: " + metodo + "\n\n" +
                      "Vetor original: " + Arrays.toString(original) + "\n\n" +
                      "Vetor ordenado: " + Arrays.toString(ordenacao) + "\n\n" 
                     ;
    JOptionPane.showMessageDialog(null, mensagem);

 
}

}

