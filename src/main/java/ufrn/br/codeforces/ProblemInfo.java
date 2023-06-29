package ufrn.br.codeforces;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ufrn.br.codeforces.JSONClass.Problem;

@Getter
@Setter
@Document(collection = "problemInfo")
public class ProblemInfo {
    @Id
    private String id;
    private Integer rating;
    private String url;
    ProblemInfo(Problem p){
        this.rating = p.getRating();
        this.url = "codeforces.com/contest/"+p.getContestId()+"/problem/"+p.getIndex();
    }

    public ProblemInfo() {

    }
}
