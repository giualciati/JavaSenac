
public class Ex_Fila_02 {
    static final int TAMANHO_MAXIMO = 100;

    
    public static class Queue {
        int itens[] = new int[100];
        int front, rear;
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.front = 0;
        q.rear = 0;
        System.out.println("Valor " + enqueue(q, 1) + " inserido na fila");
        System.out.println("Valor " + enqueue(q, 2) + " inserido na fila");
        System.out.println("Valor " + enqueue(q, 3) + " inserido na fila");
        System.out.println("Valor " + enqueue(q, 4) + " inserido na fila\n");
        System.out.println("Fila com " + (size(q) - 1) + " itens\n");
        System.out.println("Proximo valor da fila " + front(q));
        System.out.println("Tirando o valor " + dequeue(q) + " da fila ...\n");
        System.out.println("Proximo valor da fila " + front(q));
        System.out.println("Tirando o valor " + dequeue(q) + " da fila ...\n");
        System.out.println("Proximo valor da fila " + front(q));
        System.out.println("Tirando o valor " + dequeue(q) + " da fila ...\n");
        System.out.println("Proximo valor da fila " + front(q));
        System.out.println("Tirando o valor " + dequeue(q) + " da fila ...\n");
        System.out.println("Fila vazia, fila com " + (empty(q) - 1) + " itens\n");
    }


    static int empty(Queue pq) {
        /*
         * se o início da fila for igual ao final da fila,
         * a fila está vazia
         */
        if (pq.front == pq.rear) {
            return 1;
        }
        return 0;
    }

    static int enqueue(Queue pq, int x) {
        if (pq.rear + 1 >= TAMANHO_MAXIMO) {
            System.out.println("\nEstouro da capacidade da fila");
        }
        pq.itens[pq.rear++] = x;
        return x;
    }

    static int size(Queue pq) {
        return (pq.rear + 1);
    }

    static int front(Queue pq) {
        /* o primeiro elemento sempre está no início do vetor */
        return pq.itens[0];
    }

    static int dequeue(Queue pq) {
        int x, i;
        if (empty(pq) == 1) {
            System.out.println("\nFila vazia");
        }
        /*
         * Salva o primeiro elemento e refaz o arranjo dos itens,
         * puxando o segundo elemento para o primeiro, o terceiro
         * para o segundo e assim sucessivamente.
         */
        x = pq.itens[0];
        for (i = 0; i < pq.rear; i++) {
            pq.itens[i] = pq.itens[i + 1];
        }
        pq.rear--;
        return x;
    }
}
