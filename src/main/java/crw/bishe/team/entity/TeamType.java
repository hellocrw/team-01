package crw.bishe.team.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "team_type")
public class TeamType {
    @Id
    private Long key;

    private String value;
}