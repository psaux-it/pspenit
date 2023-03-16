package io.github.psauxit.pspenit.payload;

import io.github.psauxit.pspenit.annotation.*;
import lombok.Data;

@Data
@Tool(name="amass", displayName="Amass", cmd="helper.sh", description="The OWASP Amass Project performs network mapping of attack surfaces and external asset discovery using open source information gathering and active reconnaissance techniques.")
public class AmassPayload implements Payload {
    @MainParameter(displayName ="FQDN", description="Specify a FQDN, e.g. example.com. INTEL IP range scans not enabled in free plan.")
    private String domain;

    @FixedParam(param = "amass", paramType = ParameterType.ONLY_PARAM)
    private Boolean amass = true;

    @EnumParam(displayName = "Enumeration Type", param = "null", description = "Active scan uses DNS ZONE XFR. Passive scan will use simple DNS and brute force.")
    private Ams ams;

    @Override
    public String getCacheString() {
        return domain;
    }
}
