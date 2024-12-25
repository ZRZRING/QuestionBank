package ldu.questionbank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Bank {

    private Integer id;
    private String name;
    private String password;
    private String description;
    private Integer createdBy;


}
