import java.util.*;

public class SimpleListNodeBuilderPERF {
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

    // PERF: First create a fairly large linkedList (add say 1M (100,0000) elements)
    listBuilder = new ListBuilder();

    inputElements = new ArrayList<>();
    for (int i=0; i<10000000; i++) {
      inputElements.add(String.valueOf(i));
    }

    try {
      listBuilder.createList(inputElements);
    } catch (Exception e) {
      System.out.println(e);
    }

    // PERF: Add one more new element to the last of the list
    listBuilder.addValueToList("Hello");
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

    long startTime = System.currentTimeMillis();

    // create the subsequent (HEAD) Nodes
    for (int i=0; i<elementsToBeAdded.size(); i++) {
      Node node = new Node();
      node.value = elementsToBeAdded.get(i);
      node.nextNode = null;
      
      if (i == 0) {
        headNode = node;
        lastNode = node;
      }

      lastNode.nextNode = node;
      lastNode = node;
    }

    long endTime = System.currentTimeMillis();
    // PERF: Time taken?
    System.out.println("Time taken to create the list: " + (endTime-startTime));
  }

  public void addValueToList(String value) {
    // check length of the input string?
    long startTime = System.currentTimeMillis();
    Node node = new Node();
      
    node.value = value;
    node.nextNode = null;
      
    lastNode.nextNode = node;
    lastNode = node;

    // PERF: Time taken?
    long endTime = System.currentTimeMillis();
    System.out.println("Time taken in adding one node to the last: " + (endTime-startTime));
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