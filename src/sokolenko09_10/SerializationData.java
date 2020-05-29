package ua.khpi.oop.sokolenko09_10;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class SerializationData {

    public static <E> void LongTermPersistenceWrite(NewLinkedList<E> object, String path) throws FileNotFoundException {

        XMLEncoder encoder = new XMLEncoder(
                new BufferedOutputStream(
                        new FileOutputStream(path)));

        for (E elem : object) {
            encoder.writeObject(elem);
        }
        encoder.close();
    }


    @SuppressWarnings("unchecked")
    public static <E extends Prisoner> NewLinkedList<E> LongTermPersistenceRead(String path) throws FileNotFoundException {
        boolean test = true;
        NewLinkedList<E> object = new NewLinkedList<>();
        try {
            XMLDecoder decoder = new XMLDecoder(
                    new BufferedInputStream(
                            new FileInputStream(path)));
            while (test) {
                try {
                    E elem = ((E) decoder.readObject());
                    object.add(elem);


                } catch (Exception e) {
                    test = false;
                }
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return object;
    }

    public static <E extends Prisoner> void ObjectWrite(NewLinkedList<E> object, String path) throws IOException, ClassNotFoundException {

        FileOutputStream fileOutputStream = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(object);
        objectOutputStream.close();

    }

    @SuppressWarnings("unchecked")
    public static <E> NewLinkedList<E> ObjectRead(NewLinkedList<E> object, String path) throws IOException, ClassNotFoundException {
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            object = (NewLinkedList<E>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (Exception e) {
            System.out.println("Woops.......Error");
            System.err.println(e.getMessage());
        }
        return object;
    }
}