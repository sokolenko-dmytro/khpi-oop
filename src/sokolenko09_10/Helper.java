package ua.khpi.oop.sokolenko09_10;

import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;

public class Helper {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static Scanner in = new Scanner(System.in);
    private static NewLinkedList<Prisoner> object = new NewLinkedList<>();

    public static void starter(String[] arg) {
        if (arg.length == 0) {
            menu();
        } else if ("-auto".equals(arg[0])) {
            autoMode();
        }
    }

    @SuppressWarnings("unchecked")
    private static void menu() {
        int choose;

        settings();
        choose = in.nextInt();
        while (choose != 0) {
            switch (choose) {
                case 1:
                    printList(object);
                    break;
                case 2:
                    object.add(InfoInput.insert());
                    break;
                case 3:
                    remove(object);
                    break;
                case 4:
                    sorters(object);
                    break;
                case 5:
                    clear(object);
                    break;
                case 6:
                    toStr(object);
                    break;
                case 7:
                    Prisoner[] test = object.toArray(new Prisoner[object.size()]);
                    break;
                case 8:
                    save(object);
                    break;
                case 9:
                    object = download();
                    break;
                case 10:
                    settingSearch(object);
                    break;
            }
            settings();
            choose = in.nextInt();
        }

    }

    @SuppressWarnings("unchecked")
    private static void save(NewLinkedList input) {
        int choose;
        System.out.println("What type of saving do you wish for: ");
        System.out.println("1 - XML");
        System.out.println("2 - Standard Serialization");
        System.out.println("Choose: ");
        choose = in.nextInt();
        try {
            if (choose == 1) {
                SerializationData.LongTermPersistenceWrite(input, FileManager.controller());
            } else {
                SerializationData.ObjectWrite(input, FileManager.controller());
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private static void autoMode() {
        object = download();
        menu();
    }

    private static NewLinkedList download() {
        NewLinkedList<Prisoner> output = new NewLinkedList<>();
        int choose;
        System.out.println("What type of saving do you wish for: ");
        System.out.println("1 - XML");
        System.out.println("2 - Standard Serialization");
        System.out.println("Choose: ");
        choose = in.nextInt();
        try {
            if (choose == 1) {
                output = SerializationData.LongTermPersistenceRead(FileManager.controller());
            } else {
                output = SerializationData.ObjectRead(output, FileManager.controller());
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return output;
    }

    private static void settings() {

        System.out.println("Hello, you are now in menu.....");
        System.out.println("List of settings: ");
        System.out.println("0 - Exit");
        System.out.println("1 - Show data");
        System.out.println("2 - Insert");
        System.out.println("3 - Remove");
        System.out.println("4 - Sort");
        System.out.println("5 - Clear");
        System.out.println("6 - to String");
        System.out.println("7 - to Array");
        System.out.println("8 - Save");
        System.out.println("9 - Download");
        System.out.println("10 - Search");
        System.out.print("Select: ");

    }

    private static void settingAdvance() {
        System.out.println("List of settings: ");
        System.out.println("0 - Exit");
        System.out.println("1 - Sort by date of birthey");
        System.out.println("2 - Sort by date of imprisonment");
        System.out.println("3 - Sort by date of release");
        System.out.println("4 - Show data");
        System.out.print("Select: ");
    }

    @SuppressWarnings("unchecked")
    private static void sorters(NewLinkedList input) {
        int choose;

        settingAdvance();
        choose = in.nextInt();
        while (choose != 0) {
            switch (choose) {
                case 1:
                    input.sort(new Comparator<Prisoner>() {
                        @Override
                        public int compare(Prisoner o1, Prisoner o2) {
                        	if (!(o1.getFirstName().equals(o2.getFirstName()))) {
                                return 1;
                            }
                        	
                            return 0;
                        }
                    }, input.toArray(new Prisoner[input.size()]));
                    break;
                case 2:
                    input.sort(new Comparator<Prisoner>() {
                        @Override
                        public int compare(Prisoner p1, Prisoner p2) {
                            if (!(p1.getLastName().equals(p2.getLastName()))) {
                                return 1;
                            }
                            
                            return 0;
                        }
                    }, input.toArray(new Prisoner[input.size()]));
                    break;
                case 3:
                    input.sort(new Comparator<Prisoner>() {
                        @Override
                        public int compare(Prisoner p1, Prisoner p2) {
                        	if (!(p1.getFirstName().equals(p2.getFirstName()))) {
                                return 1;
                            }
                        	
                            return 0;
                        }
                    }, input.toArray(new Prisoner[input.size()]));
                    break;
                case 4:
                    printList(input);
                    break;
            }
            settingAdvance();
            choose = in.nextInt();
        }
    }

    private static void settingSearch(NewLinkedList<Prisoner> input) {
    	
    	System.out.println("Input prisoner's last name: ");
        String lastName = in.next();
    	
        for (Prisoner elem : input) {
            if (search(elem, lastName)) {
                System.out.println(elem);
            }
        }
    }

    private static void remove(NewLinkedList input) {
        int num;
        if (input.size() != 0) {
            System.out.println("Input number of note: ");
            num = in.nextInt();
            if (num >= 0 && num < input.size()) {
                input.remove(num);
            }
        } else {
            System.out.println("Error: arr is empty");
        }
    }

    private static void clear(NewLinkedList input) {

        System.out.print("Are you sure that you want delete list \n\t\t" + ANSI_RED + "\"Yes" + ANSI_GREEN + "|NO\":"
                + ANSI_RESET);
        if (in.next().matches("Yes|yes")) {
            input.clear();
        }
    }

    private static String toStr(NewLinkedList input) {
        return input.toString();
    }

    private static <E> void printList(NewLinkedList<E> input) {

        for (E elem : input) System.out.println(elem);

    }

    private static boolean search(Prisoner input, String input2) {
    	
    	return input.getLastName().equals(input2);
 
    }

}