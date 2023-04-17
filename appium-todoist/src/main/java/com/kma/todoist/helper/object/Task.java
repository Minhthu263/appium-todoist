package com.kma.todoist.helper.object;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    private String taskName;
    private String description;
    private String priority;
    private String label;
    private String projectName;

}
