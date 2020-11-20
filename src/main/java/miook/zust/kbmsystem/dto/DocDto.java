package miook.zust.kbmsystem.dto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
public class DocDto {
    private String name;
    private String likes;
    private String collection;
}
