package io.github.psauxit.pspenit.payload;

import io.github.psauxit.pspenit.annotation.*;
import lombok.Data;

@Data
@Tool(name="wpscan", displayName="WPScan", cmd="helper.sh", description="WPScan WordPress security scanner. Default enumerate: All plugins, All themes, Config backups, User IDs, Media IDs")
public class WPScanPayload implements Payload {
    @MainParameter(displayName ="Wordpress URL", description="Enter the target Wordpress host URL")
    private String wordpressurl;

    @FixedParam(param = "wpscan", paramType = ParameterType.ONLY_PARAM)
    private Boolean wpscan = true;

    @EnumParam(displayName = "Detection Mode", param = "null", description = "Available choices: mixed, passive, aggressive. Default is mixed.")
    private Dtc dtc;
  
    @EnumParam(displayName = "TLS Checks", param= "null", description="Disable SSL/TLS certificate verification, and downgrade to TLS1.0+. Default is enabled.")
    private Tls tls;
    
    @NumberParam(displayName = "Connect Timeout", param = "timeout", description = "The connection timeout in seconds. Default: 30", min = 0, max = 1000)
    private Integer connectTimeout;
    
    @NumberParam(displayName = "Request Timeout", param = "request", description = "The request timeout in seconds. Default: 60", min = 0, max = 1000)
    private Integer requestTimeout;
  
    @Override
    public String getCacheString() {
        return wordpressurl;
    }
}
