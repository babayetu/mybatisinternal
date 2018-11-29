package com.babayetu.jedisredisclusterdemo;

import java.util.ResourceBundle;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/*
 * Redis Cluster应该使用JedisCluster对象去访问
 * 
 */
public class JedisCommonPool {
	private static JedisPool pool;
	
	static {
		//ResourceBundle的用法, redis.properties文件必须放到classpath或者src根目录下
		ResourceBundle bundle = ResourceBundle.getBundle("com.babayetu.jedisredisclusterdemo.redis");
		if (bundle == null) {
			throw new IllegalArgumentException("[redis.properties] is not found!");
		}
		
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(Integer.valueOf(bundle.getString("redis.pool.maxIdle")));
		config.setMaxWaitMillis(Integer.valueOf(bundle.getString("redis.pool.maxWait")));
		config.setTestOnBorrow(Boolean.valueOf(bundle.getString("redis.pool.testOnBorrow")));
		config.setTestOnReturn(Boolean.valueOf(bundle.getString("redis.pool.testOnReturn")));
		pool = new JedisPool(config,bundle.getString("redis.ip"),Integer.valueOf(bundle.getString("redis.port")));
	}
	public static void main(String[] args) {
		Jedis jedis = pool.getResource();
		String keys = "name";
		String result = jedis.get("hello");
		System.out.println(result);
		
		//returnResource已经废弃了
		jedis.close();
	}

}
