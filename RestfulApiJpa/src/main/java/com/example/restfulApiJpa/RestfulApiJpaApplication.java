package com.example.restfulApiJpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restfulApiJpa.entity.SamTable;
import com.example.restfulApiJpa.service.SamTableService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173") // Vue 개발 서버 주소
public class RestfulApiJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulApiJpaApplication.class, args);
	}

	@Autowired
	private SamTableService service; 

	//private List<Map<String, Object>> dataList = new ArrayList<>(); 
	
    // POST: 데이터 추가
    @PostMapping("/data")
    public SamTable addValue(@RequestBody SamTable samTable) {
        return service.addValue(samTable);
    }
    /*
    public String createData(@RequestBody Map<String, String> request) {        
        // DB Table에 저장
        Integer  hviKeyno = dbmsService.getInsertKeyNo();
        String   hvsValue = request.get("value");
        int rowsAffected = dbmsService.addValue(hviKeyno, hvsValue);
        return rowsAffected > 0 ? "Data created with ID: " + hviKeyno + ", Value: " + hvsValue : "Value Insert Error" ;
    } */

    // PUT: 데이터 업데이트
    @PutMapping("/data/{id}")
    public SamTable updateValue(@PathVariable Integer id, @RequestBody String value) {
        return service.updateValue(id, value);
    }
    /*
    public String updateData(@PathVariable int id, @RequestBody Map<String, String> request) {
    	// DB Table에 데이터 수정
        Integer  hviKeyno = id;
        String   hvsValue = request.get("value");
        int rowsAffected = dbmsService.updateValue(hviKeyno, hvsValue);
        return rowsAffected > 0 ? "Data with ID " + hviKeyno.toString() + " updated." : "Data with ID " + hviKeyno.toString() + " not found.";
    }*/

    // DELETE: 데이터 삭제
    @DeleteMapping("/data/{id}")
    public void deleteValue(@PathVariable Integer id) {
        service.deleteValue(id);
    }
    /*
    public String deleteData(@PathVariable int id) {
    	// DB Table에 데이터 삭제
        Integer  hviKeyno = id; 
        int rowsAffected = dbmsService.deleteValue(hviKeyno);
        return rowsAffected > 0 ? "Data with ID " + hviKeyno.toString() + " deleted." : "Data with ID " + hviKeyno.toString() + " not found.";
    }*/

    // GET: 데이터 조회 (테스트용)
    @GetMapping("/data")
    public List<SamTable> getAllValues() {
        return service.getAllValue();
    }

    @GetMapping("/data/{id}")
    public Optional<SamTable> getValueById(@PathVariable Integer id) {
        return service.getKeyNoValue(id);
    }
    
    /*
    @GetMapping("/data/{id}")
    public String getData(@PathVariable int id) {
    	if (id == 0) {
    		// DB Table에 데이터 조회 (All)
    		List<Map<String, Object>> temp = new ArrayList<>();   
            temp = dbmsService.getAllValue();
            try {
	            // ObjectMapper 인스턴스 생성
	            ObjectMapper objectMapper = new ObjectMapper();                
	            // Map을 JSON 문자열로 변환
	            return objectMapper.writeValueAsString(temp);
            } catch (Exception e) {
            	return e.getMessage();
            }
    	
    	} else {
    		// DB Table에 데이터 조회 (KeyNo 해당 Value)
    		List<Map<String, Object>> temp = new ArrayList<>();
            Integer  hviKeyno = id;  
            temp = dbmsService.getKeyNoValue(hviKeyno);
            if (temp.isEmpty()) { 
            	return "Data with ID " + id + " not found.";
            } else {
            	Map<String, Object> data = temp.get(0);             
            	return "Find Data :" + data.get("Value");
            }
    	}
    } */
}
