package com.example.quickStart.repository;


import com.example.quickStart.model.Note;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class NotesRepository {
    List<List<Note>> notes = new ArrayList<>();
    AtomicInteger atomicInteger = new AtomicInteger(0);

    public List<List<Note>> findAll(){
        return new ArrayList<>(notes);
    }

    public Note findById(int id){
        for(List<Note> note: notes){
            if(!note.isEmpty()){
                for(Note n:note){
                    if(n.id==id){
                        return n;
                    }
                }
            }
        }
        return null;
    }

    public List<Note> getByName(String name){
        for(List<Note> note: notes){
            if(!note.isEmpty()){
                List<Note> result = new ArrayList<>();
                for(Note n: note){
                    if(n.title.equals(name)){
                        result.add(n);
                    }
                }
                return result;
            }
        }
        return new ArrayList<>();
    }

    public Note save(Note note){

    }
}