import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

public class Task_12 {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        String[] menuArray = new String[6];
        int userInput = 0;
        int arrayItemCounter = 0;
        String[] itemListArray = new String[100];

        do {
            System.out.println("Shopping list menu:");
            menuList(menuArray);

            System.out.print("\n" + "Please enter your choice: ");
            userInput = scanner.nextInt();

            if ((userInput>6)|(userInput<1)) {
                System.out.print("\n" + "Wrong choice! ");
            }
            else {

                if (userInput == 1) {       //add an item
                    System.out.print("\n" + "Enter item to add: ");
                    itemListAdd(itemListArray,arrayItemCounter);
                    arrayItemCounter++;
                }
                if (userInput == 2) {      //list items
                    System.out.println("\n" + "Items in list: ");
                    itemListPrint(itemListArray, arrayItemCounter);
                }
                if (userInput == 3) {     //delete an item
                    System.out.println("\n" + "Delete items from list: ");
                    itemListPrint(itemListArray,arrayItemCounter);
                    if (itemListArray[0] == null) {
                        //if list is empty - don't do anything
                    }
                    else {
                        System.out.print("Enter item (row) number to delete: ");
                        int userInputDelete = scanner.nextInt();
                        if ((userInputDelete>arrayItemCounter)|(userInputDelete<1)) {
                            System.out.print("\n" + "Item with such number does not exist! ");
                        }
                        else {
                            itemListDelete(itemListArray,arrayItemCounter,userInputDelete);
                            arrayItemCounter--;
                        }
                    }
                }
                if (userInput == 4) {      //save list to file
                    System.out.print("\n" + "Please specify filename (without extension): ");
                    String saveFileNameInput = scanner.next();
                    String saveFileNameFull = getHomeDir()+"\\Desktop\\"+saveFileNameInput+".txt";
                    saveToFile(saveFileNameInput, saveFileNameFull, itemListArray, arrayItemCounter);
                }
                if (userInput == 5) {      //load list from file
                    System.out.print("\n" + "Please specify filename + path (e.g. 'C:\\Users\\gailums\\Desktop\\shopping_list.txt'): ");
                    String loadFileNameInput = scanner.next();

                    BufferedReader inputStream = readFromFileCheck(loadFileNameInput);
                    if (inputStream != null) {
                        cleanArray(itemListArray);
                        arrayItemCounter = readFromFile(inputStream, itemListArray);
                        System.out.println("\n" + "List from file '" + loadFileNameInput +"' successfully loaded!" + "\n");
                    }
                }
            }
        } while (userInput != 6);

        System.out.print("\n" + "Good bye!");
    }
    public static void menuList(String menuArray[]){
        menuArray[0] = "1 - add an item";
        menuArray[1] = "2 - list items";
        menuArray[2] = "3 - delete an item";
        menuArray[3] = "4 - save list to file";
        menuArray[4] = "5 - load list from file";
        menuArray[5] = "6 - exit";
        for (int i=0; i<menuArray.length; i++) {
            System.out.println(menuArray[i]);
        }
    }
    public static void itemListAdd(String itemListArray[],int arrayItemCounter){
        Scanner scanner = new Scanner(System.in);
        String addItem = scanner.nextLine();

        itemListArray[arrayItemCounter] = addItem;

        System.out.print("\n" + "Item '" + addItem + "' added! ");
    }
    public static void itemListPrint(String itemListArray[],int arrayItemCounter){
        if (itemListArray[0] == null){
            System.out.println("there is no items in list yet!" + "\n");
        }
        else {
            for (int i=0; i<arrayItemCounter; i++){
                System.out.println(itemListArray[i]);
            }
            System.out.print("\n");
        }
    }
    public static void itemListDelete(String itemListArray[],int arrayItemCounter,int userInputDelete){
        String deletedItem = itemListArray[userInputDelete-1];
        for (int i=userInputDelete-1; i<arrayItemCounter; i++){
            itemListArray[i] = itemListArray[i+1];
        }
        System.out.print("\n" + "Item '" + deletedItem + "' deleted! ");
    }
    public static void saveToFile (String saveFileNameInput, String saveFileNameFull, String itemListArray[], int arrayItemCounter) throws IOException{
        BufferedWriter outputStream = new BufferedWriter(new FileWriter(saveFileNameFull));
        for (int i=0; i<arrayItemCounter; i++) {
            outputStream.write(itemListArray[i]);
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
    public static int readFromFile (BufferedReader inputStream, String[] itemListArray) throws IOException{
        int line=0;
        for (String i = inputStream.readLine(); i != null; i = inputStream.readLine()) {
            itemListArray[line] = i;
            line++;
        }
        inputStream.close();
        return line;
    }
    public static String[] cleanArray(String itemListArray[]){
        for (int i=0; i<itemListArray.length; i++) {
            itemListArray[i] = null;
        }
        return itemListArray;
    }
}