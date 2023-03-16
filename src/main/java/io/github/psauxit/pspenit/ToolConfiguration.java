package io.github.psauxit.pspenit;

import io.github.psauxit.pspenit.metadata.ToolMD;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToolConfiguration {
    private List<ToolMD> toolMD;
    private String introText;
}