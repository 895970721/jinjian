package com.fiveonezero.jinjianzi.Controller;

import com.fiveonezero.jinjianzi.Repository.WorksRepository;
import com.fiveonezero.jinjianzi.entity.Works;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
public class WorksController {

    @Autowired
    private WorksRepository worksRepository;

    /**
     * 通过用户id找作品
     * **/
    @GetMapping(value = "/items")
    public List<Works> worksItem1(@RequestParam("user_id") Integer user_id){
        return worksRepository.findItemByUserId(user_id);
    }

    /**
     * 查找全部作品
     * **/
    @GetMapping(value = "/allworks")
    public List<Works> allWorks(){
        return worksRepository.findAll();
    }

    /**
     * 查找全部作品加用户昵称
     * **/
    @PostMapping(value = "/allworks")
    public List<Map> findWorksAndNick_name(){
        return worksRepository.findWorksAndNick_name();
    }

    /**
     * 随机查找全部作品加用户昵称中的16条
     * **/
    @PostMapping(value = "/allworks/limit")
    public List<Map> findWorksAndNick_namelimit(){
        return worksRepository.findWorksAndNick_namelimit();
    }

    /**
     * 通过作品id找作品
     * */
    @PostMapping(value = "/items")
    public List<Works> worksItem2(@RequestParam("work_id") Integer work_id){
        return worksRepository.findItemByWorkId(work_id);
    }
    /**
     * 通过用户id找点赞的作品
     */
    @PostMapping(value = "/like_works")
    public List<Map> findLikeWorks(@RequestParam("user_id") Integer user_id){
        return worksRepository.findLikeWorks(user_id);
    }
    /**
     * 通过用户id,作品id,增加点赞
     */
    @PostMapping(value = "/add_like")
    public String addLike(
            @RequestParam("user_id") Integer user_id,
            @RequestParam("work_id") Integer work_id
    ){
        if(worksRepository.addLike(user_id,work_id)==1){
            return "插入成功";
        }else{
            return "插入失败";
        }
    }
    /**
     * 通过用户id,作品id,取消点赞
     */
    @PostMapping(value = "/remove_like")
    public String removeLike(
            @RequestParam("user_id") Integer user_id,
            @RequestParam("work_id") Integer work_id
    ){
        if(worksRepository.removeLike(user_id,work_id)==1){
            return "取消点赞成功";
        }else{
            return "取消点赞失败";
        }
    }
}
