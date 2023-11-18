package co.chu3la.controller;

import co.chu3la.resource.ContractHealthChecks;
import org.springframework.boot.actuate.health.Health;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping
public class HealthController {

    @GetMapping("/health-check")
    public Health healthCheck(@RequestParam(value="APPCODE", defaultValue="ALL") String appCode){
        return new ContractHealthChecks().getHealth(true);
    }

}
