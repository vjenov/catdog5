package com.catdog.web.usr;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @Component
@AllArgsConstructor
@NoArgsConstructor
public class User{
	private String uid, pwd, ssn, creditcard, pname, phone, address, email;
}
