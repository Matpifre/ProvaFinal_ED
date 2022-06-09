
import javax.swing.JOptionPane;

public class Main {
	    
		public static void main(String[] args) {
            int opcao;

            do {
                opcao = Integer.parseInt(JOptionPane.showInputDialog(menu()));
                if(opcao < 1 || opcao > 5) 
                {
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                }
                else
                {
			
			        switch(opcao) {
						case 1:
							Util.cadastrarProduto();
							break;
						case 2:
							Util.pesquisarProduto();
							break;
						case 3:
							Util.listarProduto();
							break;
						case 4:
							Util.removerProduto();
							break;
			        	
			        }
			    } 
			}while(opcao!=5);
		}
				
		public static String menu() {

            String aux = "Escolha uma opção:\n";
            aux += "1. Cadastrar produto\n";
            aux += "2. Pesquisar produto\n";
            aux += "3. Listar produtos\n";
            aux += "4. Remover produto\n";
            aux += "5. Encerrar aplicação\n";
            return aux;
		}
}

