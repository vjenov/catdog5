package com.catdog.web.usr;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catdog.web.utl.Printer;


@RestController
@RequestMapping("/users")

public class UserCtrl {
	private static final Logger Logger = LoggerFactory.getLogger(UserCtrl.class);
	@Autowired User user;
	@Autowired Map<String, Object> map;
	@Autowired Printer printer;
	
	@PostMapping("/")
	public Map<?,?> join(@RequestBody User param) {
//		Logger.info("AJAX가 보낸 아이디 & 비번 {}", param.getUid()+", "+ param.getPwd()+", "+ param.getPname());
		printer.accept("람다 프린터가 출력한 값 "+ param.getUid()+", "+ param.getPwd()+", "+ param.getPname());
		HashMap<String, Object> map2 = new HashMap<>();
		map2.put("uid", param.getUid());
		map2.put("pwd", param.getPwd());
		map2.put("pname", param.getPname());
		Logger.info("map에 담긴 아이디 & 비번", map2.get("uid")+", " + map2.get("pwd"));
		return map2;
	}
	@PostMapping("/login")
	public User login(@RequestBody User param) {
		user.setUid(param.getUid());
		user.setPwd(param.getPwd());
		user.setPname(param.getPname());
		Logger.info("AJAX가 보낸 아이디 & 비번 {}", param.getUid()+", "+ param.getPwd());
		return user;
	}
}
