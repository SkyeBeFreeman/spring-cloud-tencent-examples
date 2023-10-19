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

package com.skyebefreeman.examples.quickstart.caller.circuitbreaker;

import java.util.HashMap;

import com.tencent.cloud.polaris.circuitbreaker.resttemplate.PolarisCircuitBreakerFallback;
import com.tencent.cloud.polaris.circuitbreaker.resttemplate.PolarisCircuitBreakerHttpResponse;

import org.springframework.stereotype.Component;

/**
 * CustomFallback.
 *
 * @author sean yu
 */
@Component
public class CustomFallback implements PolarisCircuitBreakerFallback {
	@Override
	public PolarisCircuitBreakerHttpResponse fallback() {
		return new PolarisCircuitBreakerHttpResponse(
				200,
				new HashMap<String, String>() {{
					put("Content-Type", "application/json");
				}},
				"{\"msg\": \"this is a fallback class\"}");
	}
}
