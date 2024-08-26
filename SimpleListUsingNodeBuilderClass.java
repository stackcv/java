import java.util.*;

public class SimpleListUsingNodeBuilderClass {
  public static void main(String[] args) {

    ListBuilder listBuilder = new ListBuilder();

    // inputs:
    String[] inputStringArray = new String[]{"1", "2", "3", "4"};

    List<String> inputElements = Arrays.asList(inputStringArray);

    try {
      listBuilder.createList(inputElements);
    } catch(Exception ex) {
      System.out.println("Exception recieved from ListBuilder: " + ex);
    }

    listBuilder.printList();
  }
}

class ListBuilder {

  Node headNode = null;
  Node lastNode = null;

  public void createList(List<String> elementsToBeAdded) throws Exception {
    // list could be empty
    if (elementsToBeAdded.isEmpty()) {
      throw new Exception("Empty inputs");
    }

    Node firstNode = new Node();
    firstNode.value = elementsToBeAdded.get(0);
    firstNode.nextNode = null;
    headNode = firstNode;
    lastNode = headNode;

    // create the subsequent (HEAD) Nodes
    for (int i=1; i<elementsToBeAdded.size(); i++) {
      Node node = new Node();
      node.value = elementsToBeAdded.get(i);
      node.nextNode = null;
      lastNode.nextNode = node;
      lastNode = node;
    }
  }

  public void addValueToList(String value) {
    // check length of the input string?

  }

  public void printList() {
    // empty list should not throw NPE or cause issues, handle it
    // traverse the list, starting from the Headnode

    Node node = headNode;

    do {
      System.out.println(node.value);
      node = node.nextNode;
    } while (!Objects.isNull(node));
  }
}

class Node {
  String value;
  Node nextNode;
}