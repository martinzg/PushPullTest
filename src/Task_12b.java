import java.io.*;
import java.util.*;

public class Task_12b {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        List<String> shoppingListMenu = new ArrayList<String>();
        int userInputMenu;
        int listItemCounter = 0;
        List<String> shoppingList = new ArrayList<String>();

        do {
            System.out.println("Shopping list menu:");
            menuList(shoppingListMenu);

            System.out.print("\n" + "Please enter your choice: ");
            userInputMenu = userInputMenuCheck();
            if (userInputMenu == 0) {
                System.out.print("\n" + "Wrong choice! ");
            }
            else {

                if (userInputMenu == 1) {       //add an item
                    System.out.print("\n" + "Enter item to add: ");
                    itemListAdd(shoppingList, listItemCounter);
                    listItemCounter++;
                }
                if (userInputMenu == 2) {      //list items
                    System.out.println("\n" + "Items in list: ");
                    itemListPrint(shoppingList);
                }
                if (userInputMenu == 3) {     //delete an item
                    System.out.println("\n" + "Delete items from list: ");
                    itemListPrint(shoppingList);
                    if (!(shoppingList.isEmpty())) {
                        System.out.print("Enter item (row) number to delete: ");
                        int userInputDelete = scanner.nextInt();
                        if ((userInputDelete>listItemCounter)|(userInputDelete<1)) {
                            System.out.print("\n" + "Item with such number does not exist! ");
                        }
                        else {
                            itemListDelete(shoppingList,userInputDelete);
                            listItemCounter--;
                        }
                    }
                }
                if (userInputMenu == 4) {      //save list to file
                    System.out.print("\n" + "Please specify filename (without extension): ");
                    String saveFileNameInput = scanner.next();
                    String saveFileNameFull = getHomeDir()+"\\Desktop\\"+saveFileNameInput+".txt";
                    saveToFile(saveFileNameInput, saveFileNameFull, shoppingList);
                }
                if (userInputMenu == 5) {      //load list from file
                    System.out.print("\n" + "Please specify filename + path (e.g. 'C:\\Users\\gailums\\Desktop\\shopping_list.txt'): ");
                    String loadFileNameInput = scanner.next();

                    BufferedReader inputStream = readFromFileCheck(loadFileNameInput);
                    if (inputStream != null) {
                        shoppingList.clear();
                        listItemCounter = readFromFile(inputStream, shoppingList);
                        System.out.println("\n" + "List from file '" + loadFileNameInput + "' successfully loaded!" + "\n");
                    }
                }
            }
        } while (userInputMenu != 6);

        System.out.print("\n" + "Good bye!");
    }
    public static int userInputMenuCheck() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        boolean userInputMenuCheckInt = scanner.hasNextInt();
        int userInputMenu;
        if (userInputMenuCheckInt) {
            userInputMenu = scanner.nextInt();
            if ((userInputMenu>6)|(userInputMenu<1)) {
                userInputMenu = 0;
            }
        }
        else {
            userInputMenu = 0;
        }
        return userInputMenu;
    }
    public static void menuList(List<String> shoppingListMenu){
        shoppingListMenu.clear();
        shoppingListMenu.add("1 - add an item");
        shoppingListMenu.add("2 - list items");
        shoppingListMenu.add("3 - delete an item");
        shoppingListMenu.add("4 - save list to file");
        shoppingListMenu.add("5 - load list from file");
        shoppingListMenu.add("6 - exit");
        for (int i=0; i<shoppingListMenu.size(); i++) {
            System.out.println(shoppingListMenu.get(i));
        }
    }
    public static void itemListAdd(List<String> shoppingList,int listItemCounter){
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        String addItem = scanner.nextLine();

        shoppingList.add(listItemCounter, addItem);

        System.out.print("\n" + "Item '" + addItem + "' added! ");
    }
    public static void itemListPrint(List<String> shoppingList){
        if (shoppingList.isEmpty()){
            System.out.println("there is no items in list yet!" + "\n");
        }
        else {
            for (int i=0; i<shoppingList.size(); i++){
                System.out.println(shoppingList.get(i));
            }
            System.out.print("\n");
        }
    }
    public static void itemListDelete(List<String> shoppingList,int userInputDelete){
        String deletedItem = shoppingList.get(userInputDelete-1);
        shoppingList.remove(userInputDelete-1);

        System.out.print("\n" + "Item '" + deletedItem + "' deleted! ");
    }
    public static void saveToFile (String saveFileNameInput, String saveFileNameFull, List<String> shoppingList) throws IOException{
        BufferedWriter outputStream = new BufferedWriter(new FileWriter(saveFileNameFull));
        for (int i=0; i<shoppingList.size(); i++) {
            outputStream.write(shoppingList.get(i));
            outputStream.newLine();
        }
        outputStream.flush();
        outputStream.close();
        System.out.print("\n" + "File '" + saveFileNameInput +".txt' successfully saved to Desktop! ");
    }
    public static String getHomeDir (){
        String homeDir = System.getProperty("user.home");
        return homeDir;
    }
    public static BufferedReader readFromFileCheck (String loadFileNameInput) throws IOException{
        BufferedReader inputStream = null;
        try {
            inputStream = new BufferedReader(new FileReader(new File(loadFileNameInput)));
        }
        catch (IOException ex){
            System.err.println("\n" + "An IOException was caught!");
            ex.printStackTrace();
            System.out.print("\n");
        }
        return inputStream;
    }
    public static int readFromFile (BufferedReader inputStream, List<String> shoppingList) throws IOException{
        int line=0;
        for (String i = inputStream.readLine(); i != null; i = inputStream.readLine()) {
            shoppingList.add(line, i);
            line++;
        }
        inputStream.close();
        return line;
    }
}