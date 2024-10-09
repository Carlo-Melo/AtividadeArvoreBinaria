// Aluno: Carlos Eduardo Alves
// Atividade Supervisionada II - Recursividade e Árvores

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        //insert
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(4);
        bst.insert(6);
        bst.insert(14);
        bst.insert(16);
        bst.insert(2);
        bst.insert(18);
        //print
        System.out.println("Árvore Binária de Busca em Ordem:");
        bst.inOrder();
        System.out.println("\nÁrvore Binária de Busca Pós Ordem:");
        bst.postOrder();
        System.out.println("\nÁrvore Binária de Busca Pre Ordem:");
        bst.preOrder();
        System.out.println("\n\nDiigite um Nó a ser deletado:");
        int dado = input.nextInt();
        bst.delete(dado);
        System.out.println("\n\nÁrvore Binária de Busca em Ordem:");
        bst.inOrder();
        System.out.println("\nÁrvore Binária de Busca Pós Ordem:");
        bst.postOrder();
        System.out.println("\nÁrvore Binária de Busca Pre Ordem:");
        bst.preOrder();
        System.out.println("\nNúmero de nós : "+ bst.contarNos());
        System.out.println("Número de nós folha: " + bst.contarNosFolha());
        System.out.println("Número de nós não folha: " + bst.contarNosNaoFolha());
        System.out.println("O grau máximo da árvore é: " + bst.calcularGrau());
        //print GUI
        JFrame frame = new JFrame("Visualização da Árvore Binária");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUI treePanel = new GUI(bst);
        frame.add(treePanel);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}