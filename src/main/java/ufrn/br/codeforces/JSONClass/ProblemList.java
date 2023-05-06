package ufrn.br.codeforces.JSONClass;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProblemList {
    //@JsonIgnore
    List<Problem> problems;
    @JsonIgnore
    String problemStatistics;
}
