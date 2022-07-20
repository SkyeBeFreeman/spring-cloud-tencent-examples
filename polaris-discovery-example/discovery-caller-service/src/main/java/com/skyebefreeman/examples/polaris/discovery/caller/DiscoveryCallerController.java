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

package com.skyebefreeman.examples.polaris.discovery.caller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Discovery caller controller.
 *
 * @author Haotian Zhang
 */
@RestController
@RequestMapping("/discovery/service/caller")
public class DiscoveryCallerController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private DiscoveryCalleeService discoveryCalleeService;

	/**
	 * Get sum of two value.
	 *
	 * @param value1 value 1
	 * @param value2 value 2
	 * @return sum
	 */
	@GetMapping("/feign")
	public int feign(@RequestParam int value1, @RequestParam int value2) {
		return discoveryCalleeService.sum(value1, value2);
	}

	/**
	 * Get information of callee.
	 *
	 * @return information of callee
	 */
	@GetMapping("/rest")
	public String rest() {
		return restTemplate.getForObject(
				"http://DiscoveryCalleeService/discovery/service/callee/info",
				String.class);
	}

	/**
	 * health check.
	 *
	 * @return health check info
	 */
	@GetMapping("/healthCheck")
	public String healthCheck() {
		return "pk ok";
	}

}
