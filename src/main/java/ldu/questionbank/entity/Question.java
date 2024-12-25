package ldu.questionbank.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    private Integer id;
    private String statement;
    private String options;
    private String answers;
    private Integer createdBy;

}
