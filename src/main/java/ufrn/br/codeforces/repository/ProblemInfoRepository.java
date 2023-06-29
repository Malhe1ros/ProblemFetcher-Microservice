package ufrn.br.codeforces.repository;







import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.SampleOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import ufrn.br.codeforces.ProblemInfo;

import java.util.List;

@Repository
public interface ProblemInfoRepository extends ReactiveMongoRepository<ProblemInfo, Integer> {

    @Aggregation(pipeline = {
            "{$match: { rating: ?0 }}",
            "{$sample: { size: 1 }}"
    })
    Mono<ProblemInfo> getRandom(int rating);
}