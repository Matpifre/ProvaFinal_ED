public class ArvoreBinaria {
    
	private No raiz; 
    String dados;
	
	//Método iserção na arvore
	public void inserir(Produto produto) {
		if(raiz == null) {
			raiz = new No(produto);
		} else {
			raiz.inserirNo(produto);
		}
	}

    //Métodos Pesquisar
    public No pesquisar(int id) {
        No aux = pesquisarProduto(id, this.raiz);
        return aux;
    }

    private No pesquisarProduto(int id, No raiz){
        if(raiz == null){
            return null;
        }
        if(id == raiz.produto.getCodigo()){
            return raiz;
        }
        
        if(id > raiz.produto.getCodigo()){
            return pesquisarProduto(id, raiz.dir);   
        } else {    
            return pesquisarProduto(id, raiz.esq);
        }
    }

    //Métodos Listagem
    public void Listagem() {
        this.dados = "";
		listarEmOrdemRecursivo(raiz);
	}

	private void listarEmOrdemRecursivo(No raiz) {
		if(raiz == null) 
        {
			return;
		}
		
		listarEmOrdemRecursivo(raiz.esq);
        this.dados = this.dados + raiz.produto;
		listarEmOrdemRecursivo(raiz.dir);
	}

    //Métodos remoção
    public void remover(int id) { 
       removerProduto(id, this.raiz);
    }

    private No removerProduto(int id, No raiz) {
        
        if (raiz == null) 
        {
            return raiz;
        }

        
        if (id < raiz.produto.getCodigo()) 
        {
            raiz.esq = removerProduto(id, raiz.esq);
        } 
            else if (id > raiz.produto.getCodigo()) 
            {
            raiz.dir = removerProduto(id, raiz.dir);
        
            } 
                else 
                { 
                    if (raiz.esq == null && raiz.dir == null) {
                    
                    if(raiz.produto.getCodigo() == this.raiz.produto.getCodigo())
                    {
                        this.raiz = null;
                    }
                    raiz = null;
                    return null;
                } 
                else if (raiz.esq == null || raiz.dir == null) 
                { 
                    No filho = (raiz.esq != null) ? raiz.esq : raiz.dir;
                    
                    if(raiz.pai != null) { 
                        filho.pai = raiz.pai;
                    } else {
                        filho.pai = null;
                    }

                
                    if(raiz.produto.getCodigo() == this.raiz.produto.getCodigo())
                    {
                    this.raiz = filho;
                    }
                
                    raiz = null;
                    raiz = filho;

                } 
                else 
                { 
                    No maiorValorEsq = EsqMaior(raiz.esq);
                
                
                    if(maiorValorEsq.pai.dir == maiorValorEsq) 
                    {
                        maiorValorEsq.pai.dir = null;
                        if(maiorValorEsq.esq != null) 
                        {
                            maiorValorEsq.pai.dir = maiorValorEsq.esq;
                            maiorValorEsq.esq.pai = maiorValorEsq.pai;
                        }
                        maiorValorEsq.esq = raiz.esq;
                        maiorValorEsq.dir = raiz.dir;
                    } 
                    else if (raiz.esq == maiorValorEsq) 
                    {
                        maiorValorEsq.pai.esq = null;
                        maiorValorEsq.dir = raiz.dir;
                        if(maiorValorEsq.esq != null) 
                        {
                            maiorValorEsq.pai.dir = maiorValorEsq.esq;
                            maiorValorEsq.esq.pai = maiorValorEsq.pai;
                        }
                    }
                
                    if (raiz.pai != null) 
                    {
                        if(raiz == raiz.pai.esq) 
                        {
                            raiz.pai.esq = maiorValorEsq;
                        } else 
                        {
                            raiz.pai.dir = maiorValorEsq;
                        }
                        maiorValorEsq.pai = raiz.pai;
                    } 
                    else 
                    {
                        maiorValorEsq.pai = null;
                    }

                    if (raiz.dir != null) 
                    {
                        raiz.dir.pai = maiorValorEsq;
                    }
                    
                    if (raiz.esq != null) 
                    {
                        raiz.esq.pai = maiorValorEsq;
                    }
                    
                   
                    if(raiz.produto.getCodigo() == this.raiz.produto.getCodigo())
                    {
                        this.raiz = maiorValorEsq;
                    }

                    raiz = null;
                    raiz = maiorValorEsq;
            
                }
        }
        return raiz;
    }
    private No EsqMaior(No raiz) {
        while (raiz.dir != null) {
            raiz = raiz.dir;
        }
    
        return raiz;
    }

   
}