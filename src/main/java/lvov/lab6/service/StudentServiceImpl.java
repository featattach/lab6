package lvov.lab6.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lvov.lab6.dao.StudentDAO;
import lvov.lab6.dao.StudentDAOImpl;
import lvov.lab6.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{


    @Autowired
    private StudentDAO studentDAO;

    @Override
    @Transactional
    public List<Student> getAllStudents(){return studentDAO.getAllStudents();}

    @Override
    @Transactional
    public Student saveStudent(Student student){
        return studentDAO.saveStudent(student);
    }
    @Override
    @Transactional
    public Student getStudent(int id){
        return studentDAO.getStudent(id);}



    @Override
    @Transactional
    public void deleteStudent(int id) {
        Student student = studentDAO.getStudent(id);
        if (student != null) {
            studentDAO.deleteStudent(id);
        } else {
            throw new EntityNotFoundException("Студент с id " + id + " не найден");
        }
    }

}
