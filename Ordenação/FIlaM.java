package Ordenação;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class FilaM {
    int tamanho;

    int inicio;

    int fim;

    int total;

    Object vetor[];

    public FilaM(int tam) {

        inicio = 0;

        fim = 0;
    
        total = 0;

        tamanho = tam;

        vetor = new Object[tam];

    }

    public boolean vazia () {

        if (total == 0)

            return true;

        else

            return false;

    }

    public boolean cheia () {

        if (total >= tamanho)

            return true;

        else

            return false;

    }

    public void enfileirar(Integer x,String y,byte[] z) {

        if ( !cheia())

            { vetor[fim] =x+" / "+y+" / "+z;

                fim++;

                total++;

        if (fim >= tamanho)

            fim = 0;

        }

        else

            { System.out.println("Fila Cheia");

        }

    }

    public Object desenfileirar()

        { Object excluido;

        { if (vazia() == false)

            {excluido = vetor[inicio];

            inicio++;

        if (inicio >= tamanho)

            inicio = 0;

            return excluido;

        } else

            { excluido = null;

            return excluido;

        }

        }

    }

    public void exibeFila(){

        JFrame lista = new JFrame();
        lista.setSize(480, 300);
        lista.setResizable(false);
        lista.setTitle("Ordenação por fila");
        lista.setLocation(0, 400);
        JPanel tela = new JPanel();
        tela.setSize(150,150);
        //tela.setBackground(Color.red);       
        JTable resultado = new JTable();
        resultado.setSize(100, 100);
        DefaultTableModel modelo1 = (DefaultTableModel) resultado.getModel();
        resultado.setRowSorter(new TableRowSorter (modelo1));
        modelo1.setNumRows(0);   
        modelo1.addColumn(resultado);
        for(int i = inicio; i < total; i++){
            //System.out.println("Elemento " + vetor[i] + " posicao " + i);
            String x = vetor[i].toString();
            modelo1.addRow(new Object[]{x});
        }
        JScrollPane barraRolagem = new JScrollPane(resultado);
        tela.add(barraRolagem);  
        lista.add(tela);
        
        lista.show();

    }
}
