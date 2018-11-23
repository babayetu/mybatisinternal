package com.babayetu.asyncbylombok;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class MiaoshaService {
	public ResponseMsg<String> getResult() {
		log.info("Miaosha服务开始执行");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		log.info("Miaosha服务处理完成");
		return new ResponseMsg<String>(0,"操作成功","success");
	}
}
