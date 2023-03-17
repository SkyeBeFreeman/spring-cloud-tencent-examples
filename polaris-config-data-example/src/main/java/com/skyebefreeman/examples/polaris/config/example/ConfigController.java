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
package com.skyebefreeman.examples.polaris.config.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * the endpoint for get config.
 *
 * @author lepdou 2022-03-10
 */
@RestController
@RefreshScope
public class ConfigController {

	@Value("${timeout:1000}")
	private int timeout;

	@Autowired
	private Person person;

	@Autowired
	private Environment environment;

	@GetMapping("/timeout")
	public int timeout() {
		environment.getProperty("timeout", "1000");
		return timeout;
	}

	@GetMapping("/person")
	public String person() {
		return person.toString();
	}

}
