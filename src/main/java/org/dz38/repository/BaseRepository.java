package org.dz38.repository;

import java.util.Map;
import java.util.Optional;

public interface BaseRepository<T, V> {
    void create(T entity);
    void update(T entity);
    Optional<T> findById(Long id);
    Optional<Map<V, T>> findAll();
    void deleteById(Long id);
}
