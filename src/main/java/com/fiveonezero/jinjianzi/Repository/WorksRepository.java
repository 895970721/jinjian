package com.fiveonezero.jinjianzi.Repository;

import com.fiveonezero.jinjianzi.entity.Works;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface WorksRepository extends JpaRepository<Works,Integer> {

    @Query(value="select * from works where user_id= ?1 ",nativeQuery = true)
    List<Works> findItemByUserId(Integer userId);

    @Query(value = "select * from works where works_id= ?1",nativeQuery = true)
    List<Works> findItemByWorkId(Integer workId);
}
