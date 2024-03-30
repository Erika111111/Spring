package ru.gb.hw6.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.hw6.model.Note;
import ru.gb.hw6.servise.FileGateWay;
import ru.gb.hw6.servise.NoteService;

import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;
    private final FileGateWay fileGateWay;

    /**
     * метод просмотра всех заметок
     * @return
     */
    @GetMapping()
    public ResponseEntity<List<Note>> getAll(){
        return new ResponseEntity<>(noteService.getAllNote(), HttpStatus.OK);
    }

    /**
     * метод получения заметки по id.
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public  ResponseEntity<Note> getNote(@PathVariable("id") Long id){
        Note noteById;
        try{
            noteById = noteService.getNoteById(id);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Note());
        }
        return new ResponseEntity<>(noteById, HttpStatus.OK);
    }

    /**
     * метод добавления заметки
     * @param note
     * @return
     */
    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note){
        fileGateWay.writeToFile(note.getTitle() + ".txt", note.getContent());
        return new ResponseEntity<>(noteService.createNote(note), HttpStatus.CREATED);

    }

    /**
     * метод редактирования заметки
     * @param note
     * @return
     */
    @PutMapping
    public ResponseEntity<Note> updateNote(@RequestBody Note note){
        return new ResponseEntity<>(noteService.updateNote(note), HttpStatus.OK);
    }

    /**
     * метод удаления заметки
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable("id") Long id){
        noteService.deleteNoteById(id);
        return ResponseEntity.ok().build();

    }

}
