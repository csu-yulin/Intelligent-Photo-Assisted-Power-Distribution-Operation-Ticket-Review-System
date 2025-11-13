package csu.yulin.ipas.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author lp
 */
@Data
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String phoneNumber;
    private String password;
}