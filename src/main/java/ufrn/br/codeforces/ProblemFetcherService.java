package ufrn.br.codeforces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProblemFetcherService {
    @Autowired
    private WebClient webClient;

    List<String> ls = new ArrayList<>();

//    public Mono<String> reativo2(String st) {
//        ls.add(st);
//        return Mono.just(st);
//    }
//
//    public Flux<String> reativo(){
//        return Flux.fromIterable(ls).delayElements(Duration.ofSeconds(1)).doOnNext(x -> System.out.println("Oi"));
//    }
}
