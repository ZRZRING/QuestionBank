package ldu.questionbank.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankQuestion {
    private Integer id;
    private Integer bankId;
    private Integer questionId;
}
