package ufrn.br.codeforces.JSONClass;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Problem {
    int contestId;
    String problemsetName;

    String index;
    String name;
    @JsonIgnore
    String type;

    float points;
    int rating;
    @JsonIgnore
    String tags;

    @Override
    public String toString() {
        return "Problem{" +
                "contestId=" + contestId +
                "index="+ index+
                ", problemsetName='" + problemsetName + '\'' +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                '}';
    }
}
