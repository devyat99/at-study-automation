package at.study.automation.model.table_roles;

public enum IssuesVisibility {

    ALL_TASK_VISIBILITY("all"),
    OWN_TASK_VISIBILITY("own"),
    DEFAULT_TASK_VISIBILITY("default");

    public final String taskVisibility;

    IssuesVisibility(String taskVisibility) {
        this.taskVisibility = taskVisibility;
    }
}
