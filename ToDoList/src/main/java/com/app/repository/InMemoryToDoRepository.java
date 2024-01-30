package com.app.repository;

import com.app.model.ToDoItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Implementation of CRUD operation and memory data storage during program session.
 *
 * @author Mauricio Bedoya
 *
 * @since 1.0
 */
public class InMemoryToDoRepository implements ToDoRepository {
    private final AtomicLong currentId = new AtomicLong();
    private final ConcurrentMap<Long, ToDoItem> toDo = new ConcurrentHashMap<>();

    /**
     * @hidden
     */
    public InMemoryToDoRepository(){}
    @Override
    public List<ToDoItem> findAll() {
        List<ToDoItem> toDoItems = new ArrayList<>(toDo.values());
        Collections.sort(toDoItems);

        return toDoItems;

    }

    @Override
    public ToDoItem getById(long id) {
        return toDo.get(id);
    }

    @Override
    public Long insert(ToDoItem toDoItem) {
        Long id = currentId.incrementAndGet();
        toDoItem.setId(id);
        toDo.putIfAbsent(id, toDoItem);

        return id;
    }

    @Override
    public void update(ToDoItem toDoItem) {
        toDo.replace(toDoItem.getId(), toDoItem);
    }

    @Override
    public void delete(ToDoItem toDoItem) {
        toDoItem.makeCompleted();
    }

}
