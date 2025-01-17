
# Pentest Service RCS
### pentest-dev.psauxit.com

[![Java CI](https://github.com/psaux-it/pspenit/actions/workflows/java.yml/badge.svg)](https://github.com/psaux-it/pspenit/actions/workflows/java.yml)
[![GitHub tag](https://img.shields.io/badge/release-1.4.0-blue)](https://github.com/psaux-it/pspenit/tags)
[![Join the chat at https://web.libera.chat/#psauxit](https://img.shields.io/badge/chat%20-on%20libera-orange)](https://web.libera.chat/#psauxit)

Currently service supports the following tools:
* [TestSSL](https://github.com/drwetter/testssl.sh)
* [Ping](https://packages.ubuntu.com/jammy/iputils-ping)
* [Host](https://packages.ubuntu.com/jammy/bind9-host)
* [Whois](https://packages.ubuntu.com/jammy/whois)
* [CIDR](https://packages.ubuntu.com/jammy/sipcalc)
* [Dig](https://packages.ubuntu.com/bionic/dnsutils)
* [MTR](https://www.bitwizard.nl/mtr/)
* [ASN](https://github.com/nitefood/asn)
* [XSStrike](https://github.com/s0md3v/XSStrike)
* [RustScan & NMAP](https://github.com/RustScan/RustScan)
* [Wapiti](https://github.com/wapiti-scanner/wapiti)
* [Amass](https://github.com/OWASP/Amass)
* [WPScan](https://github.com/wpscanteam/wpscan)
* [DDEC](https://github.com/ak545/dns-domain-expiration-checker)
* [DNSRecon](https://github.com/darkoperator/dnsrecon)
* [CloudMare](https://github.com/mrh0wl/Cloudmare)


## Info
To build the tooling, just run `mvn clean install`. This builds the backend and frontend.
To run the application during development mode, please start the backend with the following command from the root folder.
```
mvn compile quarkus:dev
```

The frontend needs to be started from the frontend folder with the following command.
```
npm run dev
```

The backend listens on port 8080 and for frontend we use nginx proxy. During testing, please make sure to disable CORS in your browser.
```
location / {
                proxy_pass http://127.0.0.1:8080;
                proxy_http_version 1.1;
                proxy_cache_bypass $http_upgrade;
                proxy_set_header Upgrade $http_upgrade;
                proxy_set_header Connection "";
                proxy_set_header Host $http_host;
                proxy_set_header X-Real-IP $remote_addr;
                proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
                proxy_set_header X-Forwarded-Proto $scheme;
                proxy_redirect off;
                proxy_read_timeout 2h;
        }
 ```
 
To add own tools create an payload class for your tool.
Via Java annotations to your parameter fields, all settings for an tool are done.

E.g.

```java
import io.github.johannesschaefer.webnettools.annotation.*;
import lombok.Data;

@Data
@Tool(name="demo", displayName = "Demo", cmd="echo", description="Demo for the tooling.")
public class DemoPayload implements Payload {
    @MainParameter(displayName ="Main", description="Main parameter for this tool.")
    private String main;

    @NumberParam(displayName ="NumInt", param="num-int", description="number integer demo ", min=0., max=100., step=1.)
    private Integer numInt = 50;

    @NumberParam(displayName ="NumDouble", param="num-double", description="number double demo ", min=0.1, max=99.9, step=.1)
    private Double numDouble = 66.6;

    @StringParam(displayName ="String", param="string", description="String demo", paramType = ParameterType.EQUALS)
    private String string;

    @BooleanParam(displayName ="Bool", param="bool1", description="boolean demo")
    private Boolean bool;

    @EnumParam(displayName = "color", param = "--color", description="color selection")
    private Color color;

    @FileParam(displayName = "file", param = "--file-ca", accept = "*.abc", description = "File upload" )
    private String file;
    
    @ServerParam(param = "--optionXXX", handler = XXXHandler.class)
    private String xxx;
    
    @FixedParam(param = "--warnings")
    private String warnings = "off";
}
```

The following parameter type are supported.

* Main parameter - string value used for the main input panel
* String - simple input for strings
* Number - simple input for number
* Boolean - dropdown selection for true/false
* Enum - dropdown selection for values from the given enum, the enum should have the final parameter value as toString result. See examples in [testssl payload](https://github.com/psaux-it/pspenit/tree/main/src/main/java/io/github/psauxit/pspenit/payload/testssl/).
* File - file upload, web net tools create a temporary file with the content and passes the path to the file
* Fixed - Fixes parameter with no choice on client side
* Server side - Special parameter with additional control logic on the server side

Please check the existing payload under [/src/main/java/io/github/psaux-it/pspenit/payload](https://github.com/psaux-it/pspenit/tree/main/src/main/java/io/github/psauxit/pspenit/payload) for more examples.
