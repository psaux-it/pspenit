package io.github.psauxit.pspenit;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.reflections.Reflections;

import javax.enterprise.inject.Produces;
import javax.inject.Singleton;
import java.util.List;

public class Producer {
    @ConfigProperty(name = "AVAILABLE_TOOLS", defaultValue = "testssl,ping,traceroute,nmap,demo,dig,mtr")
    List<String> availableTools;

    @Singleton
    @Produces
    public Reflections produceReflections() {
        return new Reflections("io.github.psauxit.pspenit");
    }


    @Produces
    @Singleton
    @AvailableToolsQualifier
    public List<String> getAvailableTools() {
        return availableTools;
    }

}