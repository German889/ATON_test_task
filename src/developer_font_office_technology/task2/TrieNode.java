package developer_font_office_technology.task2;

public class TrieNode {
    private TrieNode[] children;
    private String name;

    public TrieNode() {
        children = new TrieNode[10];
        name = null;
    }

    public TrieNode getChild(int i) {
        return children[i];
    }

    public void setChild(int i, TrieNode node) {
        children[i] = node;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

