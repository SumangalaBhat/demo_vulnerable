package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import org.apache.commons.collections4.map.LazyMap;

@RestController
public class VulnerableController {

    // Intentionally vulnerable endpoint
    @GetMapping("/vuln")
    public String vulnerableEndpoint() {
        // LazyMap can be exploited via Java deserialization in unsafe scenarios
        LazyMap<String, String> map = LazyMap.lazyMap(Collections.emptyMap(), () -> "vulnerable");
        map.put("test", null);
        return "This endpoint has a simulated vulnerability!";
    }
}
