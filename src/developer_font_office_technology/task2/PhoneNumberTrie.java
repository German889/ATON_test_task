package developer_font_office_technology.task2;

public class PhoneNumberTrie {
    private TrieNode root;

    public PhoneNumberTrie() {
        root = new TrieNode();
    }

    public void insert(String phoneNumber, String name) {
        TrieNode node = root;
        for (int i = 0; i < phoneNumber.length(); i++) {
            int digit = phoneNumber.charAt(i) - '0';
            if (node.getChild(digit) == null) {
                node.setChild(digit, new TrieNode());
            }
            node = node.getChild(digit);
        }
        node.setName(name);
    }

    public String search(String phoneNumber) {
        TrieNode node = root;
        for (int i = 0; i < phoneNumber.length(); i++) {
            int digit = phoneNumber.charAt(i) - '0';
            node = node.getChild(digit);
            if (node == null) {
                return null;
            }
        }
        return node.getName();
    }
}
