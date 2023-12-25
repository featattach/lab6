package lvov.lab6.dao;

import lvov.lab6.entity.Discipline;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisciplineDAO {
    List<Discipline> getAllDisciplines();

    Discipline saveDiscipline(Discipline discipline);

    Discipline getDiscipline(int id);

    void deleteDiscipline(int id);
}