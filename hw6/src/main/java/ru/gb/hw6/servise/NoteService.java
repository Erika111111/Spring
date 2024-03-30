package ru.gb.hw6.servise;

import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.springframework.stereotype.Service;
import ru.gb.hw6.model.Note;
import ru.gb.hw6.repository.NoteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class NoteService {
    private final NoteRepository repository;

    /**
     * метод просмотра всех заметок
     * @return
     */
    public List<Note> getAllNote(){
        return repository.findAll();
    }

    /**
     * метод добавление заметки
     * @param note
     * @return
     */
    public Note createNote(Note note){
        return repository.save(note);
    }

    /**
     *  метод получения заметки по id
     * @param id
     * @return
     */
    public Note getNoteById(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Note not found with id: " + id));
    }

    /**
     * метод редактирования заметки
     * @param note
     * @return
     */
    public Note updateNote(Note note){
        Note noteById = getNoteById(note.getId());
        noteById.setContent(note.getContent());
        noteById.setTitle(note.getTitle());
        return repository.save(noteById);
    }
    public void deleteNoteById(Long id){
        Note noteById = getNoteById(id);
        repository.delete(noteById);
    }
}
