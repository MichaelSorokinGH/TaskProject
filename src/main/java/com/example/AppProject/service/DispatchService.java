package com.example.AppProject.service;

import com.example.AppProject.models.dto.DispatchDTO;
import com.example.AppProject.models.entity.Dispatch;

import java.util.List;

public interface DispatchService {

    String createDispatch(DispatchDTO dispatchDTO);
    List<Dispatch> findAlldispatch();

    Dispatch findDispatch(String address);


}
