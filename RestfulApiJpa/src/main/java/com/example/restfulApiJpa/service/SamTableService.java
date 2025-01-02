package com.example.restfulApiJpa.service;

import com.example.restfulApiJpa.entity.SamTable;
import com.example.restfulApiJpa.repository.SamTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SamTableService {

    @Autowired
    private SamTableRepository samTableRepository;

    // 입력가능 KeyNO 조회(Max +1)
    public Integer getInsertKeyNo() {
        return samTableRepository.findAll().stream()
                .mapToInt(SamTable::getKeyno)
                .max()
                .orElse(0) + 1;
    }

    // 모든 Value 조회
    public List<SamTable> getAllValue() {
        return samTableRepository.findAll();
    }

    // KeyNo로 Value 조회
    public Optional<SamTable> getKeyNoValue(Integer keyno) {
        return samTableRepository.findById(keyno);
    }

    // 신규 KeyNo, Value 추가
    public SamTable addValue(SamTable samTable) {
        return samTableRepository.save(samTable);
    }

    // KeyNo 해당 Value 업데이트
    public SamTable updateValue(Integer keyno, String value) {
        Optional<SamTable> optionalSamTable = samTableRepository.findById(keyno);
        if (optionalSamTable.isPresent()) {
            SamTable samTable = optionalSamTable.get();
            samTable.setValue(value);
            return samTableRepository.save(samTable);
        }
        throw new RuntimeException("KeyNo not found");
    }

    // KeyNo 해당 Row 삭제
    public void deleteValue(Integer keyno) {
        samTableRepository.deleteById(keyno);
    }
}
