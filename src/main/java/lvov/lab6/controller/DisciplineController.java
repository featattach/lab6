package lvov.lab6.controller;

import lvov.lab6.entity.Discipline;
import lvov.lab6.model.Response;
import lvov.lab6.service.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disciplines")
public class DisciplineController {

    @Autowired
    private DisciplineService disciplineService;

    @GetMapping
    public ResponseEntity<List<Discipline>> allDisciplines() {
        List<Discipline> allDisciplines = disciplineService.getAllDisciplines();
        return ResponseEntity.ok(allDisciplines);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getDiscipline(@PathVariable("id") int id) {
        Discipline discipline = disciplineService.getDiscipline(id);
        if (discipline != null) {
            return ResponseEntity.ok(discipline);
        } else {
            String errorMessage = "Учебная дисциплина с id " + id + " не найдена";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response(errorMessage));
        }
    }

    @PostMapping
    public ResponseEntity<Response> saveDiscipline(@RequestBody Discipline discipline) {
        try {
            disciplineService.saveDiscipline(discipline);
            return ResponseEntity.ok(new Response("Учебная дисциплина успешно сохранена"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response("Ошибка при сохранении учебной дисциплины"));
        }
    }

    @PutMapping
    public ResponseEntity<Response> updateDiscipline(@RequestBody Discipline discipline) {
        try {
            disciplineService.saveDiscipline(discipline);
            return ResponseEntity.ok(new Response("Учебная дисциплина успешно обновлена"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response("Ошибка при обновлении учебной дисциплины"));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteDiscipline(@PathVariable("id") int id) {
        try {
            disciplineService.deleteDiscipline(id);
            return ResponseEntity.ok(new Response("Учебная дисциплина успешно удалена"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response("Ошибка при удалении учебной дисциплины"));
        }
    }
}
