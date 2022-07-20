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

package com.skyebefreeman.examples.polaris.discovery.callee;

import com.tencent.cloud.common.spi.InstanceMetadataProvider;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * custom metadata for instance.
 *
 * @author lepdou 2022-06-16
 */
@Component
public class CustomMetadata implements InstanceMetadataProvider {

	@Override
	public Map<String, String> getMetadata() {
		Map<String, String> metadata = new HashMap<>();
		metadata.put("k1", "v1");
		return metadata;
	}

	@Override
	public String getZone() {
		return "shanghai-zone-1";
	}
}
