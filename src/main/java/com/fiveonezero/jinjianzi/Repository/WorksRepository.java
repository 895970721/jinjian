package com.fiveonezero.jinjianzi.Repository;

import com.fiveonezero.jinjianzi.entity.Works;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

public interface WorksRepository extends JpaRepository<Works,Integer> {
    //查找全部作品
    @Query(value="select * from works where user_id= ?1 ",nativeQuery = true)
    List<Works> findItemByUserId(Integer userId);
    //通过作品id找作品
    @Query(value = "select * from works where works_id= ?1",nativeQuery = true)
    List<Works> findItemByWorkId(Integer workId);
    //查找全部作品加用户昵称
    @Query(value = "select works.*,user.nick_name from user inner join works\ton  user.user_id=works.user_id",nativeQuery = true)
    List<Map> findWorksAndNick_name();
    //随机全部作品加用户昵称中的16条
    @Query(value = "select works.*,user.nick_name from user inner join works\ton  user.user_id=works.user_id  order by rand() limit 16",nativeQuery = true)
    List<Map> findWorksAndNick_namelimit();
    //查找用户点赞的作品
    @Query(value = "select * from works where works_id = ANY(select work_id from likes where user_id = ?1)",nativeQuery = true)
    List<Map> findLikeWorks(Integer userId);
    //增加点赞
    @Modifying
    @Transactional
    @Query(value = "CALL add_start(?1,?2)" ,nativeQuery = true)
    int addLike(Integer user_id,Integer work_id);
    //删除点赞
    @Modifying
    @Transactional
    @Query(value = "CALL cancel_start(?1,?2)" ,nativeQuery = true)
    int removeLike(Integer user_id,Integer work_id);
}
