package ufrn.br.codeforces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ufrn.br.codeforces.repository.ProblemInfoRepository;
import ufrn.br.codeforces.JSONClass.Problem;
import ufrn.br.codeforces.JSONClass.ReturnJSON;

@RestController
public class ProblemFetcherController {
    @Autowired
    private ProblemFetcherService pfs;
//    @GetMapping("/testCarga/{qv}")
//    public String testCarga(@PathVariable(value="qv") int qv){
//        String ret = "";
//        //System.out.println("chamei aqui");
//        for(int i = 0;i<qv;i++){
//            RestTemplate restTemplate = new RestTemplate();
//            String requestURL = "http://localhost:8083/checkTrue";
//            String json = restTemplate.getForObject(requestURL, String.class);
//            ret+=json;
//        }
//        return ret;
//
//    }
//
//    List<String> ls = new ArrayList<>();
//
//    @PostMapping(value = "/addProduct/{st}",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//    public Mono<String> reativo2(@PathVariable(value="st") String st) {
//        return pfs.reativo2(st);
//    }
//
//    @GetMapping(value = "/produtos",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//    public Flux<String> reativo(){
//        return pfs.reativo();
//    }

    @GetMapping("/getProblem/{rating}")
    public Mono<String> index(@PathVariable(value="rating") int rating) throws IOException, InterruptedException {
        //System.out.println(myRepo.getRandom(rating));
        //Thread.sleep(2000);
        return Mono.just(myRepo.getRandom(rating));
    }

    public List<Problem> retrieve(){
        RestTemplate restTemplate = new RestTemplate();
        String requestURL = "http://localhost:8083/getAllProblems";

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
