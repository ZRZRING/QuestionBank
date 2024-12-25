package ldu.questionbank.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentBank {
    private Integer id;
    private Integer studentId;
    private Integer bankId;
}

