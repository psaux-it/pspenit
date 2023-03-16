package io.github.psauxit.pspenit.payload;

import io.github.psauxit.pspenit.annotation.*;
import lombok.Data;

@Data
@Tool(name="traceroute", displayName="Trace Route", cmd="helper.sh", description="Standard Linux traceroute tooling. Only Europe (Germany) → Destination.")
public class TraceroutePayload implements Payload {
    @MainParameter(displayName ="IP / FQDN", description="Specify a FQDN or an IP address, e.g. example.com or 1.1.1.1")
    private String host;

    @FixedParam(param = "traceroute", paramType = ParameterType.ONLY_PARAM)
    private Boolean traceroute = true;

    @Override
    public String getCacheString() {
        return host;
    }
}
