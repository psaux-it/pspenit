package io.github.psauxit.pspenit.payload;

import io.github.psauxit.pspenit.annotation.*;
import lombok.Data;

@Data
@Tool(name="asn", displayName="ASN", cmd="helper.sh", description="ASN / RPKI validity / BGP stats / IPv4v6 / Prefix / ASPath / Organization / IP reputation lookup tool")
public class AsnPayload implements Payload {
    @MainParameter(displayName ="IP / FQDN", description="Specify a FQDN or an IP address, e.g. example.com or 1.1.1.1")
    private String host;

    @FixedParam(param = "asnn", paramType = ParameterType.ONLY_PARAM)
    private Boolean asnn = true;

    @BooleanParam(displayName ="Shodan Scan", param="-s", description="Scanning for Shodan informations")
    private Boolean shodan;

    @EnumParam(displayName = "CIDR Mapping", param = "null", description = "Displaying a list of CIDR blocks allocated to desired Country")
    private Asn asn;

    @Override
    public String getCacheString() {
        return host;
    }
}
