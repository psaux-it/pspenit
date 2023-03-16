package io.github.psauxit.pspenit.payload;

import io.github.psauxit.pspenit.annotation.*;
import lombok.Data;

@Data
@Tool(name="xsstrike", displayName="XSStrike", cmd="helper.sh", description="XSStrike is a Cross Site Scripting detection suite equipped with four hand written parsers, an incredibly fast crawler")
public class XSStrikePayload implements Payload {
    @MainParameter(displayName ="FQDN", description="Specify a FQDN, e.g. https://example.com")
    private String domain;

    @FixedParam(param = "xsstrike", paramType = ParameterType.ONLY_PARAM)
    private Boolean xsstrike = true;

    @Override
    public String getCacheString() {
        return domain;
    }
}
