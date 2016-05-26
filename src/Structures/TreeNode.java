package Structures;

public class TreeNode {
    
    private Object value;
    private TreeNode parent;
    private LinkedList Childrens = new LinkedList();
    
    public TreeNode(Object value, TreeNode parent) {
        this.value = value;
        this.parent = parent;
    }
    
    public Object getValue() {
        return value;
    }
    
    public void setValue(Object value) {
        this.value = value;
    }
    
    public TreeNode getParent() {
        return parent;
    }
    
    public void setParent(TreeNode parent) {
        this.parent = parent;
    }
    
    public LinkedList getChildrens() {
        return Childrens;
    }
    
    public void setChildrens(LinkedList Childrens) {
        this.Childrens = Childrens;
    }
    
    public TreeNode getLeftSon() {
        return (TreeNode) Childrens.at(0);
    }
    
    public TreeNode getRigthSon() {
        return (TreeNode) Childrens.at(Childrens.getSize());
    }
    
    public TreeNode getRigthBrother() {
        return (TreeNode) parent.getChildrens().at(parent.getChildrens().find(this) + 1);
    }
    
    public TreeNode getLeftBroter() {
        return (TreeNode) parent.getChildrens().at(parent.getChildrens().find(this) - 1);
    }
    
    public void addSon(TreeNode son) {
        Childrens.insert(Childrens.getSize(), son);
    }
    
    public void addSon(Object son) {
        Childrens.insert(Childrens.getSize(), new TreeNode(son, this));
    }
    
    public void delete() {
        parent.Childrens.remove(parent.getChildrens().find(this));
    }
}
