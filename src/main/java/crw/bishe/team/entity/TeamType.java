package crw.bishe.team.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "team_type")
public class TeamType implements Serializable {
    @Id
    private Long key;

    private String value;
}