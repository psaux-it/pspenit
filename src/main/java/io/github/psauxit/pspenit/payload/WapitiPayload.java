package io.github.psauxit.pspenit.payload;

import io.github.psauxit.pspenit.annotation.*;
import lombok.Data;

@Data
@Tool(name="wapiti", displayName="Wapiti", cmd="helper.sh", description="Wapiti is a web vulnerability scanner written in Python.")
public class WapitiPayload implements Payload {
    @MainParameter(displayName ="FQDN", description="Specify a FQDN, e.g. https:www.example.com")
    private String fqdn;

    @FixedParam(param = "wapiti", paramType = ParameterType.ONLY_PARAM)
    private Boolean wapiti = true;

    @Override
    public String getCacheString() {
        return fqdn;
    }
}
