
package nhom_java.skincarebookingsystem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "user_id")
public class Manager extends User {

    }
