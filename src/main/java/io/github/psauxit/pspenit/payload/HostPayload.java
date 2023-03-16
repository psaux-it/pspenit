package io.github.psauxit.pspenit.payload;

import io.github.psauxit.pspenit.annotation.*;
import lombok.Data;

@Data
@Tool(name="host", displayName="Host", cmd="helper.sh", description="Find the IP address of a particular domain name.")
public class HostPayload implements Payload {
    @MainParameter(displayName ="FQDN", description="Specify a FQDN, e.g. example.com")
    private String host;

    @FixedParam(param = "hostlinux", paramType = ParameterType.ONLY_PARAM)
    private Boolean hostlinux = true;

    @Override
    public String getCacheString() {
        return host;
    }
}
