package Structures;

import Resources.Movement;

public class Tree {
    private TreeNode root;

    public Tree(TreeNode root) {
        this.root = root;
    }
    
    public Tree(Object value){
        this.root = new TreeNode(value, null);
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }
    
    public void PreeOrden(){
        TreeNode actual = root;
        preOrdenChilld(root);
    }
    
    public void preOrdenChilld(TreeNode node){
        
        System.out.println(node.getValue() +" hijo de : " +( node.getParent() != null ? node.getParent().getValue().toString() : "") + " produnfidad de "+ node.getDepth() );
        if(node.getChildrens().getSize() > 0){
            for (int i = 0; i < node.getChildrens().getSize(); i++) {
                preOrdenChilld((TreeNode)  node.getChildrens().at(i));
            }      
        }
    }   
}