package com.example.prg;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class NoteService {
    private final Map<String, Note> notes = new HashMap<>();

    boolean save(Note note) {
        if (notes.containsKey(note.getId())) {
            return false;
        } else {
            notes.put(note.getId(), note);
            return true;
        }
    }

    Optional<Note> findById(String id) {
        //od Javy 8 mamy Optionale
        // zwracamy notatkę lub nulla:
        return Optional.ofNullable(notes.get(id));
    }
}
