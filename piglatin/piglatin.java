import java.util.Scanner;
import java.util.StringTokenizer;

class piglatin {
    
    public static void ApplyPL(String phrase){
        StringBuffer aux = new StringBuffer();
        String token;

        StringTokenizer st = new StringTokenizer(phrase);
        while (st.hasMoreTokens()) {

            token = st.nextToken();
            //System.out.println(token);

            aux.append(token.substring(1));
            aux.append(token.substring(0, 1));
            aux.append("ay");

            if(st.hasMoreTokens()){
                aux.append(" ");
            }
        }

        System.out.println(aux);
    }

    public static void main(String[] args) {

        System.out.println("Bem vindo ao codificador Pig Latin, insira uma palavra ou frase:");
        
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        ApplyPL(input);

        scan.close();
    }
}