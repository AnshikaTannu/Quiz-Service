package com.test.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RestAPIResponse {

	private String status;
    private String message;
    private Object data;

    
}
