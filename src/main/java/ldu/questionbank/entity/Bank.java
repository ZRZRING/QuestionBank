package ldu.questionbank.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bank {
    private Integer id;
    private String name;
    private String password;
    private String description;
    private Integer createdBy;
}
