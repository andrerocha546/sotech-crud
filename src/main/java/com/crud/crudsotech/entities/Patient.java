package com.crud.crudsotech.entities;

import com.crud.crudsotech.entities.data.Parents;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("patient")
public class Patient extends BaseEntity {

    @Id
    private String id;
    private Parents parents;

}
