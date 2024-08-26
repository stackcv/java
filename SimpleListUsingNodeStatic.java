// create a list of nodes and traverse it.

public class SimpleListUsingNodeStatic {
  static Node lastNode;
  public static void main(String[] args) {

    // create root node
    Node rootNode = new Node();
    rootNode.value = "root Value";
    rootNode.nextNode = null;

    lastNode = rootNode;

    addNode("2nd Value");
    addNode("3rd Value");

    // traverse the list
    traverseAndPrintElements(rootNode);
  }

  static void traverseAndPrintElements(Node node) {
    System.out.println("Here are the values of the list elements:");
    do {

      System.out.println(node.value);
      node = node.nextNode;
    } while(node != null);
  }

  static void addNode(String value) {
    // create new node
    Node newNode = new Node();
    newNode.value = value;
    newNode.nextNode = null;
    lastNode.nextNode = newNode;

    lastNode = newNode;
  }
}

class Node {
  String value;
  Node nextNode;
}