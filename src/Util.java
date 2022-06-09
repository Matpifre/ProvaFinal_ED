import javax.swing.JOptionPane;

public class Util {
	    
	    static ArvoreBinaria arvore = new ArvoreBinaria();

	    public static void cadastrarProduto() {
	        
	        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Codigo do produto: "));

	        if(arvore.pesquisar(codigo) == null){
	            String nome = JOptionPane.showInputDialog("Nome do produto: ");
	            double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor do produto: "));
	            if (valor > 0)
                {
	                int estoque = Integer.parseInt(JOptionPane.showInputDialog("Quantidade do produto em estoque: "));
	                if(estoque >= 0)
                    {
	                    Produto produto = new Produto(codigo, nome, estoque, valor);
	                    arvore.inserir(produto);
	                    JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!!");
	                
                    } 
                    else 
                    {
	                    JOptionPane.showMessageDialog(null, "A quantidade em estoque tem que ser MAIOR ou igual a 0");
	                }
	            } 
                else 
                {
	                JOptionPane.showMessageDialog(null, "O valor do produto deve ser MAIOR que 0");
	            }   
	        } 
            else 
            {
	            JOptionPane.showMessageDialog(null, "Produto já cadastrado no sistema!");
	        }
	    }

	    public static void pesquisarProduto() {
	        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Codigo do produto: "));

	        if(arvore.pesquisar(codigo) == null)
            {
	            JOptionPane.showMessageDialog(null, "Produto não cadastrado");
	        } 
            else 
            {
	            JOptionPane.showMessageDialog(null, "Produto:\n\n"+arvore.pesquisar(codigo).produto);
	        }
	    }

	    public static void listarProduto() 
        {
	        arvore.Listagem();
	        JOptionPane.showMessageDialog(null, "Produtos:\n\n"+arvore.dados);
	    }

	    public static void removerProduto() {
	        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Código do produto: "));

	        if(arvore.pesquisar(codigo) == null){
	            JOptionPane.showMessageDialog(null, "Produto não cadastrado");
	        } 
            else 
            {
	            arvore.remover(codigo);
	            JOptionPane.showMessageDialog(null, "Remoção realizada!!");
	        }

	    }

	    
	}