package ldu.questionbank.service;

import ldu.questionbank.dao.QuestionDao;
import ldu.questionbank.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuestionService {

    private final QuestionDao questionDao;

    public QuestionService(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    public Question findQuestionById(Integer id) {
        return questionDao.findById(id);
    }

    public List<Question> findAllQuestions() {
        return questionDao.findAll();
    }

    public List<Question> findQuestionsByStatement(String statement) {return questionDao.findByStatement(statement);}

    public void deleteQuestionById(Integer id) {questionDao.deleteById(id);}

    public void saveQuestion(Question question) {questionDao.save(question);}

    public void updateQuestion(Question question) {questionDao.update(question);}
}