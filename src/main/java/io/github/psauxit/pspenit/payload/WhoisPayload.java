package io.github.psauxit.pspenit.payload;

import io.github.psauxit.pspenit.annotation.*;
import lombok.Data;

@Data
@Tool(name="whois", displayName="Whois", cmd="helper.sh", description="WHOIS is widely used for querying databases that store the registered users of an Internet resource, such as a domain name or an IP address block.")
public class WhoisPayload implements Payload {
    @MainParameter(displayName ="IP / FQDN", description="Specify a FQDN or an IP address, e.g. example.com or 1.1.1.1")
    private String domain;
    
    @FixedParam(param = "whois", paramType = ParameterType.ONLY_PARAM)
    private Boolean whois = true;

    @Override
    public String getCacheString() {
        return domain;
    }
}
