public class Ex_Fila_03 {

    public static void main(String[] args) {
        FilaInteiro fila = new FilaInteiro(10);
        
        fila.enqueue(10);
        fila.ExibirFila(); 
        
        fila.dequeue();
        fila.ExibirFila();
        
        fila.enqueue(103);
        fila.ExibirFila();
        
        fila.enqueue(120);
        fila.ExibirFila();
        
        fila.enqueue(150);
        fila.ExibirFila();
        
        fila.dequeue(); // SAI O 103
        fila.enqueue(110);
        fila.ExibirFila();
    }
}

class FilaInteiro {
    private int[] vetorEstrutura;
    private int quantidade;
    private int inicio;
    private int fim;

    public FilaInteiro(int tamanhoFila) {
        vetorEstrutura = new int[tamanhoFila];
        quantidade = 0;
        inicio = 0;
        fim = -1;
    }

    public void enqueue(int value) {
        if (!isFull()) {
            fim++;
            vetorEstrutura[fim] = value;
            quantidade++;
        } else {
            System.out.println("Fila Cheia!");
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Fila Vazia!");
            return -1;
        } 
        int valorRetorno = vetorEstrutura[inicio];
        inicio++;
        quantidade--;

        // Resetar indices se a fila estiver vazia
        if (quantidade == 0) {
            inicio = 0;
            fim = -1;
        }
        return valorRetorno;
    }

    public boolean isEmpty() {
        return quantidade == 0;
    }

    public boolean isFull() {
        return fim == vetorEstrutura.length - 1;
    }

    public int size() {
        return quantidade;
    }

    public void ExibirFila() {
        if (!isEmpty()) {
            for (int i = inicio; i <= fim; i++) {
                System.out.print(vetorEstrutura[i] + " ");
            }
        } else {
            System.out.println("\nFila vazia!");
        }
        System.out.println("");
    }
}
