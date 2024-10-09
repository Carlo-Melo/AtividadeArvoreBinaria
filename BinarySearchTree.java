public class BinarySearchTree {
    Node root;

    public BinarySearchTree(){
        this.root = null;
    }

    public void insert(int dado){
        this.root = insertRec(this.root, dado);
    }

    public Node insertRec(Node root, int dado){
        if(root == null){
            root = new Node(dado);
            int contador =+1;
            return  root;
        }
        if(dado < root.dado){
            root.left = insertRec(root.left, dado); //inseirir na subarvore a esquerda
        }
        if(dado > root.dado){
            root.right = insertRec(root.right, dado); // inserir na subarvore direita
        }
        return root;
    }

    public void inOrder(){
        inOrderRec(this.root);
    }

    private void inOrderRec(Node root){
        if(root != null){
            inOrderRec(root.left);
            System.out.print(root.dado+" ");
            inOrderRec(root.right);
        }
    }

    public void postOrder() {
        postOrderRec(this.root);
    }

    // pós-ordem
    private void postOrderRec(Node root) {
        if (root != null) {
            postOrderRec(root.left);   // Percorre a subárvore esquerda
            postOrderRec(root.right);  // Percorre a subárvore direita
            System.out.print(root.dado + " ");  // Visita o nó raiz
        }
    }

    public void preOrder() {
        preOrderRec(this.root);
    }

    // pré-ordem
    private void preOrderRec(Node root) {
        if (root != null) {
            System.out.print(root.dado + " ");  // Visita o nó raiz
            preOrderRec(root.left);  // Percorre a subárvore esquerda
            preOrderRec(root.right); // Percorre a subárvore direita

        }
    }

    public void delete(int dado){
        root = deleteRec(root, dado);
    }

    private Node deleteRec(Node root, int dado){
        if(root == null){
            return root;
        }
        if(dado < root.dado){
            root.left = deleteRec(root.left, dado);
        }
        if(dado > root.dado) {
            root.right = deleteRec(root.right, dado);
        }
        if(dado == root.dado){
            root = null;
        }
        return root;

    }

    public int contarNos(){
        return  contarNosRec(root);
    }

    private int contarNosRec(Node root){
        if(root ==  null){
            return 0;
        }
        return 1 + contarNosRec(root.left) + contarNosRec(root.right);
    }

    public int contarNosFolha() {
        return contarNosFolhaRec(root);
    }

    private int contarNosFolhaRec(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return contarNosFolhaRec(root.left) + contarNosFolhaRec(root.right);
    }

    public int contarNosNaoFolha(){
        return contarNosNaoFolhaRec(root);
    }

    private int contarNosNaoFolhaRec(Node root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 0;
        }
        return 1 + contarNosFolhaRec(root.left) + contarNosFolhaRec(root.right);
    }

    public int calcularGrau() {
        return calcularGrauRec(root);
    }

    private int calcularGrauRec(Node root) {
        if (root == null) {
            return 0;
        }
        int grauAtual = 0;
        if (root.left != null) {
            grauAtual++;
        }
        if (root.right != null) {
            grauAtual++;
        }
        int grauEsquerda = calcularGrauRec(root.left); //maximo a esquerda
        int grauDireita = calcularGrauRec(root.right);
        return Math.max(grauAtual, Math.max(grauEsquerda, grauDireita));
    }
}
