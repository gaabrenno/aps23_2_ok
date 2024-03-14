
package Ordenação;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

 public class PilhaM {

    int tamanho;

    int topo;

    Object vetor[];
    

    public PilhaM(int tam) {

        topo = -1;

        tamanho = tam;

        vetor = new Object[tam];
        

        
    }

    public boolean vazia ()

        {if (topo == -1)

            return true;

        else

            return false;

    }

    public boolean cheia ()

        {if (topo >= tamanho)

            return true;

        else

            return false;

    }
    public void empilhar(Integer x,String y,byte[] z)

        {if ( !cheia( ) )

            {topo++;            
        
            vetor[topo]=  x+" / "+y+" / "+z;
            
            

        }

        else

            {System.out.println("Pilha Cheia");

            }

        }

    public Object desempilhar()

        {Object valorDesempilhado;

        if ( vazia( ) == true )

            { System.out.print("Pilha Vazia");

            valorDesempilhado = null;

            return valorDesempilhado;

        }

        else

            { valorDesempilhado = vetor[topo];

            topo--;

            return valorDesempilhado;

        }

    }

    public void exibePilha(){
        JFrame lista = new JFrame();
        lista.setSize(480, 300);
        lista.setResizable(false);
        lista.setTitle("Ordenação por Pilha");
        JPanel tela = new JPanel();
        tela.setSize(150,150);
        //tela.setBackground(Color.red);       
        JTable resultado = new JTable();
        resultado.setSize(100, 100);
        DefaultTableModel modelo1 = (DefaultTableModel) resultado.getModel();
        resultado.setRowSorter(new TableRowSorter (modelo1));
        modelo1.setNumRows(0);   
        modelo1.addColumn(resultado);
        for(int i = topo; i >= 0; i--){
            //System.out.println("Elemento " + vetor[i] + " posicao " + i);
            String x = vetor[i].toString();
            modelo1.addRow(new Object[]{x});
        }
        JScrollPane barraRolagem = new JScrollPane(resultado);
        tela.add(barraRolagem);  
        lista.add(tela);
        
        lista.show();
        //for(int i = topo; i >= 0; i--)

            //System.out.println("Elemento " + vetor[i] + " posicao " + i);
            

    }

}
