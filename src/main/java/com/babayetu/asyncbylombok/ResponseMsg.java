package com.babayetu.asyncbylombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseMsg<T> {
	private int code;
	private String msg;
	private T data;
}
