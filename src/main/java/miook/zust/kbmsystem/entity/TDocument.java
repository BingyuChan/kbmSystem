package miook.zust.kbmsystem.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table
public class TDocument  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String likes;
    @Column
    private String collection;

//    @ManyToMany(mappedBy = "tDocuments")
//    private Set<Tuser> tUsers;
}
