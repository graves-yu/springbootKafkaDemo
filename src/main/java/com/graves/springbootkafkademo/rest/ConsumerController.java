/**
 * 
 */
package com.graves.springbootkafkademo.rest;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.graves.springbootkafkademo.model.User;

/**  
 * <p>Title: ConsumerController</p>  
 * <p>Description: </p>  
 * @author Graves  
 * @date 2020年5月20日  
 */
@Component
public class ConsumerController {
	
	@KafkaListener(topics = "testTopic")
    public void onMessage(String message){
        //insertIntoDb(buffer);//这里为插入数据库代码
        System.out.println(message);
    }
	
	@KafkaListener(topics = "userTopic")
    public void onMessage(User user){
        //insertIntoDb(buffer);//这里为插入数据库代码
        System.out.println(user);
    }
}
