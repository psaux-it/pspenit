package io.github.psauxit.pspenit.payload;

import io.github.psauxit.pspenit.annotation.*;
import lombok.Data;

@Data
@Tool(name="rustscan", displayName="RustScan", cmd="helper.sh", description="RustScan is a modern take on the port scanner. Sleek & fast. All while providing extensive extendability to you.")
public class RustScanPayload implements Payload {
    @MainParameter(displayName ="IP / FQDN", description="Specify a FQDN or an IP address, e.g. example.com or 1.1.1.1. IP range scans not enabled in free plan.")
    private String server;

    @FixedParam(param = "rustscan", paramType = ParameterType.ONLY_PARAM)
    private Boolean rustscan = true;

    @EnumParam(displayName = "NMAP PIPE", param = "null", description = "Enable piping results to NMAP for extra scans on open ports.")
    private Rst rst;

    @Override
    public String getCacheString() {
        return server;
    }
}
