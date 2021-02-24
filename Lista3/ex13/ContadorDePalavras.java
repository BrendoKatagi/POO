package ex13;

import java.util.ArrayList;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

public class ContadorDePalavras extends ListaDePalavras {
    private ArrayList<String> indice = new ArrayList<>();   
    private ArrayList<AtomicInteger> contador = new ArrayList<>();
    String compare;

    @Override
    public void adiciona(String palavras) {
        StringTokenizer st = new StringTokenizer(palavras);
        while(st.hasMoreTokens()){
            String word = st.nextToken();

            if(!existe(word)){
                super.setPalavra(word);
                indice.add(word);   //lista com as palavras sem mudar a ordem
                contador.add(new AtomicInteger(0)); //lista com o contador das palavras

            }else  {
                int i = indice.indexOf(word);
                contador.get(i).getAndIncrement();

            }
        }

    }
    
    public int contaPalavra(String x){ //Retorna quantas vezes a palavra repete
        int count = 0;

        if(existe(x)){

            int i = indice.indexOf(x);
            count = contador.get(i).intValue();

        }
        return count;
    }

    public static void main(String[] args) {
        String palavras = "teste de código teste";
        ContadorDePalavras l1 = new ContadorDePalavras();
        int contador = 0;

        l1.adiciona(palavras);

        if(l1.existe("de")){
            System.out.println("a palavra 'de' Existe");
        }

        if(l1.existe("não")){
            System.out.println("Existe");
        }
            
        contador = l1.contaPalavra("teste");
        System.out.println("\nA palavra 'teste' foi armazenada " + contador + " vezes!");

        contador = l1.contaPalavra("código");
        System.out.println("A palavra 'código' foi armazenada " + contador + " vezes!");

        contador = l1.contaPalavra("não");
        System.out.println("A palavra 'não' foi armazenada " + contador + " vezes!");
    }

    
}
