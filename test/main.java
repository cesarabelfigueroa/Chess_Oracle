
import Resources.Empty;
import Resources.King;
import Resources.Knight;
import Resources.Mapping;
import Resources.Movement;
import Resources.Pawn;
import Resources.Piece;
import Structures.Tree;
import Structures.TreeNode;
import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        Tree node = new Tree(1);
        node.getRoot().addSon(3);
        ((TreeNode) node.getRoot().getChildrens().at(0)).addSon(7);
        node.getRoot().addSon(4);
        node.getRoot().addSon(9);
        node.PreeOrden();
        System.out.println("=======================");
        ((TreeNode) node.getRoot().getChildrens().at(0)).delete();
        node.PreeOrden();
    } 
}
