package ui;

import java.io.Serializable;

public  class TaskModel implements Serializable {
    private String title,desc;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public TaskModel(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }
}

