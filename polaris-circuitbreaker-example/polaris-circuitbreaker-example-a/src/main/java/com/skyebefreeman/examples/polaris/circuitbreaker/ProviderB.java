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

package com.skyebefreeman.examples.polaris.circuitbreaker;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Circuit breaker example callee provider.
 *
 * @author Haotian Zhang
 */
@FeignClient(name = "polaris-circuitbreaker-example-b",
		fallback = ProviderBFallback.class)
public interface ProviderB {

	/**
	 * Get info of service B.
	 *
	 * @return info of service B
	 */
	@GetMapping("/example/service/b/info")
	String info();

}
