package com.example.AppProject.service.impl;

import com.example.AppProject.exceptions.CustomException;
import com.example.AppProject.models.dto.DispatchDTO;
import com.example.AppProject.models.entity.Branch;
import com.example.AppProject.models.entity.Dispatch;
import com.example.AppProject.models.repositories.BranchRepository;
import com.example.AppProject.models.repositories.DispatchRepository;
import com.example.AppProject.service.DispatchService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DispatchServiceImpl implements DispatchService {

    private final DispatchRepository dispatchRepository;

    private final ObjectMapper mapper;

    private final BranchRepository branchRepository;


    @Override
    public String createDispatch(DispatchDTO dispatchDTO) {
        if (dispatchDTO.getAddress() == null) {
            throw new CustomException("Укажите адрес", HttpStatus.CONFLICT);
        }
        Dispatch dispatch = mapper.convertValue(dispatchDTO, Dispatch.class);
        Branch branch = branchRepository.findByAddress(dispatchDTO.getAddress()).orElseThrow(
                () -> new CustomException("Филиал по данному адресу не найден!", HttpStatus.NOT_FOUND)
        );
        dispatchRepository.findByAddress(dispatchDTO.getAddress()).ifPresent(h -> {
            throw new CustomException("Отдел по такому адресу уже существует", HttpStatus.CONFLICT);
        });
        dispatch.setBranch(branch);
        dispatchRepository.save(dispatch);
        branch.setDispatch(dispatch);
        branchRepository.save(branch);

        return "Диспетчерская на филиале по адресу " + branch.getAddress() + " создана.";
    }

    @Override
    public List<Dispatch> findAlldispatch() {
        return dispatchRepository.findAll();
    }

    public Dispatch findDispatch(String address) {
        return dispatchRepository.findByAddress(address)
                .orElseThrow(() ->
                        new CustomException("Диспетчерской по адресу " + address + " не существует", HttpStatus.CONFLICT));
    }
}


