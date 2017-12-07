package com.wisely.ch8_5.web;

import com.wisely.ch8_5.service.RedisBussiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wisely.ch8_5.domain.Person;
import com.wisely.ch8_5.service.DemoService;

@RestController
public class CacheController {
	
	@Autowired
	DemoService demoService;

	@Autowired
	private RedisBussiness redisBussiness;

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@RequestMapping("/redisTest")
	public Object redisTest() throws Exception{
		redisBussiness.set("acelxiao","ttttttttt");
		return redisBussiness.get("acelxiao");

	}

	@RequestMapping("/redisTest2")
	public Object redisTest2() throws Exception{
		stringRedisTemplate.opsForValue().set("acelxiao2","acelxiao2");
		return stringRedisTemplate.opsForValue().get("acelxiao2");

	}



	@RequestMapping("/put")
	public Person put(Person person){
		return demoService.save(person);
		
	}

	
	@RequestMapping("/able")
	public Person cacheable(Person person){
		
		
		return demoService.findOne(person);
		
	}
	
	@RequestMapping("/evit")
	public String  evit(Long id){
		 demoService.remove(id);
		 return "ok";
		
	}
	

}
