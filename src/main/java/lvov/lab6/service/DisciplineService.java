package lvov.lab6.service;

import lvov.lab6.entity.Discipline;

import java.util.List;

public interface DisciplineService {
    List<Discipline> getAllDisciplines();

    Discipline saveDiscipline(Discipline discipline);

    Discipline getDiscipline(int id);

    void deleteDiscipline(int id);
}
