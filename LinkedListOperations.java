import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOperations {
    private List<Integer> list;

    public ListOperations() {
        list = new ArrayList<>();
    }

    // Insert at the front
    public void insertFront(int value) {
        list.add(0, value);
    }

    // Insert at a specific position
    public void insertAt(int index, int value) {
        if (index >= 0 && index <= list.size()) {
            list.add(index, value);
        } else {
            System.out.println("Invalid index!");
        }
    }

    // Insert at the end
    public void insertEnd(int value) {
        list.add(value);
    }

    // Delete from the front
    public void deleteFront() {
        if (!list.isEmpty()) {
            int removedValue = list.remove(0);
            System.out.println("Removed from front: " + removedValue);
        } else {
            System.out.println("List is empty!");
        }
    }

    // Delete from a specific position
    public void deleteAt(int index) {
        if (index >= 0 && index < list.size()) {
            int removedValue = list.remove(index);
            System.out.println("Removed from index " + index + ": " + removedValue);
        } else {
            System.out.println("Invalid index!");
        }
    }

    // Delete from the end
    public void deleteEnd() {
        if (!list.isEmpty()) {
            int removedValue = list.remove(list.size() - 1);
            System.out.println("Removed from end: " + removedValue);
        } else {
            System.out.println("List is empty!");
        }
    }

    // Search for an element
    public void search(int value) {
        int index = list.indexOf(value);
        if (index != -1) {
            System.out.println("Element " + value + " found at index: " + index);
        } else {
            System.out.println("Element " + value + " not found!");
        }
    }

    // Merge with another list
    public void merge(List<Integer> otherList) {
        list.addAll(otherList);
        System.out.println("Lists merged successfully.");
    }

    // Traverse the list
    public void traverse() {
        if (list.isEmpty()) {
            System.out.println("List is empty!");
        } else {
            System.out.println("Current List: " + list);
        }
    }

    public static void main(String[] args) {
        ListOperations lo = new ListOperations();
        Scanner scanner = new Scanner(System.in);
        int choice, value, index;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Insert at Front");
            System.out.println("2. Insert at Position");
            System.out.println("3. Insert at End");
            System.out.println("4. Delete from Front");
            System.out.println("5. Delete from Position");
            System.out.println("6. Delete from End");
            System.out.println("7. Search Element");
            System.out.println("8. Merge Another List");
            System.out.println("9. Traverse List");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert at front: ");
                    value = scanner.nextInt();
                    lo.insertFront(value);
                    break;
                case 2:
                    System.out.print("Enter index to insert at: ");
                    index = scanner.nextInt();
                    System.out.print("Enter value to insert: ");
                    value = scanner.nextInt();
                    lo.insertAt(index, value);
                    break;
                case 3:
                    System.out.print("Enter value to insert at end: ");
                    value = scanner.nextInt();
                    lo.insertEnd(value);
                    break;
                case 4:
                    lo.deleteFront();
                    break;
                case 5:
                    System.out.print("Enter index to delete from: ");
                    index = scanner.nextInt();
                    lo.deleteAt(index);
                    break;
                case 6:
                    lo.deleteEnd();
                    break;
                case 7:
                    System.out.print("Enter value to search: ");
                    value = scanner.nextInt();
                    lo.search(value);
                    break;
                case 8:
                    List<Integer> otherList = new ArrayList<>();
                    System.out.print("Enter number of elements to merge: ");
                    int n = scanner.nextInt();
                    System.out.println("Enter elements:");
                    for (int i = 0; i < n; i++) {
                        otherList.add(scanner.nextInt());
                    }
                    lo.merge(otherList);
                    break;
                case 9:
                    lo.traverse();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
