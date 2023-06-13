package com.skyebefreeman.examples.polaris.router;

import java.util.HashMap;
import java.util.Map;

import com.tencent.cloud.common.spi.InstanceMetadataProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 *
 *
 * @author Haotian Zhang
 */
@Component
public class CustomMetadata implements InstanceMetadataProvider {

	@Autowired
	private Environment environment;
	@Override
	public Map<String, String> getMetadata() {
		Map<String, String> metadata = new HashMap<>();
		metadata.put("caller_ip", environment.getProperty("spring.cloud.client.ip-address"));
		return metadata;
	}
}
