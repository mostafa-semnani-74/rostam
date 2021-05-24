package ir.mostafa.semnani.rostambackend.service;

import ir.mostafa.semnani.rostambackend.common.exception.NotFoundException;
import ir.mostafa.semnani.rostambackend.dto.MotherboardDTO;
import ir.mostafa.semnani.rostambackend.entity.Motherboard;
import ir.mostafa.semnani.rostambackend.mapper.MotherboardMapper;
import ir.mostafa.semnani.rostambackend.repository.MotherboardRepository;
import org.springframework.beans.NotReadablePropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class MotherboardService {

    @Autowired
    private MotherboardRepository motherboardRepository;

    @Transactional
    public void create(MotherboardDTO createDTO) {
        motherboardRepository.save(MotherboardMapper.motherboardMapperInstance.dtoToEntity(createDTO));
    }

    @Transactional
    public void delete(Long id) { motherboardRepository.deleteById(id); }

    @Transactional
    public MotherboardDTO update(MotherboardDTO updateDTO, Long id){
        MotherboardDTO motherboardDTOForUpdate =
                MotherboardMapper.motherboardMapperInstance.entityToDTO(motherboardRepository.findById(id).get());

        motherboardDTOForUpdate.setName(updateDTO.getName());
        motherboardDTOForUpdate.setSerialNumber(updateDTO.getSerialNumber());

        motherboardRepository.save(MotherboardMapper.motherboardMapperInstance.dtoToEntity(motherboardDTOForUpdate));
        return motherboardDTOForUpdate;
    }

    @Transactional(readOnly = true)
    public List<MotherboardDTO> findAll() {
        List<Motherboard> motherboardList =  motherboardRepository.findAll();
        List<MotherboardDTO> motherboardDTOList = new ArrayList<>();
        for (Motherboard motherboard : motherboardList) {
            motherboardDTOList.add(MotherboardMapper.motherboardMapperInstance.entityToDTO(motherboard));
        }
        return motherboardDTOList;
    }

    @Transactional(readOnly = true)
    public MotherboardDTO findById(Long id) {
        return MotherboardMapper.motherboardMapperInstance.entityToDTO(motherboardRepository.findById(id).get());
    }

}
