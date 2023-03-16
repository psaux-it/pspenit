package io.github.psauxit.pspenit.payload;

import io.github.psauxit.pspenit.annotation.*;
import lombok.Data;

@Data
@Tool(name="ddec", displayName="Expire", cmd="helper.sh", description="This is a python script to check the expiration dates for the registration of your domains.")
public class DdecPayload implements Payload {
    @MainParameter(displayName ="FQDN", description="Specify a FQDN, e.g. example.com")
    private String domain;

    @FixedParam(param = "ddec", paramType = ParameterType.ONLY_PARAM)
    private Boolean ddec = true;
    
    @FixedParam(param = "-c -l --no-banner -d", paramType = ParameterType.ONLY_PARAM)
    private Boolean banner = true;

    @Override
    public String getCacheString() {
        return domain;
    }
}
