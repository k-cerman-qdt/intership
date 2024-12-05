package org.kure.example9.database;


import java.util.List;

public interface SongDao<T> {
    List<T> findAllCustom();
    void saveAllCustom(List<T> songs);
}
