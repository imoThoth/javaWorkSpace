package com.athena.experian.controller;

import com.athena.experian.model.DataModel;
import com.athena.experian.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "athena/experian")
public class DataController {

    private final DataService dataService;

    @Autowired
    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping
    public List<DataModel> getAllInfo(){
        return dataService.dataList();
    }

    @PostMapping(path = "/add")
    public void addNewData(@RequestBody DataModel data){
        dataService.addNewData(data);
    }

    @PutMapping(path = "update/{msg_id}")
    public void updateMessageId(
            @RequestBody DataModel data,
            @PathVariable("msg_id") Integer msg_id){
        dataService.updateMessageId(data, msg_id);
    }

}
