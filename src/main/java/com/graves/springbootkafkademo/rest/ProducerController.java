/**
 * 
 */
package com.graves.springbootkafkademo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.graves.springbootkafkademo.model.User;

/**  
 * <p>Title: ProducerController</p>  
 * <p>Description: </p>  
 * @author Graves  
 * @date 2020年5月20日  
 */
@RestController
public class ProducerController {
	
	@Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    @GetMapping("/message/send")
    public boolean send(@RequestParam String message){
        kafkaTemplate.send("testTopic",message);
        return true;
    }
    
    @PostMapping("/user/save")
    public boolean saveUser(@RequestBody User user){
        kafkaTemplate.send("userTopic",user);
        return true;
    }
}
