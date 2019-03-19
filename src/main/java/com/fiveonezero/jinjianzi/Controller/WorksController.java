package com.fiveonezero.jinjianzi.Controller;

import com.fiveonezero.jinjianzi.Repository.WorksRepository;
import com.fiveonezero.jinjianzi.entity.Works;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

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
     * 通过作品id找作品
     * */
    @PostMapping(value = "/items")
    public List<Works> worksItem2(@RequestParam("work_id") Integer work_id){
        return worksRepository.findItemByWorkId(work_id);
    }


}
