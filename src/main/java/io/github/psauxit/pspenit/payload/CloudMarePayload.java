package io.github.psauxit.pspenit.payload;

import io.github.psauxit.pspenit.annotation.*;
import lombok.Data;

@Data
@Tool(name="cloudmare", displayName="CloudMare", cmd="helper.sh", description="Cloudmare is a simple tool to find the origin servers of websites protected by Cloudflare, Sucuri, or Incapsula with a misconfiguration DNS.")
public class CloudMarePayload implements Payload {
    @MainParameter(displayName ="FQDN", description="Specify a FQDN, e.g. example.com")
    private String host;
    
    @FixedParam(param = "cloudmare", paramType = ParameterType.ONLY_PARAM)
    private Boolean cloudmare = true;

    @Override
    public String getCacheString() {
        return host;
    }
}
