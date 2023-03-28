package io.github.psauxit.pspenit.metadata;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;

@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class StringOptionMD extends OptionMD {
    private String defaultValue;
    private int minlength;
    private int maxlength;
}
