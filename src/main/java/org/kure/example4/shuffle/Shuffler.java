package org.kure.example4.shuffle;


import java.util.List;

public interface Shuffler<T> {

    T getSong(List<T> songList);
}
