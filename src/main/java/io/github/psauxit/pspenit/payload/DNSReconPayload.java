package io.github.psauxit.pspenit.payload;

import io.github.psauxit.pspenit.annotation.*;
import lombok.Data;

@Data
@Tool(name="dnsrecon", displayName="DNSRecon", cmd="helper.sh", description="DNSRecon is a simple python script that enables to gather DNS-oriented information on a given target.")
public class DNSReconPayload implements Payload {
    @MainParameter(displayName ="FQDN", description="Specify a FQDN, e.g. example.com")
    private String hostname;

    @FixedParam(param = "dnsrecon", paramType = ParameterType.ONLY_PARAM)
    private Boolean dnsrecon = true;

    @EnumParam(displayName = "Enumeration Type", param = "null", description = "DNSRecon AXFR,Zone Walk,Sub Domain Detection")
    private Dns dns;

    @Override
    public String getCacheString() {
        return hostname;
    }
}
