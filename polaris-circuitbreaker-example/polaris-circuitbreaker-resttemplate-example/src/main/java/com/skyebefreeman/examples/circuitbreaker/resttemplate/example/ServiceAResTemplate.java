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
 *
 */

package com.skyebefreeman.examples.circuitbreaker.resttemplate.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

/**
 * Circuit breaker example caller application.
 *
 * @author sean yu
 */
@SpringBootApplication
public class ServiceAResTemplate {

	public static void main(String[] args) {
		SpringApplication.run(ServiceAResTemplate.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory("http://polaris-circuitbreaker-callee-service");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setUriTemplateHandler(uriBuilderFactory);
		return restTemplate;
	}

}
