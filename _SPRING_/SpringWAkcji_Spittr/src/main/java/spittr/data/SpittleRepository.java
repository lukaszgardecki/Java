package spittr.data;

import org.springframework.stereotype.Repository;
import spittr.Spittle;

import java.util.List;

@Repository
public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
    Spittle findOne(long spittleId);
}
