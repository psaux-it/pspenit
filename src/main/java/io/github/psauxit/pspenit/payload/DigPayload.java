package io.github.psauxit.pspenit.payload;

import io.github.psauxit.pspenit.annotation.*;
import lombok.Data;

@Data
@Tool(name="dig", displayName="Dig", cmd="helper.sh", description="Dig is a robust command-line tool developed by BIND for querying DNS nameservers.")
public class DigPayload implements Payload {
    @MainParameter(displayName ="IP / FQDN", description="Specify a FQDN or an IP address, e.g. example.com or 1.1.1.1. This can be an IPv4 address in dotted-decimal notation or an IPv6 address in colon-delimited notation.")
    private String server;

    @FixedParam(param = "dig", paramType = ParameterType.ONLY_PARAM)
    private Boolean dig = true;

    @EnumParam(displayName = "SELECT RECORD", param = "null", description = "SPF,DMARC,MX,NS,A,REVERSE DNS Checker")
    private Txt txt;

    @Override
    public String getCacheString() {
        return server;
    }
}
