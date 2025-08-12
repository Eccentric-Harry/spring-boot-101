package com.example.quickStart.repository;

import com.example.quickStart.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepository {
    private final Map<Long, User> db = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong();

    public List<User> findAll(){
        return new ArrayList<>(db.values());
    }

    public Optional<User> findById(Long id){
        return Optional.ofNullable(db.get(id));
    }
    public User save(User user){
        long id = idGenerator.incrementAndGet();
        User stored = new User(id, user.name);
        db.put(id, stored);
        return stored;
    }
    public void delete(Long id){
        db.remove(id);
    }
}
