package ufrn.br.codeforces.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ufrn.br.codeforces.ProblemInfo;

import java.util.List;

@Repository
public interface ProblemInfoRepository extends JpaRepository<ProblemInfo, Integer> {
    @Query(value = "SELECT url FROM problem_info WHERE rating = :#{#x} ORDER BY random() LIMIT 1", nativeQuery = true)
    String getRandom(@Param("x")int x);
}