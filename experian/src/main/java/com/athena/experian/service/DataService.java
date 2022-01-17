package com.athena.experian.service;

import com.athena.experian.model.DataModel;
import com.athena.experian.model.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DataService {

    private final DataRepository dataRepository;

    @Autowired
    public DataService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public List<DataModel> dataList() {
        return dataRepository.findAll();
    }

    public void addNewData(DataModel data) {
        Optional<DataModel> checkData = dataRepository.findById(data.getMsg_id());

        if(checkData.isPresent()){
            throw new IllegalArgumentException("Field Value Already In Use");
        }
        dataRepository.save(data);
    }

    @Transactional
    public void updateMessageId(Integer msg_id) {
        DataModel checkModel = dataRepository.findById(msg_id).orElseThrow( ()->
                new IllegalArgumentException(
                        "Message id " + msg_id + " Does Not Exist"
                ));

        checkModel.setMsg_id(msg_id);
    }
}
