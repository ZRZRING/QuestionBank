package ldu.questionbank.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentBank {
    private Integer id;
    private Integer studentId;
    private Integer bankId;

}

