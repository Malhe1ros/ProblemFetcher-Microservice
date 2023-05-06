package ufrn.br.codeforces;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import ufrn.br.codeforces.JSONClass.Problem;

@Getter
@Setter
@Entity
public class ProblemInfo {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private Integer rating;
    private String url;
    ProblemInfo(Problem p){
        this.rating = p.getRating();
        this.url = "codeforces.com/contest/"+p.getContestId()+"/problem/"+p.getIndex();
    }

    public ProblemInfo() {

    }
}
