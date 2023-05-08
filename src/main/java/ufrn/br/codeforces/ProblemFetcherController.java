package ufrn.br.codeforces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import ufrn.br.codeforces.repository.ProblemInfoRepository;
import ufrn.br.codeforces.JSONClass.Problem;
import ufrn.br.codeforces.JSONClass.ReturnJSON;

@RestController
public class ProblemFetcherController {

    @GetMapping("/getProblem/{rating}")
    public String index(@PathVariable(value="rating") int rating) throws IOException, InterruptedException {
        System.out.println(myRepo.getRandom(rating));
        //Thread.sleep(2000);
        return myRepo.getRandom(rating);
    }

    public List<Problem> retrieve(){
        RestTemplate restTemplate = new RestTemplate();
        String requestURL = "https://codeforces.com/api/problemset.problems";

        String json = restTemplate.getForObject(requestURL, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        //return json;
        try {
            ReturnJSON problema = objectMapper.readValue(json, ReturnJSON.class);
            return problema.getResult().getProblems();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Autowired
    private ProblemInfoRepository myRepo;

    @EventListener(ApplicationReadyEvent.class)
    public String fillDB(){
        List<Problem> allProblems = retrieve();
        System.out.println(allProblems);

        for (Problem p : allProblems){
            myRepo.save(new ProblemInfo(p));
        }
        return "Salvo no banco: "+ allProblems.size()+"\n";
    }

}
