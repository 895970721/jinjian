package com.fiveonezero.jinjianzi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class WorksController {

    @Autowired
    private WorksRepository worksRepository;

    @GetMapping(value = "/works")
    public List<Works> worksList(){
        return worksRepository.findAll();
    }
}
