package com.hhq.restfulweb.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hhq.restfulweb.Quote;
import com.hhq.restfulweb.Value;

@RestController
public class QuoteController {
	private final AtomicLong counter = new AtomicLong();
	
	@GetMapping("/quote")
	public Quote quote() {
		Value value = new Value();
		value.setId(counter.incrementAndGet());
		value.setQuote("hello");
		
		
		Quote q = new Quote();
		q.setType("succcess");
		q.setValue(value);
		
		return q;
	}

}
