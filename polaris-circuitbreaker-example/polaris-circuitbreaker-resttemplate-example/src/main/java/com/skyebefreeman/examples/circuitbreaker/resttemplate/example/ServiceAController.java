/*
 * Tencent is pleased to support the open source community by making Spring Cloud Tencent available.
 *
 * Copyright (C) 2019 THL A29 Limited, a Tencent company. All rights reserved.
 *
 * Licensed under the BSD 3-Clause License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://opensource.org/licenses/BSD-3-Clause
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.skyebefreeman.examples.circuitbreaker.resttemplate.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Circuit breaker example caller controller.
 *
 * @author sean yu
 */
@RestController
@RequestMapping("/example/service/a")
public class ServiceAController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private CircuitBreakerFactory circuitBreakerFactory;

	@GetMapping("/getBServiceInfo")
	public String getBServiceInfo() {
		return circuitBreakerFactory
				.create("polaris-circuitbreaker-callee-service#/example/service/b/info")
				.run(() ->
						restTemplate.getForObject("/example/service/b/info", String.class),
						throwable -> "trigger the refuse for service b"
				);
	}

}
