package io.github.psauxit.pspenit.payload;

import io.github.psauxit.pspenit.annotation.*;
import lombok.Data;

@Data
@Tool(name="cidr", displayName="Subnet(CIDR)", cmd="helper.sh", description="IP Subnet (CIDR) Calculator")
public class CidrPayload implements Payload {
    @MainParameter(displayName ="IPv4 / IPv6", description="Specify an IP address, e.g. 1.1.1.1")
    private String host;
    
    @FixedParam(param = "cidr", paramType = ParameterType.ONLY_PARAM)
    private Boolean cidr = true;

    @Override
    public String getCacheString() {
        return host;
    }
}
