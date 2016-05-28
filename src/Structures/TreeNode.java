package Structures;

public class TreeNode {

    private Object value;
    private TreeNode parent;
    private int deepth = 0;

    private LinkedList Childrens = new LinkedList();

    public TreeNode(Object value, TreeNode parent) {
        this.value = value;
        this.parent = parent;
    }

    public TreeNode(Object value, TreeNode parent, int deepth) {
        this.value = value;
        this.parent = parent;
        this.deepth = deepth;
    }

    public int getDeepth() {
        return deepth;
    }

    public void setDeepth(int deepth) {
        this.deepth = deepth;
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
        Childrens.insert(Childrens.getSize(), new TreeNode(son, this, this.deepth++));
    }

    public boolean isLeaf() {
        return Childrens.getSize() == 0;
    }

    public int getChildCount() {
        return Childrens.getSize();
    }

    public TreeNode getChildAt(int i) {
        return (TreeNode) (Childrens.at(i));
    }

    public void delete() {
        parent.Childrens.remove(parent.getChildrens().find(this));
    }

    public LinkedList getBranches() {
        LinkedList branches = new LinkedList();
        branches.push_back(this);
        if (parent != null) {
            TreeNode temporal = parent;
            branches.push_back(temporal);
            while (temporal.getParent() != null) {
                temporal = temporal.getParent();
                branches.push_back(temporal);
            }
        }

        return branches;
    }
}
