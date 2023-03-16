package io.github.psauxit.pspenit.metadata;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class OptionMD {
    private String name;
    private String displayName;
    private String type;
    private String description;
    private String group;
}