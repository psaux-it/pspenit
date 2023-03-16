package io.github.psauxit.pspenit.metadata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToolMD {
    private String name;
    private String displayName;
    private String description;
    private OptionMD main;
    private List<OptionMD> options;
    private List<GroupMD> groups;
}