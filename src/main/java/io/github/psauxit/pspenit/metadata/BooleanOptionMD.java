package io.github.psauxit.pspenit.metadata;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class BooleanOptionMD extends OptionMD {
    private Boolean defaultValue;
    private String labelTrue;
    private String labelFalse;
}