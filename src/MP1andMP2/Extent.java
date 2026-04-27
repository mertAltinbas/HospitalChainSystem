package MP1andMP2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface Extent extends Serializable {

    static <T> ArrayList<T> loadClassList(String location) throws NullPointerException {
        ArrayList<T> arrayList;

        if (location == null || location.isEmpty()) {
            throw new NullPointerException("Location cannot be null or empty");
        }
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(location))) {
            arrayList = (ArrayList<T>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e){
            System.err.println("Error loading classes list, resetting list; " + e.getMessage());
            arrayList = new ArrayList<>();
        }
        return arrayList;
    }

    static <T> void saveClassList(String location, ArrayList<T> arrayList) throws NullPointerException {
        if (location == null || location.isEmpty()) {
            throw new NullPointerException("Location cannot be null or empty");
        }

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(location))) {
            objectOutputStream.writeObject(arrayList);
        } catch (IOException e){
            System.err.println("Occurred an error while saving: " + e.getMessage());
            e.printStackTrace();
        }
    }

    static <T> List<T> getImmutableClassList(ArrayList<T> arrayList) {
        return Collections.unmodifiableList(arrayList);
    }
}
