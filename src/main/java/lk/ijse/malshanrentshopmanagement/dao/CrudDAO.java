package lk.ijse.malshanrentshopmanagement.dao;

import java.util.ArrayList;

public interface CrudDAO<T> extends SuperDAO{
    T getAllValues(String text);
    ArrayList<T> getAll();
    boolean save(T Dto);
    String generateId();
    ArrayList<T> search(String text);
    boolean searchFromId(String id);
    boolean update(T Dto);
    boolean delete(int text);

}
