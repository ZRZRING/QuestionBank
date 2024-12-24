package ldu.questionbank.service;

import ldu.questionbank.dao.QuestionDao;
import ldu.questionbank.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuestionService {

    private final QuestionDao questionDao;

    @Autowired
    public QuestionService(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    public Question findQuestionById(Integer id) {
        return questionDao.findById(id);
    }

    public List<Question> findAllQuestions() {
        return questionDao.findAll();
    }
}